package com.nicolas_ForLaba;

public class Account implements Runnable {


    private static String amount="200";

    public static String getAmount() {
        return amount;
    }

    public static void setAmount(String amount) {
        Account.amount = amount;
    }

    public  String  input(String a){
        a= a.trim();
        if(a.equals("one")){
            return getAmount();
        }
        else if(Double.parseDouble(a)<0){
            double b=Double.parseDouble(a);
            String increment= getAmount();
            double c= Double.parseDouble(increment);
            c= c+b;
                if(c>=0){
            String q= c+"";
            setAmount(q);
            return getAmount();}
            else{
                return "you can't decrease this amount, your cash is low!";
            }

        }
        else if(Double.parseDouble(a)>0){
            double b=Double.parseDouble(a);
            String increment= getAmount();
            double c= Double.parseDouble(increment);
            c= c+b;
            String q= c+"";
            setAmount(q);
            return getAmount();

        }
else return "Error "+ 404+"";
    }


    @Override
    public void run() {

    }
}
