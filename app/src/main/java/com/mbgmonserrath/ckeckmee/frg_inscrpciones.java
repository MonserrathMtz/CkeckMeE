package com.mbgmonserrath.ckeckmee;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.mbgmonserrath.ckeckmee.adapter.AdapterInscripciones;
import com.mbgmonserrath.ckeckmee.modelo.MInscripciones;
import com.mbgmonserrath.ckeckmee.modelo.MEstudiante;
import com.mbgmonserrath.ckeckmee.volley.API;
import com.mbgmonserrath.ckeckmee.volley.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frg_inscrpciones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frg_inscrpciones extends Fragment {
    private EditText txtFiltro;
    private AdapterInscripciones adapter;
    private ArrayList<MInscripciones> lista;
    private Bundle paquete;
    private TextView txtNombre, txtMatricula, txtCorreo;
    private NavController navegador;
    private ImageView btnPerfil, btnMenu, btnGrupos, btnBaja;
    private MInscripciones obj;
    private RecyclerView rec;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnGrupos = view.findViewById(R.id.inscri_btn_grupos);
        btnPerfil = view.findViewById(R.id.inscri_btn_perfil);
        btnMenu = view.findViewById(R.id.inscri_btn_menu);
        btnBaja = view.findViewById(R.id.inscri_btn_baja);
        txtFiltro = view.findViewById(R.id.frg_inscri_txtbuscar);
        txtNombre = view.findViewById(R.id.inscri_nombre);
        txtMatricula = view.findViewById(R.id.inscri_matricula);
        txtCorreo = view.findViewById(R.id.inscri_correo);
        txtFiltro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                buscador(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        paquete = this.getArguments();
        rec = view.findViewById(R.id.frg_inscri_recycler_view);
        lista = llenadoDesdeBD();
        btnGrupos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickGrupos();
            }
        });
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickPerfil();
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickMenu();
            }
        });
        btnBaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBaja();
            }
        });

        /*if (paquete!=null){
            /*obj = (MInscripciones) paquete.getSerializable("user");
            txtNombre.setText(obj.getNombre()+"");
            txtMatricula.setText(String.valueOf(obj.getIdEstudiante()));
            txtCorreo.setText(obj.getNombreCorto());
        }*/
        navegador = Navigation.findNavController(view);
    }

    private void clickBaja() {
        navegador.navigate(R.id.action_frg_inscrpciones_to_frg_CRUD_Inscri);
    }

    private void clickMenu() {
        navegador.navigate(R.id.action_frg_inscrpciones_to_frg_menu);
    }

    private void clickPerfil() {
        navegador.navigate(R.id.action_frg_inscrpciones_to_frg_perfil);
    }

    private void clickGrupos() {
        navegador.navigate(R.id.action_frg_inscrpciones_to_frg_grupos);
    }

    private ArrayList<MInscripciones> llenadoDesdeBD() {
        ArrayList<MInscripciones> lista =new ArrayList<MInscripciones>();
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
        StringRequest solicitud= new StringRequest(Request.Method.POST,API.LISTARI,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();//apaga el cuadro de dialogo
                        try {
                            //LEER AQUI EL CONTENIDO DE LA VARIABLE response
                            JSONObject contenido = new JSONObject(response);
                            JSONArray array=contenido.getJSONArray("contenido");
                            MInscripciones obj=new MInscripciones();
                            for (int i = 0; i < array.length(); i++) {
                                obj=new MInscripciones();
                                JSONObject pos=new JSONObject(array.getString(i));
                                obj.setNombre(pos.getString("nombre"));
                                obj.setNombreDoc(pos.getString("nombreDoc")+" "+pos.getString("app") + " "+
                                        pos.getString("apm"));
                                obj.setIdGrupo(pos.getInt("idGrupo"));
                                obj.setNombreCorto(pos.getString("nombreCorto"));
                                obj.setIdInscripcion(pos.getInt("idInscripcion"));
                                obj.setIdEstudiante(pos.getInt("IdEstudiante"));
                                obj.setOp(pos.getInt("op"));
                                lista.add(obj);
                            }
                            rec.setHasFixedSize(true);
                            rec.setLayoutManager(new LinearLayoutManager(getContext()));
                            adapter=new AdapterInscripciones(lista);
                            rec.setAdapter(adapter);
                        }catch (Exception ex){
                            //DETECTA ERRORES EN LA LECTURA DEL ARCHIVO JSON
                            msg.setTitle("Error");
                            msg.setMessage("No se pudo leer el archivo JSON....");
                            msg.setPositiveButton("Aceptar",null);
                            AlertDialog dialog = msg.create();
                            msg.show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                // DETECTA ERRORES EN LA COMUNICACIÓN
                msg.setTitle("Error");
                msg.setMessage("No se pudo leer el archivo JSON*-*");
                msg.setPositiveButton("Aceptar",null);
                AlertDialog dialog = msg.create();
                msg.show();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> param=new HashMap<String,String>();
                //PASA PARAMETROS A LA SOLICITUD
                param.put("id","4");
                return param;
            }
        };
        //ENVIA LA SOLICITUD
        colaDeSolicitudes.add(solicitud);

        return lista;
    }

    private void buscador(String string) {
        ArrayList<MInscripciones> lista2 = new ArrayList<MInscripciones>();
        for (MInscripciones ins: lista){
            if (ins.getNombreCorto().contains(string.toString())) {
                lista2.add(ins);
            }
        }
        adapter.filtro(lista2);
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public frg_inscrpciones() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frg_inscrpciones.
     */
    // TODO: Rename and change types and number of parameters
    public static frg_inscrpciones newInstance(String param1, String param2) {
        frg_inscrpciones fragment = new frg_inscrpciones();
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
        return inflater.inflate(R.layout.fragment_frg_inscrpciones, container, false);
    }
}