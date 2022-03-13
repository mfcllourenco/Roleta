package Simulacoes;

import org.junit.jupiter.api.Test;

public class IniciarSimulacoes {

    @Test
    public void IniciaSimulacoesParImpar() {


        int saldoInicial = 135;
        int valorMinimoAposta = 1;
        int valorMaximoAposta = 100;

        Apostar apostar = new Apostar();

        System.out.printf("Seu saldo inicial é: %d!%n", saldoInicial);


        while (saldoInicial > 1 && saldoInicial < 235) {
            System.out.println(apostar.listaApostasParImpar(saldoInicial, valorMaximoAposta));
            saldoInicial = apostar.naRoletaParImpar(saldoInicial, valorMinimoAposta, valorMaximoAposta);
        }
    }

    @Test
    public void IniciaSimulacoesColunas() {


        int saldoInicial = 781;
        int valorMinimoAposta = 1;
        int valorMaximoAposta = 100;

        Apostar apostar = new Apostar();

        System.out.printf("Seu saldo inicial é: %d!%n", saldoInicial);


        while (saldoInicial > 2 && saldoInicial < 1000) {
            System.out.println(apostar.listaApostasColunas(saldoInicial, valorMaximoAposta));
            saldoInicial = apostar.naRoletaColunas(saldoInicial, valorMinimoAposta, valorMaximoAposta);
        }
    }
}
