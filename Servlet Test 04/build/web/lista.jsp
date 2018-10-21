<%@page import="java.util.List"%>
<%@page import="app.domain.InscripcionDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<InscripcionDTO> aux1 = (List) request.getAttribute("lista");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Inscripciones</title>
    </head>
    <body>
        <h1>Listado de inscripciones</h1>

        <table id="tabla">
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>TELEFONO</th>
                <th>CURSO</th>
                <th>FORMA PAGO</th>
            </tr>

            <% for (InscripcionDTO dto : aux1) {%>
            <tr>
                <td><%=dto.getIdCurso()%></td>
                <td><%=dto.getNombre()%></td>
                <td><%=dto.getTelefono()%></td>
                <td><%=dto.getIdCurso()%></td>
                <td><%=dto.getIdFormaPago()%></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
