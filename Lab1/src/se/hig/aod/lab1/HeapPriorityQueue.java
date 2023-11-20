package se.hig.aod.lab1;

/**
 * A static heap implementation of a priority queue for elements of type T.
 *
 * @param <T> Data type of elements stored in the queue.
 * @author Selma Abbassi
 */
public class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T> {

        private T[] heap;
        private int size;
        private final int maxSize;

        public HeapPriorityQueue(int maxSize) {
                this.heap = (T[]) (new Comparable[maxSize]);
                this.maxSize = maxSize;
                this.size = 0;
                clear();
        }

        @SuppressWarnings("unchecked")
        @Override
        public void clear() {
                heap = (T[]) (new Comparable[maxSize]); // Create empty array of size maxSize
                size = 0;
        }

        @Override
        public boolean isEmpty() {
                return size == 0;
        }

        /**
         * Method that is specific for a static implementation of the heap, checks if
         * the underlying array is full.
         *
         * @return true if the underlying array is full
         */
        public boolean isFull() {
                return size == maxSize;
        }

        @Override
        public int size() {
                return size;
        }

        @Override
        public void enqueue(T newElement) {
                if (isFull()) {
                        throw new PriorityQueueFullException("Heap is full!");
                }
                heap[size] = newElement;
                reHeapUp(size);
                size++;
        }

        @Override
        public T dequeue() {
                if (isEmpty()) {
                        throw new PriorityQueueEmptyException("Cannot dequeue empty Queue!");
                } else {
                        T dequeuedElement = heap[0];// the root element of the heap

                        // TODO Code that moves the last element in the heap to the root of the heap
                        size--;
                        // TODO reHeapDown for the new root of the heap

                        return dequeuedElement;
                }
        }

        @Override
        public T getFront() {
                if (isEmpty()) {
                        throw new PriorityQueueEmptyException("Cannot get front of empty Queue!");
                } else {
                        return heap[0];
                }
        }

        @Override
        public String toString() {
                String stringRepresentation = "";
                for (int i = 0; i < size; i++) {
                        stringRepresentation = stringRepresentation + heap[i] + " ";
                }
                return stringRepresentation;
        }

        private int parent(int currentIndex) {
                return (int) Math.floor((double) (currentIndex - 1) / 2);
        }

        private int leftChild(int currentIndex) {
                return (currentIndex * 2) + 1;
        }

        private int rightChild(int currentIndex) {
                return leftChild(currentIndex) + 1;
        }

        private void reHeapUp(int currentIndex) {
                if (isNotRoot(currentIndex) && isGreaterThanParent(currentIndex)) {
                        swap(currentIndex);
                        reHeapUp(parent(currentIndex));
                }
        }

        private void reHeapDown(int currentIndex) {
                // TODO Recursive implementation
        }

        private boolean isNotRoot(int currentIndex) {
                return currentIndex != 0;
        }

        private boolean isGreaterThanParent(int currentIndex) {
                return heap[currentIndex].compareTo(heap[parent(currentIndex)]) > 0;
        }

        private void swap(int currentIndex) {
                T currentValue = heap[currentIndex];
                int parent = parent(currentIndex);
                heap[currentIndex] = heap[parent];
                heap[parent] = currentValue;
        }
}
