package servicios;

import java.util.List;

import entidades.Comentario;
import persistencia.ComentarioDAO;

public class ComentarioServicio {
    private ComentarioDAO cd;
    
    public ComentarioServicio() {
        this.cd = new ComentarioDAO();
    }

    public void guardarComentario(int idComentario, int idCasa, String comentario) throws Exception {
        Comentario c = new Comentario(idComentario, idCasa, comentario);
        cd.guardarComentario(c);
    }

    public void eliminarComentarioPorId(int id) throws Exception {
        cd.eliminarComentarioPorId(id);
    }

    public void actualizarComentario(int idComentario, int idCasa, String comentario) throws Exception {
        Comentario coment = new Comentario(idComentario, idCasa, comentario);
        cd.actualizarComentario(coment);
    }

    public Comentario buscarComentarioPorId(int id) throws Exception {
        return cd.buscarComentarioPorId(id);
    }

    public List<Comentario> listarTodosComentarios() throws Exception {
        return cd.listarTodosComentarios();
    }
}
