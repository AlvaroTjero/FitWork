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

public class VentanaBiceps extends AppCompatActivity {

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

                if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Curl en Predicador") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=ERtAmNchnFQ");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Curl Martillo") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=de4AdSz4gcU");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Curl de Biceps") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=COzFAWnbdPY");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Curl en Barra") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=qC0yZwpF9Ew");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Curl Inverso") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=5bs0NwYKT9A");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Curl con Barra Z") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=QkvdW7Q8lWk");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Dominadas Agarre Supino") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=P68KkJU-mnA");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Flexión de Muñeca") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=xLVDLnW-dQQ");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Jalon Agarre Supino") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=uFnCyZOWxds");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Peso con Cuerda") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=0pZ98TZVCX8");
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
        listaEjerciciosZone.add(new guiaEjerciciosZone("Curl en Predicador",  R.drawable.curl_predicador));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Curl Martillo",  R.drawable.curl_martillo));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Curl de Biceps",  R.drawable.curl_biceps));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Curl en Barra", R.drawable.curl_barra));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Curl Inverso",  R.drawable.curl_inverso));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Curl con Barra Z",  R.drawable.curl_barra_z));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Dominadas Agarre Supino",  R.drawable.dominadas_supino));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Flexión de Muñeca",  R.drawable.flexion_muneca));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Jalon Agarre Supino",  R.drawable.jalon_supino));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Peso con Cuerda", R.drawable.cuerda_mancuerna));

    }

    private void initViews() {
        //Asignamos al recyclerview un linearLayout y le decimos que su tamaño sea fijo
        rvMuscles = findViewById(R.id.rv_muscles);
        rvMuscles.setLayoutManager(new LinearLayoutManager(this));
        rvMuscles.setHasFixedSize(true);

    }
}