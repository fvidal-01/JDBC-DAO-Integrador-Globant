package servicios;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import entidades.Estancia;
import persistencia.EstanciaDAO;

public class EstanciaServicio {
    private EstanciaDAO ed;

    public EstanciaServicio() {
        this.ed = new EstanciaDAO();
    }

    public void crearEstancia(int idEstancia, int idCliente, int idCasa, String nombreHuesped, Date fechaDesde, Date fechaHasta) throws Exception, SQLException, ClassNotFoundException{
        Estancia estancia = new Estancia(idEstancia,idCliente,idCasa,nombreHuesped,fechaDesde,fechaHasta);
        ed.guardarEstancia(estancia);
    }

    public void eliminarEstancia(int id) throws Exception, SQLException, ClassNotFoundException{
        ed.eliminarEstancia(id);
    }

    public List<Estancia> listarTodasLasEstancias() throws Exception, SQLException, ClassNotFoundException{
        return ed.listarTodasLasEstancias();
    }

    public void actualizarEstancia(int id_estancia, int id_cliente, int id_casa, String nombre_huesped, Date fecha_desde, Date fecha_hasta) throws Exception, SQLException, ClassNotFoundException{
        ed.actualizarEstancia(id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta);
    }

    public Estancia buscarEstanciaPorId(int id) throws Exception, SQLException, ClassNotFoundException {
        return ed.buscarEstanciaPorId(id);
    }
}
