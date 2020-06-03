package com.example.fitwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitwork.model.guiaEjercicios;
import com.example.fitwork.recyclerview.GuiaAdapter;

import java.util.ArrayList;
import java.util.List;

public class VentanaRetos extends AppCompatActivity {

    private RecyclerView rvMuscles;
    private GuiaAdapter adapter;
    private List<guiaEjercicios> listaMusculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_guia);

        //metodos para crear el recyclerview
        initViews();
        llenarDatosMusculos();
        setupMuscleAdapter();

    }

    //lo usamos para inicializar y crear el adapter para meterlo dentro del recyclerview
    private void setupMuscleAdapter() {

        adapter = new GuiaAdapter(listaMusculos);
        rvMuscles.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "100 Abdominales") {
                    Intent intent = new Intent(getApplicationContext(), VentanaAbdominalesReto.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "25 Dominadas") {
                    Intent intent = new Intent(getApplicationContext(), VentanaDominadasReto.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "50 Flexiones") {
                    Intent intent = new Intent(getApplicationContext(), VentanaFlexionesReto.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "50 Sentadillas") {
                    Intent intent = new Intent(getApplicationContext(), VentanaSentadillasReto.class);
                    startActivity(intent);
                }

            }
        });
    }

    //Rellenamos el recyclerview con los parametros pasados en el metodo guiaholder de la clase GuiaAdapter
    private void llenarDatosMusculos() {

        //creamos la lista y la llenamos
        listaMusculos = new ArrayList<>();
        listaMusculos.add(new guiaEjercicios("100 Abdominales", "Consigue hacer 100 abdominales",R.drawable.encogimientos));
        listaMusculos.add(new guiaEjercicios("25 Dominadas", "Consigue hacer 25 dominadas",R.drawable.dominadas));
        listaMusculos.add(new guiaEjercicios("50 Flexiones", "Consigue hacer 50 flexiones",R.drawable.flexiones));
        listaMusculos.add(new guiaEjercicios("50 Sentadillas", "Consigue hacer 50 sentadillas", R.drawable.sentadilla));

    }

    private void initViews() {
        //Asignamos al recyclerview un linearLayout y le decimos que su tamaño sea fijo
        rvMuscles = findViewById(R.id.rv_muscles);
        rvMuscles.setLayoutManager(new LinearLayoutManager(this));
        rvMuscles.setHasFixedSize(true);

    }
}
