package calcul.core.service;

import calcul.core.dao.CalculDAO;
import calcul.core.dao.impl.CalculDAOImpl;
import calcul.core.entity.Calcul;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
@Named
@Transactional
public class CalculService {
    @Inject
    private CalculDAO calculDAO;


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
