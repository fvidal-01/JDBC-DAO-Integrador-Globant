package persistencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Casa;

public class CasaDAO extends DAO{
    
    public void guardarCasa(Casa casa) throws Exception, SQLException, ClassNotFoundException{
        try {
            if(casa == null){
                throw new Exception("La casa no puede ser nula.");
            }
    
            String sql = "INSERT INTO casas(id_casa,calle,numero,codigo_postal,ciudad,pais,fecha_desde,fecha_hasta," +
                         "tiempo_minimo,tiempo_maximo,precio_habitacion,tipo_vivienda) VALUES " + 
    
                         casa.getIdCasa() + " ','"
                         + casa.getCalle() + "', '"
                         + casa.getNumero() + "', '"
                         + casa.getCodigoPostal() + "', '"
                         + casa.getCiudad() + "', '"
                         + casa.getPais() + "', '"
                         + casa.getFechaDesde() + "', '"
                         + casa.getFechaHasta() + "', '"
                         + casa.getTiempoMinimo() + "', '"
                         + casa.getTiempoMaximo() + "', '"
                         + casa.getPrecioHabitacion() + "', '"
                         + casa.getTipoVivienda() + "'"
                         + ");";
    
            insertarModificarEliminarDataBase(sql);
            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void eliminarCasaPorCodigo(int id) throws Exception, SQLException, ClassNotFoundException{
        try {
            if(id <= 0){
                throw new Exception("Ingrese un id válido.");
            }

            String sql = "DELETE FROM casas WHERE id_casa = " + id + ";";
            insertarModificarEliminarDataBase(sql);

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public List<Casa> listarTodasCasas() throws Exception, SQLException, ClassNotFoundException {
        try {
            String sql = "SELECT * FROM casas;";
            consultarDataBase(sql);

            List<Casa> casas = new ArrayList<>();

            while(resultSet.next()){
                Casa casa = new Casa();

                casa.setIdCasa(resultSet.getInt("id_casa"));
                casa.setCalle(resultSet.getString("calle"));
                casa.setNumero(resultSet.getInt("numero"));
                casa.setCodigoPostal(resultSet.getString("codigo_postal"));
                casa.setCiudad(resultSet.getString("ciudad"));
                casa.setPais(resultSet.getString("pais"));
                casa.setFechaDesde(resultSet.getDate("fecha_desde"));
                casa.setFechaHasta(resultSet.getDate("fecha_hasta"));
                casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
                casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
                casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
                casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));
                
                casas.add(casa);
            }

            desconectarBase();
            return casas;


        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void actualizarCasa(Casa casa) throws Exception, SQLException, ClassNotFoundException{
        try {
            if(casa == null){
                throw new Exception("La casa no puede ser nula.");
            }

            String sql = "UPDATE casas SET calle = " + casa.getCalle() + ", numero = " + casa.getNumero() + ", codigo_postal = " + casa.getCodigoPostal()
                         + ", ciudad = " + casa.getCiudad() + ", pais = " + casa.getPais() + ", fecha_desde = " + casa.getFechaDesde() + ", fecha_hasta = " + casa.getFechaHasta()
                         + ", tiempo_minimo = " + casa.getTiempoMinimo() + ", tiempo_maximo = " + casa.getTiempoMaximo() + " , precio_habitacion = " + casa.getPrecioHabitacion()
                         + ", tipo_vivienda = " + casa.getTipoVivienda() + " WHERE id_casa = " + casa.getIdCasa() + ";";

            insertarModificarEliminarDataBase(sql);
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Casa buscarCasaPorId(int id) throws Exception, SQLException, ClassNotFoundException{
        try {
            if(id <= 0){
                throw new Exception("Ingrese un id válido.");
            }

            String sql = "SELECT * FROM casas WHERE id_casa = " + id + ";";
            consultarDataBase(sql);

            Casa c = new Casa();
            
            while(resultSet.next()){
                c.setIdCasa(resultSet.getInt("id_casa"));
                c.setCalle(resultSet.getString("calle"));
                c.setNumero(resultSet.getInt("numero"));
                c.setCodigoPostal(resultSet.getString("codigo_postal"));
                c.setCiudad(resultSet.getString("ciudad"));
                c.setPais(resultSet.getString("pais"));
                c.setFechaDesde(resultSet.getDate("fecha_desde"));
                c.setFechaHasta(resultSet.getDate("fecha_hasta"));
                c.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
                c.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
                c.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
                c.setTipoVivienda(resultSet.getString("tipo_vivienda"));
            }

            desconectarBase();
            return c;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
