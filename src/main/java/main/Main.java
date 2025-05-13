package main;

import dao.AcordeDAO;
import model.Acorde;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o tom da música (ex: C, D, E, F#): ");
        String tom = sc.nextLine().trim();

        AcordeDAO dao = new AcordeDAO();
        List<Acorde> acordes = dao.buscarPorTom(tom);

        if (acordes.isEmpty()) {
            System.out.println("Nenhum acorde encontrado para o tom " + tom);
        } else {
            System.out.println("Acordes do campo harmônico maior de " + tom + ":");
            for (Acorde a : acordes) {
                System.out.println(a.getGrau() + " - " + a.getAcorde());
            }
        }
    }
}