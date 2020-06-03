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

public class VentanaEspalda extends AppCompatActivity {

    private RecyclerView rvMuscles;
    private ZoneAdapter adapter;
    private List<guiaEjerciciosZone> listaEjerciciosZone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_espalda);

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

                if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Dominadas") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=8mhDd9Ahl1M");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Dominada Mixta") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=cdcnc7HtLH4");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Flexión de brazo") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=-EHnqnRUBcQ");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Inverted Pull Ups") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=bEbh0uB94Bc");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Jalon Polea Alta") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=ai-Q068ZTJg");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Jalon a la Nuca") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=Ty5dsvPWfEs");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Pullover") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=qAYyJugCLKo");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Remo con Banda") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=Jk0nQEmi0bA");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Remo Horizontal") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=Xzo0GBl5qw8");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Remo con Mancuerna") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=0pNK-bdRtBY");
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
        listaEjerciciosZone.add(new guiaEjerciciosZone("Dominadas",  R.drawable.dominadas));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Dominada Mixta",  R.drawable.dominada_mixta));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Flexión de Brazo",  R.drawable.flexion_brazo));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Inverted Pull Ups", R.drawable.inverted_pull_ups));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Jalon Polea Alta",  R.drawable.jalon_polea_alta));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Jalon a la Nuca",  R.drawable.jalon_nuca));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Pullover",  R.drawable.pullover));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Remo con Banda",  R.drawable.remo_banda));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Remo Horizontal",  R.drawable.remo_horizontal));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Remo con Mancuerna", R.drawable.remo_mancuerna));
        
    }

    private void initViews() {
        //Asignamos al recyclerview un linearLayout y le decimos que su tamaño sea fijo
        rvMuscles = findViewById(R.id.rv_muscles);
        rvMuscles.setLayoutManager(new LinearLayoutManager(this));
        rvMuscles.setHasFixedSize(true);

    }
}
