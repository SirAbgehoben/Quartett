package org.abgehoben.service;

import jakarta.servlet.http.HttpSession;
import org.abgehoben.front.htmlbuilder;
import org.abgehoben.rest.GameMain;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static org.abgehoben.rest.GameMain.*;


@SpringBootApplication
@Controller
public class SpringBoot {

    @GetMapping("/")
        public String Main(Model model) {
        return "main";
    }


    Boolean UserIdNumberSwitch = false;// Switch between user1 and user2 for unique userId


    @GetMapping("/Quartett")
    @ResponseBody
    public String Quartett(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        // Check if userId is present in session or assign if new
        if (userId == null) {
            if (!UserIdNumberSwitch) {
                userId = "user1";
                UserIdNumberSwitch = true;
                GameMain.GenerateCards("user1", "user2");
                GameMain.GenerateCards();
            } else {
                userId = "user2";
                UserIdNumberSwitch = false;
            }
            session.setAttribute("userId", userId);
        }

        return htmlbuilder.htmlbuilder(userId);
    }



    @PostMapping("/Quartett1")
    public String Quartett1(HttpSession session) throws InterruptedException {
        String userId = (String) session.getAttribute("userId");

        GameMain.GameAction("Quartett1", userId);
        GameMain.SetOpponentCardInformation("Quartett1", userId);

        System.out.println("Quartett1 triggered by user: " + userId);
        return "redirect:/Quartett";
    }

    @PostMapping("/Quartett2")
    public String Quartett2(HttpSession session) throws InterruptedException {
        String userId = (String) session.getAttribute("userId");

        GameMain.GameAction("Quartett2", userId);
        GameMain.SetOpponentCardInformation("Quartett2", userId);

        System.out.println("Quartett2 triggered by user: " + userId);
        return "redirect:/Quartett";
    }

    @PostMapping("/Quartett3")
    public String Quartett3(HttpSession session) throws InterruptedException {
        String userId = (String) session.getAttribute("userId");

        GameMain.GameAction("Quartett3", userId);
        GameMain.SetOpponentCardInformation("Quartett3", userId);

        System.out.println("Quartett3 triggered by user: " + userId);
        return "redirect:/Quartett";
    }

    @PostMapping("/Quartett4")
    public String Quartett4(HttpSession session) throws InterruptedException {
        String userId = (String) session.getAttribute("userId");

        GameMain.GameAction("Quartett4", userId);
        GameMain.SetOpponentCardInformation("Quartett4", userId);

        System.out.println("Quartett4 triggered by user: " + userId);
        return "redirect:/Quartett";
    }

    @PostMapping("/QuartettReset")
    public String QuartettReset(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        GameMain.ResetQuartett(userId);

        System.out.println("reset");
        return "redirect:/Quartett";
    }

}