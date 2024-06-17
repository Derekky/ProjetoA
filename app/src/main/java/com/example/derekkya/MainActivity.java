package com.example.derekkya;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv_latitude, tv_longitude, tv_precisao, tv_velocidade, tv_sensor, tv_atualizacao, tv_endereco;
    Switch sw_locationUpdates, sw_gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Inicialização dos objetos de texto
        tv_latitude = findViewById(R.id.tv_lat);
        tv_longitude = findViewById(R.id.tv_long);
        tv_precisao = findViewById(R.id.tv_prec);
        tv_velocidade = findViewById(R.id.tv_vel);
        tv_sensor = findViewById(R.id.tv_sens);
        tv_atualizacao = findViewById(R.id.tv_atuali);
        tv_endereco = findViewById(R.id.tv_ender);
        sw_gps = findViewById(R.id.switchGPS);
        sw_locationUpdates = findViewById(R.id.switchUpdates);

        //Variáveis de Geolocalização
        //lat2 e lon2 equivale ao campus USP-Leste por enquanto
        //lat1 e lon1 será as coordenadas atuais
        double lat1 = 0, lat2 = -23.48514333234679, lon1 = 0, lon2 = -46.50123767388998;

    }

    public double calcularDistancia(double lat1, double lat2, double lon1, double lon2){

        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers.
        double r = 6371;

        // calculate the result
        return(c * r);
    }
}