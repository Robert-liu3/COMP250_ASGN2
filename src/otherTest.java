public class otherTest {
    public static void main(String[] args) {
        Owner own = new Owner("mcgill");
        Staff staff1 = new Staff("worker", false);
        Server server1 = new Server("cloudberry", 20);

        Restaurant r1 = new Restaurant("rest1", 200, own, staff1, server1);
        Restaurant r2 = new Restaurant("rest2", 500, own, staff1, server1);
        System.out.println(r1.equals(r2)); //will return false if IDs are correctly assigned and .equals() method is working
    }
}
