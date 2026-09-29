package com.prasad.lld.patterns.creational.singleton;
public class Main {

    public static void main(String[] args) {

        Runnable task = () -> {
            Employee employee = Employee.getEagerInstance();

            System.out.println(
                    Thread.currentThread().getName()
                            + " -> "
                            + employee
            );
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");
        Thread t4 = new Thread(task, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}