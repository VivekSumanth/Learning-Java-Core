package ProducerCosnsumerPattern;
import java.util.List;
public class Database {

    private List<String> database;

    Database(List<String> data){
        this.database = data;
    }

    //add data adds the data into the database(Producer)
    public void adddata(String[] data) {
        String total_data[] = data;
        for (String each : total_data) {
            System.out.println("adding into the database " + each);
            synchronized (database) {
                this.database.add(each);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }

        }
        synchronized (database) {
            database.add("EOF");
        }
    }
    //send data sends is consumer part of the code
    public void senddata(){
        while(true){
            synchronized (database) {
                if (database.isEmpty()) {
                    continue;
                }
                if (database.get(0).equals("EOF")) {
                    break;
                } else {
                    System.out.println(database.remove(0));
                }
            }
        }

    }
}
