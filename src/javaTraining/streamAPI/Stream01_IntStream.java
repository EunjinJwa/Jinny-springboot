package javaTraining.streamAPI;
import java.util.stream.IntStream;

/**
 * IntStream을 사용하여 무한 Int Stream 생성
 *
 * @since 2019-10-13
 */
public class Stream01_IntStream {

    public static void main(String[] args) {

        // range(시작값, 종료값 + 1)
        IntStream.range(1, 10).forEach(i -> System.out.print(i + " "));     // 1~9 까지 숫자

        // rangeClosed(시작값, 종료값)
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.println(i + " "));     // 1 ~ 10 까지 숫자

        // iterate(seed, 증가식)
        // 증가식의 결과값이 i 값으로 계속 들어가면서 stream 진행이 된다.
        IntStream.iterate(1, i -> i + 1)
                .forEach(i -> System.out.println(i + " "));

    }
}
