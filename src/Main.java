import java.util.Scanner;
import java.util.Calendar;

import static java.util.Calendar.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many tickets would you like to purchase?");
        int partyNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your full name");
        String userName = scanner.nextLine();
        System.out.println("What date would you like to attend? (mm/dd/yyyy)");
        String date = scanner.nextLine();

        Calendar calendar = new Calendar() {
            @Override
            protected void computeTime() {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            public void add(int field, int amount) {

            }

            @Override
            public void roll(int field, boolean up) {

            }

            @Override
            public int getMinimum(int field) {
                return 0;
            }

            @Override
            public int getMaximum(int field) {
                return 0;
            }

            @Override
            public int getGreatestMinimum(int field) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int field) {
                return 0;
            }
        };
        calendar.set(2024,DECEMBER,16);
        System.out.println(calendar.get(DAY_OF_WEEK));
    }
}