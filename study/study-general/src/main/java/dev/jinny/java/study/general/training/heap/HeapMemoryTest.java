package dev.jinny.java.study.general.training.heap;

import dev.jinny.java.utils.EtcUtils;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;

public class HeapMemoryTest {

    /**
     * heap memory 적게 사용하는 코딩
     */

    public static void main(String[] args) {
        stringBufferTest01();
        stringBufferTest02();
        arrayListTest1();
        arrayListTest2();
    }

    /**
     * 그냥 StringBuffer 사용했을 경우
     * 메모리 사용량이 제일 높았음.
     */
    public static void stringBufferTest01() {
        final int max = 5000*1000;
        EtcUtils.printHeap(0);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < max; i++) {
            sb.append("a");
        }
        EtcUtils.printHeap(1);  // 19M 정도 사용됨
        EtcUtils.printHeap(2);
        System.out.println("====================================");
    }

    /**
     * StringBuffer 의 String을 byte 상태로 가지고 있는 경우
     * StringBuffer를 초기화하고, String을 byte 상태로 가지고 있을 때 메모리 사용량이 많이 줄어들었음.
     */
    public static void stringBufferTest02() {
        final int max = 5000*1000;
        EtcUtils.printHeap(0);

        StringBuffer sb = new StringBuffer(max);    // StringBuffer 크기를 선언해주면, 메모리를 좀 덜 잡아먹을 수 있음.
        for (int i = 0; i < max; i++) {
            sb.append("a");
        }
        byte[] b = sb.toString().getBytes();
        sb = null;              // null 초기화 해줌으로써, CG에서 삭제할 수 있도록 함
        EtcUtils.printHeap(1);  // 5M 정도 사용됨
        EtcUtils.printHeap(2);
        System.out.println("====================================");
    }

    /**
     * List에서 데이터를 들고있는 경우 힙 메모리 사이즈
     * StringBuffer 보다 메모리 사이즈가 커졌음.
     */
    public static void arrayListTest1() {
        final int max = 5000*1000;
        EtcUtils.printHeap(0);

        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            arr.add("a");
        }
        EtcUtils.printHeap(1);  // 25M 정도 사용됨
        EtcUtils.printHeap(2);
        System.out.println("====================================");
    }

    /**
     * Array의 size를 지정한 경우
     * 지정하지 않았을 때보다 5M정도 메모리 감소가 나타남.
     */
    public static void arrayListTest2() {
        final int max = 5000*1000;
        EtcUtils.printHeap(0);

        ArrayList<String> arr = new ArrayList<>(max + 1);   // size 지정
        for (int i = 0; i < max; i++) {
            arr.add("a");
        }
        EtcUtils.printHeap(1);  // 20M 정도 사용됨
        EtcUtils.printHeap(2);
        System.out.println("====================================");
    }



}
