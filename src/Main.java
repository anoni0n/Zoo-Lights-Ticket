import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = "";
        boolean discount = false;
        boolean canDrink = false;
        boolean canRideTrain = false;
        int adults = 0;
        int kids = 0;
        int teens = 0;
        int partyMembers = 0;
        int age;
        double cost = 0;
        int ID = (int)(Math.random()*100000);

        System.out.println("What is your full name?");
        userName = scanner.nextLine();

        System.out.println("What date would you like to visit the zoolights?");
        String dayOfEntry = scanner.nextLine();
        boolean isWeekend = isWeekend(dayOfEntry);

        System.out.println("Enter your date of birth (mm/dd/yyyy):");
        String birthday = scanner.nextLine();

        System.out.println("How would you like to access the zoo lights? (drivethrough/walkthrough)");
        boolean walking = scanner.nextLine().equals("walkthrough");

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
        }
        else {
            System.out.println("How many adults are in your party?");
            partyMembers = scanner.nextInt();
        }

        System.out.println("Enter discount code:");
        scanner.nextLine();
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

        System.out.println("Would you like to ride the train? (yes/no)");
        if (scanner.nextLine().equals("yes")) {
            System.out.println("Input your height (in):");
            int height = scanner.nextInt();
            System.out.println("Input your weight (lbs):");
            int weight = scanner.nextInt();
            if (height > 48 && weight < 300 && walking) {
                canRideTrain = true;
            }
        }

        Ticket ticket = new Ticket(ID, userName, age, cost, canDrink, canRideTrain);
        ticket.printTicket();
        }

        public static int getAge(String birthday, String dayOfEntry){

            int age = 0;
            int birthYear = Integer.parseInt(birthday.substring(6, 10));
            int birthMonth = Integer.parseInt(birthday.substring(0, 2));
            int birthDate = Integer.parseInt(birthday.substring(3, 5));

            int yearOfEntry = Integer.parseInt(dayOfEntry.substring(6, 10));
            int monthOfEntry = Integer.parseInt(dayOfEntry.substring(0, 2));
            int dateOfEntry = Integer.parseInt(dayOfEntry.substring(3, 5));

            if ((yearOfEntry - birthYear > 21 || (yearOfEntry - birthYear == 21 && monthOfEntry > birthMonth) || (yearOfEntry - birthYear == 21 && monthOfEntry == birthMonth && dateOfEntry > birthDate))) {
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