/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Curso;
import java.util.List;

public interface CRUDCurso {
    public List listarcurso(); // listar
    public Curso buscarcurso(int idcurso); // buscar
    public boolean agregarcurso(Curso curso); // agregar
    public boolean editarcurso(Curso curso); // editar
    public boolean eliminarcurso(int idcurso); // eliminar
}
