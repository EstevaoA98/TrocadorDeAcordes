package dao;

import model.Acorde;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcordeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/trocador_acordes";
    private static final String USER = "root";
    private static final String PASSWORD = "sua_senha";

    // Método para buscar acordes por tom e modo
    public List<Acorde> buscarPorTomEModo(String tom, String modo) {
        List<Acorde> acordes = new ArrayList<>();
        String sql = "SELECT * FROM acordes WHERE tom = ? AND modo = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tom);
            ps.setString(2, modo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int grau = rs.getInt("grau");
                String acorde = rs.getString("acorde");
                acordes.add(new Acorde(tom, modo, grau, acorde));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return acordes;
    }

    // Método para inserir um acorde
    public void inserirAcorde(Acorde acorde) {
        String sql = "INSERT INTO acordes (tom, modo, grau, acorde) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, acorde.getTom());
            ps.setString(2, acorde.getModo());
            ps.setInt(3, acorde.getGrau());
            ps.setString(4, acorde.getAcorde());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
