package calcul.core.dao;

import calcul.core.entity.Qcm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QcmDAO extends JpaRepository<Qcm,Long> {

    Qcm getQCM();

    List<Integer> saveResult(Long id);

    void saveQcm(Qcm qcm);


}
