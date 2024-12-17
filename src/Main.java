import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many tickets would you like to purchase?");
        int partyNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your full name");
        String userName = scanner.nextLine();
        System.out.println("What date would you like to attend? (mm/dd/yyyy)");
        String dayOfEntry = scanner.nextLine();
        if (isWeekend(dayOfEntry)){

        }
    }

    public static boolean isWeekend(String dayOfEntry){

        int month = Integer.parseInt(dayOfEntry.substring(0,2));
        int date = Integer.parseInt(dayOfEntry.substring(3,5));
        int century = Integer.parseInt(dayOfEntry.substring(6,8));
        int year = Integer.parseInt(dayOfEntry.substring(8,10));

        if (month <= 2){
            month += 10;
        }
        else {
            month -= 2;
        }

        int dayOfWeek = (int) (date + (2.6*month - 0.2) - 2*century + year + year/4 + century/4)%7;

        return dayOfWeek == 0 || dayOfWeek == 6;
    }
}