package com.example.fitwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VentanaProteinas extends AppCompatActivity {

    Button comprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_proteinas);

        comprar = findViewById(R.id.bt_cProteinas);

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.amazon.es/gp/product/B002DYIZHG/ref=as_li_tl?ie=UTF8&tag=suples21s-21&camp=3638&creative=24630&linkCode=as2&creativeASIN=B002DYIZHG&linkId=c2c6fc68bea4750404926a30f9b30e31");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
