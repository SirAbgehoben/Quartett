package org.abgehoben.service;

import jakarta.servlet.http.HttpSession;
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

        //implement game end gui here


        // Render HTML
        StringBuilder html = new StringBuilder();
        html.append("<html>")
                .append("<head>")
                .append("<title>Car Comparison</title>")
                .append("<meta http-equiv=\"refresh\" content=\"1\">") // Auto-refresh every 1 seconds
                .append("<style>")
                .append("body { font-family: sans-serif; }")
                .append(".container { display: flex; justify-content: center; }")
                .append(".car-card { border: 1px solid black; padding: 10px; margin: 10px; text-align: center; width: 220px; }")
                .append(".car-image { max-width: 200px; max-height: 150px; }")
                .append(".vs-container { display: flex; align-items: center; justify-content: center; margin: 10px; }")
                .append(".vs-text { padding: 10px; }")
                .append(".game-result { border: 1px solid black; padding: 10px; margin: 10px; }")
                .append("button[type=\"submit\"] img { width: 12px; height: 12px; }")
                .append("</style>")
                .append("</head>")
                .append("<body>")
                .append("<div class=\"container\">");

        // User's card
        if (GameMain.AktiveUser.equals(userId) && userId.equals("user1")) {
            html.append("<div class=\"car-card\">")
                    .append("<h2>").append(GameMain.CarNameUser1).append("</h2>")
                    .append("<img src=\"").append(GameMain.CarImageUser1).append("\" alt=\"User 1 Car Image\" class=\"car-image\">")
                    .append("<form action=\"/Quartett1\" method=\"post\">")
                    .append("<p>Top Speed: ").append(GameMain.TopSpeedUser1).append(" km/h <button type=\"submit\"><img src=\"/x.webp\" alt=\"x\"></button></p>")
                    .append("</form>")
                    .append("<form action=\"/Quartett2\" method=\"post\">")
                    .append("<p>0-100: ").append(GameMain.AccelerationUser1).append(" sec. <button type=\"submit\"><img src=\"/x.webp\" alt=\"x\"></button></p>")
                    .append("</form>")
                    .append("<form action=\"/Quartett3\" method=\"post\">")
                    .append("<p>PS: ").append(GameMain.PsUser1).append(" PS <button type=\"submit\"><img src=\"/x.webp\" alt=\"x\"></button></p>")
                    .append("</form>")
                    .append("<form action=\"/Quartett4\" method=\"post\">")
                    .append("<p>Consumption: ").append(GameMain.ConsumptionUser1).append(" Liter <button type=\"submit\"><img src=\"/x.webp\" alt=\"x\"></button></p>")
                    .append("</form>")
                    .append("</div>");
        } else if (GameMain.AktiveUser.equals(userId) && userId.equals("user2")) {
            html.append("<div class=\"car-card\">")
                    .append("<h2>").append(GameMain.CarNameUser2).append("</h2>")
                    .append("<img src=\"").append(GameMain.CarImageUser2).append("\" alt=\"User 2 Car Image\" class=\"car-image\">")
                    .append("<form action=\"/Quartett1\" method=\"post\">")
                    .append("<p>Top Speed: ").append(GameMain.TopSpeedUser2).append(" km/h <button type=\"submit\"><img src=\"/x.webp\" alt=\"x\"></button></p>")
                    .append("</form>")
                    .append("<form action=\"/Quartett2\" method=\"post\">")
                    .append("<p>0-100: ").append(GameMain.AccelerationUser2).append(" sec. <button type=\"submit\"><img src=\"/x.webp\" alt=\"x\"></button></p>")
                    .append("</form>")
                    .append("<form action=\"/Quartett3\" method=\"post\">")
                    .append("<p>PS: ").append(PsUser2).append(" PS <button type=\"submit\"><img src=\"/x.webp\" alt=\"x\"></button></p>")
                    .append("</form>")
                    .append("<form action=\"/Quartett4\" method=\"post\">")
                    .append("<p>Consumption: ").append(GameMain.ConsumptionUser2).append(" Liter <button type=\"submit\"><img src=\"/x.webp\" alt=\"x\"></button></p>")
                    .append("</form>")
                    .append("</div>");
        } else if (!GameMain.AktiveUser.equals(userId) && userId.equals("user1")) {
            html.append("<div class=\"car-card\">")
                    .append("<h2>").append(GameMain.CarNameUser1).append("</h2>")
                    .append("<img src=\"").append(GameMain.CarImageUser1).append("\" alt=\"User 1 Car Image\" class=\"car-image\">")
                    .append("<form action=\"/Quartett1\" method=\"post\">")
                    .append("<p>Top Speed: ").append(GameMain.TopSpeedUser1).append(" km/h")
                    .append("</form>")
                    .append("<form action=\"/Quartett2\" method=\"post\">")
                    .append("<p>0-100: ").append(GameMain.AccelerationUser1).append(" sec.")
                    .append("</form>")
                    .append("<form action=\"/Quartett3\" method=\"post\">")
                    .append("<p>PS: ").append(GameMain.PsUser1).append(" PS")
                    .append("</form>")
                    .append("<form action=\"/Quartett4\" method=\"post\">")
                    .append("<p>Consumption: ").append(GameMain.ConsumptionUser1).append(" Liter")
                    .append("</form>")
                    .append("</div>");
        } else if (!GameMain.AktiveUser.equals(userId) && userId.equals("user2")) {
            html.append("<div class=\"car-card\">")
                    .append("<h2>").append(GameMain.CarNameUser2).append("</h2>")
                    .append("<img src=\"").append(GameMain.CarImageUser2).append("\" alt=\"User 2 Car Image\" class=\"car-image\">")
                    .append("<form action=\"/Quartett1\" method=\"post\">")
                    .append("<p>Top Speed: ").append(GameMain.TopSpeedUser2).append(" km/h")
                    .append("</form>")
                    .append("<form action=\"/Quartett2\" method=\"post\">")
                    .append("<p>0-100: ").append(GameMain.AccelerationUser2).append(" sec.")
                    .append("</form>")
                    .append("<form action=\"/Quartett3\" method=\"post\">")
                    .append("<p>PS: ").append(PsUser2).append(" PS")
                    .append("</form>")
                    .append("<form action=\"/Quartett4\" method=\"post\">")
                    .append("<p>Consumption: ").append(GameMain.ConsumptionUser2).append(" Liter")
                    .append("</form>")
                    .append("</div>");
        }


        // VS Container
        html.append("<div class=\"vs-container\">")
                .append("<div class=\"vs-text\">VS.</div>")
                .append("</div>");

        // Opponent's card (card back if Ready is false)
        if (GameMain.Ready) {
            if ("user1".equals(userId)) {
                html.append("<div class=\"car-card\">")
                        .append("<h2>").append(GameMain.CarNameUser2).append("</h2>")
                        .append("<img src=\"").append(GameMain.CarImageUser2).append("\" alt=\"Opponent Car Image\" class=\"car-image\">")
                        .append("<p>Top Speed: ").append(GameMain.TopSpeedUser2).append(" km/h")        .append(Objects.equals(CheckedCardInformation, "Top-Speed") ? "🟢" + "</p>" : "</p>") //using java ternary operator for if else statement in the same line
                        .append("<p>0-100: ").append(GameMain.AccelerationUser2).append(" sec.")        .append(Objects.equals(CheckedCardInformation, "0-100") ? "🟢" + "</p>" : "</p>")
                        .append("<p>PS: ").append(GameMain.PsUser2).append(" PS")                       .append(Objects.equals(CheckedCardInformation, "PS") ? "🟢" + "</p>" : "</p>")
                        .append("<p>Consumption: ").append(GameMain.ConsumptionUser2).append(" Liter")  .append(Objects.equals(CheckedCardInformation, "Consumption") ? "🟢" + "</p>" : "</p>")
                        .append("</div>");
            } else {
                html.append("<div class=\"car-card\">")
                        .append("<h2>").append(GameMain.CarNameUser1).append("</h2>")
                        .append("<img src=\"").append(GameMain.CarImageUser1).append("\" alt=\"Opponent Car Image\" class=\"car-image\">")
                        .append("<p>Top Speed: ").append(GameMain.TopSpeedUser1).append(" km/h")        .append(Objects.equals(CheckedCardInformation, "Top-Speed") ? "🟢" + "</p>" : "</p>") //using java ternary operator for if else statement in the same line
                        .append("<p>0-100: ").append(GameMain.AccelerationUser1).append(" sec.")        .append(Objects.equals(CheckedCardInformation, "0-100") ? "🟢" + "</p>" : "</p>")
                        .append("<p>PS: ").append(GameMain.PsUser1).append(" PS")                       .append(Objects.equals(CheckedCardInformation, "PS") ? "🟢" + "</p>" : "</p>")
                        .append("<p>Consumption: ").append(GameMain.ConsumptionUser1).append(" Liter")  .append(Objects.equals(CheckedCardInformation, "Consumption") ? "🟢" + "</p>" : "</p>")
                        .append("</div>");
            }
        } else {
            html.append("<div class=\"car-card\">")
                    .append("<h2>Opponent's Card</h2>")
                    .append("<img src=\"cardback.jpg\" alt=\"Opponent Card Back\" class=\"car-image\">")
                    .append("</div>");
        }

        html.append("</div>")
                .append("<div class=\"container\">")
                .append("<div class=\"game-result\" style=\"background-color: lightgreen;\">");

        if ("user1".equals(userId)) {
            html.append("<p>You have ").append(GameMain.CardsUser1).append(" cards.</p>");
            if (AktiveUser.equals("user1")) {
                html.append("<p>Your Turn<p>");
            }
        } else {
            html.append("<p>You have ").append(GameMain.CardsUser2).append(" cards.</p>");
            if (AktiveUser.equals("user2")) {
                html.append("<p>Your Turn<p>");
            }
        }

        html.append("</div>")
                .append("<div class=\"game-result\" style=\"background-color: pink;\">");

        if ("user1".equals(userId)) {
            html.append("<p>Opponent has ").append(GameMain.CardsUser2).append(" cards.</p>");
            if (AktiveUser.equals("user2")) {
                html.append("<p>Opponends Turn<p>");
            }
        } else {
            html.append("<p>Opponent has ").append(GameMain.CardsUser1).append(" cards.</p>");
            if (AktiveUser.equals("user1")) {
                html.append("<p>Opponends Turn<p>");
            }
        }

        html.append("</div>")
                .append("</div>")
                .append("</body>")
                .append("</html>");

        return html.toString();
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

}