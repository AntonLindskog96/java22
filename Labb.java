package sw.iths.labb;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Labb {
    static TimePrice[] prices;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Elpriser\n" +
                    "========\n" +
                    "1. Inmatning\n" +
                    "2. Min, Max och Medel\n" +
                    "3. Sortera\n" +
                    "4. Bästa Laddningstid (4h)\n" +
                    "e. Avsluta");
            System.out.println("Välj ett alternativ: ");
            String input = scanner.nextLine();
            if (input.equals("e"))
                break;


            if (input.equals("1")) {
                pricesRandom();
                printPrice();

            }
            if (input.equals("2")) {
                highestLowest();
                avgPrice();
            }
            if (input.equals("3")) {
                bubbleSort(prices);
                sortPrice();
            }
        }
    }

    public static void pricesRandom() {
        prices = new TimePrice[24];
        Random rd = new Random();
        for (int i = 0; i < prices.length; i++) {
            prices[i] = new TimePrice(i, rd.nextInt(50, 800));


        }
    }

    public static void printPrice() {
        for (int i = 0; i < 24; i++) {
            System.out.println("Mellan kl: " + printHour(prices[i].getTime()) + " kostar det: " + prices[i].getPrice() + " öre");
        }
    }


    public static void highestLowest() {
        int smallest = prices[0].getPrice();
        int highest = prices[0].getPrice();
        for (int i = 0; i <= 23; i++) {
            if (prices[i].getPrice() < smallest)
                smallest =(prices[i].getPrice());
            if (prices[i].getPrice() > highest)
                highest = prices[i].getPrice();
        }
        System.out.println(highest + " Högsta priset" );
        System.out.println(smallest + " Lägsta priset" );
    }

    public static String printHour(int i) {
        int helpTimer = i + 1;
        if (i < 9)
            return "0" + i + "-0" + helpTimer;
        else if (i < 10)
            return "0" + i + "-" + helpTimer;
        else
            return i + "-" + helpTimer;

    }

    public static void avgPrice() {
        double total = 0;
        for (int i = 0; i < prices.length; i++) {
            total = total + prices[i].getPrice();
        }
        double avg = total / prices.length;
        System.out.println("Medelpriset är: " + avg + " öre.");

    }

    public static void sortPrice() {
        for (int i = 0; i < prices.length; i++) {

            System.out.println("Mellan kl: " + printHour(prices[i].getTime()) + " Kostar det: " +  prices[i].getPrice() + " öre");
        }
    }

    public static void bubbleSort(TimePrice[] prices) {
        boolean bubbleSort = true;
        while (bubbleSort) {
            bubbleSort = false;
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i; j < prices.length-1; j++) {
                    if (prices[i].getPrice() > prices[j + 1].getPrice()) {

                        TimePrice temp = prices[j + 1];
                        prices[j + 1] = prices[i];
                        prices[i] = temp;
                        bubbleSort = true;
                    }
                }

                }
            }

        }

    }


