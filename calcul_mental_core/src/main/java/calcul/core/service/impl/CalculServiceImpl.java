package calcul.core.service.impl;

import calcul.core.dao.CalculDAO;
import calcul.core.entity.Calcul;
import calcul.core.service.CalculService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class CalculServiceImpl implements CalculService {

    @Inject
    private CalculDAO calculDAO;

    @Override
    public List<Calcul> getListCalcul() {
        return calculDAO.getListCalcul();
    }

    @Override
    public Calcul getCalcul() {
        return calculDAO.getCalcul();
    }
}
