

class MedianFinder {
    // Stores the lower half of numbers (Largest at the top)
    private PriorityQueue<Integer> maxHeap; 
    
    // Stores the upper half of numbers (Smallest at the top)
    private PriorityQueue<Integer> minHeap; 

    public MedianFinder() {
        // Java's PriorityQueue is a Min-Heap by default. 
        // We use Collections.reverseOrder() to turn it into a Max-Heap.
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Always add to the maxHeap first
        maxHeap.offer(num);
        
        // Step 2: Balance the values 
        // Ensure the largest number in the lower half is moved to the upper half
        minHeap.offer(maxHeap.poll());
        
        // Step 3: Balance the sizes
        // We want maxHeap to always have the same size as minHeap, or exactly 1 more.
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // If odd total elements, maxHeap has the extra element (the median)
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } 
        // If even total elements, average the top of both heaps
        else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}