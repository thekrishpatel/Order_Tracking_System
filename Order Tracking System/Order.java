import java.util.Date;

public class Order extends Genral_Methods {
    private int orderId;
    private String source;
    private String destination;
    private String status;
    private Date orderDate;
    private Date expectedDeliveryDate;

    public Order(int orderId, String source, String destination, Date orderDate) {
        this.orderId = orderId;
        this.source = source;
        this.destination = destination;
        this.status = "Placed";
        this.orderDate = orderDate;
        this.expectedDeliveryDate = null;
    }

    Order() {
    };

    public static Date expectedDeliveryDate(Date orderDate, String source, String destination, int pending_orders) {
        double totalDays = calculateTotalTimeBetweenWarehouses(source, destination);
        long millisecondsInADay = 24 * 60 * 60 * 1000;
        long totalMilliseconds = (long) (totalDays * millisecondsInADay) + (pending_orders * 60 * 60 * 1000);
        long expectedDeliveryTimeMillis = orderDate.getTime() + totalMilliseconds;
        Date expectedDeliveryDate = new Date(expectedDeliveryTimeMillis);
        return expectedDeliveryDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public void cancelOrder() {
        this.status = "Cancelled";
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}
