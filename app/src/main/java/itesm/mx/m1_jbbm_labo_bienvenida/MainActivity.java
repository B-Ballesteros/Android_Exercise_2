package itesm.mx.m1_jbbm_labo_bienvenida;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final String DEBUG_TAG = "TAG_MainActivity";

    private Button btnSaludar;
    private TextView tvMensaje;
    private EditText etNombre;
    private ImageView ivImagen;
    private Button btnMostrar;

    int[] idImagenes = new int[]{
            R.drawable.persona1,
            R.drawable.persona2,
            R.drawable.persona3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.edit_Nombre);
        tvMensaje = (TextView)findViewById(R.id.text_Mensaje_Saludar);
        btnSaludar = (Button)findViewById(R.id.button_Saludar);
        ivImagen = (ImageView)findViewById(R.id.image_Icono);
        btnMostrar =  (Button)findViewById(R.id.button_Mostrar);

        btnSaludar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        switch(v.getId()){
            case R.id.button_Mostrar:
                Random rnd = new Random();
                int indiceImagen = rnd.nextInt(3);
                Log.d(DEBUG_TAG, "indice " + indiceImagen);
                Bitmap imagen = BitmapFactory.decodeResource(getResources(),
                        idImagenes[indiceImagen]);
                imagen = Bitmap.createScaledBitmap(imagen, 200, 200, true);
                ivImagen.setImageBitmap(imagen);
                break;
            case  R.id.button_Saludar:
                String nombre = etNombre.getText().toString();
                String mensaje = getResources().getString(R.string.mensaje_bienvenida_1) +
                        nombre +
                        getResources().getString(R.string.mensaje_bienvenida_2);
                tvMensaje.setText(mensaje);
                break;

        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        }else if( newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
        Log.d(DEBUG_TAG, "onConfigurationChanged");
    }
}
