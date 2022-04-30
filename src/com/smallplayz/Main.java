package com.smallplayz;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, AWTException {
        run();
    }
    public static void Mouseclick(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    public static void botGame(int code) throws InterruptedException, AWTException {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://kahoot.it?pin="+code+"&refer_method=link");
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        wait(1250);
        Robot robot = new Robot();
        Mouseclick(400, 400);
        robot.keyPress(KeyEvent.VK_TAB);
        wait(10);
        robot.keyPress((int)(Math.random()*26)+65);
        robot.keyPress((int)(Math.random()*26)+65);
        robot.keyPress((int)(Math.random()*26)+65);
        robot.keyPress((int)(Math.random()*26)+65);
        robot.keyPress((int)(Math.random()*26)+65);
        robot.keyPress((int)(Math.random()*26)+65);
        wait(10);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public static void run() throws InterruptedException, AWTException {
        Scanner reader = new Scanner(System.in);
        System.out.print("Game Code: ");
        int code = reader.nextInt();
        System.out.print("Number of Bots: ");
        int numbots = reader.nextInt();
        System.out.print("Stay AFK momentarily as the BOT floods your game.");
        wait(1500);
        for(int i = 0; i < numbots; i++)
            botGame(code);
    }
    public static void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
