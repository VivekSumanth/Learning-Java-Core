package Threads;

public class Printer {
    synchronized void printdocuments(int numberofcopies, String nameofdoc){

        for(int i=0; i<=numberofcopies; i++){
            System.out.println("printing "+ nameofdoc+ "copy "+ i );
        }
    }
}
