class MedianFinder {
    PriorityQueue<Integer> hi;
    PriorityQueue<Integer> lo;

    public MedianFinder() {
        hi = new PriorityQueue<>(Comparator.reverseOrder());
        lo = new PriorityQueue<>(); 
    } // MedianFinder
    
    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());

        if (lo.size() < hi.size()) lo.offer(hi.poll());
    } // addNum
    
    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (((double) lo.peek() + hi.peek()) * 0.5);
    } // findMedian
} // MedianFinder

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */