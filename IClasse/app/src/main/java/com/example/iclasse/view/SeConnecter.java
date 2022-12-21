package com.example.iclasse.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iclasse.R;
import com.example.iclasse.controller.ControllerCreerCompte;
import com.example.iclasse.model.Compte;

public class SeConnecter extends AppCompatActivity {
    private Button btnEtudiant;
    private Button btnEnseignant;
    private boolean etudiantOuEnseignant= false; //false : etudiant | true : enseignant
    private Button btnSeConnecter;
    private EditText txtAdresseEmail;
    private EditText txtMdp;
    private TextView resultatTxt;
    private ControllerCreerCompte controllerCreerCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.se_connecter);
        controllerCreerCompte=ControllerCreerCompte.getInstance(this.getApplicationContext());
        init();
        ecouteEtudiant();
        ecouteEnseignant();
        ecouteSeConnecter();
    }


    private void ecouteSeConnecter() {
        btnSeConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txtAdresseEmail.getText().toString();
                String mdp=txtMdp.getText().toString();

                Intent intent = new Intent(SeConnecter.this, AccueilEnseignant.class);
                intent.putExtra("email", email);
                intent.putExtra("mdp", mdp);
                startActivity(intent);

            }
        });
    }


    private void ecouteEnseignant() {
    }

    private void ecouteEtudiant() {
    }

    public void init(){
        btnSeConnecter=findViewById(R.id.btnSeConnecter);
        txtAdresseEmail=findViewById(R.id.adresseemailSeConnecter);
        txtMdp=findViewById(R.id.motdepasseSeConnecter);
        resultatTxt=(TextView) findViewById(R.id.resultatSeConnecter);
    }
}
