class RideSharingSystem {
    Queue<Integer> drivers;
    Queue<Integer> riders;
    Map<Integer, Boolean> cancellations;

    public RideSharingSystem() {
        this.drivers = new LinkedList<>();
        this.riders = new LinkedList<>();
        this.cancellations = new HashMap<>();
    } // RideSharingSystem
    
    public void addRider(int riderId) {
        riders.offer(riderId);
        cancellations.put(riderId, false);
    } // addRider
    
    public void addDriver(int driverId) {
        drivers.offer(driverId);
    } // addDriver
    
    public int[] matchDriverWithRider() {
        while (!riders.isEmpty() && cancellations.get(riders.peek())) {
            riders.poll();
        } // while

        if (riders.isEmpty() || drivers.isEmpty()) return new int[]{-1, -1};
        return new int[]{drivers.poll(), riders.poll()};
    } // matchDriverWithRider
    
    public void cancelRider(int riderId) {
        cancellations.put(riderId, true);
    } // cancelRider
} // RideSharingSystem

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */