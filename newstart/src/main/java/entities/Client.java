package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client extends AbstractEntity {
    @Id
    private String telephone;
    private String nom;
    private String prenom;
    private String ville;
    private String quartier;
    private String villa;

    public String gettelephone() {
        return telephone;
    }

    public void settelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public String getprenom() {
        return prenom;
    }

    public void setprenom(String prenom) {
        this.prenom = prenom;
    }

    public String getville() {
        return ville;
    }

    public void setville(String ville) {
        this.ville = ville;
    }

    public String getquartier() {
        return quartier;
    }

    public void setquartier(String quartier) {
        this.quartier = quartier;
    }

    public String getvilla() {
        return villa;
    }

    public void setvilla(String villa) {
        this.villa = villa;
    }
}

