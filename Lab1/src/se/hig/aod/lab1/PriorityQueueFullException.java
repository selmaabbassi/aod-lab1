package se.hig.aod.lab1;

/**
 * Exception that can be thrown to indicate that a @{@link PriorityQueue} is full
 *
 * @author Selma Abbassi
 */
public class PriorityQueueFullException extends RuntimeException {

        /**
         * Calls the @{@link RuntimeException} super constructor with a message describing the error that occurred when a @{@link PriorityQueue} is full
         *
         * @param message
         */
        public PriorityQueueFullException(String message) {
                super(message);
        }
}
