package com.example.iclasse.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iclasse.R;
import com.example.iclasse.controller.ControllerCreerCompte;
import com.example.iclasse.model.Compte;

public class CreerCompte extends AppCompatActivity {
    private static EditText txtNom;
    private static EditText txtPrenom;
    private static EditText txtAdresseEmail;
    private static EditText txtMdp;
    private TextView dejaCompte;
    private static TextView resultatTxt;
    private Button btnCreerCompte;
     static boolean seConnecter=false;
     static String nom,prenom,email,mdp;
    private static ControllerCreerCompte controllerCreerCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creer_compte);
        controllerCreerCompte=ControllerCreerCompte.getInstance(this.getApplicationContext());
        init();
        ecouteCreerCompte();
        ecouteAvoirDejaCompte();
    }

//CV !
    public void ecouteAvoirDejaCompte() {
        dejaCompte.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreerCompte.this, SeConnecter.class);
                startActivity(intent);
            }
        });
    }


    //CVPAS !
    public void ecouteCreerCompte(){
        btnCreerCompte.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                nom= txtNom.getText().toString();
                prenom= txtPrenom.getText().toString();
                email= txtAdresseEmail.getText().toString();
                mdp= txtMdp.getText().toString();

                Compte compte=new Compte(nom,prenom,email,mdp);
                controllerCreerCompte.creerCompte(nom,prenom,email,mdp,seConnecter);

                Intent intent2 = new Intent(CreerCompte.this, AccueilEnseignant.class);
                intent2.putExtra("compte",compte);
                startActivity(intent2);


            }
        });
    }


    private void init(){
    txtNom=(EditText) findViewById(R.id.nomCreerCompte);
    txtPrenom=(EditText) findViewById(R.id.prenomCreerCompte);
    txtAdresseEmail=(EditText) findViewById(R.id.adresseemailCreerCompte);
    txtMdp=(EditText) findViewById(R.id.motdepasseCreerCompte);
    btnCreerCompte=(Button) findViewById(R.id.btnCreerCompte);
    dejaCompte=(TextView) findViewById(R.id.pasDeComptetxt);
    resultatTxt=(TextView) findViewById(R.id.resultatCreerCompte);
     }

}




