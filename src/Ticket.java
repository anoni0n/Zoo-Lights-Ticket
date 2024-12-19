public class Ticket {

    private static int ID;
    private static String userName;
    private static int age;
    private static double cost;
    private static boolean canDrink;
    private static boolean canRideTrain;

    public Ticket(int ID, String userName, int age, double cost, boolean canDrink, boolean canRideTrain){
        Ticket.ID = ID;
        Ticket.userName = userName;
        Ticket.age = age;
        Ticket.cost = cost;
        Ticket.canDrink = canDrink;
        Ticket.canRideTrain = canRideTrain;
    }

    public void printTicket(){
        System.out.printf("%nID: %d%nNAME: %s%nAGE: %d%nCOST: %.2f%nCAN ACCESS ALCOHOL AREA: %s%nCAN RIDE TRAIN: %s", ID, userName, age, cost, canDrink, canRideTrain);
    }
}
