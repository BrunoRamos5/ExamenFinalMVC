package ModeloDAO;

import Config.bd.ConectaBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interfaces.CRUDCurso;
import Modelo.Curso;

public class CursoDAO implements CRUDCurso {

    private static final String SQL_SELECT = "SELECT * FROM academico.cursos";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM academico.cursos WHERE idcurso = ?";
    private static final String SQL_INSERT = "INSERT INTO cursos(nombre, horas, creditos, estado) "
                                            + "VALUES ( ? , ? , ? , ? ) ";
    private static final String SQL_UPDATE = "UPDATE cursos "
                                            + "SET nombre= ? , horas= ? , creditos= ? , estado= ? "
                                            + "WHERE idcurso = ?";
    private static final String SQL_DELETE = "DELETE FROM cursos WHERE idcurso = ? ";
    
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Curso e = new Curso();

    @Override
    public List listarcurso() {
        ArrayList<Curso> cursos = new ArrayList<>();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setIdcurso(rs.getInt("idcurso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setHoras(rs.getInt("horas"));
                curso.setCreditos(rs.getInt("creditos"));
                curso.setEstado(rs.getString("estado"));
                cursos.add(curso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursos;
    }

    @Override
    public Curso buscarcurso(int idcurso) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_SELECT_BY_ID);
            pst.setInt(1, idcurso);
            rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdcurso(rs.getInt("idcurso"));
                e.setNombre(rs.getString("nombre"));
                e.setHoras(rs.getInt("horas"));
                e.setCreditos(rs.getInt("creditos"));
                e.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return e;
    }

    @Override
    public boolean agregarcurso(Curso curso) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1, curso.getNombre());
            pst.setInt(2, curso.getHoras());
            pst.setInt(3, curso.getCreditos());
            pst.setString(4, curso.getEstado());
            pst.executeUpdate();
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editarcurso(Curso curso) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, curso.getNombre());
            pst.setInt(2, curso.getHoras());
            pst.setInt(3, curso.getCreditos());
            pst.setString(4, curso.getEstado());
            pst.setInt(5, curso.getIdcurso());
            pst.executeUpdate();
        } catch (Exception e) {
             e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarcurso(int idcurso) {
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, idcurso);
            pst.executeUpdate();
        } catch (Exception e) {
             e.printStackTrace();
        }
        return false;
    }

}
