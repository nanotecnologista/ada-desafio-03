package br.com.nanotech.model;

public class Conta {
    private String titular;
    private String numero;
    private double saldo;
    private static final double TAXA = 0.50;

    public Conta(String titular, String numero, double saldoInicial) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) return false;
        saldo += valor - TAXA;
        return true;
    }

    public boolean sacar(double valor) {
        if (valor + TAXA > saldo || valor <= 0) return false;
        saldo -= (valor + TAXA);
        return true;
    }

    public boolean transferir(Conta destino, double valor) {
        if (valor + TAXA > saldo || valor <= 0) return false;
        saldo -= (valor + TAXA);
        destino.saldo += valor;
        return true;
    }

    public boolean pagar(double valor) {
        if (valor + TAXA > saldo || valor <= 0) return false;
        saldo -= (valor + TAXA);
        return true;
    }
}

