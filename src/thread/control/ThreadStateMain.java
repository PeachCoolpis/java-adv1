package thread.control;

import util.MyLogger;

import static util.MyLogger.*;

public class ThreadStateMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState());
        log("myThread.start()");
        thread.start();
        
    }
    static class MyRunnable implements Runnable {
        
        @Override
        public void run() {
            try {
                log("start");
                log("myThread.state2 = " + Thread.currentThread().getState());
                log("sleep() start");
                Thread.sleep(3000);
                log("myThread.state3 = " + Thread.currentThread().getState());
                log("sleep() end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
