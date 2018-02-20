package calcul.core.entity;

import javax.persistence.Entity;

@Entity
public class Calcul {

    /*
    Le calcul doit avoir deux chiffres à proposer ainsi que le type d'opération qui est proposé (pour savoir s'il s'agit d'une
    addition, soustraction, etc.) Le résultat est calculable par un switch case, les valeurs max des deux chiffres proposés sont
    quantifiables et modifiables par l'attribut max.
     */

    private int max = 9;
    private int firstNumber;
    private int secondNumber;
    private Type_Calcul type_calcul;

    public Calcul() {
    }

    public Calcul(Type_Calcul type_calcul) {
        Random random = new Random(System.currentTimeMillis());
        this.type_calcul = type_calcul;
        this.firstNumber= random.nextInt(max)+1;
        this.secondNumber=random.nextInt(max)+1;
    }

    public Calcul(int max, Type_Calcul type_calcul) {
        this.max = max;
        this.type_calcul = type_calcul;
    }

    public Calcul(int max, int firstNumber, int secondNumber, Type_Calcul type_calcul) {
        this.max = max;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.type_calcul = type_calcul;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Type_Calcul getType_calcul() {
        return type_calcul;
    }

    public void setType_calcul(Type_Calcul type_calcul) {
        this.type_calcul = type_calcul;
    }

    public int getResult(){
        switch (this.type_calcul){
            case Addition:
                return (this.firstNumber+this.secondNumber);

            case Division:
                return (this.firstNumber/this.secondNumber);

            case Soustraction:
                return (this.firstNumber-this.secondNumber);

            case Multiplication:
                return (this.firstNumber*this.secondNumber);

        }
        return 0;
    }
}