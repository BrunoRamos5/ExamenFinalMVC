package ModeloDAO;

import Config.bd.ConectaBd;
import Modelo.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interfaces.CRUDEstudiante;

public class EstudianteDAO implements CRUDEstudiante {

    private static final String SQL_SELECT = "SELECT * FROM academico.estudiantes";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM academico.estudiantes WHERE idestudiante = ?";
    private static final String SQL_INSERT = "INSERT INTO estudiantes(nombre, apellidos, dni, codigo, estado) "
                                            + "VALUES ( ? , ? , ? , ? , ? ) ";
    private static final String SQL_UPDATE = "UPDATE estudiantes "
                                            + "SET nombre= ? , apellidos= ? , dni= ? , codigo= ? , estado= ? "
                                            + "WHERE idestudiante = ?";
    private static final String SQL_DELETE = "DELETE FROM estudiantes WHERE idestudiante = ? ";
    
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Estudiante e = new Estudiante();

    @Override
    public List listarestudiante() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setIdestudiante(rs.getInt("idestudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setDni(rs.getString("dni"));
                estudiante.setCodigo(rs.getString("codigo"));
                estudiante.setEstado(rs.getString("estado"));
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudiantes;
    }

    @Override
    public Estudiante buscarestudiante(int idestudiante) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_SELECT_BY_ID);
            pst.setInt(1, idestudiante);
            rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdestudiante(rs.getInt("idestudiante"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setDni(rs.getString("dni"));
                e.setCodigo(rs.getString("codigo"));
                e.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return e;
    }

    @Override
    public boolean agregarestudiante(Estudiante estudiante) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1, estudiante.getNombre());
            pst.setString(2, estudiante.getApellidos());
            pst.setString(3, estudiante.getDni());
            pst.setString(4, estudiante.getCodigo());
            pst.setString(5, estudiante.getEstado());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editarestudiante(Estudiante estudiante) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, estudiante.getNombre());
            pst.setString(2, estudiante.getApellidos());
            pst.setString(3, estudiante.getDni());
            pst.setString(4, estudiante.getCodigo());
            pst.setString(5, estudiante.getEstado());
            pst.setInt(6, estudiante.getIdestudiante());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarestudiante(int idestudiante) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, idestudiante);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
