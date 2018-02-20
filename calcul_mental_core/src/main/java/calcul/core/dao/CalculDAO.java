package calcul.core.dao;

import calcul.core.entity.Calcul;

import java.util.List;

public interface CalculDAO{

        List<Calcul> getListCalcul();

        Calcul getCalcul();
    }
