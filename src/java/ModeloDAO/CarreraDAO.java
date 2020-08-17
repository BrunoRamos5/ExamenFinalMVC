package ModeloDAO;

import Config.bd.ConectaBd;
import Modelo.Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interfaces.CRUDCarrera;

public class CarreraDAO implements CRUDCarrera{
    
     private static final String SQL_SELECT = "SELECT * FROM academico.carreras";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM academico.carreras WHERE idcarrera = ?";
    private static final String SQL_INSERT = "INSERT INTO carreras(nombre,estado) VALUES ( ? , ? ) ";                                           
    private static final String SQL_UPDATE = "UPDATE carreras SET nombre= ? , estado= ? WHERE idcarrera = ? ";
    private static final String SQL_DELETE = "DELETE FROM carreras WHERE idcarrera = ? ";
    
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Carrera e = new Carrera();

    @Override
    public List listarcarrera() {
        ArrayList<Carrera> carreras = new ArrayList<>();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                Carrera carrera = new Carrera();
                carrera.setIdcarrera(rs.getInt("idcarrera"));
                carrera.setNombre(rs.getString("nombre"));
                carrera.setEstado(rs.getString("estado"));
                carreras.add(carrera);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carreras;
    }

    @Override
    public Carrera buscarcarrera(int idcarrera) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_SELECT_BY_ID);
            pst.setInt(1, idcarrera);
            rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdcarrera(rs.getInt("idcarrera"));
                e.setNombre(rs.getString("nombre"));
                e.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return e;
    }

    @Override
    public boolean agregarcarrera(Carrera carrera) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1, carrera.getNombre());
            pst.setString(2, carrera.getEstado());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editarcarrera(Carrera carrera) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, carrera.getNombre());
            pst.setString(2, carrera.getEstado());
            pst.setInt(3, carrera.getIdcarrera());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarcarrera(int idcarrera) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, idcarrera);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

   } 