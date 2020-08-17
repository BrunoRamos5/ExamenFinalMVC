/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author sis
 */
public class Matricula {
    private int idmatricula ;
    private String semestre;
    private int ciclo;
    private String estado;
    private int idcurso;
    private int idestudiante;
    private int idcarrera;

    public Matricula() {
    }

    public Matricula(int idmatricula, String semestre, int ciclo, String estado, int idcurso, int idestudiante, int idcarrera) {
        this.idmatricula = idmatricula;
        this.semestre = semestre;
        this.ciclo = ciclo;
        this.estado = estado;
        this.idcurso = idcurso;
        this.idestudiante = idestudiante;
        this.idcarrera = idcarrera;
    }

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }
    
}
