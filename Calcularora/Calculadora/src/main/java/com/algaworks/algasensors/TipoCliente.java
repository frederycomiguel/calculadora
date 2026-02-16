package com.algaworks.algasensors;

public enum TipoCliente {
    // Cliente regular: recebe 5% de desconto apenas em compras acima de 500
    REGULAR {
        @Override
        public double aplicarDesconto(double total, boolean possuiCupom) {
            if (total > 500) {
                return total * 0.95;
            }
            return total;
        }
    },
    // Cliente premium: recebe 10% de desconto e mais 20 reais fixos se tiver cupom
    PREMIUM {
        @Override
        public double aplicarDesconto(double total, boolean possuiCupom) {
            double valor = total * 0.90;
            if (possuiCupom) {
                valor -= 20;
            }
            return valor;
        }
    },
    // Cliente VIP: recebe 15% de desconto e mais 50 reais fixos se tiver cupom
    VIP {
        @Override
        public double aplicarDesconto(double total, boolean possuiCupom) {
            double valor = total * 0.85;
            if (possuiCupom) {
                valor -= 50;
            }
            return valor;
        }
    };

    public abstract double aplicarDesconto(double total, boolean possuiCupom);
}
