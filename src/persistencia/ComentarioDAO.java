package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Comentario;

public class ComentarioDAO extends DAO{

    public void guardarComentario(Comentario comentario) throws Exception, SQLException, ClassNotFoundException {
        try {
            if(comentario == null){
                throw new Exception("El comentario no puede ser nulo.");
            }

            String sql = "INSERT INTO comentarios (id_comentario,id_casa,comentario) VALUES ("
                       + comentario.getIdComentario() + " ','"
                       + comentario.getIdCasa() + " ',"
                       + comentario.getComentario() + " ')'";
            
            insertarModificarEliminarDataBase(sql);
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void eliminarComentarioPorId(int id) throws Exception, SQLException, ClassNotFoundException {
        try {
            String sql = "DELETE FROM comentarios WHERE id_comentario = " + id;
            insertarModificarEliminarDataBase(sql);

            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void actualizarComentario(Comentario comentario) throws Exception, SQLException, ClassNotFoundException {
        try {
            if(comentario == null){
                throw new Exception("El comentario no puede ser nulo.");
            }

            String sql = "UPDATE comentarios SET id_comentario = " + comentario.getIdComentario() + " , id_casa = " 
                       + comentario.getIdCasa() + " , comentario =" + comentario.getComentario() + " WHERE id_comentario = " + comentario.getIdComentario();

            insertarModificarEliminarDataBase(sql);
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Comentario buscarComentarioPorId(int id) throws Exception, SQLException, ClassNotFoundException {
        try {
            String sql = "SELECT * FROM comentarios WHERE id_comentario = " + id;
            consultarDataBase(sql);

            Comentario comentario = new Comentario();
            
            while (resultSet.next()) {
                comentario.setIdComentario(resultSet.getInt("id_comentario"));
                comentario.setIdCasa(resultSet.getInt("id_casa"));
                comentario.setComentario(resultSet.getString("comentario"));
            }
            
            desconectarBase();
            return comentario;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public List<Comentario> listarTodosComentarios() throws Exception, SQLException, ClassNotFoundException{
        try {
            String sql = "SELECT * FROM comentarios";
            consultarDataBase(sql);

            List<Comentario> comentarios = new ArrayList<>();

            while(resultSet.next()) {
                Comentario c = new Comentario();

                c.setIdComentario(resultSet.getInt("id_comentario"));
                c.setIdCasa(resultSet.getInt("id_casa"));
                c.setComentario(resultSet.getString("comentario"));


                comentarios.add(c);
            }

            desconectarBase();
            return comentarios;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
