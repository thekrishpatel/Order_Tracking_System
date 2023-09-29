class OrderTrackingSystem {

    static class Phase {
        String name;
        Phase nextPhase;
        Phase prevPhase;
        String nextTime;
        String prevTime;
        int nextDistance;
        int prevDistance;

        Phase(String name) {
            this.name = name;
            this.nextDistance = 0;
            this.prevDistance = 0;
            this.nextPhase = null;
            this.prevPhase = null;
            this.nextTime = "00:00:00";
            this.prevTime = "00:00:00";
        }
    }

    static Phase headquarter;

    static void addNextPhase(String name, int distance, String time) {
        if (headquarter == null) {
            headquarter = new Phase(name);
            headquarter.nextTime = time;
            headquarter.prevTime = "00:00:00";
            headquarter.nextDistance = distance;
            headquarter.prevDistance = 0;
            return;
        }
        Phase temp = headquarter;
        while (temp.nextPhase != null) {
            temp = temp.nextPhase;
        }
        temp.nextPhase = new Phase(name);
        temp.nextPhase.prevPhase = temp;
        temp = temp.nextPhase;
        temp.nextDistance = distance;
        temp.prevDistance = temp.nextDistance;
        temp.nextTime = time;
        temp.prevTime = temp.prevPhase.nextTime;
    }

    static void PhaseList() {
        addNextPhase("ahmedabad", 57, "03:30:00");
        addNextPhase("nadiad", 80, "03:30:00");
        addNextPhase("anand", 118, "02:00:00");
        addNextPhase("vadodara", 266, "10:00:00");
        addNextPhase("surat", 360, "6:30:00");
        addNextPhase("vapi", 504, "12:00:00");
        addNextPhase("borivali", 531, "03:30:00");
        addNextPhase("mumbai", 0, "00:00:00");
    }
}
