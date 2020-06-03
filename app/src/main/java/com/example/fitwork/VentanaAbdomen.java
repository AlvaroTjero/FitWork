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

public class VentanaAbdomen extends AppCompatActivity {

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

                if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Abdominales con Roller") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=3XTYGJyyIug");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Elevación de Piernas") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=F9wTR13Cd3M");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Encogimiento Estirado") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=m66lWZ1VAbQ");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Encogimientos") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=OsUz898onTE");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Elevación Pierna Flexionada") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=WeCKFEasj_g");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Elevación Vertical") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=gSDrCCPscsk");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Plancha") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=61A2oTh10V8");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Plancha Lateral") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=9jbytm2Kmu0");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Plancha Inversa") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=sW3N9sZLh2E");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Tijeras en Supino") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=eeKu3owQSKo");
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
        listaEjerciciosZone.add(new guiaEjerciciosZone("Abdominales con Roller", R.drawable.abdominales_roller));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Elevación de Piernas", R.drawable.elevacion_piernas));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Encogimiento Estirado", R.drawable.encogimientos_brazo_estirado));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Encogimientos", R.drawable.encogimientos));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Elevación Pierna Flexionada", R.drawable.elevacion_piernas_flexionadas));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Elevación Vertical", R.drawable.elevacion_pelvis_vertical));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Plancha",  R.drawable.plancha_isometrica));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Plancha Lateral", R.drawable.plancha_lateral));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Plancha Inversa", R.drawable.plancha_inversa));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Tijeras en Supino", R.drawable.tijeras_supino));

    }

    private void initViews() {
        //Asignamos al recyclerview un linearLayout y le decimos que su tamaño sea fijo
        rvMuscles = findViewById(R.id.rv_muscles);
        rvMuscles.setLayoutManager(new LinearLayoutManager(this));
        rvMuscles.setHasFixedSize(true);

    }
}
