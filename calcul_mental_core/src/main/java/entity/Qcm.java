package entity;

import com.sun.javafx.image.IntPixelGetter;

public class Qcm {

    private String question;



    private Integer propositionA;
    private Integer propositionB;
    private Integer propositionC;
    private Integer propositionD;
    private int difficulty;
    private String category;
    private int reponse;

    public Qcm() {
    }


    public Qcm(String question, Integer propositionA, Integer propositionB, Integer propositionC, Integer propositionD,int reponse) {
        this.question = question;
        this.propositionA = propositionA;
        this.propositionB = propositionB;
        this.propositionC = propositionC;
        this.propositionD = propositionD;
        this.reponse=reponse;
    }

    public Qcm(String question, Integer propositionA, Integer propositionB, Integer propositionC, Integer propositionD, int difficulty, String category) {
        this.question = question;
        this.propositionA = propositionA;
        this.propositionB = propositionB;
        this.propositionC = propositionC;
        this.propositionD = propositionD;
        this.difficulty = difficulty;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getPropositionA() {
        return propositionA;
    }

    public void setPropositionA(Integer propositionA) {
        this.propositionA = propositionA;
    }

    public Integer getPropositionB() {
        return propositionB;
    }

    public void setPropositionB(Integer propositionB) {
        this.propositionB = propositionB;
    }

    public Integer getPropositionC() {
        return propositionC;
    }

    public void setPropositionC(Integer propositionC) {
        this.propositionC = propositionC;
    }

    public Integer getPropositionD() {
        return propositionD;
    }

    public void setPropositionD(Integer propositionD) {
        this.propositionD = propositionD;
    }


}
