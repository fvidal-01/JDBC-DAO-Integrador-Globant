package servicios;

import java.util.List;

import entidades.Cliente;
import persistencia.ClienteDAO;

public class ClienteServicio {
    private ClienteDAO cd;

    public ClienteServicio() {
        this.cd = new ClienteDAO();
    }

    public void guardarCliente(int idCliente, String nombre, String calle, int numero, String codigoPostal, String ciudad,String pais, String email) throws Exception{
        Cliente cliente = new Cliente(idCliente,nombre,calle,numero,codigoPostal,ciudad,pais,email);
        cd.guardarCliente(cliente);
    }

    public void eliminarClientePorId(int id)  throws Exception{
        cd.eliminarClientePorId(id);
    }

    public List<Cliente> listarTodosLosClientes()  throws Exception{
        return cd.listarTodosLosClientes();
    }

    public void actualizarCliente(int idCliente, String nombre, String calle, int numero, String codigoPostal, String ciudad,String pais, String email) throws Exception {
        Cliente cliente = new Cliente(idCliente, nombre, calle, numero, codigoPostal, ciudad, pais, email);
        cd.actualizarCliente(cliente);
    }

    public Cliente buscarClientePorId(int id) throws Exception {
        return cd.buscarClientePorId(id);
    }
}
