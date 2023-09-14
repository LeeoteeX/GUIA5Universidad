/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia5universidad;
import AccesoADatos.*;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
/**
 *
 * @author Leandro
 */
public class GUIA5Universidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Alumno alumno = new Alumno(37813922, "Juan", "Lopez", LocalDate.of(2000, 05, 07), true);
//        AlumnoData alum = new AlumnoData();
//        Alumno alumno = new Alumno();
//        alumno.setApellido("Garrido");
//        alumno.setDni(23552123);
//        alumno.setNombre("Jose");
//        alumno.setFechaN(LocalDate.of(1990, 10, 05));
//        alumno.setIdAlumno(165);
        // GUARDAR ALUMNO
       // alum.guardarAlumno(alumno);
        
        // BUSCAR ALUMNO
       // System.out.println(alum.buscarAlumno(162));
        
      // System.out.println(alum.buscarAlumnoPorDNI(42903210));
        
       // System.out.println(alum.listarAlumnos());
        // MODIFICAR ALUMNO 
        
       // alum.modificarAlumno(alumno);
       
       // ELIMINAR ALUMNO
       //alum.eliminarAlumno(165);
       
       // GUARDAR MATERIA
//       Materia materia = new Materia("Literatura",3,true);
//       Materia materia2 = new Materia("Taller",1,true);
//       Materia materia3 = new Materia("Fisica",3,true);
//       Materia materia4 = new Materia("Redes",2,true);
//       materia4.setIdMateria(102);
//       MateriaData mat = new MateriaData();
//       mat.guardarMateria(materia);
//       mat.guardarMateria(materia2);
//       mat.guardarMateria(materia3);
//       mat.guardarMateria(materia4);
//       
       // BUSCAR MATERIA
//        System.out.println(mat.buscarMateria(99));

//        // MODIFICAR MATERIA
//        mat.modificarMateria(materia4);
//        
        // LISTAR MATERIAS
//        System.out.println(mat.listarMaterias());
        
        // ELIMINAR MATERIA
//        mat.eliminarMateria(102);
        
        // GUARDAR INSCRIPCION
//        Inscripcion inscripcion = new Inscripcion(2, alumno, materia4);
        InscripcionData inscData = new InscripcionData();
//        inscData.guardarInscripcion(inscripcion);
        List<Inscripcion> lista = inscData.obtenerInscripciones();
        for (Inscripcion inscripcion : lista) {
    System.out.println("ID de Inscripción: " + inscripcion.getIdInscripto());
    System.out.println("ID de Alumno: " + inscripcion.getAlumno().getIdAlumno());
    System.out.println("ID de Materia: " + inscripcion.getMateria().getIdMateria());
    System.out.println("Nota: " + inscripcion.getNota());
    System.out.println("------------"); // Separador entre inscripciones
    }
    }
}
