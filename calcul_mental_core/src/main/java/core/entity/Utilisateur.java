package core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private Integer maxlvl;
    private Integer maxscore;

    public Utilisateur() {
    }

    public Utilisateur(String nom, Integer maxlvl, Integer maxscore) {
        this.nom = nom;
        this.maxlvl = maxlvl;
        this.maxscore = maxscore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getMaxlvl() {
        return maxlvl;
    }

    public void setMaxlvl(Integer maxlvl) {
        this.maxlvl = maxlvl;
    }

    public Integer getMaxscore() {
        return maxscore;
    }

    public void setMaxscore(Integer maxscore) {
        this.maxscore = maxscore;
    }
}
