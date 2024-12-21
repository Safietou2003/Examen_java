package services;

import entities.Commande;
import repository.repositoryList.RepositoryCommande;
public class CommandeService {
    private RepositoryCommande repositoryCommande;

    public CommandeService(RepositoryCommande repositoryCommande) {
        this.repositoryCommande = repositoryCommande;
    }

    public void addCommande(Commande commande) {
        repositoryCommande.save(commande);
    }

    
}
