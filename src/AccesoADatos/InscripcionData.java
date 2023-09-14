/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;
import Entidades.Alumno;
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
        // REVISAR EL SQL
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion agregada con exito!");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Conexion. GUARDAR INSCRIPCION" + ex.getMessage());
        }
    }

    public List<Inscripcion> obtenerInscripciones() {

        String sql = "SELECT * FROM inscripcion";
        List<Inscripcion> listaInsc = new ArrayList<>();
        AlumnoData alum= new AlumnoData();
        MateriaData mat = new MateriaData();
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            int idAlumno, idMateria;
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                Alumno alumno = new Alumno();
                Materia materia = new Materia();
                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
                idAlumno=(rs.getInt("idAlumno"));
                idMateria=(rs.getInt("idMateria"));
                inscripcion.setNota(rs.getDouble("nota"));
                alumno = alum.buscarAlumno(idAlumno);
                materia = mat.buscarMateria(idMateria);
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                listaInsc.add(inscripcion);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Conexion, OBTENER INSCRIPCIONES" + ex.getMessage());
        }
        return listaInsc;
    }

//    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
//
//        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
//        List<Inscripcion> listaInsc = new ArrayList<>();
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Inscripcion inscripcion = new Inscripcion();
//                inscripcion.setIdAlumno(rs.getInt("idAlumno"));
//                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
//                inscripcion.setIdMaterial(rs.getInt("idMateria"));
//                listaInsc.add(inscripcion);
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error de Conexion, OBTENER INSCRIPCIONES POR ALUMNO" + ex.getMessage());
//        }
//        return listaInsc;
//    }

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
    
    // HACER EL METODO OBTENER MATERIAS NO CURSADAS !!!
    
}
