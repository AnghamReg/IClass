package com.example.iclasse.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iclasse.R;
import com.example.iclasse.model.Etudiant;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClasseLSI extends AppCompatActivity {
private ArrayList<Etudiant> listeEtudiant;
private String nomClasse;
private Button btnEtudiant1 , btnEtudiant2,btnEtudiant3,btnEtudiant4,btnEtudiant5;
private Button btnEnregistrer;
private Button btnAnnuler;
private TextView txtNomClasse;
private TextView txtNomEtudiant1,txtNomEtudiant2,txtNomEtudiant3,txtNomEtudiant4,txtNomEtudiant5;
private int nbAbsence=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classe_lsi);
        getData();
        init();
        ecouteBtnEtudiant1();
        ecouteBtnEtudiant2();
        ecouteBtnEtudiant3();
        ecouteBtnEtudiant4();
        ecouteBtnEtudiant5();
        ecouteBtnEnregistrer();
        ecouteBtnAnnuler();
    }

    private void ecouteBtnEnregistrer(){
    btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Socket socket=new Socket("192.168.56.1",8080);
                    System.out.println("le client est connecté");

                    OutputStream outputStream = socket.getOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                    String envoie=nomClasse+" "+nbAbsence;

                    System.out.println(envoie);
                    dataOutputStream.writeUTF(envoie);
                    System.out.println("client a envoyé le message");


                    dataOutputStream.close();
                    outputStream.close();
                    socket.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                Toast toast = Toast.makeText(getApplicationContext(), "Classe : "+nomClasse+"\n Il y'a "+nbAbsence+" absences :", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void ecouteBtnAnnuler() {
        btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnEtudiant1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btnEtudiant2.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btnEtudiant3.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btnEtudiant4.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btnEtudiant5.setBackgroundColor(getResources().getColor(R.color.purple_500));
                nbAbsence=0;
            }
        });
    }

    private void ecouteBtnEtudiant1() {
        btnEtudiant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEtudiant1.setBackgroundColor(getResources().getColor(R.color.red));
                nbAbsence++;
            }
        });
    }
    private void ecouteBtnEtudiant2() {
        btnEtudiant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEtudiant2.setBackgroundColor(getResources().getColor(R.color.red));
                nbAbsence++;
            }
        });
    }
    private void ecouteBtnEtudiant3() {
        btnEtudiant3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              btnEtudiant3.setBackgroundColor(getResources().getColor(R.color.red));
              nbAbsence++;
            }
        });
    }
    private void ecouteBtnEtudiant4() {
        btnEtudiant4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEtudiant4.setBackgroundColor(getResources().getColor(R.color.red));
                nbAbsence++;
            }
        });
    }
    private void ecouteBtnEtudiant5() {
        btnEtudiant5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEtudiant5.setBackgroundColor(getResources().getColor(R.color.red));
                nbAbsence++;
            }
        });
    }
    private void getData() {
        Intent intent = getIntent();
        nomClasse=intent.getStringExtra("nomClasse");
        listeEtudiant=new ArrayList<Etudiant>();
        listeEtudiant=intent.getSerializableExtra("listeEtudiants")!=null?
                (ArrayList<Etudiant>) intent.getSerializableExtra("listeEtudiants"):null;
    }

    private void init() {
        btnAnnuler=(Button)findViewById(R.id.btnAnnuler);
        btnEnregistrer=(Button)findViewById(R.id.btnEnregistrer);
        btnEtudiant1=(Button)findViewById(R.id.btnAbsent1);
        btnEtudiant2=(Button)findViewById(R.id.btnAbsent2);
        btnEtudiant3=(Button)findViewById(R.id.btnAbsent3);
        btnEtudiant4=(Button)findViewById(R.id.btnAbsent4);
        btnEtudiant5=(Button)findViewById(R.id.btnAbsent5);
        txtNomClasse=(TextView)findViewById(R.id.txtNomClasse);
        txtNomClasse.setText(nomClasse);
        txtNomEtudiant1=(TextView)findViewById(R.id.txtEtudiant1);
        txtNomEtudiant1.setText(listeEtudiant.get(0).getNom()+" "+listeEtudiant.get(0).getPrenom());
        txtNomEtudiant2=(TextView)findViewById(R.id.txtEtudiant2);
        txtNomEtudiant2.setText(listeEtudiant.get(1).getNom()+" "+listeEtudiant.get(1).getPrenom());
        txtNomEtudiant3=(TextView)findViewById(R.id.txtEtudiant3);
        txtNomEtudiant3.setText(listeEtudiant.get(2).getNom()+" "+listeEtudiant.get(2).getPrenom());
        txtNomEtudiant4=(TextView)findViewById(R.id.txtEtudiant4);
        txtNomEtudiant4.setText(listeEtudiant.get(3).getNom()+" "+listeEtudiant.get(3).getPrenom());
        txtNomEtudiant5=(TextView)findViewById(R.id.txtEtudiant5);
        txtNomEtudiant5.setText(listeEtudiant.get(4).getNom()+" "+listeEtudiant.get(4).getPrenom());
    }

}
