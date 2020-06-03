package com.example.fitwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VentanaPreentreno extends AppCompatActivity {

    Button comprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_preentreno);

        comprar = findViewById(R.id.bt_cPreentreno);

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.amazon.es/gp/product/B00CBEJVSU/ref=as_li_tl?ie=UTF8&tag=suples21s-21&camp=3638&creative=24630&linkCode=as2&creativeASIN=B00CBEJVSU&linkId=7c2b695e96a63289ea710e73bb81a13e");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
