package calcul.core.dao.impl;

import calcul.core.dao.CalculDAO;
import calcul.core.entity.Calcul;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalculDAOImpl implements CalculDAO {

    private Random random = new Random();

    private int max=0;
    private int min=9;

    private List<Integer> listRandom = new ArrayList<Integer>();

    /*public List<Integer> generateListRandom(int result){ // il faut qu'une des réponses soit le résultat!

        for (int i=0; i<4; i++)
        {
            int tmp = random.nextInt(max-min) + min;

            if (result==tmp){
                tmp = tmp-1;
                listRandom.add(tmp);
            }else {
                listRandom.add(tmp);
            }
        }

        for (int i=0; i<listRandom.size() ; i++) {
            for (int j = i + 1; j < listRandom.size(); i++) {
                if (listRandom.get(i).equals(listRandom.get(j))) {
                    int tmp = random.nextInt(max - min) + min;
                    listRandom.set(j, tmp);
                }

            }
        }

        return listRandom;
    }*/

    public List<Calcul> getListCalcul() {
        return null;
    }

    public Calcul getCalcul() {
        return null;
    }
}
