package com.example.animalHous.interfaceAnimal;

public class Dog implements Animal {

    public String name() {
        return "강아지";
    }
    public void makeSound() {
        System.out.println("Dog says: Bark!");
    }

    public void eat(String food) {
        System.out.println("Dog eats " + food);
    }
}
