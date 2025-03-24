package thread.start.test;

import util.MyLogger;

public class StartTest1Main {
    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread();
        counterThread.start();
    }
    
    static class CounterThread extends Thread {
        
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                MyLogger.log("value = " + i);
            }
        }
    }
}
