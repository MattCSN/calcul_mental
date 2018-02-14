package dao.impl;

import dao.CalculDAO;
import entity.Calcul;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalculDAOImpl implements CalculDAO {

    private Random random = new Random();

    private int max=0;
    private int min=9;

    private int firstNumber = random.nextInt(max-min) + min;
    private int secondNumber = random.nextInt(max-min) + min;
    private int result;

    private List<Integer> listRandom = new ArrayList<Integer>();

    public List<Integer> generateListRandom(){
        Calcul calcul;

        for (int i=0; i<4;i++)
        {
            int buffer = random.nextInt(max-min) + min;

            if (result==buffer){
                buffer = buffer-1;
                listRandom.add(buffer);
            }else {
                listRandom.add(buffer);
            }
        }
        return listRandom;
    }

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
