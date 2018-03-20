package core.service.impl;

import core.dao.UtilisateurDAO;
import core.entity.Utilisateur;
import core.service.UtilisateurService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService{
    @Inject
    private UtilisateurDAO utilisateurDAO;

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurDAO.findAll();
    }

    @Override
    public Utilisateur findById(long id) {
        return utilisateurDAO.findById(id);
    }

    @Override
    public void saveUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.save(utilisateur);
    }
}
