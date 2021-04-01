package DeadLocks;

public class Main {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
//        Runnable ref = new lock1();
//        Runnable ref2 = new lock2();

        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        t1.start();
        t2.start();
    }
}

class Thread1 implements Runnable{

    @Override
    public void run() {
        synchronized (Main.lock1){
            System.out.println("Thread 1 using lock 1");
            synchronized (Main.lock2){
                System.out.println("Thread 1 using lock 2");
            }
        }
    }
}

// this piece of code causes dead lock because Thread 1 needs lock 2 where as lock 2 is already syncronized with thread 2
// so thread 2 is waiting for lock 2 so this is a dead lock situation.


//class Thread2 implements Runnable{
//
//    @Override
//    public void run() {
//        synchronized (Main.lock2){
//            System.out.println("Thread 2 using lock 2");
//
//            synchronized (Main.lock1){
//                System.out.println("Thread 2 using lock 1");
//            }
//        }
//
//    }
//}

// DeadLock can be cleared by writing the required locks in same order in both the classes as below first both the classes
// uses lock 1 and then lock 2 in this fashion one thread executes after the syncronization lock is released by one thread.
class Thread2 implements Runnable{

    @Override
    public void run() {
        synchronized (Main.lock1){
            System.out.println("Thread 2 using lock 1");

            synchronized (Main.lock2){
                System.out.println("Thread 2 using lock 2");
            }
        }

    }
}