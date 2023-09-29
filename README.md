# Order Management System

Welcome to the Order Management System! This Java application allows companies to place and manage orders efficiently. It also provides features for tracking orders and viewing order details. Here's a brief overview of the system's functionalities and how to use them.

## Table of Contents
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Authentication](#authentication)
- [Placing an Order](#placing-an-order)
- [Cancelling an Order](#cancelling-an-order)
- [Tracking an Order](#tracking-an-order)
- [Viewing Order Details](#viewing-order-details)
- [Admin Panel](#admin-panel)
- [Exiting the System](#exiting-the-system)

## Getting Started

### Prerequisites
Before using the Order Management System, ensure you have Java installed on your system.

### Authentication
To access the system's features, a company must first authenticate using a password. Follow these steps:

1. Choose option 1: "Authenticate Company."
2. Enter the company's password when prompted.

## Placing an Order

1. After successful authentication, choose option 2: "Place Order."
2. Enter the following information:
   - Order ID: A unique identifier for the order.
   - Source: The starting point of the order.
   - Destination: The destination of the order.
3. The system will calculate the expected delivery date based on the source and destination. The order will be placed.

## Cancelling an Order

1. Choose option 3: "Cancel Order."
2. Enter the Order ID of the order you want to cancel.
3. If the order is found and not already canceled, it will be canceled.

## Tracking an Order

1. Choose option 4: "Track Order."
2. Enter the Order ID of the order you want to track.
3. The system will display the expected delivery date if the order is active. If the order is canceled, it will be indicated.

## Viewing Order Details

1. Choose option 5: "View Order Details."
2. Enter the Order ID of the order for which you want to view details.
3. The system will display detailed information about the order, including its source, destination, status, order date, and expected delivery date.

## Admin Panel

The admin panel is accessible only to authenticated companies. It provides the following functionalities:

1. Display the phases of the order tracking system.
2. Add a new phase to the order tracking system.

To access the admin panel:

1. Choose option 6: "Admin Panel."
2. Select an option:
   - Option 1: Display the phases of the order tracking system.
   - Option 2: Add a new phase by providing its name, distance, and time to reach the next phase.

## Exiting the System

To exit the Order Management System, choose option 7: "Exit." This will close the application.

Thank you for using the Order Management System! If you encounter any issues or have questions, please contact our support team.
