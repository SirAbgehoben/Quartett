package org.abgehoben.rest;

import java.util.Random;

public class GameMain {
    public static String CheckedCardInformation = "youareanidiot";

    public static String CarImageUser1 = null;
    public static String CarNameUser1 = null;
    public static String TopSpeedUser1 = null;
    public static String AccelerationUser1 = null;
    public static String PsUser1 = null;
    public static String ConsumptionUser1 = null;

    public static Integer CardsUser1 = 18;

    public static String CarImageUser2 = null;
    public static String CarNameUser2 = null;
    public static String TopSpeedUser2 = null;
    public static String AccelerationUser2 = null;
    public static String PsUser2 = null;
    public static String ConsumptionUser2 = null;

    public static Integer CardsUser2 = 18;

    public static String AktiveUser = "user1";
    public static Boolean Ready = false;  // Set this to true or control it based on game logic


    public static void SetOpponentCardInformation(String Action, String user) {
        switch (Action) {
            case "Quartett1":
                CheckedCardInformation = "Top-Speed";
                break;
            case "Quartett2":
                CheckedCardInformation = "0-100";
                break;
            case "Quartett3":
                CheckedCardInformation = "PS";
                break;
            case "Quartett4":
                CheckedCardInformation = "Consumption";
                break;
        }
    }

    public static int RandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static Integer RandomCardUser1 = 1;
    public static Integer RandomCardUser2 = 2;

    public static void GenerateCards(String user1, String user2) {
        RandomCardUser1 = RandomInt(1, 18);
        RandomCardUser2 = RandomInt(1, 18);
        System.out.println("generated cards" + RandomCardUser1 + RandomCardUser2);
    }

    public static void GenerateCards() {
        CarImageUser1 = "/" + cards.getCarAttribute(RandomCardUser1, "Name") + ".png";
        CarNameUser1 = cards.getCarAttribute(RandomCardUser1, "Name");
        TopSpeedUser1 = cards.getCarAttribute(RandomCardUser1, "Top-Speed");
        AccelerationUser1 = cards.getCarAttribute(RandomCardUser1, "0-100");
        PsUser1 = cards.getCarAttribute(RandomCardUser1, "PS");
        ConsumptionUser1 = cards.getCarAttribute(RandomCardUser1, "Consumption");

        CarImageUser2 = "/" + cards.getCarAttribute(RandomCardUser2, "Name") + ".png";
        CarNameUser2 = cards.getCarAttribute(RandomCardUser2, "Name");
        TopSpeedUser2 = cards.getCarAttribute(RandomCardUser2, "Top-Speed");
        AccelerationUser2 = cards.getCarAttribute(RandomCardUser2, "0-100");
        PsUser2 = cards.getCarAttribute(RandomCardUser2, "PS");
        ConsumptionUser2 = cards.getCarAttribute(RandomCardUser2, "Consumption");

    }

    public static void GameAction(String Action, String user) throws InterruptedException {

        if (Ready) { //ignore requests when showing other cards
            return;
        }


        ShowCards(); //Expecting 5 seconds of sleep

        switch (Action) {
            case "Quartett1":
                if (user.equals("user1")) {
                    if (Float.parseFloat(TopSpeedUser1) >= Float.parseFloat(TopSpeedUser2)) {
                        CardsUser2--;
                        CardsUser1++;
                    } else {
                        CardsUser1--;
                        CardsUser2++;
                        ChangeAktiveUser();
                    }
                } else if (user.equals("user2")) {
                    if (Float.parseFloat(TopSpeedUser2) >= Float.parseFloat(TopSpeedUser1)) {
                        CardsUser2++;
                        CardsUser1--;
                    } else {
                        CardsUser1++;
                        CardsUser2--;
                        ChangeAktiveUser();
                    }
                }
                break;
            case "Quartett2": //Acceleration needs to be lower because it represents 0-100
                if (user.equals("user1")) {
                    if (Float.parseFloat(AccelerationUser1) <= Float.parseFloat(AccelerationUser2)) {
                        CardsUser2--;
                        CardsUser1++;
                    } else {
                        CardsUser1--;
                        CardsUser2++;
                        ChangeAktiveUser();
                    }
                } else if (user.equals("user2")) {
                    if (Float.parseFloat(AccelerationUser2) <= Float.parseFloat(AccelerationUser1)) {
                        CardsUser2++;
                        CardsUser1--;
                    } else {
                        CardsUser1++;
                        CardsUser2--;
                        ChangeAktiveUser();
                    }
                }
                break;
            case "Quartett3":
                if (user.equals("user1")) {
                    if (Float.parseFloat(PsUser1) >= Float.parseFloat(PsUser2)) {
                        CardsUser2--;
                        CardsUser1++;
                    } else {
                        CardsUser1--;
                        CardsUser2++;
                        ChangeAktiveUser();
                    }
                } else if (user.equals("user2")) {
                    if (Float.parseFloat(PsUser2) >= Float.parseFloat(PsUser1)) {
                        CardsUser2++;
                        CardsUser1--;
                    } else {
                        CardsUser1++;
                        CardsUser2--;
                        ChangeAktiveUser();
                    }
                }
                break;
            case "Quartett4":
                if (user.equals("user1")) {
                    if (Float.parseFloat(ConsumptionUser1) <= Float.parseFloat(ConsumptionUser2)) {
                        CardsUser2--;
                        CardsUser1++;
                    } else {
                        CardsUser1--;
                        CardsUser2++;
                        ChangeAktiveUser();
                    }
                } else if (user.equals("user2")) {
                    if (Float.parseFloat(ConsumptionUser2) <= Float.parseFloat(ConsumptionUser1)) {
                        CardsUser2++;
                        CardsUser1--;
                    } else {
                        CardsUser1++;
                        CardsUser2--;
                        ChangeAktiveUser();
                    }
                }
                break;
        }

        if (CardsUser1.equals(0) || CardsUser2.equals(0)) {
            System.out.println("GameOver");
            //implement game over method
        }
    }


    public static void ShowCards() throws InterruptedException {
        Ready = true;
        new Thread(() -> { //creating a new thread and waiting there to not block the main thread
            try {
                Thread.sleep(5000); // wait for 5 seconds
                GenerateCards("user1", "user2");
                GenerateCards();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Ready = false;
        }).start();
    }

    public static void ChangeAktiveUser() {
        if (AktiveUser.equals("user1")) {
            AktiveUser = "user2";
        }
        else if (AktiveUser.equals("user2")) {
            AktiveUser = "user1";
        }
        else {
            AktiveUser = "user1";
        }
    }
}
