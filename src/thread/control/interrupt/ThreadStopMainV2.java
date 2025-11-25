package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();
        
        sleep(4000);
        log("작업 중단지시 thread.interrupt");
        thread.interrupt();
        log("스레드 인터럽트상태1 = " + thread.isInterrupted());
    }
    
    static class MyTask implements Runnable {
        
        @Override
        public void run() {
            try {
                while (true) {
                    log("작업중");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());
                log("메세지 = " + e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("작업 종료");
        }
    }
}
