package app.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.util.UConnection;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAO {

    public int insertar(InscripcionDTO dto) {
        // el query para obtener la secuencia
        String s1 = "";
        s1 += "SELECT MAX(id_inscripcion)+1 ";
        s1 += "FROM inscripcion ";

        // ahora el insert
        String s2 = "";
        s2 += "INSERT INTO inscripcion(";
        s2 += "             id_inscripcion";
        s2 += "            ,nombre";
        s2 += "            ,telefono";
        s2 += "            ,id_curso";
        s2 += "           ,id_forma_pago) ";
        s2 += "VALUES (?,?,?,?,?) ";

        try (Connection con = UConnection.getConnection(); PreparedStatement ps1 = con.prepareStatement(s1); PreparedStatement ps2 = con.prepareStatement(s2); ResultSet rs = ps1.executeQuery()) {
            if (rs.next()) {
                ResultSet rs1 = ps1.executeQuery();
                rs1.next();
                int max = rs1.getInt(1);

                ps2.setInt(1, max);
                ps2.setString(2, dto.getNombre());
                ps2.setString(3, dto.getTelefono());
                ps2.setInt(4, dto.getIdCurso());
                ps2.setInt(5, dto.getIdFormaPago());

                if (ps2.executeUpdate() != 1) {
                    throw new RuntimeException("Error...");
                }

                return max;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        throw new RuntimeException();
    }

    public List<InscripcionDTO> leerLista() {
        // el query para obtener la secuencia
        String s1 = "";
        s1 += "SELECT * ";
        s1 += "FROM inscripcion ";

        try (
                Connection con = UConnection.getConnection();
                PreparedStatement ps1 = con.prepareStatement(s1);
                ResultSet rs = ps1.executeQuery()) {
            List<InscripcionDTO> ls = new ArrayList<>();
            while (rs.next()) {
                InscripcionDTO dto = new InscripcionDTO();
                dto.setIdCurso(rs.getInt(1));
                dto.setNombre(rs.getString(2));
                dto.setTelefono(rs.getString(3));
                dto.setIdCurso(rs.getInt(4));
                dto.setIdFormaPago(rs.getInt(5));
                ls.add(dto);
            }
            return ls;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

    }
     public InscripcionDTO mostrarID(int x) {
        // el query para obtener la secuencia
        String s1 = "";
        s1 += "SELECT * ";
        s1 += "FROM inscripcion ";
        s1 += "where id_inscripcion = " + x;

        try (
                Connection con = UConnection.getConnection();
                PreparedStatement ps1 = con.prepareStatement(s1);
                ResultSet rs = ps1.executeQuery()) {
            
            if (rs.next()) {
                InscripcionDTO dto = new InscripcionDTO();
                dto.setIdInsc(rs.getInt(1));
                dto.setNombre(rs.getString(2));
                dto.setTelefono(rs.getString(3));
                dto.setIdCurso(rs.getInt(4));
                dto.setIdFormaPago(rs.getInt(5));
                return dto;
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return null;

    }
}
