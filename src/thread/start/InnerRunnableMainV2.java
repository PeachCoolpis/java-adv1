package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV2 {
    
    public static void main(String[] args) {
        log("main start");
        
        
        new Thread(() -> log("run()")).start();
        
        log("main() start");
    }
    
    
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            log("run()");
        }
    }
}

