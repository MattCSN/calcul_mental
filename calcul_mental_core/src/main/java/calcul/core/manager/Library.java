package calcul.core.manager;

import calcul.core.dao.impl.CalculDAOImpl;
import calcul.core.dao.CalculDAO;

import java.util.List;

public class Library {


    private int firstnumber;

    private static class CalculLibraryHolder {
        private final static Library instance = new Library();
    }

    public static Library getInstance() {
        return CalculLibraryHolder.instance;
    }
    private CalculDAO calculDAO= new CalculDAOImpl();

    private Library(){

    }

    public void add(){
        calculDAO.add();
    }
    public void multiply(){
        calculDAO.multiply();
    }
    public void divide(){
        calculDAO.divide();
    }
    public int getFirstNumber(){
       return calculDAO.getFirstNumber();
    }
    public void setFirstNumber(int firstNumber){
       calculDAO.setFirstNumber(firstNumber);
    }
    public int getResult(){
        return calculDAO.getResult();
    }
    public void setResult(int result){
        calculDAO.setResult(result);
    }
    public int getSecondNumber(){
        return calculDAO.getSecondNumber();
    }
    public void setSecondNumber(int secondNumber){
        calculDAO.setSecondNumber(secondNumber);
    }
    public List<Integer> generateListRandom(int result){return calculDAO.generateListRandom(result);}
}
