package com.jinny.java.general.javaTraining.javaEtc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kassy.
 * Date: 2019-11-26
 */
public class ComparableExam01 {

    public static void main(String[] args) {

        Car car1 = new Car("K2", 2, "red");
        Car car2 = new Car("K10", 10, "red");
        Car car3 = new Car("K8", 8, "red");

        List<Car> carList = Arrays.asList(car1, car2, car3);

        /**
         * [정상 코드]
         * Car 객에체서 Comparable 인터페이스를 실행하고 compareTo() 메서드 구현체를 작성해주면,
         * Collections.sort 를 사용하여 정렬할 수 있다.
         */
        Collections.sort(carList);
        for(Car c : carList) {
            System.out.println(c.getModel());
        }


        /**
         * [문제 코드]
         * 정렬하고자 하는 객체에서 Comparable 인터페이스를 구현하지 않으면
         * Collections.sort 로 sort 기능을 사용할 수 없다.
         */
        List<test> testList = Arrays.asList(
                new test("K2", 2, "red"),
                new test("K10", 10, "red"),
                new test("K8", 8, "red")
        );
        // Collections.sort(testList);     // compile error >> sort 사용할 수 없음.
    }

}

class Car implements Comparable<Car> {

    private String modelName;
    private int modelYear;
    private String color;

    Car(String mn, int my, String c){
        this.modelName = mn;
        this.modelYear = my;
        this.color = c;
    }

    public String getModel() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                ", modelYear=" + modelYear +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car obj) {
        if(this.modelYear == obj.modelYear) return 0;
        else if(this.modelYear < obj.modelYear) return -1;
        else return 1;
    }
}

class test {
    private String modelName;
    private int modelYear;
    private String color;

    test(String mn, int my, String c){
        this.modelName = mn;
        this.modelYear = my;
        this.color = c;
    }

    public String getModel() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                ", modelYear=" + modelYear +
                ", color='" + color + '\'' +
                '}';
    }
}
