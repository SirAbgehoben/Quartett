package org.abgehoben;

import org.abgehoben.rest.GameMain;
import org.abgehoben.rest.cards;
import org.abgehoben.service.SpringBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class Main extends Thread{

    public static void main(String[] args) {
        Main thread = new Main();
        thread.start();

        SpringApplication.run(SpringBoot.class, args);
        cards cards = new cards(); //yes this is fucking mandatory why did I spend fucking hours on this single line bruh. o(≧口≦)o
    }

    public void run() { //default thread called by extends Thread
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n" +
                "\n" +
                "  ██╗  ██╗     █████╗ ██████╗  ██████╗ ███████╗██╗  ██╗ ██████╗ ██████╗ ███████╗███╗   ██╗    ██╗  ██╗  \n" +
                " ██╔╝ ██╔╝    ██╔══██╗██╔══██╗██╔════╝ ██╔════╝██║  ██║██╔═══██╗██╔══██╗██╔════╝████╗  ██║    ╚██╗ ╚██╗ \n" +
                "██╔╝ ██╔╝     ███████║██████╔╝██║  ███╗█████╗  ███████║██║   ██║██████╔╝█████╗  ██╔██╗ ██║     ╚██╗ ╚██╗\n" +
                "╚██╗ ╚██╗     ██╔══██║██╔══██╗██║   ██║██╔══╝  ██╔══██║██║   ██║██╔══██╗██╔══╝  ██║╚██╗██║     ██╔╝ ██╔╝\n" +
                " ╚██╗ ╚██╗    ██║  ██║██████╔╝╚██████╔╝███████╗██║  ██║╚██████╔╝██████╔╝███████╗██║ ╚████║    ██╔╝ ██╔╝ \n" +
                "  ╚═╝  ╚═╝    ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝    ╚═╝  ╚═╝  \n" +
                "                                                                                                        \n" +
                "\n");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "exit":
                    System.exit(0);
                    break;
                case "reset":
                    GameMain.ResetQuartett("user1");
                    GameMain.ResetQuartett("user2");
                    break;
                case "set":

                    System.out.println("enter var name:  ");
                    String varName = scanner.nextLine();
                    System.out.println("enter type:  ");
                    String varType = scanner.nextLine();

                    Object varValue;
                    switch (varType.toLowerCase()) {
                        case "int":
                            System.out.println("enter var value:  ");
                            varValue = scanner.nextInt();
                            break;
                        case "String":
                            System.out.println("enter var value:  ");
                            varValue = scanner.nextLine();
                            break;
                        case "boolean":
                            System.out.println("enter var value:  ");
                            varValue = scanner.nextBoolean();
                            break;
                        case "double":
                            System.out.println("enter var value:  ");
                            varValue = scanner.nextDouble();
                            break;
                        case "float":
                            System.out.println("enter var value:  ");
                            varValue = scanner.nextFloat();
                            break;
                        default:
                            System.out.println("enter var value:  ");
                            varValue = scanner.nextLine();
                            break;
                    }

                    try {

                        Field field = GameMain.class.getDeclaredField(varName);
                        field.setAccessible(true);
                        field.set(null, varValue); //null == static

                    } catch (NoSuchFieldException | IllegalAccessException e) {

                        System.out.println("error setting variable: " + e.getMessage());
                    }

                    System.out.println("set " + varName + " to " + varValue);
                    break;
            }
        }
    }
}