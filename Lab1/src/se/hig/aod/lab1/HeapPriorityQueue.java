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

        /**
         * Creates a new array with @{@link Comparable} elements and sets the array's maxsize
         *
         * @param maxSize
         */
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

                        T lastElement = heap[size - 1];
                        heap[0] = lastElement;
                        size--;
                        reHeapDown(0);

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
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < size; i++) {
                        stringBuilder.append(heap[i]).append(" ");
                }
                return stringBuilder.toString();
        }
        
        private int parent(int currentIndex) {
                return (int) Math.floor((double) (currentIndex - 1) / 2);
        }

        private int leftChild(int currentIndex) {
                return (currentIndex * 2) + 1;
        }

        private int rightChild(int currentIndex) {
                return (currentIndex * 2) + 2;
        }

        private void reHeapUp(int currentIndex) {
                if (isNotRoot(currentIndex) && isGreaterThanParent(currentIndex)) {
                        swap(currentIndex, parent(currentIndex));
                        reHeapUp(parent(currentIndex));
                }
        }

        protected void reHeapDown(int currentIndex) {
                if (leftChild(currentIndex) > size - 1) {
                        return;
                }

                int greaterChild = getGreaterChild(currentIndex);

                if (isGreaterThan(greaterChild, currentIndex)) {
                        swap(greaterChild, currentIndex);
                        reHeapDown(greaterChild);
                }
        }

        private int getGreaterChild(int currentIndex) {
                if (leftIsGreaterThanRight(currentIndex)) {
                        return leftChild(currentIndex);
                } else {
                        return rightChild(currentIndex);
                }
        }

        private boolean isNotRoot(int currentIndex) {
                return currentIndex != 0;
        }

        private boolean isGreaterThanParent(int currentIndex) {
                return isGreaterThan(currentIndex, parent(currentIndex));
        }

        private boolean leftIsGreaterThanRight(int currentIndex) {
                return isGreaterThan(leftChild(currentIndex), rightChild(currentIndex));
        }

        private boolean isGreaterThan(int index, int otherIndex) {
                return heap[index].compareTo(heap[otherIndex]) > 0;
        }

        private void swap(int index, int otherIndex) {
                T currentValue = heap[index];
                heap[index] = heap[otherIndex];
                heap[otherIndex] = currentValue;
        }
}
