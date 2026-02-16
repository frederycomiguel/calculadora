package com.algaworks.algasensors;

public enum FormaPagamento {
    // Adiciona uma taxa de 2% para compras no cartão de crédito
    CARTAO_CREDITO {
        @Override
        public double aplicarTaxa(double valor) {
            return valor + (valor * 0.02);
        }
    },
    // Aplica um desconto de 5% para pagamentos via PIX
    PIX {
        @Override
        public double aplicarTaxa(double valor) {
            return valor - (valor * 0.05);
        }
    },
    // Aplica um desconto de 3% para pagamentos via Boleto
    BOLETO {
        @Override
        public double aplicarTaxa(double valor) {
            return valor - (valor * 0.03);
        }
    },
    // Mantém o valor original para pagamentos em dinheiro
    DINHEIRO {
        @Override
        public double aplicarTaxa(double valor) {
            return valor;
        }
    };

    public abstract double aplicarTaxa(double valor);
}
