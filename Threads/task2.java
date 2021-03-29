package Threads;

public class task2 implements Runnable{
    Printer pref;

    task2(Printer p){
        pref = p;
    }

    public void run(){
        pref.printdocuments(5,"anoo");
    }
}