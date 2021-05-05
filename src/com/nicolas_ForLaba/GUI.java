package com.nicolas_ForLaba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends Frame implements ActionListener {
    public static String getCurrentBalance() {
        return currentBalance;
    }

    public static void setCurrentBalance(String currentBalance) {
        GUI.currentBalance = currentBalance;
    }
    private int ifStart=0;

    public int getIfStart() {
        return ifStart;
    }

    public void setIfStart(int ifStart) {
        this.ifStart = ifStart;
    }

    final private int numberClient;
    private static String  currentBalance;
    JLabel description= new JLabel("<html>Some instructions: your initial balance is 200$ <br />" +
            "1. Press 'Start'. 2. Enter amount in text area in format '121.12'.<br /> " +
            "3. Click on <increase> or <decrease> button." +
            " 4. After that you can watch your changed balance by pressing the button 'show current balance'.</html>");
    Button decr=new Button("decrease");
    Button incr=new Button("increase");
    Button show=new Button("show current balance");
    Button start =new Button("Start");
    JTextField txa = new JTextField();

    public  GUI( int numberClient) {
        super("Bank account");
        this.numberClient = numberClient;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if(numberClient==2){
                Client_2.closeOperation();}
                if(numberClient==1){
                    Client_1.closeOperation();}
                dispose();
            }
        });
        setLayout(null);
        setBackground(new Color(150, 200, 100));
        setSize(600, 250);
        add(decr);
        add(start);
        add(txa);
        add(incr);
        add(show);
        add(description);
        decr.setBounds(450, 125, 100, 30);
        decr.addActionListener(this);
        incr.setBounds(50, 125, 100, 30);
        incr.addActionListener(this);
        show.setBounds(325, 180, 150, 30);
        show.addActionListener(this);
        start.setBounds(125, 180, 150, 30);
        start.addActionListener(this);
        txa.setBounds(200, 125, 200, 30);
        description.setBounds(100, 25, 450, 100);
        this.show();
        this.setLocationRelativeTo(null);

    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==start) {
            setIfStart(1);
        }
        if (ae.getSource()==incr && getIfStart()==1){

            String a= txa.getText();
            try{
            double b= Double.parseDouble(a);

            if(numberClient==1){
                Client_1.increase(b);
            }
            if(numberClient==2){
            Client_2.increase(b);
            }}
            catch (NumberFormatException e){
                txa.setText("Check you entry and repeat!");
            }
        } else if (ae.getSource()==decr && getIfStart()==1){
            String a= txa.getText();
            try{
            double b= Double.parseDouble(a);
                b=0-b;
            if(numberClient==1) {
                Client_1.decrease(b);
            }
            if(numberClient==2){
                Client_2.decrease(b);
            }
        }catch (NumberFormatException e){
                txa.setText("Check you entry and repeat!");
            }
        }
        else if (ae.getSource()==show && getIfStart()==1){
            if(numberClient==1) {
                Client_1.showOut();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                txa.removeAll();
                txa.setText(getCurrentBalance());
            }
            if(numberClient==2) {
                Client_2.showOut();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                txa.removeAll();
                txa.setText(getCurrentBalance());
            }
        }
}
    public static void showIn(String v){
        v= v.trim();
        setCurrentBalance(v);
    }
}
