package java8.pojo;

import java.util.Arrays;
import java.util.stream.Stream;


public class Fruit {
    private Apple apple1;
    private Apple apple2;
    private Stream<Apple> appleStream = Arrays.asList(new Apple(), new Apple(), new Apple()).stream();

    public Stream<Apple> getAppleStream() {
        return appleStream;
    }

    public void setAppleStream(Stream<Apple> appleStream) {
        this.appleStream = appleStream;
    }

    public Apple getApple1() {
        return apple1;
    }

    public void setApple1(Apple apple1) {
        this.apple1 = apple1;
    }

    public Apple getApple2() {
        return apple2;
    }

    public void setApple2(Apple apple2) {
        this.apple2 = apple2;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "apple1=" + apple1 +
                ", apple2=" + apple2 +
                '}';
    }
}
