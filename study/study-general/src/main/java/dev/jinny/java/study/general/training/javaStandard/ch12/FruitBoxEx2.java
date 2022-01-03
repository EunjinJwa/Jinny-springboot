package dev.jinny.java.study.general.training.javaStandard.ch12;

/**
 * ch12. 제네릭
 * 제네릭 타입에 'extends'를 사용하면 특정 타입의 자손들만 대입할 수 있다.
 * Created by Eunjin on 2022-01-03.
 */

public class FruitBoxEx2 {

    public static void main(String[] args) {
        // 과일종류만 담도록 설계한 FruitBox
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();

        FruitBox<Apple> appleFruitBox = new FruitBox<>();
        FruitBox<Grape> grapeFruitBox = new FruitBox<>();

        /** Toy 클래스는 Fruit 를 상속받지 않으므로 FruitBox에서 사용할 수 없다. */
        // FruitBox<Toy> toyFruitBox = new FruitBox<Toy>();

        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        /** Toy 클래스는 Fruit의 자손이 아니므로 담을 수 없음 */
//        fruitBox.add(new Toy());

        /** 자손 클래스 & 인터페이스 구현  */
        FruitBoxWhitIf<Peach> fruitBoxWhitIf = new FruitBoxWhitIf<Peach>();
        fruitBoxWhitIf.add(new Peach());
//        fruitBoxWhitIf.add(new Apple());    // Apple 클래스는 Eatable를 구현하지 않았으므로 넣을 수 없다.

    }
}


class FruitBox<T extends Fruit> extends Box<T> {}

interface Eatable {}
// Fruit의 자손이면서 Eatable 인터페이스를 구현하는 클래스를 제네릭 클래스로 사용함
class FruitBoxWhitIf<T extends Fruit & Eatable> extends Box<T> {}

class Peach extends Fruit implements Eatable {
    public String toString() {
        return "Peach";
    }
}
