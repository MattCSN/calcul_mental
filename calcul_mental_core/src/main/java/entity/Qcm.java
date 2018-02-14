package entity;

public class Qcm {

    private String question;
    private String propositionA;
    private String propositionB;
    private String propositionC;
    private  String propositionD;

    public Qcm() {
    }


    public Qcm(String question, String propositionA, String propositionB, String propositionC, String propositionD) {
        this.question = question;
        this.propositionA = propositionA;
        this.propositionB = propositionB;
        this.propositionC = propositionC;
        this.propositionD = propositionD;
    }



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPropositionA() {
        return propositionA;
    }

    public void setPropositionA(String propositionA) {
        this.propositionA = propositionA;
    }

    public String getPropositionB() {
        return propositionB;
    }

    public void setPropositionB(String propositionB) {
        this.propositionB = propositionB;
    }

    public String getPropositionC() {
        return propositionC;
    }

    public void setPropositionC(String propositionC) {
        this.propositionC = propositionC;
    }

    public String getPropositionD() {
        return propositionD;
    }

    public void setPropositionD(String propositionD) {
        this.propositionD = propositionD;
    }


}
