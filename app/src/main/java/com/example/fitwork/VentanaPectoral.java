package com.example.fitwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fitwork.model.guiaEjerciciosZone;
import com.example.fitwork.recyclerview.ZoneAdapter;

import java.util.ArrayList;
import java.util.List;

public class VentanaPectoral extends AppCompatActivity {

    private RecyclerView rvMuscles;
    private ZoneAdapter adapter;
    private List<guiaEjerciciosZone> listaEjerciciosZone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_pectoral);

        //metodos para crear el recyclerview
        initViews();
        llenarDatosMusculos();
        setupMuscleAdapter();

    }

    //lo usamos para inicializar y crear el adapter para meterlo dentro del recyclerview
    private void setupMuscleAdapter() {

        adapter = new ZoneAdapter(listaEjerciciosZone);
        rvMuscles.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Aperturas con Botellas") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=xyHdY99F640");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Aperturas en máquina") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=88trPSR2xqU");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Flexiones") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=vwOth6wAR5Q");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Flexiones Apoyado") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=23NYAAo1usA");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Flexiones con Palmada") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=icdEDFsd0b0");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Fondos Paralelas") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=Dhkb1XVUzLI");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Press Banca") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=j47ElpSfjKs");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Press Banca Mancuernas") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=MeyuOEimrC0");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Press con TRX") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=k8jG-jhB0p0");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Press Mancuernas") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=MeyuOEimrC0");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });
    }


    //Rellenamos el recyclerview con los parametros pasados en el metodo guiaholder de la clase GuiaAdapter
    private void llenarDatosMusculos() {

        //creamos la lista y la llenamos
        listaEjerciciosZone = new ArrayList<>();
        listaEjerciciosZone.add(new guiaEjerciciosZone("Aperturas con Botellas",R.drawable.aperturas_botellas));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Aperturas en máquina",R.drawable.aperturas_maquina));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Flexiones", R.drawable.flexiones));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Flexiones Apoyado",R.drawable.flexion_apoyado));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Flexiones con Palmada",R.drawable.flexiones_palmada));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Fondos Paralelas",R.drawable.fondos_paralelas));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Press Banca",R.drawable.press_banca));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Press Banca Mancuernas",R.drawable.press_banca_con_mancuernas));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Press con TRX",R.drawable.press_pectoral));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Press Mancuernas",R.drawable.press_mancuernas));
    }

    private void initViews() {
        //Asignamos al recyclerview un linearLayout y le decimos que su tamaño sea fijo
        rvMuscles = findViewById(R.id.rv_muscles);
        rvMuscles.setLayoutManager(new LinearLayoutManager(this));
        rvMuscles.setHasFixedSize(true);

    }
}