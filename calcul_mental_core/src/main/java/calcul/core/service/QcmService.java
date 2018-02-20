package calcul.core.service;

import calcul.core.dao.QcmDAO;
import calcul.core.entity.Qcm;
import calcul.core.service.impl.QcmServiceImpl;

import java.util.List;

public interface QcmService {

    Qcm getQCM();

    List<Integer> saveResult(Long id);

    void saveQcm(Qcm qcm);
}
