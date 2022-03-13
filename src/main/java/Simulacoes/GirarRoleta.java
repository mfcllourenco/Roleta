package Simulacoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GirarRoleta {

    public int numeroSorteado() {

        int numeroSorteado = gerarNumero(-1, 36);

        return numeroSorteado;

    }

    public String parOuImpar() {

        int aposta = gerarNumero(1, 2);

        if (aposta == 2) {
            return "par";
        } else {
            return "impar";
        }
    }

    public String naColuna() {

        return String.valueOf(gerarNumero(1, 3));
    }

    public int gerarNumero(int min, int max) {

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
