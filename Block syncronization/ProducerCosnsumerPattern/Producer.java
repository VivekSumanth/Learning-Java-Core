package ProducerCosnsumerPattern;

public class Producer implements Runnable {

    Database dref;

    Producer(Database d){
        dref = d;
    }
    @Override
    public void run() {
        String total_data[] = {
                "hello world",
                "hello world2",
                "hello world3"
        };
        dref.adddata(total_data);
    }
    }
