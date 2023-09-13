
package Entidades;

public class Inscripcion {

    private int idInscripto;
    private double nota;
    private int idAlumno;
    private int idMateria;

    public Inscripcion() {
    }

    public Inscripcion(double nota, int idAlumno, int idMaterial) {
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idMateria = idMaterial;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdMaterial() {
        return idMateria;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMateria = idMaterial;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripto=" + idInscripto + ", nota=" + nota + ", idAlumno=" + idAlumno + ", idMateria=" + idMateria + '}';
    }

}
