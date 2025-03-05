package servicios;

import entidades.Familia;
import persistencia.FamiliaDAO;

public class FamiliaServicio {
    private FamiliaDAO fd;
    
    public FamiliaServicio() {
        this.fd = new FamiliaDAO();
    }

    public Familia crearNuevaFamiia(int idFamilia, String nombre, int edadMinima, int edadMaxima, int numHijos, String email, int idCasaFamilia) throws Exception {
        Familia familia = new Familia(idFamilia,nombre,edadMinima,edadMaxima,numHijos,email,idCasaFamilia);
        fd.guardarFamilia(familia);

        return familia;
    }

    public void listarTodasFamilias() throws Exception {
        fd.listarFamilias();
    }

    public void eliminarFamilias(int id) throws Exception {
        fd.eliminarFamilia(id);
    }
}
