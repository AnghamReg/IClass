package com.example.iclasse.model;

import java.io.Serializable;

public class Compte implements Serializable{
    private static final long serialVersionUID = 1L;
    private String email,nom,prenom,mdp;
    private boolean connecter;

    public Compte( String nom,String prenom,String email, String mdp) {
        this.email = email;
        this.nom=nom;
        this.prenom=nom;
        this.mdp = mdp;
    }



    public Compte( String nom,String prenom,String email, String mdp, boolean connecter) {
        this.email = email;
        this.nom=nom;
        this.prenom=nom;
        this.mdp = mdp;
        this.connecter = connecter;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    public boolean isConnecter() {
        return connecter;
    }



    public void setConnecter(boolean connecter) {
        this.connecter = connecter;
    }



    public boolean mdpCorrec(String m) {
        return mdp.equals(m);
    }


    public String toString() {
        return "email= "+email+" mdp= "+mdp+" nom= "+nom+" prenom= "+prenom;
    }

}
