package com.mbgmonserrath.ckeckmee;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.mbgmonserrath.ckeckmee.modelo.MInscripciones;
import com.mbgmonserrath.ckeckmee.volley.API;
import com.mbgmonserrath.ckeckmee.volley.VolleySingleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frg_CRUD_Inscri#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frg_CRUD_Inscri extends Fragment {
    private EditText txtIdGrupo, txtIdEstudiante, txtOp;
    private CardView btnEliminar;
    private Bundle paquete;
    private MInscripciones ins;
    private int op;
    private ArrayList<MInscripciones> lista;
    private Spinner spinerAsig;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtIdGrupo = view.findViewById(R.id.crudI_txtIdGrupo);
        txtIdEstudiante = view.findViewById(R.id.crudI_txtidEstudiante);
        txtOp = view.findViewById(R.id.crudI_txtOp);
        btnEliminar = view.findViewById(R.id.crud_gpo_btn_eliminar);
        lista = new ArrayList<MInscripciones>();
        paquete = this.getArguments();
        if (paquete != null) {
            ins = (MInscripciones) paquete.getSerializable("objeto");
            op = paquete.getInt("op");
            txtIdGrupo.setText(ins.getIdGrupo()+"");
            txtIdEstudiante.setText(ins.getIdEstudiante()+"");
            txtOp.setText(ins.getOp()+"");
            if (op == 1) {
                btnEliminar.setVisibility(View.VISIBLE);
            }
            if (op == 2) {
                btnEliminar.setVisibility(View.VISIBLE);
            }
        }
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicEliminar();
            }
        });
    }

    private void clicEliminar() {
        AlertDialog.Builder msg = new AlertDialog.Builder(this.getContext());

        // Crear un ProgressBar
        ProgressBar progressBar = new ProgressBar(this.getContext());
        progressBar.setIndeterminate(true); // Estilo de carga indeterminada

        // Crear el AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("Por favor, espera");
        builder.setMessage("Conectandose con el servidor...");
        builder.setView(progressBar);
        builder.setCancelable(false); // Evitar que se pueda cancelar
        AlertDialog dialog = builder.create();
        dialog.show();

        RequestQueue colaDeSolicitudes= VolleySingleton.getInstance(this.getContext()).getRequestQueue();
        StringRequest solicitud= new StringRequest(Request.Method.POST, API.ELIMINARA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();//apaga el cuadro de dialogo
                        try {
                            //LEER AQUI EL CONTENIDO DE LA VARIABLE response
                            msg.setTitle("Eliminando");
                            msg.setMessage("La información se elimino correctamente");
                            msg.setPositiveButton("Aceptar",null);
                            AlertDialog dialog=msg.create();
                            msg.show();
                            txtIdEstudiante.setText("");
                            txtIdGrupo.setText("");
                            txtOp.setText("");
                        }catch (Exception ex){
                            //DETECTA ERRORES EN LA LECTURA DEL ARCHIVO JSON

                            msg.setTitle("Error");
                            msg.setMessage("La información no se pudo eliminar");
                            msg.setPositiveButton("Aceptar",null);
                            AlertDialog dialog=msg.create();
                            msg.show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                // DETECTA ERRORES EN LA COMUNICACIÓN
                msg.setTitle("Error");
                msg.setMessage("No se pudo conectar con el servidor");
                msg.setPositiveButton("Aceptar",null);
                AlertDialog dialog=msg.create();
                msg.show();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> param=new HashMap<String,String>();
                //PASA PARAMETROS A LA SOLICITUD
                param.put("idInscripcion","14");


                return param;
            }
        };
        //ENVIA LA SOLICITUD
        colaDeSolicitudes.add(solicitud);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public frg_CRUD_Inscri() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frg_CRUD_Inscri.
     */
    // TODO: Rename and change types and number of parameters
    public static frg_CRUD_Inscri newInstance(String param1, String param2) {
        frg_CRUD_Inscri fragment = new frg_CRUD_Inscri();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frg__c_r_u_d__inscri, container, false);
    }
}