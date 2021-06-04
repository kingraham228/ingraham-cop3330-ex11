package oop.example;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kate Ingraham
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Input {
    double inputEuros;
    double inputExchange;
    BigDecimal euros;
    BigDecimal euroExRate;
    BigDecimal dollars;


   public void setEuros(){
       Scanner input = new Scanner(System.in);
       do {

           System.out.println("How many euros are you exchanging? ");
           while (!input.hasNextDouble()) {
               String str1 = input.next();
               System.out.println(str1 + " is not a valid amount.");
               System.out.println("How many euros are you exchanging? ");
           }
           inputEuros = input.nextDouble();
           if (inputEuros < 0) {
               System.out.println("Euros cannot be a negative value.");
           }
       } while (inputEuros < 0);
       euros = BigDecimal.valueOf(inputEuros);
   }


    public void setEuroExchange(){
        Scanner input = new Scanner(System.in);
           do {
            System.out.println("Enter the exchange rate for dollars equal to one euro.");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid rate.");
                System.out.println("Enter the exchange rate for dollars equal to one euro.");
            }
            inputExchange = input.nextDouble();
            if (inputExchange < 0) {
                System.out.println("Exchange rate cannot be a negative value.");
            }
        } while (inputExchange < 0);
        euroExRate = BigDecimal.valueOf(inputExchange);
    }

    public void calcExchange(){
       dollars = euros.multiply(euroExRate);

       euros = euros.setScale(2, RoundingMode.UP);
       euroExRate = euroExRate.setScale(4, RoundingMode.UP);
       dollars = dollars.setScale(2, RoundingMode.UP);

        System.out.print("You are exchanging "+euros+" euros.\n" +
                "The exchange rate is "+euroExRate+" dollars to 1.00 euro.\n" +
                euros +" euros at an exchange rate of "+euroExRate+" is\n"+dollars+" dollars.\n");

    }



}
