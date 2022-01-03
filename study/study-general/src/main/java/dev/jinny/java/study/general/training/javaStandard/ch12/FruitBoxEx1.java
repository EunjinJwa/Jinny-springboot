package dev.jinny.java.study.general.training.javaStandard.ch12;

import java.util.ArrayList;

/**
 * Ch12. 제네릭
 * 제넥릭은 본인과 자식 클래스를 허용한다.
 * Created by Eunjin on 2022-01-03.
 */
public class FruitBoxEx1 {

    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<Fruit>();
        Box<Toy> toyBox = new Box<Toy>();

        fruitBox.add(new Fruit());  // 본인 클래스는 당연하게 넣을 수 있음
        fruitBox.add(new Apple());  // 부모 클래스 제네릭은 자식 클래스도 넣을 수 있음
      //  fruitBox.add(new Toy());    // fruitBox 의 Fruit 클래스는 Toy 클래스를 담을 수 없다.
    }
}


class Fruit {
    public String toString() {
        return "Fruit";
    }
}
class Apple extends Fruit {
    public String toString() {
        return "Apple";
    }
}
class Grape extends Fruit {
    public String toString() {
        return "Grape";
    }
}
class Toy {
    public String toString() {
        return"Toy";
    }
}

/**
 * 제네릭을 사용하는 클래스 Box<T>
 * @param <T>
 */
class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) {
        list.add(item);
    }
    T get(int i) {
        return list.get(i);
    }
    int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}




