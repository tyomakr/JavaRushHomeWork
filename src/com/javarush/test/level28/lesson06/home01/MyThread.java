package com.javarush.test.level28.lesson06.home01;


import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

    private static AtomicInteger currentPriority = new AtomicInteger(0);

    public MyThread() {
        initialize();
    }

    private void initialize() {
        currentPriority.incrementAndGet();
        currentPriority.compareAndSet(11, 1);

        int newPriority = currentPriority.get();
        if (getThreadGroup() != null) {
            if (newPriority > getThreadGroup().getMaxPriority()) {
                newPriority = getThreadGroup().getMaxPriority();
            }
        }
        setPriority(newPriority);
    }

    public MyThread(Runnable target) {
        super(target);
        initialize();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        initialize();
    }

    public MyThread(String name) {
        super(name);
        initialize();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        initialize();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        initialize();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        initialize();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        initialize();
    }

}
