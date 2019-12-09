package net.iessochoa.joseantoniolopez.ciclovida;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class CicloVidaFragment extends Fragment {

    public boolean mostrarLog=false;
    private final String LOG_TAG = "EstadoCV-Fragment";
    public final  static String PARAMETRO="PARAMETRO";
    private String titulo="";
    String par="";

    private void leerPreferencias(){
        SharedPreferences prefs = getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

    }
    public CicloVidaFragment() {
        // Required empty public constructor
    }
    public static CicloVidaFragment newInstance(String param1) {
        CicloVidaFragment fragment = new CicloVidaFragment();
        Bundle args = new Bundle();
        args.putString(PARAMETRO, param1);

        fragment.setArguments(args);

        return fragment;
    }






    @Override
    public void onAttach (Activity activity) {
        super.onAttach(activity);
        leerPreferencias();
        if (getArguments() != null) {
            par = getArguments().getString(PARAMETRO);

        }
        Log.i(LOG_TAG, "onAttach" + " " + par);
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        leerPreferencias();

        Log.i(LOG_TAG, "onCreate"+" "+par);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ciclo_vida, container, false);
        leerPreferencias();
        Log.i(LOG_TAG, "onCreateView" + " " + par);
		/* Aquí podemos seleccionar las Views contenidas en el Layout para trabajar con ellas, por ejemplo con:
		 * TipoView miView = (TipoView) rootView.findViewById(R.id.miViewXML);
		 */
        return rootView;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        leerPreferencias();
        if (getArguments() != null) {
            par = getArguments().getString(PARAMETRO);
            ((TextView)getView().findViewById(R.id.lblFragment)).setText("Fragmento "+par);
        }
        Log.i(LOG_TAG, "onActivityCreated"+" "+par);

    }

    @Override
    public void onViewStateRestored (Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        leerPreferencias();
        Log.i(LOG_TAG, "onViewStateRestored"+" "+par);
    }

    @Override
    public void onStart () {
        super.onStart();
        leerPreferencias();
       Log.i(LOG_TAG, "onStart"+" "+par);
    }

    @Override
    public void onResume () {
        super.onResume();
        leerPreferencias();
        Log.i(LOG_TAG, "onResume"+" "+par);
    }

    @Override
    public void onPause () {
        super.onPause();
        leerPreferencias();
      Log.i(LOG_TAG, "onPause"+" "+par);
    }

    @Override
    public void onStop () {
        super.onStop();
        leerPreferencias();
       Log.i(LOG_TAG, "onStop"+" "+par);
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        leerPreferencias();
        Log.i(LOG_TAG, "onSaveInstanceState" + " " + par);
    }
    @Override
    public void onDestroyView () {
        super.onDestroyView();
        leerPreferencias();
       Log.i(LOG_TAG, "onDestroyView"+" "+par);
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
        leerPreferencias();
        Log.i(LOG_TAG, "onDestroy"+" "+par);
    }

    @Override
    public void onDetach () {
        super.onDetach();
        leerPreferencias();
         Log.i(LOG_TAG, "onDetach"+" "+par);
    }



}
