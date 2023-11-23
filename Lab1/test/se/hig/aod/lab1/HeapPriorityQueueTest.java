package se.hig.aod.lab1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test methods for the Abstract Data Type @{@link HeapPriorityQueue}
 *
 * @author Selma Abbassi
 */
class HeapPriorityQueueTest {

        static final Integer[] INT_FIXTURE = {78, 35, 49, 96, 21, 10, 65, 54, 87, 3};

        HeapPriorityQueue<Integer> nonEmptyQueue;
        HeapPriorityQueue<Integer> emptyQueue;

        /**
         * Creates two queues with a fixed max size, one empty and one with integers, before each test
         */
        @BeforeEach
        void setUp() {
                nonEmptyQueue = new HeapPriorityQueue<>(INT_FIXTURE.length);
                emptyQueue = new HeapPriorityQueue<>(INT_FIXTURE.length);

                for (int testData : INT_FIXTURE) {
                        nonEmptyQueue.enqueue(testData);
                }
        }

        /**
         * Resets both queues after each test and sets them to null
         */
        @AfterEach
        void tearDown() {
                nonEmptyQueue = null;
                emptyQueue = null;
        }

        /**
         * Test method for @{@link HeapPriorityQueue#clear()} on empty queue should clear queue
         */
        @Test
        void testClearNonEmptyQueue() {
                nonEmptyQueue.clear();
                assertTrue(nonEmptyQueue.isEmpty(), "intQueue borde vara tom efter en clear");
        }

        /**
         * Test method for @{@link HeapPriorityQueue#clear()} on non-empty queue should clear queue
         */
        @Test
        void testClearEmptyQueue() {
                emptyQueue.clear();
                assertTrue(emptyQueue.isEmpty(), "emptyQueue should be empty after clear");
        }

        /**
         * Test method for @{@link HeapPriorityQueue#isEmpty()} on empty queue should be true
         */
        @Test
        void testIsEmptyOnEmptyQueue() {
                assertTrue(emptyQueue.isEmpty());
        }

        /**
         * Test method for @{@link HeapPriorityQueue#isEmpty()} on non-empty queue should be false
         */
        @Test
        void testIsEmptyOnNonEmptyQueue() {
                assertFalse(nonEmptyQueue.isEmpty());
        }

        /**
         * Test method for @{@link HeapPriorityQueue#enqueue(Comparable)} on empty queue that checks that the queue is no longer empty after enqueue
         */
        @Test
        void testEnqueueOnEmptyQueue() {
                assertTrue(emptyQueue.isEmpty());
                emptyQueue.enqueue(5);
                assertFalse(emptyQueue.isEmpty());
        }

        /**
         * Test method for @{@link HeapPriorityQueue#enqueue(Comparable)} on non-empty queue should throw @{@link PriorityQueueFullException}
         */
        @Test
        void testEnqueueOnFullQueue() {
                assertThrows(PriorityQueueFullException.class, () -> nonEmptyQueue.enqueue(5), "Enqueue() should throw PriorityQueueFullException when queue is full");
        }

        /**
         * Test method for @{@link HeapPriorityQueue#dequeue()} on empty queue should throw @{@link PriorityQueueEmptyException}
         */
        @Test
        void testDequeueOnEmptyQueue() {
                assertThrows(PriorityQueueEmptyException.class, () -> emptyQueue.dequeue(), "Dequeue() should throw PriorityQueueEmptyException when queue is empty");
        }

        /**
         * Test method for @{@link HeapPriorityQueue#dequeue()} on non-empty queue checks that the size of the queue has decreased and that the front has a new value
         */
        @Test
        void testDequeueOnNonEmptyQueue() {
                assertEquals(10, nonEmptyQueue.size());
                assertEquals(96, nonEmptyQueue.getFront());

                nonEmptyQueue.dequeue();
                assertEquals(9, nonEmptyQueue.size());
                assertEquals(87, nonEmptyQueue.getFront());
        }

        /**
         * Test method for @{@link HeapPriorityQueue#size()} on empty queue should be 0
         */
        @Test
        void testSizeOnEmptyQueue() {
                assertEquals(0, emptyQueue.size());
        }

        /**
         * Test method for @{@link HeapPriorityQueue#size()} on non-empty queue should be 10
         */
        @Test
        void testSizeOnNonEmptyQueue() {
                assertEquals(10, nonEmptyQueue.size());
        }

        /**
         * Test method for @{@link HeapPriorityQueue#getFront()} on empty queue should throw @{@link PriorityQueueEmptyException}
         */
        @Test
        void testGetFrontOnEmptyQueue() {
                assertThrows(PriorityQueueEmptyException.class, () -> emptyQueue.getFront(), "GetFront() should throw PriorityQueueEmptyException when queue is empty");
        }

        /**
         * Test method for @{@link HeapPriorityQueue#getFront()} on non-empty queue should return front element of queue
         */
        @Test
        void testGetFrontOnNonEmptyQueue() {
                Integer front = nonEmptyQueue.getFront();
                assertEquals(96, front);
        }
}
