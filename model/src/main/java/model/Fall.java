package model;

public class Fall implements Runnable {
    @Override
    public void run(){
        while(true){
            System.out.println("Mon traitement");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
