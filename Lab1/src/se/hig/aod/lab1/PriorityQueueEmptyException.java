package se.hig.aod.lab1;

/**
 * Exception that can be thrown to indicate that a @{@link PriorityQueue} is empty
 *
 * @author Selma Abbassi
 */
public class PriorityQueueEmptyException extends RuntimeException {

        /**
         * Calls the @{@link RuntimeException} super constructor with a message describing the error that occurred when a @{@link PriorityQueue} is empty
         *
         * @param message
         */
        public PriorityQueueEmptyException(String message) {
                super(message);
        }
}
