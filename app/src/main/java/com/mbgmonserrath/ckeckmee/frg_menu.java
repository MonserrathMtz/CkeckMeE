package com.mbgmonserrath.ckeckmee;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frg_menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frg_menu extends Fragment {
    private CardView btnPerfil, btnGrupo, btnInscripciones, btnCerrarSesion, btnAcercaDe;
    private NavController navegador;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public frg_menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frg_menu.
     */
    // TODO: Rename and change types and number of parameters
    public static frg_menu newInstance(String param1, String param2) {
        frg_menu fragment = new frg_menu();
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
        return inflater.inflate(R.layout.fragment_frg_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnPerfil = view.findViewById(R.id.menu_btn_perfil);
        btnGrupo = view.findViewById(R.id.menu_btn_grupo);
        btnInscripciones = view.findViewById(R.id.menu_btn_inscripciones);
        btnCerrarSesion = view.findViewById(R.id.menu_btn_cerrarsesion);
        btnAcercaDe = view.findViewById(R.id.menu_btn_acerca_de);
        navegador = Navigation.findNavController(view);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicarPerfil();
            }
        });
        btnGrupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicGrupo();
            }
        });
        btnInscripciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicInscripciones();
            }
        });
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicCerrarSesion();
            }
        });
        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAcercaDe();
            }
        });

    }

    private void clicInscripciones() {
        navegador.navigate(R.id.action_frg_menu_to_frg_inscrpciones);
    }

    private void clicCerrarSesion() {
        navegador.navigate(R.id.action_frg_menu_to_frg_login);
    }

    private void clicAcercaDe() {
        navegador.navigate(R.id.action_frg_menu_to_frg_acerca_de);
    }

    private void clicGrupo() {
        navegador.navigate(R.id.action_frg_menu_to_frg_grupos);
    }

    private void clicarPerfil() {
        navegador.navigate(R.id.action_frg_menu_to_frg_perfil);
    }
}