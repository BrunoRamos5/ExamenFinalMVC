/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Matricula;
import java.util.List;

public interface CRUDMatricula {

    public List listarmatricula(); // listar
    public List listarmatricula1(); // listar1
    public Matricula buscarmatricula(int idmatricula); // buscar
    public boolean agregarmatricula(Matricula matricula); // agregar
    public boolean editarmatricula(Matricula matricula); // editar
    public boolean eliminarmatricula(int idmatricula); // eliminar
}
