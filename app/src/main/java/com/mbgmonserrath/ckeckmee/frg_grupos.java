package com.mbgmonserrath.ckeckmee;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frg_grupos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frg_grupos extends Fragment {
    private ImageView btnPerfil, btnInscripciones, btnMenu, btnAsistencia;
    private NavController navegador;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public frg_grupos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frg_grupos.
     */
    // TODO: Rename and change types and number of parameters
    public static frg_grupos newInstance(String param1, String param2) {
        frg_grupos fragment = new frg_grupos();
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
        return inflater.inflate(R.layout.fragment_frg_grupos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnPerfil = view.findViewById(R.id.gpo_btn_perfil);
        btnInscripciones = view.findViewById(R.id.gpo_btn_inscripciones);
        btnMenu = view.findViewById(R.id.gpo_btn_menu);
        //btnAsistencia = view.findViewById(R.id.item_asistencia);
        navegador = Navigation.findNavController(view);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicarPerfil();
            }
        });
        btnInscripciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicInscripciones();
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicMenu();
            }
        });
        /*btnAsistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAsistencia();
            }
        });*/
    }

    private void clicAsistencia() {
        navegador.navigate(R.id.action_frg_grupos_to_frg_asistencia);
    }

    private void clicInscripciones() {
        navegador.navigate(R.id.action_frg_grupos_to_frg_inscrpciones);
    }

    private void clicMenu() {
        navegador.navigate(R.id.action_frg_grupos_to_frg_menu);
    }

    private void clicarPerfil() {
        navegador.navigate(R.id.action_frg_grupos_to_frg_perfil);
    }
}