package org.teamone.client;

//import Spring libs
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//import core libs.
import org.teamone.core.MessageService;

@Controller
public class HelloWorld {

    @RequestMapping("/")
    public ModelAndView JSPtest() {
        return new ModelAndView("index");
    }

    @RequestMapping("/message")
    public String index() {
        MessageService messageService = new MessageService();

        String message = messageService.getMessage();
        System.out.println(message);
        return message;
    }
}
