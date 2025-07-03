package thread.control.join;

import static java.lang.Thread.sleep;
import static util.MyLogger.log;

public class JoinMainV4 {
    public static void main(String[] args) throws InterruptedException {
        log("Start");
        
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");
        
        thread1.start();
        thread2.start();
        
        // 스레드가 종료될 때 까지 대기
        log("join() - main 스레드가 thread1 1초 대기");
        thread1.join(1000);
        log("main 스레드 대기완료");
        
        log("task1.result = " + task1.result);
        log("End");
    }
    
    static class SumTask implements Runnable {
        
        int startValue;
        int endValue;
        int result;
        
        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }
        
        @Override
        public void run() {
            log("작업 시작");
            try {
                sleep(2000);
                int sum = 0;
                for (int i = startValue; i <=endValue ; i++) {
                    sum += i;
                }
                result = sum;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log("작업 완료 result = " + result);
        }
    }
}
