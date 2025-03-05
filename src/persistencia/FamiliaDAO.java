package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Familia;

public class FamiliaDAO extends DAO{
    
    public void guardarFamilia(Familia familia) throws Exception, SQLException, ClassNotFoundException {
        try {
            if(familia == null) {
                throw new Exception("La familia no puede ser nula.");
            }

            String sql = "INSERT INTO familias (id_familia,nombre,edad_minima,edad_maxima,num_hijos,email,id_casa_familia) VALUES ("
                    + familia.getIdFamilia() + ", "
                    + familia.getNombre() + ", "
                    + familia.getEdadMinima() + ", "
                    + familia.getEdadMaxima() + ", "
                    + familia.getNumHijos() + ", "
                    + familia.getEmail() + ", "
                    + familia.getIdCasaFamilia() + ")";

            insertarModificarEliminarDataBase(sql);
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void eliminarFamilia(int id) throws Exception, SQLException, ClassCastException {
        try {
            String sql = "DELETE FROM familias WHERE id_familia = " + id;
            insertarModificarEliminarDataBase(sql);

            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public List<Familia> listarFamilias() throws Exception, SQLException, ClassNotFoundException{
        try {
            String sql = "SELECT * FROM familias";
            consultarDataBase(sql);

            List<Familia> familias = new ArrayList<>();

            while(resultSet.next()){
                Familia familia = new Familia();

                familia.setIdFamilia(resultSet.getInt("id_familia"));
                familia.setNombre(resultSet.getString("nombre"));
                familia.setEdadMinima(resultSet.getInt("edad_minima"));
                familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
                familia.setNumHijos(resultSet.getInt("num_hijos"));
                familia.setEmail(resultSet.getString("email"));
                familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));

                familias.add(familia);
            }

            desconectarBase();
            return familias;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void actualizarFamilia(Familia familia) throws Exception, SQLException, ClassNotFoundException {
        try {
            if(familia == null){
                throw new Exception("La familia no puede ser nulo.");
            }

            String sql = "UPDATE familias SET id_familia = " + familia.getIdFamilia() + ", nombre = " + familia.getNombre() + ", edad_minima = " + familia.getEdadMinima()
                       + ", edad_maxima = " + familia.getEdadMaxima() + ",  num_hijos = " + familia.getNumHijos() + ",  email = " + familia.getEmail() + ", id_casa_familia = " + familia.getIdCasaFamilia();
            
            insertarModificarEliminarDataBase(sql);
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Familia buscarFamiliaPorId(int id) throws Exception, SQLException, ClassNotFoundException {
        try {
            String sql = "SELECT * FROM familias WHERE id_familia = " + id;
            consultarDataBase(sql);

            Familia familia = new Familia();

            familia.setIdFamilia(resultSet.getInt("id_familia"));
            familia.setNombre(resultSet.getString("nombre"));
            familia.setEdadMinima(resultSet.getInt("edad_minima"));
            familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
            familia.setNumHijos(resultSet.getInt("num_hijos"));
            familia.setEmail(resultSet.getString("email"));
            familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));

            desconectarBase();
            return familia;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
