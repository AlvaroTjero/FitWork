package com.example.fitwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fitwork.model.guiaEjercicios;
import com.example.fitwork.recyclerview.GuiaAdapter;

import java.util.ArrayList;
import java.util.List;

public class VentanaGuia extends AppCompatActivity {

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

                if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Pectorales") {
                    Intent intent = new Intent(getApplicationContext(), VentanaPectoral.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Espalda") {
                    Intent intent = new Intent(getApplicationContext(), VentanaEspalda.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Biceps") {
                    Intent intent = new Intent(getApplicationContext(), VentanaBiceps.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Triceps") {
                    Intent intent = new Intent(getApplicationContext(), VentanaTriceps.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Hombros") {
                    Intent intent = new Intent(getApplicationContext(), VentanaHombros.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Piernas") {
                    Intent intent = new Intent(getApplicationContext(), VentanaPiernas.class);
                    startActivity(intent);
                }

                else if (listaMusculos.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Abdomen") {
                    Intent intent = new Intent(getApplicationContext(), VentanaAbdomen.class);
                    startActivity(intent);
                }

            }
        });
    }

    //Rellenamos el recyclerview con los parametros pasados en el metodo guiaholder de la clase GuiaAdapter
    private void llenarDatosMusculos() {

        //creamos la lista y la llenamos
        listaMusculos = new ArrayList<>();
        listaMusculos.add(new guiaEjercicios("Pectorales", "Ejercicios para pecho", R.drawable.pecho));
        listaMusculos.add(new guiaEjercicios("Espalda", "Ejercicios para espalda y dorsal",R.drawable.espalda));
        listaMusculos.add(new guiaEjercicios("Biceps", "Ejercicios para biceps y antebrazo",R.drawable.biceps));
        listaMusculos.add(new guiaEjercicios("Triceps", "Ejercicios para triceps",R.drawable.triceps));
        listaMusculos.add(new guiaEjercicios("Hombros", "Ejercicios para hombros",R.drawable.hombros));
        listaMusculos.add(new guiaEjercicios("Piernas", "Ejercicios para piernas y gluteos",R.drawable.piernas));
        listaMusculos.add(new guiaEjercicios("Abdomen", "Ejercicios para abdomen",R.drawable.abdomen));


    }

    private void initViews() {
        //Asignamos al recyclerview un linearLayout y le decimos que su tamaño sea fijo
        rvMuscles = findViewById(R.id.rv_muscles);
        rvMuscles.setLayoutManager(new LinearLayoutManager(this));
        rvMuscles.setHasFixedSize(true);

    }
}