package main.java.start;

public class Main extends Thread {

    public static void main(String[] args) {

        Main t = new Main();
        t.start();
    }
    
    public void run() {
        
        System.out.println("Wello Horld");
    }
    
    
    

}
