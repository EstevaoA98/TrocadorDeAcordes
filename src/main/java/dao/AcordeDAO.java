package dao;

import model.Acorde;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcordeDAO {
    public List<Acorde> buscarPorTom(String tom) {
        List<Acorde> acordes = new ArrayList<>();

        String sql = "SELECT * FROM acordes WHERE tom = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tom);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String grau = rs.getString("grau");
                String acorde = rs.getString("acorde");
                acordes.add(new Acorde(tom, grau, acorde));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar acordes: " + e.getMessage());
        }

        return acordes;
    }
}