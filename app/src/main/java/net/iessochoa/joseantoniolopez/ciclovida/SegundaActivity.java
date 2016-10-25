package net.iessochoa.joseantoniolopez.ciclovida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SegundaActivity extends AppCompatActivity {
    public void salir(View v)
    {
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
    }
}
