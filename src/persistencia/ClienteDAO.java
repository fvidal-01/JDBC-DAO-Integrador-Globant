package persistencia;

import entidades.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO{
    public void guardarCliente(Cliente cliente) throws Exception, SQLException, ClassNotFoundException {
        try {
            if(cliente == null){
                throw new Exception("Cliente no puede ser nulo.");
            }

            String sql = "INSERT INTO cliente (id_cliente,nombre,calle,numero,codigo_postal,ciudad,pais,email) VALUES (" +
                         cliente.getIdCliente() + "', "
                         + cliente.getNombre() + "', "
                         + "'" + cliente.getCalle() + "', "
                         + cliente.getNumero() + ", "
                         + cliente.getCodigoPostal() + ", "
                         + "'" + cliente.getPais() + "', "
                         + "'" + cliente.getEmail() + "')";

            insertarModificarEliminarDataBase(sql);
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    } 

    public void eliminarClientePorId(int id) throws Exception, SQLException, ClassCastException {
        try {
            String sql = "DELETE FROM cliente WHERE id_cliente = " + id;
            insertarModificarEliminarDataBase(sql);

            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public List<Cliente> listarTodosLosClientes() throws Exception, SQLException, ClassCastException {
        try {
            String sql = "SELECT * FROM cliente";
            consultarDataBase(sql);

            List<Cliente> clientes = new ArrayList<>();

            while (resultSet.next()) {
                Cliente c = new Cliente();

                c.setIdCliente(resultSet.getInt("id_cliente"));
                c.setNombre(resultSet.getString("nombre"));
                c.setCalle(resultSet.getString("calle"));                
                c.setNumero(resultSet.getInt("numero"));
                c.setCodigoPostal(resultSet.getString("codigo_postal"));
                c.setCiudad(resultSet.getString("ciudad"));
                c.setPais(resultSet.getString("pais"));
                c.setEmail(resultSet.getString("email"));                
            
                clientes.add(c);   
            }

            desconectarBase();
            return clientes;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void actualizarCliente(Cliente cliente) throws Exception, SQLException, ClassNotFoundException {
        try {
            String sql = "UPDATE SET('"
                         + cliente.getNombre() + "', "
                         + "'" + cliente.getCalle() + "', "
                         + cliente.getNumero() + ", "
                         + cliente.getCodigoPostal() + ", "
                         + "'" + cliente.getPais() + "', "
                         + "'" + cliente.getEmail() + "'"
                         + ") WHERE id_cliente = " + cliente.getIdCliente();

            insertarModificarEliminarDataBase(sql);
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Cliente buscarClientePorId(int id) throws Exception, SQLException, ClassNotFoundException {
        try {
            String sql = "SELECT * FROM cliente WHERE id_cliente = " + id;
            consultarDataBase(sql);

            Cliente c = new Cliente();
            c.setIdCliente(resultSet.getInt("id_cliente"));
            c.setNombre(resultSet.getString("nombre"));
            c.setCalle(resultSet.getString("calle"));                
            c.setNumero(resultSet.getInt("numero"));
            c.setCodigoPostal(resultSet.getString("codigo_postal"));
            c.setCiudad(resultSet.getString("ciudad"));
            c.setPais(resultSet.getString("pais"));
            c.setEmail(resultSet.getString("email")); 

            desconectarBase();
            return c;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
