package org.example;

import java.util.List;
import java.util.Scanner;

public class Tabela {
    String jogador;
    int jogada;

    public Tabela(String jogador, int jogada) {
        this.jogador = jogador;
        this.jogada = jogada;
    }

    public static String imprimirTabela(List<String> casas) {
        System.out.println("-----|-----|-----|-----|-----|-----");
        for (int i = 0; i < casas.size(); i++) {
            if (i == 5 || i == 11 || i == 17 || i == 23 || i == 29) {
                System.out.println("  " + (casas.get(i).equals("X") ? "\u001B[34m" + casas.get(i) + "\u001B[0m" :
                        casas.get(i).equals("O") ? "\u001B[31m" + casas.get(i) + "\u001B[0m" : casas.get(i)) + "  ");
                System.out.println("-----|-----|-----|-----|-----|-----");
            } else if (i == 35) {
                System.out.print("  " + (casas.get(i).equals("X") ? "\u001B[34m" + casas.get(i) + "\u001B[0m" :
                        casas.get(i).equals("O") ? "\u001B[31m" + casas.get(i) + "\u001B[0m" : casas.get(i)) + "  \n");
            } else {
                System.out.print("  " + (casas.get(i).equals("X") ? "\u001B[34m" + casas.get(i) + "\u001B[0m" :
                        casas.get(i).equals("O") ? "\u001B[31m" + casas.get(i) + "\u001B[0m" : casas.get(i)) + "  |");
            }
        }
        System.out.println("-----|-----|-----|-----|-----|-----");
        return casas.get(0);
    }

    public static boolean fazerJogada(List<String> casas, String jogador, Scanner sc) {
        System.out.println("-------------------------------");
        System.out.println((jogador.equals("X") ? "\u001B[34m" + "Qual casa quer jogar, " + jogador + "?" + "\u001B[0m" : jogador.equals("O") ? "\u001B[31m" + "Qual casa quer jogar, " + jogador + "?" + "\u001B[0m" : jogador));
        System.out.println();
        imprimirTabela(casas);
        try {
            int casa;
            System.out.print("\nDigite a casa: ");
            String jogada = sc.next();
            if (jogada.equals("0") || jogada.equals("2") || jogada.equals("3") || jogada.equals("4") || jogada.equals("5") || jogada.equals("6") || jogada.equals("7") || jogada.equals("8")
            || jogada.equals("9") || jogada.equals("1")){
                casa = Integer.parseInt(jogada) + 1;
            }else{
                casa = letraParaNumero(jogada); // chamada para o método que converte letra para número
            }
            if (casa < 1 || casa > 36) {
                System.out.print("\nCasa inválida. Escolha um número entre 0 a 10, ou uma letra de (a)-(z) ");
                System.out.println();
                return false;
            }
            if (casas.get(casa - 1).equals("X") || casas.get(casa - 1).equals("O")) {
                System.out.println("\nVocê não pode escolher uma casa já escolhida!");
                return false;
            }
            casas.set(casa - 1, jogador);
            return true;
        } catch (NumberFormatException e) {
            System.out.print("\nEntrada inválida. Tente novamente.");
            System.out.println();
            return false;
        }
    }
    private static int letraParaNumero(String letra) {
        String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int[] numeros = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};

        for (int i = 0; i < letras.length; i++) {
            if (letra.equalsIgnoreCase(letras[i])) {
                return numeros[i];
            }
        }

        // se a letra não for encontrada, retorna -1
        return -1;
    }

    public static Boolean verificarVencedor(List<String> casas) {
        // Verificar Linhas
        for (int i = 0; i < 36; i += 6) {
            for (int j = 0; j < 3; j++) {
                if (casas.get(i + j).equals(casas.get(i + j + 1)) && casas.get(i + j).equals(casas.get(i + j + 2)) && casas.get(i + j).equals(casas.get(i + j + 3))) {
                    return true;
                }
            }
        }
        // Verificar Colunas
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (casas.get(i + j * 6).equals(casas.get(i + (j + 1) * 6)) && casas.get(i + j * 6).equals(casas.get(i + (j + 2) * 6)) && casas.get(i + j * 6).equals(casas.get(i + (j + 3) * 6))) {
                    return true;
                }
            }
        }

        // Verificar Diagonais
        for (int i = 0; i < 3; i++) {
            if (casas.get(i).equals(casas.get(i + 7)) && casas.get(i).equals(casas.get(i + 14)) && casas.get(i).equals(casas.get(i + 21))) {
                return true;
            }
            if (casas.get(i + 5).equals(casas.get(i + 10)) && casas.get(i + 5).equals(casas.get(i + 15)) && casas.get(i + 5).equals(casas.get(i + 20))) {
                return true;
            }
        }

        return false;
    }
    public static Boolean verificarEmpate(List<String> casas) {
        int y = 0;
        for(int i = 0; i < casas.size(); i ++) {
            if (casas.get(i).equals("X") || (casas.get(i).equals("O"))){
                y++;
            }
        }
        if(y == casas.size()) {
            return true;
        }else{
            return false;
        }
    }
}