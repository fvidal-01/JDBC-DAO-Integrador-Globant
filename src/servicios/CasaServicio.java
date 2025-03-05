package servicios;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import entidades.Casa;
import persistencia.CasaDAO;

public class CasaServicio {
    private CasaDAO cd;

    public CasaServicio() {
        this.cd = new CasaDAO();
    }

    public void crearCasa(int idCasa, String calle, int numero, String codigoPostal, String ciudad, String pais, Date fechaDesde,
            Date fechaHasta, int tiempoMinimo, int tiempoMaximo, double precioHabitacion, String tipoVivienda) throws Exception{
                
        Casa c = new Casa(idCasa,calle,numero,codigoPostal,ciudad,pais,fechaDesde,fechaHasta,tiempoMinimo,tiempoMaximo,precioHabitacion,tipoVivienda);
        cd.guardarCasa(c);
    }

    public void actualizarCasa(int idCasa, String calle, int numero, String codigoPostal, String ciudad, String pais, Date fechaDesde,
            Date fechaHasta, int tiempoMinimo, int tiempoMaximo, double precioHabitacion, String tipoVivienda) throws Exception{
                
        Casa c = new Casa(idCasa,calle,numero,codigoPostal,ciudad,pais,fechaDesde,fechaHasta,tiempoMinimo,tiempoMaximo,precioHabitacion,tipoVivienda);
        cd.actualizarCasa(c);
    }

    public List<Casa> listarCasas() throws Exception, SQLException, ClassNotFoundException {
        return cd.listarTodasCasas();
    }

    public Casa buscarCasaPorId(int id) throws Exception, SQLException, ClassNotFoundException {
        return cd.buscarCasaPorId(id);
    }

    public void eliminarCasaPorId(int id) throws Exception, SQLException, ClassNotFoundException {
        cd.eliminarCasaPorCodigo(id);
    }
}