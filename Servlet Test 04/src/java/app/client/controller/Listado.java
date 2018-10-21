package app.client.controller;

import app.domain.InscripcionDTO;
import app.logical.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Listado", urlPatterns = {"/Listado"})
public class Listado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Facade f = new Facade();

        // obtengo las colecciones 
        List<InscripcionDTO> aux = f.obtenerListado();

        // adjunto las colecciones al request
        request.setAttribute("lista", aux);

        // redirecciono el request a la pagina JSP  
        request.getRequestDispatcher("lista.jsp")
                .forward(request, response);
    }

}
