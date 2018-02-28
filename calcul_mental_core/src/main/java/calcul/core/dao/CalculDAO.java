package calcul.core.dao;

import calcul.core.entity.Calcul;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalculDAO extends JpaRepository<Calcul,Long> {

        List<Calcul> getListCalcul();

        Calcul getCalcul();
    }
