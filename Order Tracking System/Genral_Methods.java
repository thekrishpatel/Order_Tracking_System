public class Genral_Methods extends OrderTrackingSystem {

    static double convertTimeToDays(String time) {
        String[] parts = time.split(":");
        double hours = Double.parseDouble(parts[0]);
        double minutes = Double.parseDouble(parts[1]);
        double seconds = Double.parseDouble(parts[2]);
        return (hours / 24.0) + (minutes / 1440.0) + (seconds / 86400.0);
    }

    static double calculateTotalTimeBetweenWarehouses(String source, String destination) {
        double totalTimeInDays = 0.0;
        Phase currentPhase = sourcePhase(source);
        while (currentPhase != null && !currentPhase.name.equalsIgnoreCase(destination)) {
            totalTimeInDays += convertTimeToDays(currentPhase.nextTime);
            currentPhase = currentPhase.nextPhase;
        }
        return totalTimeInDays;
    }

    static Phase sourcePhase(String source) {
        Phase currentPhase = OrderTrackingSystem.headquarter;
        while (currentPhase != null && !currentPhase.name.equalsIgnoreCase(source)) {
            currentPhase = currentPhase.nextPhase;
        }
        return currentPhase;
    }

    static void display() {
        Phase temp = headquarter;
        while (temp.nextPhase != null) {
            System.out.print(temp.name + "--->");
            temp = temp.nextPhase;
        }
        System.out.println(temp.name);
        temp = headquarter;
        while (temp.nextPhase != null) {
            System.out.print(temp.nextTime + "--->");
            temp = temp.nextPhase;
        }
        System.out.println(temp.nextTime);
    }
}
