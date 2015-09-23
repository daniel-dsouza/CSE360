package org.teamone.client;

import java.util.Map;

//import Spring libs
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.teamone.coe.MessageService;

@Controller
public class HelloWorld {

    @RequestMapping("/")
    public String JSPtest(Map<String, Object> model) {
        return "index";
    }

    @RequestMapping("/message")
    public String index() {
        MessageService messageService = new MessageService();

        String message = messageService.getMessage();
        System.out.println(message);
        return message;
    }
}
