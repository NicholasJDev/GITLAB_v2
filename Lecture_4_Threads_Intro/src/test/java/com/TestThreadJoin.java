package com;

import java.lang.Thread.State;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestThreadJoin {
    /**
     * Fill in the gaps and insert instructions to make code executable
     *
     * @throws InterruptedException
     */
    @Test
    public void testThread() throws InterruptedException {
        Thread thread1 = createThread(() -> {
            try {
                // TODO: design wait right way
                synchronized (this) {
                    wait(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = createThread(() -> {
            try {
                // TODO: design wait right way
                synchronized (this) {
                    wait(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        Thread.sleep(100);

        // TODO: make TIMED_WAITING
        // TODO: make TIMED_WAITING

        assertEquals(thread1.getState(), State.TIMED_WAITING);
        assertEquals(thread2.getState(), State.TIMED_WAITING);

        // TODO: Wait till both threads are completed or terminated
        Thread.sleep(1000);
        // threads should run task to be put on hold
        assertEquals(thread1.getState(), State.TERMINATED);
        assertEquals(thread2.getState(), State.TERMINATED);

        // TODO: fill in action with Thread to exit loop
        while (!Thread.currentThread().isInterrupted()) {
            Thread.currentThread().interrupt();
        }

        assertTrue(Thread.currentThread().isInterrupted());
        assertEquals(Thread.currentThread().getState(), State.RUNNABLE);
    }

    private Thread createThread() {
        final Thread thread = new Thread();
        return thread;
    }

    private Thread createThread(Runnable runnable) {
        final Thread thread = new Thread(runnable);
        return thread;
    }

}