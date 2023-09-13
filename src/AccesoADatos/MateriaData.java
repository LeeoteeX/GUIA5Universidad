/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class MateriaData {

    private Connection con = null;

    public MateriaData() {
        con = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {

        String sql = "INSERT INTO materia (nombre, año, estado) " + "VALUES (?, ?, ?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAno());
            ps.setBoolean(3, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Materia buscarMateria(int id) {
        Materia materia = null;
        String sql = "SELECT nombre, año FROM materia WHERE idMateria = ? AND estado =1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAno(rs.getInt("año"));
                materia.setEstado(true);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Materia no encontrada");
        }
        return materia;
    }

    public void modificarMateria(Materia materia) {

        String sql = "UPDATE materia SET nombre=?, año=?, estado=? WHERE idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAno());
            ps.setBoolean(3, true);
            ps.setInt(4, materia.getIdMateria());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia modificada");

            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La materia no existe" + ex.getMessage());
        }
    }
    
    public ArrayList<Materia> listarMaterias() {
        ArrayList < Materia > materias = new ArrayList<> ();
        String sql = "SELECT * FROM materia WHERE estado = 1";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Materia materia = new Materia();
                materia.setAno(rs.getInt("año"));
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setEstado(true);
                materias.add(materia);
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return materias;
    }
    
    public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int correcto= ps.executeUpdate();
            if (correcto == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
