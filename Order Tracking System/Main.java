import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Operations operations = new Operations();
        Scanner scanner = new Scanner(System.in);
        OrderTrackingSystem.PhaseList();

        System.out.println("Welcome to the Order Management System!");
        while (true) {
            System.out.println("1. Authenticate Company");
            System.out.println("2. Place Order");
            System.out.println("3. Cancel Order");
            System.out.println("4. Track Order");
            System.out.println("5. View Order Details");
            System.out.println("6. Admin Panel");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter company password: ");
                    String password = scanner.nextLine();
                    operations.authenticateCompany(password);
                    break;
                case 2:
                    if (operations.companyLoggedIn) {
                        System.out.print("Enter Order ID: ");
                        int orderId = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter Source: ");
                        String source1 = scanner.nextLine();
                        String source = source1.toLowerCase();

                        System.out.print("Enter Destination: ");
                        String destination1 = scanner.nextLine();
                        String destination = destination1.toLowerCase();
                        operations.placeOrder(orderId, source, destination);
                    } else {
                        System.out.println("You must log in as a company first.");
                    }
                    break;
                case 3:
                    if (operations.companyLoggedIn) {
                        System.out.print("Enter Order ID to cancel: ");
                        int orderId = scanner.nextInt();
                        operations.cancelOrder(orderId);
                    } else {
                        System.out.println("You must log in as a company first.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Order ID to track: ");
                    int orderIdToTrack = scanner.nextInt();
                    operations.trackOrder(orderIdToTrack);
                    break;
                case 5:
                    System.out.print("Enter Order ID to view details: ");
                    int orderIdToView = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    String orderDetails = Operations.orderDetails(orderIdToView);
                    System.out.println(orderDetails);
                    break;
                case 6:
                    if (operations.companyLoggedIn == false) {
                        System.out.println("You must log in as a company first.");
                        break;
                    }
                    System.out.println("1) Display the phase \n2) Add new Phase \nEnter your choice");
                    int a = scanner.nextInt();
                    scanner.nextLine();
                    switch (a) {
                        case 1:
                            Operations.display();
                            break;
                        case 2:
                            System.out.println("Enter the name of the phase : ");
                            String name = scanner.nextLine();
                            System.out.println("Enter the distance : ");
                            int dis = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter the time to reach next phase : ");
                            String time = scanner.nextLine();
                            Genral_Methods.addNextPhase(name, dis, time);
                            break;
                        default:
                            System.out.println("Enter valid option");
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Exiting the Order Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
