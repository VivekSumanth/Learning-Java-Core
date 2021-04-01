package ProducerCosnsumerPattern;

public class Consumer implements Runnable{

    Database dref;


    Consumer(Database d){
        dref = d;
    }

    @Override
    public void run() {
        dref.senddata();
    }
}
