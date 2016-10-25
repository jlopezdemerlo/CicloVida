package net.iessochoa.joseantoniolopez.ciclovida;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private final static String CICLO_TAG = "EstadoCV-Activity";
    private String ciclo_vida;
    private TextView txv_estado;
    private ArrayList<CharSequence> datosSpinner;
    private ArrayAdapter<CharSequence>  adaptador;
    private Spinner cmbDesaparece;
    private CheckBox chkGuardar;
    private int totalFragmento=0;

    //pivate frgFragment CicloVidaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_iniciar = (Button)findViewById(R.id.btn_iniciar_activity);
        Button btn_finalizar = (Button)findViewById(R.id.btn_finalizar);
        txv_estado = (TextView)findViewById(R.id.txv_estado);
        chkGuardar=(CheckBox) findViewById(R.id.chkGuardar);

        //frgFragment=(CicloVidaFragment)findViewById(R.id.frgFragment);


        ciclo_vida = "Estado: onCreate";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG, ciclo_vida);

        //Prueba Girar pantalla
        cmbDesaparece=(Spinner) findViewById(R.id.cmbDesaparece);
        if(savedInstanceState==null)//Primer Create
        {

            datosSpinner = new ArrayList<CharSequence>();
            datosSpinner.add("Cero");

        }else{//Recuperamos los datos del spinner si los hemos guardado
            datosSpinner=savedInstanceState.getCharSequenceArrayList("DATOS_SPINNER");
            if(datosSpinner==null){//no se guardaron los datos
                datosSpinner = new ArrayList<CharSequence>();
                datosSpinner.add("Cero");
            }
            else
                android.util.Log.i(CICLO_TAG, "Datos de Spinner recuperados en onCreate");

        }

        adaptador = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, datosSpinner);
        cmbDesaparece.setAdapter(adaptador);



    }

    @Override
    protected void onStart(){
        super.onStart();
        ciclo_vida = "Estado: onStart";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        ciclo_vida = "Estado: onRestart";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG, ciclo_vida);
    }

    @Override
    protected void onResume(){
        super.onResume();
        ciclo_vida = "Estado: onResume";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }

    @Override
    protected void onPause(){
        super.onPause();
        ciclo_vida = "Estado: onPause";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }

    @Override
    protected void onStop(){
        super.onStop();
        ciclo_vida = "Estado: onStop";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ciclo_vida = "Estado: onDestroy";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ciclo_vida = "Estado: onSaveInstanceState-Guardar los datos que quieras recuperar de  reconstruccion  Activity";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG, ciclo_vida);
        if(chkGuardar.isChecked()){
            android.util.Log.i(CICLO_TAG, "Guardamos los datos del Spinner");
            outState.putCharSequenceArrayList("DATOS_SPINNER",datosSpinner);
        }

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ciclo_vida = "Estado: onRestoreInstanceState-Recuperar datos  reconstruccion  Activity";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG, ciclo_vida);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void iniciarActivity(View view){
        Intent starter = new Intent(this, SegundaActivity.class);
        startActivity(starter);
    }

    public void finalizarActivity(View view){
        finish();

    }
    public void cuadroDialogo(View v){
        final AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Aviso");
        dialogo1.setMessage("El cuadro de dialogo es un fragment y la Activity no cambia de estado");
        dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogo, int i) {
                //
                dialogo.cancel();


            }
        });

        dialogo1.show();
    }
    public void iniciarActivityVisible(View view){
        Intent starter = new Intent(this, AcercaDeActivity.class);
        startActivity(starter);
    }
    public void verCicloVida(View v){
        Intent starter = new Intent(this, ImgenCicloVidaActivity.class);
        startActivity(starter);
    }
    public void cargarDatosSpinner(View v){
        datosSpinner.add("uno");
        datosSpinner.add("dos");
        datosSpinner.add("tres");
        datosSpinner.add("cuatro");


        adaptador.notifyDataSetChanged();


    }
    void asignaParametrosContenedorFragment(View v){
        FrameLayout.LayoutParams params=
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT);
        v.setLayoutParams(params);

    }
    public void cargaFragment(View v){

        FragmentManager fragmentManager;
        FragmentTransaction transaction;
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        CicloVidaFragment frgFragment=CicloVidaFragment.newInstance(Integer.toString(totalFragmento));
        transaction.replace(R.id.lytFragment, frgFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        fragmentManager.executePendingTransactions();
        ((TextView)(findViewById(R.id.lblFragmentDinamico))).setVisibility(View.INVISIBLE);

        totalFragmento++;

    }
    public void informacion(View v){

            final AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Informacion");
            dialogo1.setMessage("Para ver los estados ve a \"logcat\" y en \"loglevel\" elige \"info\". Escribe :\nEstadoCV: Todos los estados\nEstadoCV-A: Estados Activity\nEstadoCV-F: Estados Fragment ");
            dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogo, int i) {
                    //
                    dialogo.cancel();


                }
            });

            dialogo1.show();

    }
}
