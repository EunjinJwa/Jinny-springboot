package dev.jinny.java.study.general.training.javaStandard.ch13;

/**
 * Created by Eunjin on 2022-01-08.
 */
public class ThreadEx20 {
    public static void main(String[] args) {
        ThreadEx20_1 gc = new ThreadEx20_1();
        gc.setDaemon(true);
        gc.start();

        int requiredMemory = 0;

        for (int i=0; i < 20; i++) {
            requiredMemory = (int) ((Math.random() * 10) * 20);     // 임의의 required memory 생성

            // 필요한 메모리가 사용할 수 있는 양보다 적거나 전체 메모리의 60%을 사용했을 경우 gc를 깨운다.
            if (gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
                gc.interrupt();     // 잠자고있는(sleep) gc 스레드를 깨운다.
                try {
                    gc.join(100);      // gc를 깨운 후 gc가 모두 수행 후 main 스레드를 실행할 수 있도록 한다.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            gc.usedMemory += requiredMemory;
            System.out.println("usedMemory : " + gc.usedMemory);
        }
    }

}


class ThreadEx20_1 extends Thread {
    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;

    // 10초마다 gc를 수행하는 스레드
    public void run() {
        while (true) {
            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                // 외부적으로 sleep이 깨졌을 경우 Exception 실행됨
                System.out.println("Awaken by interrupt(). ");
            }
            gc();
            System.out.println("Garbage Colleced. Free Memory : " + freeMemory());
        }
    }

    public void gc() {
        usedMemory -= 300;
        if (usedMemory < 0) usedMemory = 0;
    }
    public int totalMemory() { return MAX_MEMORY;}
    public int freeMemory() { return MAX_MEMORY - usedMemory;}
}
