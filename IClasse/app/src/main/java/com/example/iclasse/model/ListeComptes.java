package com.example.iclasse.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ListeComptes implements Serializable {

    private ArrayList<Compte> liste;
    int nb;

    public ListeComptes() {
        liste=new ArrayList<Compte>();
        nb=0;
    }

    private boolean rechercheCompteParEmail(Compte c) {
        for (Compte i :liste) {
            if(i.getEmail().equals(c.getEmail()))
                return true;
        }
        return false;
    }
    public boolean addCompte(Compte c ) {
        if(this.rechercheCompteParEmail(c))
        {
            return false;
        }
        else {
            liste.add(c);
            nb++;
            return true;
        }
    }

    public Compte getCompteParIndice(int i) {
        if(i>nb)
            return null;
        else
            return liste.get(i);
    }

    public Compte rechercheCompteParEmailEtMdp(String email,String mdp) {
        if (nb == 0)
            return null;
        else{
            for (Compte i : liste) {
                if (i.getEmail().equals(email) && i.getMdp().equals(mdp)) {
                    return i;
                }
            }
            return null;
        }
    }

    public boolean accessACompte(String email,String mdp) {
        Compte compteExiste=this.rechercheCompteParEmailEtMdp(email,mdp);
        return compteExiste!=null;
    }

    public String getListe() {
        return liste.toString();
    }

}

