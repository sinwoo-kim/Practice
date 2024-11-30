package com.example.animalHous;

import TIL.dto.StatusCommand;
import TIL.interfaceAnimal.Animal;

import java.util.Scanner;

public class AnimalHous {

    // 코어 객체 & 리스트
    final private Animal animal;
    final private Status status;

    Scanner sc = new Scanner(System.in);

    // 생성자
    public AnimalHous(Animal animal, Status status) {
        this.animal = animal;
        this.status = status;
    }

    // 메인 컨트롤러 실행
    public void start() {

        System.out.println("[:" + animal.name() + " house:]");
        animal.makeSound();
        validation();
    }

    //유효성 검증
    private void validation() {
        while (true) {
            StatusCommand statusCommand = handleStatusSelector();
            if (statusCommand.getCommand().equals("isNotHungry")) {
                System.out.println("아직 밥 때가 아닙니다.");
                break;
            }
            if (statusCommand.getCommand().equals("retry")) {
                continue;
            }
            System.out.println(animal.name() + "가 배고플 수 있습니다.");
            System.out.print("먹일 음식을 입력해주세요: ");
            animal.eat(sc.nextLine());
            // 추후 아이템 리스트 출력하여 뭐 먹일지 선택할 수 있도록 구현
        }
    }

    // [상태 처리기]
    private StatusCommand handleStatusSelector() {
        // 1. 상태 출력
        int number = 1;
        for (Status status : status.statusList) {
            System.out.println(number++ + ". " + status.getStatus());
        }

        // 2. 상태 셀렉
        System.out.print("현재 상황과 맞는 번호를 입력해주세요: ");
        String input = sc.nextLine();
        int command = Integer.parseInt(input);

        // 3. 셀렉 값 분기 처리
        if (command == 1) {
            Status selectStatus = status.statusList.get(0);
            System.out.println("-> " + selectStatus.getStatus() + "를 선택하셨습니다.");
            return new StatusCommand("isHungry");
        } else if (command == 2) {
            Status selectStatus = status.statusList.get(1);
            System.out.println("-> " + selectStatus.getStatus() + "를 선택하셨습니다.");
            return new StatusCommand("isNotHungry");
        } else {
            System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요.");
            return new StatusCommand("retry");
        }
    }
}
