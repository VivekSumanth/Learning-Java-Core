package Threads;

class task extends Main implements Runnable{

    Printer pref;

    task(Printer p){
        pref = p;
    }

    public void run(){
        pref.printdocuments(5,"vivek");
    }
}