package dao;

import model.Acorde;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcordeDAO {

    private final String url = "jdbc:mysql://localhost:3306/trocador_acordes";
    private final String usuario = "root";
    private final String senha = "Gabriel9112";

    public List<Acorde> buscarPorTomEModo(String tom, String modo) {
        List<Acorde> lista = new ArrayList<>();
        String sql = "SELECT tom, grau, acorde FROM acordes WHERE tom = ? AND modo = ?";

        try (Connection con = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, tom);
            stmt.setString(2, modo);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Acorde(
                        rs.getString("tom"),
                        rs.getString("grau"),
                        rs.getString("acorde")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
