package com.example.firebaseexamen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firebaseexamen.model.Gasolinera;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText nombreEt, precioDEt, precioREt, precioSEt;
    ListView lvPersona;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreEt = findViewById(R.id.nombre);
        precioDEt = findViewById(R.id.apellidos);
        precioREt = findViewById(R.id.correo);
        precioSEt = findViewById(R.id.contra);

        lvPersona = findViewById(R.id.lvPersonas);
        inicializarFirebase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String nombre = nombreEt.getText().toString();
        String apellidos = precioDEt.getText().toString();
        String correo = precioREt.getText().toString();
        String contra = precioSEt.getText().toString();

        switch(item.getItemId()){
            case R.id.icon_add:{
                if(nombre.equals("")){
                    validacion();
                }else{
                    Gasolinera p = new Gasolinera();
                    p.setUid(UUID.randomUUID().toString());
                    p.setNombre(nombre);
                    p.setPrecioDiesel(apellidos);
                    p.setPrecioRegular(correo);
                    p.setPrecioSuper(contra);
                    databaseReference.child("Gasolinera").child(p.getUid()).setValue(p);

                    Toast.makeText(this, "Agregar", Toast.LENGTH_LONG).show();
                    limpiarCampos();
                }
                break;
            }

            case R.id.icon_save:{
                Toast.makeText(this, "Guardar", Toast.LENGTH_LONG).show();
                break;
            }

            default:break;

        }

        return true;
    }

    private void limpiarCampos() {
        nombreEt.setText("");
        precioDEt.setText("");
        precioREt.setText("");
        precioSEt.setText("");
    }

    private void validacion() {
        String nombre = nombreEt.getText().toString();

        if(nombre.equals("")){
            nombreEt.setError("Required");
        }
    }
}