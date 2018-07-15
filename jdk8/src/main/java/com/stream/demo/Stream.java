package com.stream.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chenhao.ye on 2017/9/24.
 */
public class Stream {

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        filterApples(list, Apple::isGreenApple);
    }

    public static List<Apple> filterApples(List<Apple> list, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();

        return result.stream().filter(item -> p.test(item)).collect(Collectors.toList());
    }

}

interface Predicate<T> {
    boolean test(T t);
}

class Apple {
    private String color;

    private Integer weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

}