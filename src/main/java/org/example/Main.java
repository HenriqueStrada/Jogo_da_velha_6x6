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






//if(jogada.equals("a")){
//casa = 11;
//        }else if(jogada.equals("b")){
//casa = 12;
//        }else if(jogada.equals("c")){
//casa = 13;
//        }else if(jogada.equals("d")){
//casa = 14;
//        }else if(jogada.equals("e")){
//casa = 15;
//        }else if(jogada.equals("f")){
//casa = 16;
//        }else if(jogada.equals("g")){
//casa = 17;
//        }else if(jogada.equals("h")){
//casa = 18;
//        }else if(jogada.equals("i")){
//casa = 19;
//        }else if(jogada.equals("j")){
//casa = 20;
//        }else if(jogada.equals("k")){
//casa = 21;
//        }else if(jogada.equals("l")){
//casa = 22;
//        }else if(jogada.equals("m")){
//casa = 23;
//        }else if(jogada.equals("n")){
//casa = 24;
//        }else if(jogada.equals("o")){
//casa = 25;
//        }else if(jogada.equals("p")){
//casa = 26;
//        }else if(jogada.equals("q")){
//casa = 27;
//        }else if(jogada.equals("r")){
//casa = 28;
//        }else if(jogada.equals("s")){
//casa = 29;
//        }else if(jogada.equals("t")){
//casa = 30;
//        }else if(jogada.equals("u")){
//casa = 31;
//        }else if(jogada.equals("v")){
//casa = 32;
//        }else if(jogada.equals("w")){
//casa = 33;
//        }else if(jogada.equals("x")){
//casa = 34;
//        }else if(jogada.equals("y")){
//casa = 35;
//        }else if(jogada.equals("z")){
//casa = 36;