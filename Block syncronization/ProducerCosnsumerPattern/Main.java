package ProducerCosnsumerPattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> data = new ArrayList<String>();
        Database ref = new Database(data);
        (new Thread(new Producer(ref))).start();
        (new Thread(new Consumer(ref))).start();

//        Runnable prf = new Producer(ref);
//        Thread t1 = new Thread(prf);
//        Runnable crf = new Consumer(ref);
//        Thread t2 = new Thread(crf);

//
//        t1.start();
//        t2.start();

    }
}
