public class PrahinogHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize heap
    public PrahinogHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Method to insert a new value into the heap
    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full");
            return;
        }

        heap[size] = value;
        size++;

        heapifyUp(size - 1);
    }

    // Method to move the element at index up to restore the heap property
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        // Continue moving up until we find the correct spot
        while (index > 0 && heap[index] > heap[parentIndex]) {
            // Swap the current element with its parent
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    // Method to swap elements
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Method to print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrahinogHeap prahinogHeap = new PrahinogHeap(10);

        prahinogHeap.insert(20);
        prahinogHeap.insert(15);
        prahinogHeap.insert(30);
        prahinogHeap.insert(10);
        prahinogHeap.insert(5);

        prahinogHeap.printHeap(); // Output should be a max-heap representation
    }
}
