package core.service;

import core.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    List<Utilisateur> findAll();
    Utilisateur findById(long id);
    Utilisateur findByNom(String nom);
    void saveUtilisateur(Utilisateur utilisateur);
}
