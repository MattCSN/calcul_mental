package calcul.core.service;

import calcul.core.dao.CalculDAO;
import calcul.core.service.impl.CalculServiceImpl;
import calcul.core.entity.Calcul;

import java.util.List;

public interface CalculService {

    List<Calcul> getListCalcul();
     Calcul getCalcul();
}
