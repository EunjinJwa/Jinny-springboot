package dev.jinny.java.utils;

public class EtcUtils {

    private static Runtime runtime = Runtime.getRuntime();

    public static long printHeap(int index) {
        runtime.gc();
        long t = runtime.totalMemory();
        long f = runtime.freeMemory();
        long u = t - f;
        System.out.println(String.format("%d HEAP:%,8d bytes", index, u));

        return u;
    }

}
