package com.jinny.java.general.codingTest.nsus_codingTest;

import java.util.concurrent.atomic.AtomicInteger;

public class TestEtc {

	public static void main(String[] args) {
		AtomicInteger currentRequestCountw = new AtomicInteger(10);
		int newPeak = currentRequestCountw.incrementAndGet();
		System.out.println(newPeak);
		System.out.println(currentRequestCountw.incrementAndGet());
		
		
	}
}
