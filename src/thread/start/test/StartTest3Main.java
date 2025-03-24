package thread.start.test;

import util.MyLogger;

public class StartTest3Main {
    public static void main(String[] args) {
        
        Thread counter = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    MyLogger.log("value = " + i);
                }
            }
        });
        counter.start();
        
    }
}
