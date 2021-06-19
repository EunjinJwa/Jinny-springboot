package dev.jinny.java.study.general.training.javaEtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Kassy.
 * Date: 2019-11-27
 *
 * Comparator
 * 정렬을 위한 Collections.sort 메서드는 두 번째 인자로 Comparator 인터페이스를 받을 수 있도록 되어있다.
 * Comparator 인터페스의 compare 메서드를 오버라이드 하여 구현하면 된다.
 * compare 메서드를 어떻게 구현하느냐에 따라 오름차순, 내림차순 정렬일 할 수 있다.
 */
public class ComparatorExam01 {

    public static void main(String[] args) {


        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("kassy1", 60));
        studentList.add(new Student("kassy2", 100));
        studentList.add(new Student("kassy3", 95));


        System.out.println("오름차순 정렬 -------------");
        /** 오름차순 정렬 */
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.score == o2.score) return 0;
                else if (o1.score < o2.score) return -1;
                else return 1;
            }
        });

        for(Student s : studentList) {
            System.out.println(s.toString());
        }

        /** 내림차순 정렬 */
        System.out.println("내림차순 정렬 -------------");
        Comparator<Student> comparatorDesc = new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.score == o2.score) return 0;
                if(o1.score < o2.score) return 1;
                else return -1;
            }
        };
        Collections.sort(studentList, comparatorDesc);
        for(Student s : studentList) {
            System.out.println(s.toString());
        }

    }
}


class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}