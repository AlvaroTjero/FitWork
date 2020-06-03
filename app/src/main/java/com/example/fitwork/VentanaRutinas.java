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

public class VentanaRutinas extends AppCompatActivity {

    private RecyclerView rvMuscles;
    private GuiaAdapter adapter;
    private List<guiaEjercicios> listaMusculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_rutinas);

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

                if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Principiante") {
                    Intent intent = new Intent(getApplicationContext(), VentanaPrincipiante.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Intermedio") {
                    Intent intent = new Intent(getApplicationContext(), VentanaMedio.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Avanzado") {
                    Intent intent = new Intent(getApplicationContext(), VentanaAvanzado.class);
                    startActivity(intent);
                }


            }
        });
    }

    //Rellenamos el recyclerview con los parametros pasados en el metodo guiaholder de la clase GuiaAdapter
    private void llenarDatosMusculos() {

        //creamos la lista y la llenamos
        listaMusculos = new ArrayList<>();
        listaMusculos.add(new guiaEjercicios("Principiante", "Rutinas para nivel principiante", R.drawable.principiante));
        listaMusculos.add(new guiaEjercicios("Intermedio", "Rutinas para nivel intermedio",R.drawable.medio));
        listaMusculos.add(new guiaEjercicios("Avanzado", "Rutinas para nivel avanzado",R.drawable.avanzado));

    }

    private void initViews() {
        //Asignamos al recyclerview un linearLayout y le decimos que su tamaño sea fijo
        rvMuscles = findViewById(R.id.rv_muscles);
        rvMuscles.setLayoutManager(new LinearLayoutManager(this));
        rvMuscles.setHasFixedSize(true);

    }
}

