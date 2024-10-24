package com.mbgmonserrath.ckeckmee.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.mbgmonserrath.ckeckmee.R;
import com.mbgmonserrath.ckeckmee.modelo.MInscripciones;

import java.util.ArrayList;

public class AdapterInscripciones extends RecyclerView.Adapter<AdapterInscripciones.ViewHolderInscripciones> {
    private ArrayList<MInscripciones> lista;
    private Bundle paquete;

    public AdapterInscripciones(ArrayList<MInscripciones> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public AdapterInscripciones.ViewHolderInscripciones onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inscripciones, null, false);
        return new ViewHolderInscripciones(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterInscripciones.ViewHolderInscripciones holder, int position) {
        MInscripciones ins = lista.get(position);
        holder.txtClave.setText(ins.getNombreCorto()+"");
        holder.txtNombre.setText(ins.getNombreDoc()+"");
        paquete = new Bundle();
        paquete.putSerializable("objeto", ins);
        holder.btnAlta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicAlta(v,ins);
            }
        });
        holder.btnBaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paquete.putSerializable("objeto", ins);
                clicBaja(v);
            }
        });
    }

    private void clicBaja(View v) {
        NavController nav = Navigation.findNavController(v);
        paquete.putInt("op", 1);
        nav.navigate(R.id.action_frg_inscrpciones_to_frg_CRUD_Inscri, paquete);
    }

    private void clicAlta(View v, MInscripciones ins) {
        NavController nav = Navigation.findNavController(v);
        paquete.putInt("op", 2);
        nav.navigate(R.id.action_frg_inscrpciones_to_frg_CRUD_Inscri, paquete);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
    public  void filtro(ArrayList<MInscripciones> filtrados){
        this.lista = filtrados;
        notifyDataSetChanged();
    }
    public class ViewHolderInscripciones extends RecyclerView.ViewHolder {
        TextView txtClave, txtNombre;
        ImageView btnAlta, btnBaja;
        public ViewHolderInscripciones(@NonNull View itemView) {
            super(itemView);
            txtClave = itemView.findViewById(R.id.inscri_clave_gpo);
            txtNombre = itemView.findViewById(R.id.inscri_nombre_docente);
            btnAlta = itemView.findViewById(R.id.inscri_btn_alta);
            btnBaja = itemView.findViewById(R.id.inscri_btn_baja);
        }
    }
}
