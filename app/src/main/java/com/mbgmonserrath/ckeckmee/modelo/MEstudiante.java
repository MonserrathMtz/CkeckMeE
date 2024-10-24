package com.mbgmonserrath.ckeckmee.modelo;

import java.io.Serializable;

public class MEstudiante implements Serializable {
    private int idEstudiante;
    private int matricula;
    private String nombre;
    private String app;
    private String apm;
    private String correo;
    private String edo;
    private String muni;
    private String col;
    private int gen;
    private String contrasenia;
    private int idCarrera;


    public MEstudiante() {
    }

    public MEstudiante(int idEstudiante, int matricula, String nombre, String app, String apm, String correo, String edo, String muni, String col, int gen, String contrasenia, int idCarrera) {
        this.idEstudiante = idEstudiante;
        this.matricula = matricula;
        this.nombre = nombre;
        this.app = app;
        this.apm = apm;
        this.correo = correo;
        this.edo = edo;
        this.muni = muni;
        this.col = col;
        this.gen = gen;
        this.contrasenia = contrasenia;
        this.idCarrera = idCarrera;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEdo() {
        return edo;
    }

    public void setEdo(String edo) {
        this.edo = edo;
    }

    public String getMuni() {
        return muni;
    }

    public void setMuni(String muni) {
        this.muni = muni;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public String toString() {
        return "MEstudiante{" +
                "idEstudiante=" + idEstudiante +
                ", matricula=" + matricula +
                ", nombre='" + nombre + '\'' +
                ", app='" + app + '\'' +
                ", apm='" + apm + '\'' +
                ", correo='" + correo + '\'' +
                ", edo='" + edo + '\'' +
                ", muni='" + muni + '\'' +
                ", col='" + col + '\'' +
                ", gen=" + gen +
                ", contrasenia='" + contrasenia + '\'' +
                ", idCarrera=" + idCarrera +
                '}';
    }
}
