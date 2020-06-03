package com.example.fitwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fitwork.model.Foro;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VentanaForo extends AppCompatActivity {

    private List<Foro> listMensajes = new ArrayList<Foro>();
    ArrayAdapter<Foro> arrayAdapterEjercicio;

    EditText menU;
    ListView listV_mensajes;
    String nombre, mensaje;

    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Foro mensajeSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ventana_foro);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.rutinas);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.rutinas:
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), VentanaInicio.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.cuenta:
                        startActivity(new Intent(getApplicationContext(), VentanaPerfil.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        mAuth = FirebaseAuth.getInstance();

        menU = findViewById(R.id.mensaje);
        listV_mensajes = findViewById(R.id.datos);
        
        //Metodo para inicializar Firebase
        inicializarFirebase();
        listarDatos();

        listV_mensajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mensajeSelected = (Foro) parent.getItemAtPosition(position);

                menU.setText(mensajeSelected.getMensaje());
            }
        });

    }

    private void listarDatos() {
        databaseReference.child("Foro").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listMensajes.clear();

                //recorremos el objeto snapshot y obtenemos el hijo, con el objeto Foro obtenemos la clase y la guardamos y finalmente a la lista le añadimos el objeto
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    Foro j = objSnapshot.getValue(Foro.class);
                    listMensajes.add(j);

                    //Creamos el arrayAdapter y le colocamos una plantilla a la lista listEjercicio, finalmente añadimos al listView el nuevo adapter
                    arrayAdapterEjercicio = new ArrayAdapter<Foro>(VentanaForo.this, android.R.layout.simple_list_item_1, listMensajes);
                    listV_mensajes.setAdapter(arrayAdapterEjercicio);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
        //mAuth = FirebaseAuth.getInstance();
    }

    //Agregamos el menu a la ventana rutina de los tres botones a la derecha
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rutina, menu);
        return super.onCreateOptionsMenu(menu);

    }

    //Menu para los botones de arriba a la derecha
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        mensaje = menU.getText().toString();
        switch (item.getItemId()) {

            case R.id.add:{
                if (mensaje.isEmpty()) {
                    validacion();
                }
                else {
                    //Objeto ejercicio creado en model
                    Foro j = new Foro();
                    j.setUid(UUID.randomUUID().toString());

                    Intent intent = getIntent();

                    String nombre = intent.getStringExtra("string_usuario");

                    j.setNombre(nombre);
                    j.setMensaje(mensaje);

                    databaseReference.child("Foro").child(j.getUid()).setValue(j);

                    Toast.makeText(this, "Se ha añadido Correctamente", Toast.LENGTH_SHORT).show();
                    limpiarCajas();
                }
                break;
            }

            case R.id.save:{
                //hacemos que cuando seleccionemos un item de la lista nos rellene los editText con sus datos,
                //podemos modificarlos y cuando le demos al boton de guardar, se actualizaran los datos
                Foro j = new Foro();
                j.setUid(mensajeSelected.getUid());

                j.setMensaje(menU.getText().toString().trim());

                databaseReference.child("Foro").child(j.getUid()).setValue(j);

                Toast.makeText(this, "Se ha editado Correctamente", Toast.LENGTH_SHORT).show();
                limpiarCajas();
                break;
            }

            case R.id.delete:{

                if (mensaje.isEmpty()) {
                    validacion2();
                }
                else {
                    Foro j = new Foro();
                    j.setUid(mensajeSelected.getUid());
                    databaseReference.child("Foro").child(j.getUid()).removeValue();

                    Toast.makeText(this, "Se ha borrado correctamente", Toast.LENGTH_SHORT).show();
                    limpiarCajas();
                }
                break;
            }
            default:break;
        }
        return true;
    }

    private void validacion2() {
        Toast.makeText(this, "Debe seleccionar un objeto de la lista", Toast.LENGTH_SHORT).show();
    }

    private void validacion() {

        mensaje = menU.getText().toString();

        if (mensaje.isEmpty()) {
            menU.setError("Campo Requerido");
        }
    }

    private void limpiarCajas() {
        menU.setText("");
    }

}


