package com.example.geolocalizacion10;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.zip.DeflaterOutputStream;

public class MainActivity extends AppCompatActivity {


    private FusedLocationProviderClient fusedLocationClient;        //Instanciar cliente de Servicios de Ubicacion
    TextView sLatitud, sLongitud;                                   //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        onGetRealTimeLocation();
        sLatitud = (TextView)findViewById(R.id.txtLatitud);
        sLongitud = (TextView)findViewById(R.id.txtLongitud);
    }

    private void onGetRealTimeLocation() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {

                            Log.e("Latitud -> " + location.getLatitude(),  " | Longitud -> "+ location.getLongitude());


                            String dLongitud = Double.toString(location.getLatitude());
                            String dLatitud = Double.toString(location.getLongitude());

                            sLatitud.setText(dLatitud);
                            sLongitud.setText(dLongitud);



                        }
                    }
                });
    }

    public void MyNewFunction(){
        //Funcion Developer 1
        //Funcion Pluss
    }

    public void FunctionDeveloper02(){
        //Cambio en funcion

        //Developer2
        //Developer1
    }

    public void MyNewFunction2(){
        //Construccioin...
    }
}
