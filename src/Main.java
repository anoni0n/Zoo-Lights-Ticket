import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        ArrayList<Integer> ticketIDs = new ArrayList<>();
        boolean makingTickets = true;
        while (makingTickets){
            Scanner scanner = new Scanner(System.in);
            tickets.add(makeTicket());
            ticketIDs.add(tickets.getLast().getTicketID());
            System.out.println("\nThere are currently "+ tickets.size()+" tickets in the database. Would you like to look one up? (yes/no)");
            boolean validID = !scanner.nextLine().equals("yes");
            while (!validID) {
                System.out.println(ticketIDs);
                System.out.println("Enter the ticket ID to look one up.");
                int targetID = scanner.nextInt();
                for (int i = 0; i < ticketIDs.size(); i++) {
                    if (targetID == ticketIDs.get(i)) {
                        tickets.get(i).printTicket();
                        validID = true;
                        i = ticketIDs.size();
                    }
                    else if (i == tickets.size() - 1) {
                        System.out.println("\nThere is no ticket with that ID in the database. Try looking up a different ID.");
                        System.out.println(ticketIDs);
                        targetID = scanner.nextInt();
                        i = 0;
                    }
                }
                scanner.nextLine();
            }
            System.out.println("Would you like to keep making tickets? (yes/no)");
            makingTickets = scanner.nextLine().equals("yes");
        }
    }

        public static Ticket makeTicket(){
            Scanner scanner = new Scanner(System.in);
            String userName;
            boolean isWeekend;
            boolean walking;
            String birthday;
            boolean discount = false;
            boolean canDrink = false;
            boolean canRideTrain = false;
            int adults = 0;
            int kids = 0;
            int teens = 0;
            int partyMembers = 0;
            int age;
            double cost;
            int ID = 0;
            while (ID < 9999) {
                ID = (int)(Math.random()*100000);
            }

            System.out.println("Enter your full name:");
            userName = scanner.nextLine();

            System.out.println("What date would you like to visit the zoolights? (mm/dd/yyyy)");
            String dayOfEntry = scanner.nextLine();
            isWeekend = isWeekend(dayOfEntry);

            System.out.println("Enter your date of birth (mm/dd/yyyy):");
            birthday = scanner.nextLine();

            System.out.println("How would you like to access the zoo lights? (drivethrough/walkthrough)");
            walking = scanner.nextLine().equals("walkthrough");

            age = getAge(birthday,dayOfEntry);
            if (age >= 21 && walking){
                canDrink = true;
            }


            if (walking){
                System.out.println("How many adults are in your party?");
                adults = scanner.nextInt();
                System.out.println("How many children aged 2 to 14 are in your party?");
                kids = scanner.nextInt();
                System.out.println("How many minors above 15 are in your party?");
                teens = scanner.nextInt();
                System.out.println("Would you like to ride the train? (yes/no)");
                scanner.nextLine();
                if (scanner.nextLine().equals("yes")) {
                    System.out.println("Input your height (in):");
                    int height = scanner.nextInt();
                    System.out.println("Input your weight (lbs):");
                    int weight = scanner.nextInt();
                    scanner.nextLine();
                    if (height > 48 && weight < 300) {
                        canRideTrain = true;
                    }
                }
            }
            else {
                System.out.println("How many people are in your party?");
                partyMembers = scanner.nextInt();
                scanner.nextLine();
            }

            System.out.println("Enter discount code:");
            if (scanner.nextLine().equals("MEMBER")) {
                discount = true;
            }

            if (walking && isWeekend) {
                cost = 25*adults + 12*kids + 18*teens;
            }
            else if (walking) {
                cost = 16 * adults + 8 * kids + 12 * teens;
            }
            else if (partyMembers > 8){
                cost = 65 + 12*(partyMembers - 8);
            }
            else {
                cost = 65;
            }

            if (discount){
                cost *= 0.8;
            }

            return new Ticket(ID, userName, age, cost, canDrink, canRideTrain);
        }

        public static int getAge(String birthday, String dayOfEntry){

            int age = 0;
            int birthYear = Integer.parseInt(birthday.substring(6, 10));
            int birthMonth = Integer.parseInt(birthday.substring(0, 2));
            int birthDate = Integer.parseInt(birthday.substring(3, 5));

            int yearOfEntry = Integer.parseInt(dayOfEntry.substring(6, 10));
            int monthOfEntry = Integer.parseInt(dayOfEntry.substring(0, 2));
            int dateOfEntry = Integer.parseInt(dayOfEntry.substring(3, 5));

            if ((yearOfEntry - birthYear > 21) || (yearOfEntry - birthYear == 21 && monthOfEntry > birthMonth) || (yearOfEntry - birthYear == 21 && monthOfEntry == birthMonth && dateOfEntry >= birthDate)) {
                age = yearOfEntry - birthYear;
            } else if (monthOfEntry > birthMonth || (monthOfEntry == birthMonth && dateOfEntry > birthDate)) {
                age = yearOfEntry - birthYear;
            }
            return age;
        }

        public static boolean isWeekend (String dayOfEntry){

            int month = Integer.parseInt(dayOfEntry.substring(0, 2));
            int date = Integer.parseInt(dayOfEntry.substring(3, 5));
            int century = Integer.parseInt(dayOfEntry.substring(6, 8));
            int year = Integer.parseInt(dayOfEntry.substring(8, 10));

            if (month <= 2) {
                month += 10;
            } else {
                month -= 2;
            }

            int dayOfWeek = (int) (date + (2.6 * month - 0.2) - 2 * century + year + year / 4 + century / 4) % 7;

            return dayOfWeek == 0 || dayOfWeek == 6;
        }
}