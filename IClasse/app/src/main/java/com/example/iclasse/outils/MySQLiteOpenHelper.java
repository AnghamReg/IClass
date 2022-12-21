package com.example.iclasse.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private String creationEtudiant="create table Etudiant (JoinDate TEXT PRIMARY KEY, Nom TEXT NOT NULL, Prenom TEXT NOT NULL, Email TEXT NOT NULL, Password TEXT NOT NULL)";
   private String creationEnseignant="create table Enseignant (JoinDate TEXT PRIMARY KEY, Nom TEXT NOT NULL, Prenom TEXT NOT NULL, Email TEXT NOT NULL, Password TEXT NOT NULL)";
    //Constructeur
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        //factory est le producteur de la base de données
    }

    //création de la base de données et des tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(creationEtudiant);
        sqLiteDatabase.execSQL(creationEnseignant);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
