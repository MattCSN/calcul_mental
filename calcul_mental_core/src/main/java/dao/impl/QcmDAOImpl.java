package dao.impl;

import dao.QcmDAO;
import entity.Qcm;
import dao.CalculDAO;
import dao.impl.CalculDAOImpl;

import java.util.List;

public class QcmDAOImpl implements QcmDAO {
private int firstproposition;
private int secondproposition;
private int thirdproposition;
private int fourthproposition;
    private CalculDAO calculDAO=new CalculDAOImpl();
    public void genererQCM() {
       List<Integer> listRandom= calculDAO.generateListRandom(calculDAO.getResult());
       firstproposition=listRandom.get(0);
       secondproposition=listRandom.get(1);
       thirdproposition=listRandom.get(2);
       fourthproposition=listRandom.get(3);


        Qcm question= new Qcm("Quel est le résultat de 2+2?",firstproposition,secondproposition,thirdproposition,fourthproposition,4);
    }
}
