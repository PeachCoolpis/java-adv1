package thread.start.test;

import util.MyLogger;

public class StartTest4Main {
    public static void main(String[] args) {
        new Thread(new PrintWork("A",1000),"ThreadA").start();
        new Thread(new PrintWork("B",500),"ThreadB").start();
    }
    
    static class PrintWork implements Runnable {
        private String content;
        private int sleepMs;
        
        public PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }
        
        @Override
        public void run() {
            while (true) {
                MyLogger.log(content);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
