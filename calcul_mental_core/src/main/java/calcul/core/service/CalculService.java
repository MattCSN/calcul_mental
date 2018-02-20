package calcul.core.service;

import calcul.core.dao.CalculDAO;
import calcul.core.dao.impl.CalculDAOImpl;
import calcul.core.entity.Calcul;

import java.util.List;

public class CalculService {
    private CalculDAO calculDAO = new CalculDAOImpl();

    /*public List<Integer> generateListRandom(int result){

        return calculDAO.generateListRandom(result);
    }*/

    public List<Calcul> getListCalcul(){
        return calculDAO.getListCalcul();
    }

    public Calcul getCalcul(){
        return calculDAO.getCalcul();
    }
}
