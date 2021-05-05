package com.nicolas_ForLaba;

import java.io.*;
import java.net.ServerSocket;

/**
 * @version 1.0
 * @author Nicola
 * Class starts server
 */
public class Server {
    /**
     * in this part we start our class
     * @param args the project is going
     */
    public static void main(String[] args) {

        Account account= new Account();
        try(ServerSocket server = new ServerSocket(8000)) {

            System.out.println("Server started!");

            while(true) {
                Phone phone = new Phone(server);
                new Thread(() -> {

                    String request = phone.readLine();
                    System.out.println("Request: " + request);
                    String response= account.input(request);

                    phone.writeLine(response);
                    System.out.println("Response: " + response);
                    try {
                        phone.close();
                    } catch (IOException e) {
                    }
                }).start();
            }



        }catch (IOException e) {
            throw new RuntimeException(e);

        }

    }}
