package dev.jinny.java.study.general.training.FunctionalInterface;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Supplier
 *
 * 전달값 없이 리턴값만 있는 인터페이스
 *
 * .get()을 호출해야만 결과를 리턴하므로 , 이 점을 활용하여 사용하면 된다.
 *
 * @since 2019-10-13
 */
public class Java04_Supplier {
    public static void main(String[] args) {

        /** 1. Supplier 기본 사용법 */
        final Supplier<String> helloSupplier = () -> "Hello ";  // parameter가 없으므로 빈괄호 ()를 작성한다.
        System.out.println(helloSupplier.get() + "World");



        /** 2. Supplier를 활용하는 예제 */

        /* 2-1 메서드 호출 - 조건에 상관없이 항상 getName()을 호출하여 시간이 오래 소요됨. */
        long startTime = System.currentTimeMillis();
        printValidName(1, getName());   // 3초 소요
        printValidName(-2, getName());  // 3초 소요
        System.out.println( "소요시간 : " + ((System.currentTimeMillis() - startTime)/1000) + "초" );    // 6초
        // 조건과 상관없이 항상 getName() 메서드를 호출함으로써, 호출하는 개수만큼 시간이 걸린다.

        /* 2-2 메서드 호출 - Supplier를 사용하여 필요할때만 getName() 을 호출하도록 함. */
        long startTime2 = System.currentTimeMillis();
        printValidNameForSupplier(1, () -> getName());  // 3초 소요
        printValidNameForSupplier(-2, () -> getName());     // 조건부함x. getName() 메서드 실행하지 않음.
        System.out.println( "소요시간 : " + ((System.currentTimeMillis() - startTime2)/1000) + "초" );   // 3초
        // 조건에 맞을때만 getName() 메서드를 호출함으로써, 시간이 단축되는것을 확인할 수 있다.

        /* 2-2 메서드 사용 - 위의 람다식을 메서드로 풀어서 사용하면 아래와 같다. */
        Supplier<String> suppliers = new Supplier<String>() {
            @Override
            public String get() {
                return getName();
            }
        };
        printValidNameForSupplier(1, suppliers);

    }



    /** 2. int 값이 조건에 부합하는 경우 Name값을 출력해주는 메서드
     *
     * 실제 name 이 필요한 경우는, number의 값이 0보다 큰 경우, 즉 조건에 부합하는 경우에만 필요하다.
     * */

    /**
     * 2-1. 부하가 오래걸리는 코드
     * @param number
     * @param name
     */
    private static void printValidName(int number, String name){
        if(number > 0){
            System.out.println("Name is " + name);
        }else{
            System.out.println("Invalid");
        }
    }

    /**
     * 2-2. Supplier를 사용하여, 필요한 순간에만 getName 메서드를 실행하는 코드
     * @param number
     * @param sp
     */
    private static void printValidNameForSupplier(int number, Supplier sp){
        if(number > 0){
            System.out.println(sp.get());
        }else{
            System.out.println("Invalid");
        }
    }



    /** 한번 처리하는데 3초가 걸리는 비용이 큰 메서드*/
    private static String getName(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "kassy";
    }


}
