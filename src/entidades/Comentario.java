package entidades;

public class Comentario {
    private int idComentario;
    private int idCasa;
    private String comentario;

    public Comentario() {
        
    }

    public Comentario(int idComentario, int idCasa, String comentario) {
        this.idComentario = idComentario;
        this.idCasa = idCasa;
        this.comentario = comentario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario [ID: " + idComentario + ", ID Casa: " + idCasa + ", Comentario: " + comentario + "]";
    }

    
}
