package dev.jinny.java.study.general.training.thread;

/**
 * Thread 생성하는 방법.
 * 1. implements Runnable 하는 방법 (권장)
 * 2. extends Thread 하는 방법
 * Created by Eunjin on 2022-01-08.
 */
public class ThreadEx01 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadEx01_th1());    // Runnablea을 구현한 클래스를 인자값으로 넘겨준다.
        t1.start();

        Thread t2 = new ThreadEx01_th2();                // Thread를 상속받은 클래스를 바로 생성할 수 있다.
        t2.start();
    }
}

/**
 * Runnable 를 구현한 클래스로 만드는 Thread
 * Runnable 을 사용한 구현을 권장함.
 */
class ThreadEx01_th1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("* * " + i);
        }
    }
}

/**
 * Thread 클래스를 상속받아서 만드는 Thread
 */
class ThreadEx01_th2 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("# # " + i);
        }
    }
}