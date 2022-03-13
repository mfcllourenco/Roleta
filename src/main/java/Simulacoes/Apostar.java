package Simulacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Apostar {

    public int naRoletaParImpar(int saldo, int apostaMinima, int apostaMaxima) {

        boolean venceu = false;
        int valorAposta = apostaMinima;

        GirarRoleta girarRoleta = new GirarRoleta();
        List<Integer> sequenciaApostas = new ArrayList<>();

        if (saldo > 10) {
            sequenciaApostas = listaApostasParImpar(saldo - 7, apostaMaxima);
        } else {
            sequenciaApostas = listaApostasParImpar(saldo, apostaMaxima);
        }

        for (int i = 0; i < sequenciaApostas.size(); i++) {

            String aposta = girarRoleta.parOuImpar();
            int apostarNumero = girarRoleta.gerarNumero(1, 36);
            int numeroSorteado = girarRoleta.numeroSorteado();
            valorAposta = sequenciaApostas.get(i);

            int valorApostaNumero = 0;

            if (sequenciaApostas.size() > 3) {
                if (apostarNumero == numeroSorteado) {
                    System.out.printf("Voce acertou o numero %d!%n", numeroSorteado);
                    valorApostaNumero = 35;
                } else {
                    valorApostaNumero = -1;
                }
            }

            if ((numeroSorteado < 1) || ((numeroSorteado % 2) == 0 && aposta.equals("impar")) || ((numeroSorteado % 2) == 1 && aposta.equals("par"))) {
                saldo = saldo - valorAposta + valorApostaNumero;
                System.out.printf("Voce apostou %d no %s e o numero sorteado foi %d. Voce perdeu e seu saldo atual é: %d!%n",
                        valorAposta, aposta, numeroSorteado, saldo);
            } else {
                saldo = saldo + valorAposta + valorApostaNumero;
                System.out.printf("Voce apostou %d no %s e o numero sorteado foi %d. Voce venceu e seu saldo atual é: %d!%n",
                        valorAposta, aposta, numeroSorteado, saldo);
                break;
            }
        }
        return saldo;
    }

    public int naRoletaColunas(int saldo, int apostaMinima, int apostaMaxima) {

        boolean venceu = false;
        int valorAposta = apostaMinima;

        GirarRoleta girarRoleta = new GirarRoleta();
        List<Integer> sequenciaApostas = new ArrayList<>();

//        if (saldo > 10) {
//            sequenciaApostas = listaApostasParImpar(saldo - 7, apostaMaxima);
//        } else {
//            sequenciaApostas = listaApostasParImpar(saldo, apostaMaxima);
//        }

        sequenciaApostas = listaApostasColunas(saldo, apostaMaxima);

        for (int i = 0; i < sequenciaApostas.size(); i++) {

            String aposta = girarRoleta.naColuna();
            int apostarNumero = girarRoleta.gerarNumero(1, 36);
            int numeroSorteado = girarRoleta.numeroSorteado();
            valorAposta = sequenciaApostas.get(i);

//            int valorApostaNumero = 0;
//
//            if (sequenciaApostas.size() > 3) {
//                if (apostarNumero == numeroSorteado) {
//                    System.out.printf("Voce acertou o numero %d!%n", numeroSorteado);
//                    valorApostaNumero = 35;
//                } else {
//                    valorApostaNumero = -1;
//                }
//            }

            if ((numeroSorteado < 1) ||
                    ((numeroSorteado % 3) == 0 && !aposta.equals("3")) ||
                    ((numeroSorteado % 3) == 1 && !aposta.equals("1")) ||
                    ((numeroSorteado % 3) == 2 && !aposta.equals("2"))) {
                saldo = saldo - valorAposta;
                System.out.printf("Voce apostou %d no c%s e o numero sorteado foi %d. Voce perdeu e seu saldo atual é: %d!%n",
                        valorAposta, aposta, numeroSorteado, saldo);
            } else {
                saldo = saldo + (valorAposta * 2);
                System.out.printf("Voce apostou %d no c%s e o numero sorteado foi %d. Voce venceu e seu saldo atual é: %d!%n",
                        valorAposta, aposta, numeroSorteado, saldo);
                break;
            }
        }
        return saldo;
    }

    public int novoValorAposta(int valorAposta, int apostaMaxima, int saldo) {

        if (valorAposta * 2 < saldo) {
            if (valorAposta * 2 <= apostaMaxima) {
                return valorAposta * 2;
            }
            return apostaMaxima;
        }

        if (saldo > apostaMaxima) {
            return apostaMaxima;
        } else {
            return saldo;
        }
    }

    public List<Integer> listaApostasParImpar(int saldo, int apostaMaxima) {

        List<Integer> listaAposta = new ArrayList<>();

        while (saldo > 1) {
            if (saldo > (apostaMaxima * 2)) {
                saldo = apostaMaxima;
                listaAposta.add(saldo);
            } else {
                if (saldo % 2 == 1) {
                    saldo = (saldo - 1) / 2;
                    listaAposta.add(saldo);
                } else {
                    saldo = saldo / 2;
                    listaAposta.add(saldo);
                }
            }
        }

        listaAposta = listaAposta.stream().sorted().collect(Collectors.toList());

        return listaAposta;
    }

    public List<Integer> listaApostasColunas(int saldo, int apostaMaxima) {

        List<Integer> listaAposta = new ArrayList<>();
        int aposta = 0;

        if (saldo > 288) {
            saldo = 290;
        }

        while (saldo > 1 && aposta != 1) {
            if (saldo == 288) {
                listaAposta.add(100);
                saldo = saldo - 100;
            } else {
                aposta = (int) Math.floor(saldo * 0.345);
                listaAposta.add(aposta);
                saldo = saldo - aposta;
            }
        }

        listaAposta.add(1);
        listaAposta.add(1);

        listaAposta = listaAposta.stream().sorted().collect(Collectors.toList());

        return listaAposta;
    }
}
