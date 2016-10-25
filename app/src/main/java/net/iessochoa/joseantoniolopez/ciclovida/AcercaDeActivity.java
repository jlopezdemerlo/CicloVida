package net.iessochoa.joseantoniolopez.ciclovida;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class AcercaDeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);


    }

    public void clickAceptar(View v){
        this.finish();
    }
}
