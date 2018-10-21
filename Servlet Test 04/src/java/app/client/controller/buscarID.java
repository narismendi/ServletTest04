package app.client.controller;

import app.domain.InscripcionDTO;
import app.logical.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "buscarID", urlPatterns = {"/buscarID"})
public class buscarID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Facade f = new Facade();

        InscripcionDTO dto = f.obtenerID(id);
        // adjunto las colecciones al request
        request.setAttribute("dtoID", dto);

        request.getRequestDispatcher("mostrarID.jsp")
                .forward(request, response);
    }

}
