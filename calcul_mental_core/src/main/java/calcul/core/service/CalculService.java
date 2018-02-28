package calcul.core.service;

import calcul.core.dao.CalculDAO;
import calcul.core.service.impl.CalculServiceImpl;
import calcul.core.entity.Calcul;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

public interface CalculService {

     List<Calcul> getListCalcul();
     Calcul getCalcul();
}
