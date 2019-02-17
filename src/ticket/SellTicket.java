package ticket;

public class SellTicket{
    public static void main(String[] args) {
        TicketResource resouces = new TicketResource();
        Thread t1 = new Thread(resouces,"窗口1");
        Thread t2 = new Thread(resouces,"窗口2");
        Thread t3 = new Thread(resouces,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
