public class Ticket {

    private final int ID;
    private final String userName;
    private final int age;
    private final double cost;
    private final boolean canDrink;
    private final boolean canRideTrain;

    public Ticket(int ID, String userName, int age, double cost, boolean canDrink, boolean canRideTrain){
        this.ID = ID;
        this.userName = userName;
        this.age = age;
        this.cost = cost;
        this.canDrink = canDrink;
        this.canRideTrain = canRideTrain;
    }
    public int getTicketID(){
        return ID;
    }
    public void printTicket(){
        System.out.printf("%nID: %d%nNAME: %s%nAGE: %d%nCOST: %.2f%nCAN ACCESS ALCOHOL AREA: %s%nCAN RIDE TRAIN: %s%n", ID, userName, age, cost, canDrink, canRideTrain);
    }
}
