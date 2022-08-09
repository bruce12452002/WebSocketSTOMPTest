package home.bruce.WebSocketSTOMPTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/toClient")
    public String test() {
        System.out.println("test");
        return "clientPublish.html";
    }
}
