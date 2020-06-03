package com.example.fitwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class VentanaRegistro extends AppCompatActivity {


    EditText nombre, correo, contraseña;
    Button crearCuenta;

    //Variables de los datos que vamos a registrar
    String name = " ";
    String email = " ";
    String password = " ";

    //Objeto firebaseauth que nos permitira hacer la autenticacion con firebase
    private FirebaseAuth mAuth;
    //Objeto para la base de datos realtime de Firebase
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_registro);

        //Inicializamos FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
        //Inicializamos la base de datos
        mDatabase = FirebaseDatabase.getInstance().getReference();

        nombre = findViewById(R.id.et_nombre);
        correo = findViewById(R.id.et_correo);
        contraseña = findViewById(R.id.et_contrasena);
        crearCuenta = findViewById(R.id.bt_registrar);

        crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nombre.getText().toString();
                email = correo.getText().toString();
                password = contraseña.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {

                    if(password.length() >= 6) {
                        //Si la contraseña tiene 6 o mas caracteres llamamos al metodo registrar usuario
                        registerUser();
                    }
                    else {
                        Toast.makeText(VentanaRegistro.this, "La contraseña debe de tener al menos 6 carácteres", Toast.LENGTH_LONG).show();
                    }

                }

                else {
                    //Si algun campo se deja vacio,saldra este mensaje
                    Toast.makeText(VentanaRegistro.this, "Debe completar todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void registerUser() {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                //si la tarea se completo exitosamente, crearemos los datos en la base de datos
                if (task.isSuccessful()) {

                    Map<String, Object> map = new HashMap<>();
                    map.put("name", name);
                    map.put("email", email);
                    map.put("password", password);

                    //Obtenemos el usuario que se va a registrar
                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {
                                //si los usuarios se crean exitosamente los enviamos a otra pantalla
                                startActivity(new Intent(VentanaRegistro.this, VentanaPerfil.class));
                                finish();
                            }
                            else {
                                Toast.makeText(VentanaRegistro.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                else {
                    //Si no enviaremos un mensaje al usuario de que no se ha podido guardar los datos
                    Toast.makeText(VentanaRegistro.this, "No se pudo registrar este usuario", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
