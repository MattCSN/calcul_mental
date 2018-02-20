package calcul.core.service.impl;

import calcul.core.entity.Qcm;
import calcul.core.dao.QcmDAO;
import calcul.core.service.QcmService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class QcmServiceImpl implements QcmService {

    @Inject
    private QcmDAO qcmDAO;

    @Override
    public Qcm getQCM(){
        return qcmDAO.getQCM();
    }

    @Override
    public List<Integer> saveResult(Long id) {
        return qcmDAO.saveResult(id);
    }

    @Override
    public void saveQcm(Qcm qcm){
        qcmDAO.saveQcm(qcm);
    }
}
