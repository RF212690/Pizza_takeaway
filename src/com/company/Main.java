package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        float total = 0;
        String pizza = "";
        int toppingsNum =0;
        Hashtable<String, Float> pizzas = new Hashtable<String, Float>();
        pizzas.put("small", 7.99f);pizzas.put("medium", 10.99f);pizzas.put("large", 13.99f);
        while (!valid) {
            try {
                System.out.println("Choose a pizza size between small, medium or large");
                pizza = input.next().toLowerCase();
            } catch (Exception e) {
                System.out.println("Are you sure thats a pizza? " + e);
            }
            for (Map.Entry<String, Float> entry : pizzas.entrySet()) {
                if (pizza.equals(entry.getKey())) {
                    valid = true;
                    total = total + pizzas.get(pizza);
                }
            }
            if (!valid) {
                System.out.println("Not a valid size");

            }
        }
        valid=false;
        while(!valid) {
            System.out.println("You can get up to 10 toppings, How many do you want?");
            try {
                toppingsNum = input.nextInt();
                if(toppingsNum >=0 && toppingsNum <=10){
                    valid=true;
                }
                if(toppingsNum >=2){
                    total= (float)(total+(toppingsNum -2)*1.25);
                }
            } catch (Exception e) {
                System.out.println(e);
                input.next();
            }
        }
        String toppings[]= new String[toppingsNum];
        for (int i = 0; i < toppingsNum; i++) {
            do{
                try{
                    System.out.println("Insert topping: ");
                    toppings[i]=input.next();
                    valid=true;
                }catch(Exception e){
                    System.out.println(e);
                    input.next();
                    valid=false;
                }
            }while(!valid);
        }System.out.println("List of your toppings: ");
        for (int i = 0; i < toppingsNum; i++) {
            System.out.print(toppings[i]+", ");

        }
        System.out.println("the total cost is: "+total);

    }
}
