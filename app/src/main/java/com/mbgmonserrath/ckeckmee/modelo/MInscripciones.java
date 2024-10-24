package com.mbgmonserrath.ckeckmee.modelo;

import java.io.Serializable;

public class MInscripciones implements Serializable {
    private int idGrupo;
    private int idEstudiante;
    private int op;
    private String nombre, nombreDoc, app, apm;
    private String nombreCorto;
    private int idInscripcion;

    public MInscripciones(){

    }

    public MInscripciones(int idGrupo, int idEstudiante, int op, String nombre, String nombreDoc, String app, String apm, String nombreCorto, int idInscripcion) {
        this.idGrupo = idGrupo;
        this.idEstudiante = idEstudiante;
        this.op = op;
        this.nombre = nombre;
        this.nombreDoc = nombreDoc;
        this.app = app;
        this.apm = apm;
        this.nombreCorto = nombreCorto;
        this.idInscripcion = idInscripcion;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "MInscripciones{" +
                "idGrupo=" + idGrupo +
                ", idEstudiante=" + idEstudiante +
                ", op=" + op +
                ", nombre='" + nombre + '\'' +
                ", nombreDoc='" + nombreDoc + '\'' +
                ", app='" + app + '\'' +
                ", apm='" + apm + '\'' +
                ", nombreCorto='" + nombreCorto + '\'' +
                ", idInscripcion=" + idInscripcion +
                '}';
    }
}
