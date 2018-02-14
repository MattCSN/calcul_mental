package entity;

public class Calcul {

    private int max;
    private int min;
    private int firstNumber;
    private int secondNumber;
    private int result;

    public Calcul() {
    }

    public Calcul(int max, int min, int firstNumber, int secondNumber) {
        this.max = max;
        this.min = min;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
