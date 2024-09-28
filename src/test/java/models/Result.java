package models;

import java.util.Objects;

public class Result {
    private AutomationRun result;

    public AutomationRun getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(result);
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                '}';
    }
}