package com.example.Calculator;

import java.util.LinkedList;

public class ResultStorage {
    private LinkedList<Double> results = new LinkedList<>();

    public void saveResult(double result) {
        results.add(result);
    }
    public void removeResult() {
        results.pop();
    }
    /* Getter 메서드 캡슐화 구현 */
    public LinkedList<Double> getResults() {
        return new LinkedList<>(this.results);
    }
    /* Setter 메서드 구현 */
    public void setResults() {

    }
}
