package view;

import dao.AcordeDAO;
import model.Acorde;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainView extends JFrame {

    private JTextField campoTom;
    private JComboBox<String> campoModo;
    private JTextArea resultado;

    public MainView() {
        setTitle("Trocador de Acordes");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painelEntrada = new JPanel(new FlowLayout());

        campoTom = new JTextField(5);
        campoModo = new JComboBox<>(new String[]{"maior", "menor"});
        JButton botaoBuscar = new JButton("Buscar");

        painelEntrada.add(new JLabel("Tom:"));
        painelEntrada.add(campoTom);
        painelEntrada.add(new JLabel("Modo:"));
        painelEntrada.add(campoModo);
        painelEntrada.add(botaoBuscar);

        resultado = new JTextArea();
        resultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultado);

        botaoBuscar.addActionListener((ActionEvent e) -> buscarAcordes());

        add(painelEntrada, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    private void buscarAcordes() {
        String tom = campoTom.getText().trim();
        String modo = (String) campoModo.getSelectedItem();
        resultado.setText("");

        try {
            AcordeDAO dao = new AcordeDAO();
            List<Acorde> acordes = dao.buscarPorTomEModo(tom, modo);

            if (acordes.isEmpty()) {
                resultado.append("Nenhum acorde encontrado para o tom " + tom + " e modo " + modo + ".\n");
            } else {
                resultado.append("Campo harmônico de " + tom + " (" + modo + "):\n");
                for (Acorde a : acordes) {
                    resultado.append(a.getGrau() + " - " + a.getAcorde() + "\n");
                }
            }
        } catch (Exception e) {
            resultado.append("Erro ao buscar acordes: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView tela = new MainView();
            tela.setVisible(true);
        });
    }
}
