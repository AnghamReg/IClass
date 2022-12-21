package com.example.iclasse.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iclasse.R;
import com.example.iclasse.model.Compte;
import com.example.iclasse.model.Etudiant;

import java.util.ArrayList;

public class AccueilEnseignant extends AppCompatActivity {
    private TextView txtNom;
    private TextView txtPrenom;
    private Compte compte;
    private Button btnClasse1, btnClasse2, btnClasse3, btnClasse4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enseignant_accueil);
        getData();
        init();
        ecouteBtnClasse1();
        ecouteBtnClasse2();
        ecouteBtnClasse3();
        ecouteBtnClasse4();
    }

    private void ecouteBtnClasse1() {
        btnClasse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilEnseignant.this, ClasseLSI.class);
                ArrayList<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
                listeEtudiant.add(new Etudiant("Barkia", "Firas"));
                listeEtudiant.add(new Etudiant("Boubakri", "Rihab"));
                listeEtudiant.add(new Etudiant("Elghoul", "Khawla"));
                listeEtudiant.add(new Etudiant("Yousfi", "Mohamed"));
                listeEtudiant.add(new Etudiant("Karray", "Nesrine"));
                intent.putExtra("listeEtudiants", listeEtudiant);
                intent.putExtra("nomClasse", "LSI31.1");
                startActivity(intent);
            }
        });

        }

    private void ecouteBtnClasse2() {
        btnClasse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilEnseignant.this, ClasseLSI.class);
                ArrayList<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
                listeEtudiant.add(new Etudiant("Regaieg", "Angham"));
                listeEtudiant.add(new Etudiant("Elkamel", "Ghassen"));
                listeEtudiant.add(new Etudiant("Bouassida", "Oussema"));
                listeEtudiant.add(new Etudiant("Kammoun", "Eya"));
                listeEtudiant.add(new Etudiant("Masmoudi", "Hadil"));
                intent.putExtra("listeEtudiants", listeEtudiant);
                intent.putExtra("nomClasse", "LSI32.1");
                startActivity(intent);
            }
        });
    }

    private void ecouteBtnClasse3() {
        btnClasse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilEnseignant.this, ClasseLSI.class);
                ArrayList<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
                listeEtudiant.add(new Etudiant("Hentati", "Malek"));
                listeEtudiant.add(new Etudiant("Hentati", "Mahmoud"));
                listeEtudiant.add(new Etudiant("Benali", "Mohamed"));
                listeEtudiant.add(new Etudiant("Mannai", "Ahmed"));
                listeEtudiant.add(new Etudiant("Zaidi", "Melek"));
                intent.putExtra("listeEtudiants", listeEtudiant);
                intent.putExtra("nomClasse", "LSI31.2");
                startActivity(intent);
            }
        });
    }

    private void ecouteBtnClasse4() {
        btnClasse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilEnseignant.this, ClasseLSI.class);
                ArrayList<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
                listeEtudiant.add(new Etudiant("Arous", "Achraf"));
                listeEtudiant.add(new Etudiant("Arous", "Ilyes"));
                listeEtudiant.add(new Etudiant("Jmal", "Ahmed"));
                listeEtudiant.add(new Etudiant("Kadri", "Amal"));
                listeEtudiant.add(new Etudiant("Njeh", "Ons"));
                intent.putExtra("listeEtudiants", listeEtudiant);
                intent.putExtra("nomClasse", "LSI32.2");
                startActivity(intent);
            }
        });
    }


    private void init() {
        txtNom=findViewById(R.id.txtNomEnseignant);
        txtPrenom=findViewById(R.id.txtPrenomEnseignant);
        btnClasse1=findViewById(R.id.btnClasse1);
        btnClasse2=findViewById(R.id.btnClasse2);
        btnClasse3=findViewById(R.id.btnClasse3);
        btnClasse4=findViewById(R.id.btnClasse4);
        btnClasse1.setText("LSI3 1.1");
        btnClasse2.setText("LSI3 2.1");
        btnClasse3.setText("LSI3 1.2");
        btnClasse4.setText("LSI3 2.2");
        if(compte!=null){
            txtNom.setText("Bienvenue "+compte.getNom()+" !");
            txtPrenom.setText(compte.getPrenom());
        }else{
            txtNom.setText("Bienvenue !");
        }
        txtPrenom.setText(" Veuillez selectionner la classe que vous souhaitez gérer :");
    }

    private void getData() {
        Intent intent = getIntent();
        compte = intent.getSerializableExtra("compte") != null ? (Compte) intent.getSerializableExtra("compte") : null;
    }
}
