package com.algaworks.algasensors;

import java.util.Date;

public class CalculadoraPedido {

    public double calcularValorFinal(
            double total,
            TipoCliente tipoCliente,
            boolean possuiCupom,
            FormaPagamento formaPagamento,
            Date dataPedido) {
        double valorFinal = total;

        // desconto baseado no tipo de cliente
        valorFinal = tipoCliente.aplicarDesconto(total, possuiCupom);
        valorFinal = formaPagamento.aplicarTaxa(valorFinal);

        // uma taxa extra de 10 se o pedido for feito no fim de semana
        if (dataPedido.getDay() == 0 || dataPedido.getDay() == 6) {
            valorFinal = valorFinal + 10;
        }

        // Garante que o valor final nunca seja negativo.
        if (valorFinal < 0) {
            valorFinal = 0;
        }

        return valorFinal;
    }
}
