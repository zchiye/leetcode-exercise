package io.zchiye.javafundamentals.multithreads;

import java.util.concurrent.atomic.AtomicInteger;

public class TakeTurnOutputs {

    private static void takeTurnOutput(int max, int threadNum) throws InterruptedException {
        AtomicInteger target = new AtomicInteger(0);
        AtomicInteger token = new AtomicInteger(0);
        for (int i = 0; i < threadNum; i++) {
            AtomicInteger threadMark = new AtomicInteger(i);
            Thread thread = new Thread(() -> {
                while (target.get() <= max) {
                    if (token.get() % threadNum == threadMark.get()) {
                        System.out.println("Thread " + threadMark.get() + " : " + target.getAndIncrement());
                        token.incrementAndGet();
                    }
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        takeTurnOutput(300, 5);
    }

}
