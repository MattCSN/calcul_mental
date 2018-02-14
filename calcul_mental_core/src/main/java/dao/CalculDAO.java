package dao;

import java.util.List;

public interface CalculDAO{


        void add();

        void multiply();

        void divide();

        int getFirstNumber();

        void setFirstNumber(int firstNumber);

        int getResult();

        void setResult(int result);

        int getSecondNumber();

        void setSecondNumber(int secondNumber);

        List<Integer> generateListRandom(int result);

    }
