package main;

import dao.AcordeDAO;
import model.Acorde;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AcordeDAO dao = new AcordeDAO();

        while (true) {
            System.out.print("Digite o tom da música (ex: C, D, E, F#) ou 'sair' para encerrar: ");
            String tom = sc.nextLine().trim();

            if (tom.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o modo (maior/menor): ");
            String modo = sc.nextLine().trim();

            List<Acorde> acordes = dao.buscarPorTomEModo(tom, modo);

            if (acordes.isEmpty()) {
                System.out.println("Nenhum acorde encontrado para o tom " + tom + " e modo " + modo);
            } else {
                System.out.println("Acordes do campo harmônico " + modo + " de " + tom + ":");
                for (Acorde acorde : acordes) {
                    System.out.println(acorde);
                }
            }

            System.out.print("Deseja ver acordes menores para o tom " + tom + " (s/n)? ");
            String resposta = sc.nextLine().trim();

            if (resposta.equalsIgnoreCase("s")) {
                System.out.println("Acordes menores do tom " + tom + ":");

            }
        }

        sc.close();
        System.out.println("Programa encerrado.");
    }
}
