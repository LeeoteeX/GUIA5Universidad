/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;
import Entidades.Materia;
import Entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author Leandro
 */
public class InscripcionData {

    Connection conn = null;
    MateriaData matData;
    AlumnoData aluData;

    public InscripcionData() {

        conn = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion insc) {

        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getIdAlumno());
            ps.setInt(3, insc.getIdMaterial());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Conexion. GUARDAR INSCRIPCION" + ex.getMessage());
        }
    }

    public List<Inscripcion> obtenerInscripciones() {

        String sql = "SELECT * FROM inscripcion";
        List<Inscripcion> listaInsc = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdAlumno(rs.getInt("idAlumno"));
                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
                inscripcion.setIdMaterial(rs.getInt("idMateria"));
                listaInsc.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Conexion, OBTENER INSCRIPCIONES" + ex.getMessage());
        }
        return listaInsc;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {

        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
        List<Inscripcion> listaInsc = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdAlumno(rs.getInt("idAlumno"));
                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
                inscripcion.setIdMaterial(rs.getInt("idMateria"));
                listaInsc.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Conexion, OBTENER INSCRIPCIONES POR ALUMNO" + ex.getMessage());
        }
        return listaInsc;
    }

    public List <Materia > obtenerMateriasCursadas(int id) {
        
        String sql = "SELECT idMateria FROM inscripcion WHERE idAlumno = ? ";
        List <Materia> listMat = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Materia materia = new Materia();
                materia.setAno(rs.getInt("año"));
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setEstado(true);
                listMat.add(materia);
            }
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMat;
    }
    
    
    
}
