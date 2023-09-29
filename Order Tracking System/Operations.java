import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Operations extends Order {
    private static Queue<Order> orders;
    boolean companyLoggedIn;
    private String password = "123456";

    public Operations() {
        Operations.orders = new LinkedList<>();
        this.companyLoggedIn = false; // Initially, the company is not logged in
    }

    // Authenticates the company using a password
    public void authenticateCompany(String password) {
        if (this.password.equals(password)) {
            System.out.println("Company login successful.");
            companyLoggedIn = true;
        } else {
            System.out.println("Invalid password. Company login failed.");
        }
    }

    public void placeOrder(int orderId, String source, String destination) {
        if (!companyLoggedIn) {
            System.out.println("You must log in as a company to place an order.");
            return;
        }

        Queue<Order> temp1 = orders;
        int i = 0;
        while (!temp1.isEmpty()) {
            temp1.remove();
            i++;
        }

        Date orderDate = new Date(); // Get the current date and time
        Order order = new Order(orderId, source, destination, orderDate);

        // Calculate the expected delivery date
        int c = 0;
        if (OrderTrackingSystem.headquarter != null) {
            OrderTrackingSystem.Phase temp = OrderTrackingSystem.headquarter;
            while (temp != null) {
                if (temp.name.equals(destination)) {
                    Date expectedDeliveryDate = Order.expectedDeliveryDate(orderDate, source, destination, i);
                    order.setExpectedDeliveryDate(expectedDeliveryDate);
                    c = 1;
                    break;
                }
                temp = temp.nextPhase;
            }
            if (c == 0) {
                System.out.println("Destination not found!");
                return;
            }
        }
        orders.add(order);
    }

    public void cancelOrder(int orderId) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getOrderId() == orderId) {
                order.cancelOrder();
                System.out.println("Order ID " + orderId + " has been cancelled.");
                orders.remove(order);
                return;
            }
        }
        System.out.println("Order ID " + orderId + " not found.");
    }

    public void trackOrder(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId && !order.getStatus().equals("Cancelled")) {
                System.out.println("Order number " + order.getOrderId() + " will be delivered before "
                        + order.getExpectedDeliveryDate());
                return;
            }
            if (order.getStatus().equalsIgnoreCase("Cancelled")) {
                System.out.println("Order number : " + order.getOrderId() + " is cancelled");
                return;
            }
        }
        System.out.println("Order ID " + orderId + " not found.");
    }

    public static String orderDetails(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                return "Order ID: " + order.getOrderId() +
                        "\nSource: " + order.getSource() +
                        "\nDestination: " + order.getDestination() +
                        "\nStatus: " + order.getStatus() +
                        "\nOrder Date: " + dateFormat.format(order.getOrderDate()) +
                        "\nExpected Delivery Date: " + dateFormat.format(order.getExpectedDeliveryDate());
            }
        }
        return "Order ID " + orderId + " not found.";
    }
}
