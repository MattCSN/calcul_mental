package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Calcul {

    private int max=0;
    private int min=9;
    private Random random = new Random();

    private int firstNumber = random.nextInt(max-min) + min;
    private int secondNumber= random.nextInt(max-min) + min;
    private int result = firstNumber + secondNumber;

    private List<Integer> listRandom = new ArrayList<Integer>();

    public List<Integer> generateListRandom(){
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
