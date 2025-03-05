package persistencia;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Estancia;

public class EstanciaDAO extends DAO{

    public void guardarEstancia(Estancia estancia) throws Exception, SQLException, ClassNotFoundException {
        try {
            String sql = "INSERT INTO estancias (id_estancia,id_cliente,id_casa,nombre_huesped,fecha_desde,fecha_hasta) VALUES ("
            + estancia.getIdEstancia() + ", "
            + estancia.getIdCliente() + ", "
            + estancia.getIdCasa() + ", "
            + estancia.getNombreHuesped() + ", "
            + estancia.getFechaDesde() + ", "
            + estancia.getFechaHasta() + ")";

            insertarModificarEliminarDataBase(sql);
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void eliminarEstancia(int idEstancia) throws Exception, SQLException, ClassCastException {
        try {
            String sql = "DELETE FROM estancias WHERE id_estancia = " + idEstancia;
            insertarModificarEliminarDataBase(sql);

            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public List<Estancia> listarTodasLasEstancias() throws Exception, SQLException, ClassNotFoundException{
        try {
            String sql = "SELECT * FROM estancias";
            consultarDataBase(sql);

            List<Estancia> estancias = new ArrayList<>();

            while(resultSet.next()){
                Estancia estancia = new Estancia();

                estancia.setIdEstancia(resultSet.getInt("id_estancia"));
                estancia.setIdCliente(resultSet.getInt("id_cliente"));
                estancia.setIdCasa(resultSet.getInt("id_casa"));
                estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
                estancia.setFechaDesde(resultSet.getDate("fecha_desde"));
                estancia.setFechaHasta(resultSet.getDate("fecha_hasta"));
                
                estancias.add(estancia);
            }

            desconectarBase();
            return estancias;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void actualizarEstancia(int id_estancia, int id_cliente, int id_casa, String nombre_huesped, Date fecha_desde, Date fecha_hasta) throws Exception, SQLException, ClassNotFoundException {
        try {
            String sql = "UPDATE estancias SET id_cliente = " + id_cliente + ", id_casa = " + id_casa + ", nombre_huesped = " + nombre_huesped 
                        + ", fecha_desde = " + fecha_desde + ", fecha_hasta = " + fecha_hasta + " WHERE id_estancia = " + id_estancia;

            insertarModificarEliminarDataBase(sql);
            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Estancia buscarEstanciaPorId(int id) throws Exception, SQLException, ClassNotFoundException {
        try{
            String sql = "SELECT * FROM estancias WHERE id_estancia = " + id;
            consultarDataBase(sql);

            Estancia estancia = null;

            while(resultSet.next()){
                estancia = new Estancia();

                estancia.setIdEstancia(resultSet.getInt("id_estancia"));
                estancia.setIdCliente(resultSet.getInt("id_cliente"));
                estancia.setIdCasa(resultSet.getInt("id_casa"));
                estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
                estancia.setFechaDesde(resultSet.getDate("fecha_desde"));
                estancia.setFechaHasta(resultSet.getDate("fecha_hasta"));
            }

            if(estancia == null){
                throw new Exception("No existe estancia con el ID ingresado.");
            } else{
                desconectarBase();
                return estancia;
            }
        } catch (Exception e){
            desconectarBase();
            throw e;
        }
    }
}