package dao.impl;

import dao.CalculDAO;

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

    public List<Integer> generateListRandom(int result){

        for (int i=0; i<4; i++)
        {
            int tmp = random.nextInt(max-min) + min;

            if (result==tmp){
                tmp = tmp-1;
                listRandom.add(tmp);
            }else {
                listRandom.add(tmp);
            }
        }

        for (int i=0; i<listRandom.size() ; i++) {
            for (int j = i + 1; j < listRandom.size(); i++) {
                if (listRandom.get(i).equals(listRandom.get(j))) {
                    int tmp = random.nextInt(max - min) + min;
                    listRandom.set(j, tmp);
                }

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
