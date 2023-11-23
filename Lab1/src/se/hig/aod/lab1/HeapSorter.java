package se.hig.aod.lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Sorts values of generic type T in a @{@link List} using a @{@link HeapPriorityQueue}
 */
public class HeapSorter {

        public static void main(String[] args) {
                List<Integer> inputList = List.of(17, 42, 8, 3, 29, 14, 5, 37, 21, 50, 2, 48, 12, 35, 7, 18);
                List<Integer> sortedList = sort(inputList);

                System.out.println("Input List: " + inputList);
                System.out.println("Sorted List: " + sortedList);
        }

        /**
         * Sorts a @{@link List} with @{@link Comparable} elements using Max-Heap sorting
         *
         * @param inputList @{@link List} with @{@link Comparable} elements
         * @param <T>       a @{@link Comparable} generic type
         * @return sorted list with largest to smallest value
         */
        public static <T extends Comparable<? super T>> List<T> sort(List<T> inputList) {
                HeapPriorityQueue<T> heap = new HeapPriorityQueue<>(inputList.size());
                
                inputList.forEach(heap::enqueue);

                ArrayList<T> sortedList = new ArrayList<>();

                while (!heap.isEmpty()) {
                        T maxValue = heap.dequeue();
                        sortedList.add(maxValue);
                }

                return sortedList;
        }

}
