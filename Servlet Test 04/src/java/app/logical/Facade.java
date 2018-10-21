package app.logical;

import app.domain.CursoDAO;
import java.util.List;

import app.domain.CursoDTO;
import app.domain.FormaPagoDAO;
import app.domain.FormaPagoDTO;
import app.domain.InscripcionDAO;
import app.domain.InscripcionDTO;

public class Facade {

    public int registrarInscripcion(InscripcionDTO dto) {
        InscripcionDAO dao = new InscripcionDAO();
        return dao.insertar(dto);
    }

    public List<CursoDTO> obtenerCursos() {
        CursoDAO dao = new CursoDAO();
        return dao.getCursos();
    }

    public List<FormaPagoDTO> obtenerFormasPago() {
        FormaPagoDAO dao = new FormaPagoDAO();
        return dao.getFormasPago();
    }

    //public List<InscripcionDTO> obtenerListado() {
    public List<InscripcionDTO> obtenerListado() {
        InscripcionDAO dao = new InscripcionDAO();
       
        return dao.leerLista();
        //return dao.getFormasPago();
    }
    
    public InscripcionDTO obtenerID(int x) {
        InscripcionDAO dao = new InscripcionDAO();     
        
        return dao.mostrarID(x);
    }
}
