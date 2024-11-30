package com.example.Calculator;

import java.util.Map;

public enum OperationType {
    ADD {
        @Override
        public double apply(int num1, int num2) {
            return num1 + num2;
        }
    }, SUBTRACT {
        @Override
        public double apply(int num1, int num2) {
            return num1 - num2;
        }
    }, MULTIPLY {
        @Override
        public double apply(int num1, int num2) {
            return num1 * num2;
        }
    }, DIVIDE {
        @Override
        public double apply(int num1, int num2) {
            if (num2 == 0) throw new ArithmeticException("0은 나눌 수 없습니다.");
            return num1 / num2;
        }
    };

    public abstract double apply(int num1, int num2);

    // 연산 기호와 타입 매핑
    private static final Map<String, OperationType> SYMBOL_MAP = Map.of("+", ADD, "-", SUBTRACT, "*", MULTIPLY, "/", DIVIDE);

    public static OperationType fromSymbol(String symbol) {
        OperationType operation = SYMBOL_MAP.get(symbol);
        if (operation == null) {
            throw new IllegalArgumentException("잘못된 연산자: " + symbol);
        }
        return operation;
    }
}
      /*  return switch (symbol) {
            case "+" -> ADD;
            case "-" -> SUBTRACT;
            case "*" -> MULTIPLY;
            case "/" -> DIVIDE;
            default -> throw new IllegalArgumentException("잘못된 연산자: " + symbol);
        };
       */
