package org.teamone.client.auth;

/**
 * Created by daniel on 9/26/15.
 */

//import Spring libs

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.AlertSQL;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.SQL.LoginSQL;
import org.teamone.core.users.HSP;
import org.teamone.core.users.Person;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@Scope("request")
@RequestMapping(value = {"/settings"})
public class SettingsController {

    //@Autowired
    //private User user;

    @RequestMapping(method = RequestMethod.GET)
    public String viewLogin(Map<String, Object> model,
                            @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        LoginAttempt attempt = new LoginAttempt();
        String infoMessage = "Because you are accessing secure information, we ask you to re-enter your password";
        model.put("infoMessage", infoMessage);
        model.put("userInput", attempt);
        System.out.println("loading secure access");
        if (user.getSettingsTime() == null) {
            return "auth/settings/secureInformationLogin"; //send to login screen
        } else {
            SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date temp = user.getSettingsTime();
            String settingsStr = convertToDate.format(temp);
            if(AlertSQL.isTimeWithin5Min(settingsStr))
            {
                return "auth/settings/user";//no need to authenticate if user did within x mins
            }
            else
            {
                return "auth/settings/secureInformationLogin"; //send to login screen
            }
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPassword(
            //@ModelAttribute("userInput") LoginAttempt attempt,
            @ModelAttribute("userInput") LoginAttempt attempt,
            @ModelAttribute("user") User user, //special bean used to store session
            Map<String, Object> model) {

        Person pAttempt = new Person();
        pAttempt.setUserID(user.getPerson().getUserID());
        pAttempt.setPassword(attempt.getPassword());
        Person pResult = LoginSQL.authenticate(pAttempt);

        if (pResult != null) {
            System.out.println("Authentication succeeded");
            user.setSettingsTime(new Date());//assign when user logged on to settings

            return "auth/settings/user";
        } else {
            System.out.println("Authentication Failed");
            String errorMessage = "Your password was incorrect. Try again.";
            model.put("errorMessage", errorMessage);
            return "auth/settings/secureInformationLogin";
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public String changePassword(Map<String, Object> model,
                                 @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        PasswordAttempt attempt = new PasswordAttempt();
        model.put("userInput", attempt);
        return "auth/settings/changePassword";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String processChangePassword(Map<String, Object> model,
                                        @ModelAttribute("userInput") PasswordAttempt attempt,
                                        @ModelAttribute("user") User user) {

        if ((attempt.getFirstPassword().equals(attempt.getNewPassword()))) {
            Person p1 = user.getPerson();
            String newPass = attempt.getNewPassword();
            if (LoginSQL.changePassword(p1, newPass)) {
                System.out.println(user.getPerson().getUserID() + " has just changed password!");
                return "redirect:/settings" ;
            } else {
                System.out.println("Password not changed");
                String errorMessage = "Something went wrong. Try again.";
                model.put("errorMessage", errorMessage);
                model.put("userInput", attempt);
                return "auth/settings/changePassword";
            }
        } else {
            String errorMessage = "Your passwords do not match. Try again.";
            model.put("errorMessage", errorMessage);
            model.put("userInput", attempt);
            return "auth/settings/changePassword";
        }
    }

    @RequestMapping(value = "/masterPanel", method = RequestMethod.GET)
    public String viewMasterPanel(Map<String, Object> model,
                                  @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        if (!(user.getPerson() instanceof HSP))
            return "redirect:/settings";

        LoginAttempt attempt = new LoginAttempt();
        String infoMessage = "WARNING. YOU ARE ATTEMPTING TO ACCESS A RESTRICTED AREA!";
        model.put("infoMessage", infoMessage);
        model.put("userInput", attempt);
        System.out.println("loading master access");
        return "auth/settings/secureInformationLogin";
    }

    @RequestMapping(value = "/masterPanel", method = RequestMethod.POST)
    public String processMasterPanel(@ModelAttribute("userInput") LoginAttempt attempt,
                                     @ModelAttribute("user") User user, //special bean used to store session
                                     Map<String, Object> model) {
        if (user.getPerson() == null)
            return "redirect:/login";
        if (!(user.getPerson() instanceof HSP))
            return "redirect:/settings";
        if (HspSQL.authenticate("MasterPanel", attempt.getPassword())) {
            List everyone = HspSQL.revealAll();
            model.put("everyone", everyone);
            return "auth/settings/masterPanel";
        } else {
            return "redirect:/settings" ;
        }

    }

    /**
     * Only to be used by HSP
     *
     * @param model
     * @param user
     * @param userID
     * @return
     */
    @RequestMapping(value = "/changePassword/{userID}", method = RequestMethod.GET)
    public String changeMasterPassword(Map<String, Object> model,
                                       @ModelAttribute User user,
                                       @PathVariable("userID") String userID) {
        if (user.getPerson() == null)
            return "redirect:/login";
        if (!(user.getPerson() instanceof HSP))
            return "redirect:/settings";
        PasswordAttempt attempt = new PasswordAttempt();
        model.put("userInput", attempt);
        return "auth/settings/changePassword";
    }

    @RequestMapping(value = "/changePassword/{userID}", method = RequestMethod.POST)
    public String processChangeMasterPassword(Map<String, Object> model,
                                              @ModelAttribute("userInput") PasswordAttempt attempt,
                                              @ModelAttribute("user") User user,
                                              @PathVariable("userID") String userID) {

        if ((attempt.getFirstPassword().equals(attempt.getNewPassword()))) {
            Person p1 = new Person();
            p1.setUserID(Integer.parseInt(userID));
            String newPass = attempt.getNewPassword();
            if (LoginSQL.changePassword(p1, newPass)) {
                System.out.println(user.getPerson().getUserID() + " has just changed password for " + userID);
                return "redirect:/settings";
            } else {
                System.out.println("Password not changed");
                String errorMessage = "Something went wrong. Try again.";
                model.put("errorMessage", errorMessage);
                model.put("userInput", attempt);
                return "auth/settings/changePassword";
            }
        } else {
            String errorMessage = "Your passwords do not match. Try again.";
            model.put("errorMessage", errorMessage);
            model.put("userInput", attempt);
            return "auth/settings/changePassword";
        }
    }
}

class PasswordAttempt {
    private String firstPassword;
    private String newPassword;

    public String getFirstPassword() {
        return firstPassword;
    }

    public void setFirstPassword(String firstPassword) {
        this.firstPassword = firstPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    PasswordAttempt() {
    }
}

