/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.bd.ConectaBd;
import Interfaces.CRUDMatricula;
import Modelo.Estudiante;
import Modelo.Matricula;
import Modelo.Matricula1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sis
 */
public class MatriculaDAO implements CRUDMatricula {

    private static final String SQL_SELECT_1 = "SELECT est.nombre as estudiante , mat.idmatricula , mat.semestre , mat.ciclo , mat.estado  , cur.nombre as curso , car.nombre as carrera \n"
            + "FROM matriculas as mat , estudiantes as est , cursos as cur , carreras as car "
            + "where mat.idestudiante = est.idestudiante and mat.idcurso = cur.idcurso "
            + "and mat.idcarrera = car.idcarrera "
            + "order by est.nombre asc";
    private static final String SQL_SELECT = "SELECT * FROM academico.matriculas";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM academico.matriculas WHERE idmatricula = ?";
    private static final String SQL_INSERT = "INSERT INTO matriculas(semestre, ciclo, estado, idcurso, idestudiante , idcarrera) "
            + "VALUES ( ? , ? , ? , ? , ? ,? ) ";
    private static final String SQL_UPDATE = "UPDATE matriculas "
            + "SET semestre= ? , ciclo= ? , estado= ? , idcurso= ? , idestudiante= ? , idcarrera= ?"
            + "WHERE idmatricula = ?";
    private static final String SQL_DELETE = "DELETE FROM matriculas WHERE idmatricula = ? ";

    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Matricula e = new Matricula();
    Matricula1 e1 = new Matricula1();

    @Override
    public List listarmatricula() {
        ArrayList<Matricula> matriculas = new ArrayList<>();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                Matricula matricula = new Matricula();
                matricula.setIdmatricula(rs.getInt("idmatricula"));
                matricula.setSemestre(rs.getString("semestre"));
                matricula.setCiclo(rs.getInt("ciclo"));
                matricula.setEstado(rs.getString("estado"));
                matricula.setIdcurso(rs.getInt("idcurso"));
                matricula.setIdestudiante(rs.getInt("idestudiante"));
                matricula.setIdcarrera(rs.getInt("idcarrera"));
                matriculas.add(matricula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matriculas;
    }

    @Override
    public List listarmatricula1() {
        ArrayList<Matricula1> matriculas1 = new ArrayList<>();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_SELECT_1);
            rs = pst.executeQuery();
            while (rs.next()) {
                Matricula1 matricula1 = new Matricula1();
                matricula1.setEstudiante(rs.getString("estudiante"));
                matricula1.setIdmatricula(rs.getInt("idmatricula"));
                matricula1.setSemestre(rs.getString("semestre"));
                matricula1.setCiclo(rs.getInt("ciclo"));
                matricula1.setEstado(rs.getString("estado"));            
                matricula1.setCurso(rs.getString("curso"));
                matricula1.setCarrera(rs.getString("carrera"));
                matriculas1.add(matricula1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matriculas1;
    }

    @Override
    public Matricula buscarmatricula(int idmatricula) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_SELECT_BY_ID);
            pst.setInt(1, idmatricula);
            rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdmatricula(rs.getInt("idmatricula"));
                e.setSemestre(rs.getString("semestre"));
                e.setCiclo(rs.getInt("ciclo"));
                e.setEstado(rs.getString("estado"));
                e.setIdcurso(rs.getInt("idcurso"));
                e.setIdestudiante(rs.getInt("idestudiante"));
                e.setIdcarrera(rs.getInt("idcarrera"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return e;
    }

    @Override
    public boolean agregarmatricula(Matricula matricula) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1, matricula.getSemestre());
            pst.setInt(2, matricula.getCiclo());
            pst.setString(3, matricula.getEstado());
            pst.setInt(4, matricula.getIdcurso());
            pst.setInt(5, matricula.getIdestudiante());
            pst.setInt(6, matricula.getIdcarrera());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editarmatricula(Matricula matricula) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, matricula.getSemestre());
            pst.setInt(2, matricula.getCiclo());
            pst.setString(3, matricula.getEstado());
            pst.setInt(4, matricula.getIdcurso());
            pst.setInt(5, matricula.getIdestudiante());
            pst.setInt(6, matricula.getIdcarrera());
            pst.setInt(7, matricula.getIdmatricula());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarmatricula(int idmatricula) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, idmatricula);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
