package com.example.Calculator;

import com.example.OperationType;
import com.example.ResultStorage;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                // 첫번째 정수 입력
                System.out.print("첫번째 양의 정수를 입력하세요.:");
                int num1 = Integer.parseInt(sc.next());
                if (num1 < 0) {
                    throw new IllegalArgumentException("양의 정수만 입력 가능합니다.");
                }

                // 연산자 입력
                System.out.print("사칙연산 기호를 입력하세요. (+, -, *, /):");
                String operator = sc.next();
                // 상수 매핑
                OperationType operation = OperationType.fromSymbol(operator);

                // 두번째 정수 입력
                System.out.print("두번째 양의 정수를 입력하세요.:");
                int num2 = Integer.parseInt(sc.next());
                if (num2 < 0) {
                    throw new IllegalArgumentException("양의 정수만 입력 가능합니다.");
                }

                // 계산기 실행
                double result = operation.apply(num1, num2);
                System.out.println(result);

                // 값 저장
                ResultStorage storage = new ResultStorage();
                storage.saveResult(result);

                // getter
                storage.getResults();
                System.out.println("getter:" + storage.getResults());

                // setter
                storage.setResults();

                // 첫 번째 값 제거
                storage.removeResult();
                System.out.println("첫 번째 값 제거:" + storage.getResults());


                // 개행 문자 제거
                sc.nextLine(); // 기존 남아 있는 개행 문자 제거

                // exit
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String exit = sc.nextLine();
                if (exit.equals("exit")) {
                    sc.close();
                    break;
                }
            } catch (ArithmeticException e) {
                System.out.println("입력 오류: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("입력 오류: " + e.getMessage());
            }
        }
    }
}

