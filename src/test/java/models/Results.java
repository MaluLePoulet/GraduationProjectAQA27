package models;

import java.util.Arrays;
import java.util.Objects;

public class Results {
    private AutomationRun[] result;

    public AutomationRun[] getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results = (Results) o;
        return Objects.deepEquals(result, results.result);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(result);
    }

    @Override
    public String toString() {
        return "Results{" +
                "result=" + Arrays.toString(result) +
                '}';
    }
}