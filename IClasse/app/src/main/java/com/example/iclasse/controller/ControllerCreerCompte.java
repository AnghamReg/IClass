package com.example.iclasse.controller;

import android.content.Context;

import com.example.iclasse.model.Compte;
import com.example.iclasse.model.ListeComptes;

public class ControllerCreerCompte {
   // private AccessLocal accessLocal;
    private static ListeComptes liste;
    private Compte compte;
    private static ControllerCreerCompte instance=null;

    private ControllerCreerCompte(Context context){
        //système de controlle
        super();
        //accessLocal=new AccessLocal(context);
        liste=new ListeComptes();
    }

    public static final ControllerCreerCompte getInstance(Context context){
        return instance==null?new ControllerCreerCompte(context):instance;
    }

    public boolean creerCompte(String nom, String prenom, String adresseEmail, String mdp,boolean seConnecter){
        //TODO : creer un compte
        Compte compte=new Compte(nom,prenom,adresseEmail,mdp,seConnecter);
        //accessLocal.ajout(compte);
        return liste.addCompte(compte);
    }

    public Compte getCompte(){
        return compte;
    }

    public Compte rechercherCompteParEmailEtMdp(String email,String mdp) {
        return liste.rechercheCompteParEmailEtMdp(email,mdp);
    }

    public boolean compteExiste(String email,String mdp){
        //return accessLocal.compteExiste(ae,etOuEn);
        return liste.accessACompte(email,mdp);
    }

}

