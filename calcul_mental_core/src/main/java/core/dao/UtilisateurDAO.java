package core.dao;

import core.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurDAO extends JpaRepository<Utilisateur,Long> {

    @Override
    List<Utilisateur> findAll();
    Utilisateur findById(long id);

}
