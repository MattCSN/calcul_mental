package calcul.core.dao;

import calcul.core.entity.Qcm;

import java.util.List;

public interface QcmDAO {

    Qcm getQCM();

    List<Integer> saveResult(Long id);
}
