package javaTraining.streamAPI;


import java.util.Arrays;
import java.util.List;

/**
 * Stream VS 예전방식 비교
 *
 * @since 2019-10-13
 */
public class Stream02_Exam1 {
    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        /**
         * 예제
         * 위 List numbers 요소 중 3보다 크고 9보다 작은수에 대하여 2배수를 한 값에서 10보다 큰 가장 첫 번째 수를 구해라.
         */

        int result1 = gtNum_BadCase(numbers);
        System.out.println(result1);

        int result2 = getNum_Stream(numbers);
        System.out.println(result2);

    }

    /** BAD CASE */
    private static Integer gtNum_BadCase(List<Integer> numbers){
        Integer result = null;

        for(Integer number : numbers){
            if(number > 3 && number < 10){
                final Integer newNumber = number * 2;
                if(newNumber > 10){
                    result = newNumber;
                    break;
                }
            }
        }
        return result;
    }

    /** Stream 사용
     * 효율성 면에서도 더 좋음
     * */
    private static Integer getNum_Stream(List<Integer> numbers){
        Integer result = null;

        result = numbers.stream()
                .filter(i -> i > 3)
                .filter(i -> i < 10)
                .map(i -> i * 2)
                .filter(i -> i > 10)
                .findFirst().orElse(0);

        return result;

    }


}
