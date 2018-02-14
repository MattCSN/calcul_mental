package dao.impl;

import dao.CalculDAO;

public class CalculDAOImpl implements CalculDAO {

    private int firstNumber = 0;

    private int result = 0;


    private int secondNumber = 0;


    public void add() {
        result = firstNumber + secondNumber;
    }

    public void multiply() {
        result = firstNumber * secondNumber;
    }

    public void divide() {
        this.result = this.firstNumber / this.secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
}
