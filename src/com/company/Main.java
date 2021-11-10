package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        float total = 0;
        String pizza = "";
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
        String temp="";
        String[] toppings= {"pepperoni","cheese","mushrooms","onions","bacon","green peppers","spinach","black olives",
        "sausage","pineapple"};
        int[] toppingsnum= new int[10];
        ArrayList<String> usertoppings= new ArrayList<>();
        boolean found=false;
            do{
                try{
                    System.out.println("type help to get a list of toppings, type end if you're satisfied.\n"
                    +"Insert topping: ");
                    temp=input.next();
                }catch(Exception e){
                    System.out.println(e);
                    input.next();
                }
                if(temp.equalsIgnoreCase("end")){
                    valid=true;
                }
                else if(temp.equalsIgnoreCase("help")){
                    System.out.println("List of our toppings: ");
                    for (int i = 0; i < toppings.length; i++) {
                        System.out.print(toppings[i]+", ");
                    }
                    System.out.println();
                }
                else{
                    for (int i = 0; i < toppings.length; i++) {
                        if(toppings[i].equalsIgnoreCase(temp)){
                            found=true;
                            if(toppingsnum[i]<2){
                                usertoppings.add(temp.toLowerCase(Locale.ROOT));
                                toppingsnum[i]++;
                                System.out.println("topping added to your pizza");
                            }
                            else{
                                System.out.println("You selected this topping too many times");
                            }
                        }
                    }
                    if(!found){
                        System.out.println("Not one of our toppings");
                    }
                    else{
                        found=false;
                    }
                }

            }while(!valid && usertoppings.size()<20);
            usertoppings.stream().sorted();
            if(usertoppings.size()==20){
            System.out.println("You inserted the maximum amount of toppings");
            }
            if(usertoppings.size()>=2){
                total+=(usertoppings.size()-2)*1.25;
            }
        for (int i = 0; i < usertoppings.size(); i++) {
            for (int j = i+1; j < usertoppings.size(); j++) {
                if(usertoppings.get(i).equals(usertoppings.get(j))){
                    usertoppings.remove(j);
                }
            }
        }
            System.out.println("List of your toppings: ");
            for (int i = 0; i < usertoppings.size(); i++) {
                System.out.print(usertoppings.get(i)+"\n");
            }
            System.out.println();
        System.out.println("the total cost is: "+total);
    }
}
