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
public class Matricula1 {
    private int idmatricula ;
    private String semestre;
    private int ciclo;
    private String estado;
    private String estudiante;
    private String curso;
    private String carrera;

    public Matricula1() {
    }

    public Matricula1(int idmatricula, String semestre, int ciclo, String estado, String curso, String estudiante, String carrera) {
        this.idmatricula = idmatricula;
        this.semestre = semestre;
        this.ciclo = ciclo;
        this.estado = estado;
        this.curso = curso;
        this.estudiante = estudiante;
        this.carrera = carrera;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
    
}
