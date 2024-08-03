package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Tabela.fazerJogada;
import static org.example.Tabela.verificarVencedor;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ganhador = false;
        String jogador = "X";
        List<String> casas = new ArrayList<>();
        casas.add("0");casas.add("1");casas.add("2");casas.add("3");casas.add("4");casas.add("5");casas.add("6");casas.add("7");casas.add("8");
        casas.add("9");casas.add("a");casas.add("b");casas.add("c");casas.add("d");casas.add("e");casas.add("f");casas.add("g");casas.add("h");
        casas.add("i");casas.add("j");casas.add("k");casas.add("l");casas.add("m");casas.add("n");casas.add("o");casas.add("p");casas.add("q");
        casas.add("r");casas.add("s");casas.add("t");casas.add("u");casas.add("v");casas.add("w");casas.add("x");casas.add("y");casas.add("z");

        while (!ganhador) {
            boolean entradaInvalida = true;
            while (entradaInvalida) {
                boolean jogadaValida = fazerJogada(casas, jogador, sc);
                if (jogadaValida) {
                    entradaInvalida = false;
                }
            }
            if (verificarVencedor(casas)) {
                if(verificarVencedor(casas) == jogador.equals("X")) {
                    System.out.println("\u001B[34mJogador " + jogador + " venceu!\u001B[0m");
                    Tabela.imprimirTabela(casas);
                    break;
                } else{
                    System.out.println("\u001B[31mJogador " + jogador + " venceu!\u001B[0m");
                    Tabela.imprimirTabela(casas);
                    break;
                }
            }if (Tabela.verificarEmpate(casas)) {
                System.out.println("Empate!");
                Tabela.imprimirTabela(casas);
                break;
            }
            jogador = jogador.equals("X") ? "O" : "X";
        }
    }
}
