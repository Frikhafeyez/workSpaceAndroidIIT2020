package com.example.atelier_5_gestion_contacts;

public class Personne {
    public String nom;
    public String prenom;
    public int tel;

    public Personne(String nom, String prenom, int tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return nom +"      "+ prenom + "      "+ tel ;
    }
}
