<%@page import="app.domain.InscripcionDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    InscripcionDTO aux1 = (InscripcionDTO) request.getAttribute("dtoID");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle ID</title>
    </head>
    <body>
        <div>
            <form action="buscarID" method="GET" >
                ID <input type="text" name="id">
                <input type="submit" value="Buscar">
            </form>
        </div>
        <br>
        ID            : <%=aux1.getIdInsc()%> <br>
        Nombre        : <%=aux1.getNombre()%> <br>
        Telefono      : <%=aux1.getTelefono()%> <br> 
        Curso         : <%=aux1.getIdCurso()%> <br>
        Forma de pago : <%=aux1.getIdFormaPago()%>

    </body>
</html>
