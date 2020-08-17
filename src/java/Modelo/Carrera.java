package Modelo;

public class Carrera {

    private int idcarrera;
    private String nombre;
    private String estado;

    public Carrera() {
    }

    public Carrera(int idcarrera, String nombre, String estado) {
        this.idcarrera = idcarrera;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
