package com.nicolas_ForLaba;

import java.io.*;


public class Client_2 {
    public static int getSchet() {
        return schet;
    }

    public static void setSchet(int schet) {
        Client_2.schet = schet;
    }

    private static int schet=1;
    private static double increased;
    private static double decreased;
    private static String showOut=null;


    private synchronized void addClient_2() {
         new GUI(2);
        while (getSchet()==1) {
            while (increased != 0 || decreased != 0|| showOut!=null)
        try(Phone phone= new Phone("127.0.0.1", 8000)) {

                if (increased != 0) {
                String request = increased + "";
                System.out.println("Request: " + request);
                phone.writeLine(request);
                String response = phone.readLine();
                System.out.println("Response: " + response);

                increased=0;}

                 else if (decreased != 0) {
                    String request1 = decreased + "";
                    System.out.println("Request: " + request1);
                    phone.writeLine(request1);
                    String response = phone.readLine();
                    System.out.println("Response: " + response);
                    decreased=0;

                }else if(showOut!=null){
                    String request2 = showOut;
                    System.out.println("Request: " + request2);
                    phone.writeLine(request2);
                    String response = phone.readLine();
                    System.out.println("Response: " + response);
                    GUI.setCurrentBalance(response);
                    showOut=null;
                }

 } catch (IOException  e) {
            e.printStackTrace();
        }}}

    public static void closeOperation(){
        setSchet(0);
    }

    public static void main(String[] args) {
        Client_2 client= new Client_2();
            client.addClient_2();

    }
    public static void increase(double a) {
        System.out.println("We are increased!");
        increased = a;
        System.out.println(a);


    }

    public static void decrease(double a) {
        System.out.println("We are decreased!");
        decreased = a;
        System.out.println(a);

    }

    public static void showOut(){
        System.out.println("We are show!");
        showOut="one";
        System.out.println(showOut);

    }
}
