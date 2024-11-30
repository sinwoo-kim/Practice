package com.example.animalHous.interfaceAnimal;

public class Cat implements Animal {

    public String name() {
        return "고양이";
    }

    public void makeSound() {
        System.out.println("야옹");
    }

    public void eat(String food) {
        System.out.println("Cat eats " + food);
    }

}
