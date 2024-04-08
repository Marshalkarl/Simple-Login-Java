package com.example.logactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.logactivity.databinding.ActivityEmploiDuTemps2Binding;

import java.text.BreakIterator;

public class EmploiDuTempsActivity2 extends AppCompatActivity {

    ActivityEmploiDuTemps2Binding binding;
    DatabaseHelper databaseHelper;
    Button Emploi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmploiDuTemps2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);

        Emploi = findViewById(R.id.ajouter_btn);
//        Emploi = findViewById(R.id.ajouter_btn);
            Emploi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmploiDuTempsActivity2.this, AjoutActivity2.class);
                EmploiDuTempsActivity2.this.startActivity(intent);
            }
        });


//        binding.ajouter_btn.setOnClickListener(new View.OnClickListener() {
//           @Override
//            public void onClick(View v) {
//            String filiere, matiere, heure, prof, salle, jours;
//                filiere = binding.filiere_btn.getText().toString();
//                matiere = binding.matiere_btn.getText().toString();
//                heure = binding.heure_btn.getText().toString();
//                prof = binding.prof_btn.getText().toString();
//                salle = binding.salle_btn.getText().toString();
//                jours = binding.jours_btn.getText().toString();
//
//                if(filiere.equals("") || matiere.equals("") || heure.equals("") || prof.equals("") || salle.equals("") || jours.equals("")) {
//                    Toast.makeText(EmploiDuTempsActivity2.this, "Tous les champs sont requis", Toast.LENGTH_SHORT).show();
//                    }else{
//                        Boolean insertReg= databaseHelper.reg(filiere);
//                    }
//                }
//
//                 Vérifier si la filiere existe déjà dans la base de données
//                boolean filiereExists = databaseHelper.checkReg(filiere);
//                if (filiereExists) {
//                   Toast.makeText(getApplicationContext(), "La filiere existe déjà", Toast.LENGTH_SHORT).show();
//                } else {
//                     Insérer les données dans la base de données
//                    boolean inserted = databaseHelper.insertReg( filiere, matiere, heure, prof, salle, jours);
//                    if (inserted) {
//                        Toast.makeText(getApplicationContext(), "Enregistrement réussi", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Erreur lors de l'enregistrement", Toast.LENGTH_SHORT).show(); }
//                }
//            }
//        });


    }
}
