package thread.start.test;

import util.MyLogger;

import static util.MyLogger.*;

public class StartTest2Main {
    public static void main(String[] args) {
        
        CounterRunnable counterRunnable = new CounterRunnable();
        
        Thread counter = new Thread(counterRunnable);
        counter.start();
    }
    
    static class CounterRunnable implements Runnable {
        
        @Override
        public void run() {
            for (int i = 1; i <=5 ; i++) {
                log("value = " + i);
            }
        }
    }
}
