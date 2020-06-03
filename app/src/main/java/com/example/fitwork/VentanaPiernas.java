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

public class VentanaPiernas extends AppCompatActivity {

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

                if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Elevación de Talones") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=3r06Djg4edQ");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Extensión de Gemelos") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=mM7K8Mmh-20");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Peso Muerto") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=jTb4BKBCGxk");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Pistol Squats") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=Hh2hIJDGCz8");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Plancha Inversa") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=sW3N9sZLh2E");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Puente de Gluteos") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=zcSGnMm5QUk");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Sentadilla con Salto") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=IiHH0EWo8-k");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Sentadilla Bulgara") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=rlFldyOt0b0");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Sentadilla Sumo") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=o7YCG_QPmCA");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Zancada") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=qfKHl9_EvWc");
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
        listaEjerciciosZone.add(new guiaEjerciciosZone("Elevación de Talones", R.drawable.elevacion_talones));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Extensión de Gemelos", R.drawable.extension_gemelos));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Peso Muerto", R.drawable.peso_muerto));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Pistol Squats", R.drawable.pistol_squeats));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Plancha Inversa", R.drawable.plancha_inversa));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Puente de Gluteos", R.drawable.puente_gluteos));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Sentadilla con Salto", R.drawable.sentadilla_salto));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Sentadilla Bulgara", R.drawable.sentadilla_bulgara));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Sentadilla Sumo", R.drawable.sentadilla_sumo));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Zancada", R.drawable.zancada));

    }

    private void initViews() {
        //Asignamos al recyclerview un linearLayout y le decimos que su tamaño sea fijo
        rvMuscles = findViewById(R.id.rv_muscles);
        rvMuscles.setLayoutManager(new LinearLayoutManager(this));
        rvMuscles.setHasFixedSize(true);

    }
}