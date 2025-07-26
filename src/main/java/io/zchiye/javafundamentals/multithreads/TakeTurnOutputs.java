package io.zchiye.javafundamentals.multithreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TakeTurnOutputs {

    private static void takeTurnOutput(int max, int threadNum, List<Integer> resultList) throws InterruptedException {
        AtomicInteger target = new AtomicInteger(0);
        AtomicInteger token = new AtomicInteger(0);
        for (int i = 0; i < threadNum; i++) {
            int threadMark = i;
            Thread thread = new Thread(() -> {
                while (target.get() <= max) {
                    if (token.get() % threadNum == threadMark) {
//                        System.out.println("Thread " + threadMark + " : " + target.getAndIncrement());
                        resultList.add(target.getAndIncrement());
                        token.incrementAndGet();
                    }
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startMs = System.currentTimeMillis();
        List<Integer> resultList = new ArrayList<>();
        takeTurnOutput(10000000, 5, resultList);
        long endMs = System.currentTimeMillis();
        System.out.println("CostMs: " + (endMs - startMs));
        System.out.println(checkResultList(resultList));
    }

    private static boolean checkResultList(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) != 1) {
                return false;
            }
        }
        return true;
    }

}
