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

public class VentanaDietas extends AppCompatActivity {

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

                if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Perder peso") {
                    Intent intent = new Intent(getApplicationContext(), VentanaPerder.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Ganar masa muscular") {
                    Intent intent = new Intent(getApplicationContext(), VentanaGanar.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Suplementos") {
                    Intent intent = new Intent(getApplicationContext(), VentanaSuplementos.class);
                    startActivity(intent);
                }
            }
        });
    }

    //Rellenamos el recyclerview con los parametros pasados en el metodo guiaholder de la clase GuiaAdapter
    private void llenarDatosMusculos() {

        //creamos la lista y la llenamos
        listaMusculos = new ArrayList<>();
        listaMusculos.add(new guiaEjercicios("Perder peso", "Dietas para perder peso", R.drawable.perder_peso));
        listaMusculos.add(new guiaEjercicios("Ganar masa muscular", "Dietas para ganar masa",R.drawable.ganar_masa));
        listaMusculos.add(new guiaEjercicios("Suplementos", "Suplementos Alimenticios",R.drawable.suplementos));

    }

    private void initViews() {
        //Asignamos al recyclerview un linearLayout y le decimos que su tamaño sea fijo
        rvMuscles = findViewById(R.id.rv_muscles);
        rvMuscles.setLayoutManager(new LinearLayoutManager(this));
        rvMuscles.setHasFixedSize(true);

    }
}