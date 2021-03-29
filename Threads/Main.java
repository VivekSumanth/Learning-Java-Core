package Threads;


public class Main {
    public static void main(String[] args) {

        //job 1
        System.out.println("----- Application Started ---------");


        Printer printer = new Printer(); // reference to the Printer in printer obj

        Runnable mref = new task(printer); // reference variable printer is pointing to the object which implements the printer
        Runnable yref = new task2(printer);

        Thread task = new Thread(mref); // Thread object is created with runnable object
        Thread task2 = new Thread(yref);

        task2.start(); //starting the task

        // join block used for synchronization
//        try {
//            task2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        task.start();


        //job 3
        System.out.println("-------- Application job done ------");
    }
}
