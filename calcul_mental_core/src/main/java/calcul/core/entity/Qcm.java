package calcul.core.entity;

import java.util.List;

public class Qcm {

    /*
    Le QCM devrait être composé d'une liste d'un nombre fixe de Calculs (avec les différents attributs lui étant propres,
    un identifiant qui lui est unique (pour être traité en BDD ultérieurement)
    ainsi qu'une liste de réponses données (utilisée pour comparer au calculs proposés à l'écran)
    (dans le cas d'une catégorie fixe par QCM; sinon il faut associer une catégorie aux calculs directement)
     */
    private Long id;
    private List<Calcul> calculList;
    private List<Integer> responseList;
    private int difficulty=1;

    private int nbCalculs=1;

    public Qcm() {
        for(int i=0;i<this.nbCalculs;i++) {
            this.calculList.add(new Calcul(Type_Calcul.Addition));
            this.responseList.add(null);
        }
    }

    public Qcm(int difficulty) {
        this.difficulty = difficulty;
    }

    public Qcm(int difficulty, int nbCalculs) {
        this.difficulty = difficulty;
        this.nbCalculs = nbCalculs;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public List<Calcul> getCalculList() {
        return calculList;
    }

    private void setCalculList(List<Calcul> calculList) {
        this.calculList = calculList;
    }

    public List<Integer> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Integer> responseList) {
        this.responseList = responseList;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
