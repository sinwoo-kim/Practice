package com.example.animalHous;

import TIL.interfaceAnimal.Cat;
import TIL.interfaceAnimal.Dog;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 리스트 추가
        List<Status> statusList = new ArrayList<>();
        statusList.add(new Status("bowl is empty"));
        statusList.add(new Status("bowl is full"));

        // 핵심 객체 초기화 및 의존성 주입
        Status status = new Status(statusList);
        AnimalHous dogHous = new AnimalHous(new Dog(), status);
        AnimalHous catHous = new AnimalHous(new Cat(), status);

        dogHous.start();
        catHous.start();

    }
}
