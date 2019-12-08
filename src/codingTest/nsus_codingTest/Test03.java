package codingTest.nsus_codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Test03 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
            String strTotal = br.readLine();
            String strShareRates = br.readLine();
//
            final double total_amount = Double.valueOf(strTotal);
            String[] arr = strShareRates.split(" ");
            final double[] share = Arrays.stream(arr).mapToDouble(Double::valueOf).toArray();
            final double share_sum = Arrays.stream(share).reduce((d1, d2) -> d1 + d2).orElse(.0);

            // 소수점 둘째자리에서 반올림처리
            String result = Arrays.stream(share)
//            .map(s -> total_amount * (s / share_sum))
                    .map(s ->Math.round(total_amount * (s / share_sum)*10)/10.0)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));

            System.out.println(result);

            double a = Math.round(3.333*10)/10.0;
            System.out.println(a);
        } catch (Exception e){

        }

	}
}
