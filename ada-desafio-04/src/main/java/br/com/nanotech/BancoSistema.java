package br.com.nanotech;

import br.com.nanotech.model.Conta;
import java.util.Scanner;

public class BancoSistema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do titular: ");
        String titular = sc.nextLine();
        System.out.print("Digite o número da conta: ");
        String numero = sc.nextLine();
        Conta conta = new Conta(titular, numero, 0);

        // Conta para transferências
        Conta contaDestino = new Conta("Conta Destino", "9999", 0);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Transferir");
            System.out.println("4. Pagar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();

            if (opcao == 5) {
                System.out.println("Saindo...");
                break;
            }

            System.out.print("Digite o valor: ");
            double valor = sc.nextDouble();
            boolean sucesso = false;

            switch (opcao) {
                case 1:
                    sucesso = conta.depositar(valor);
                    break;
                case 2:
                    sucesso = conta.sacar(valor);
                    break;
                case 3:
                    sucesso = conta.transferir(contaDestino, valor);
                    break;
                case 4:
                    sucesso = conta.pagar(valor);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            if (sucesso) {
                System.out.printf("Operação realizada! Saldo atual: R$%.2f\n", conta.getSaldo());
            } else {
                System.out.println("Operação não permitida. Verifique o valor ou saldo.");
                System.out.printf("Saldo atual: R$%.2f\n", conta.getSaldo());
            }
        }
        sc.close();
    }
}

