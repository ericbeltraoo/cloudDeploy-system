package application;

import entities.Aplicativo;
import entities.Departamento;
import entities.Infraestrutura;
import util.Calculos;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        // OBJETOS

        Scanner input = new Scanner(System.in);
        Infraestrutura infra1 = new Infraestrutura();
        Infraestrutura infra2 = new Infraestrutura();

        System.out.println("\n-- Servidor 1 --\n");
        System.out.println("Digite o codigo de identificação do servidor 1: ");
        infra1.codigoIdentificacao = input.nextInt();
        input.nextLine();

        System.out.println("Digite a quantidade de Memória ram disponível no servidor 1: ");
        infra1.ramTotalDisponivel = input.nextInt();
        input.nextLine();

        System.out.println("Digite a quantidade de Armazenamento disponível no servidor 1: ");
        infra1.armazenamentoTotalDisponivel = input.nextDouble();
        input.nextLine();

        System.out.println("\n-- Servidor 2 --\n");
        System.out.println("Digite o codigo de identificação do servidor 2: ");
        infra2.codigoIdentificacao = input.nextInt();
        input.nextLine();

        System.out.println("Digite a quantidade de Memória ram disponível no servidor 2: ");
        infra2.ramTotalDisponivel = input.nextInt();
        input.nextLine();

        System.out.println("Digite a quantidade de Armazenamento disponível no servidor 2: ");
        infra2.armazenamentoTotalDisponivel = input.nextDouble();
        input.nextLine();

        System.out.println("\n-- Aplicativo --\n");
        System.out.println("Digite o nome do aplicativo: ");
        String tempNome = input.nextLine();

        System.out.println("Digite a quantidade de memória ram necessária para rodar o aplicativo no servidor: ");
        int tempMemoriaRamNecessaria = input.nextInt();
        input.nextLine();

        System.out.println("Digite o armazenamento necessário para rodar o aplicativo no servidor: ");
        double tempArmazenamentoNecessario = input.nextDouble();
        input.nextLine();

        System.out.println("Digite a previsão de faturamento mensal do aplicativo: ");
        double tempPrevisaoFaturamentoMensal = input.nextDouble();
        input.nextLine();

        Aplicativo app = new Aplicativo(tempNome,tempMemoriaRamNecessaria, tempArmazenamentoNecessario, tempPrevisaoFaturamentoMensal);

        System.out.println("\n-- Departamento --\n");
        System.out.println("Digite o nome do departamento: ");
        String tempNomeDep = input.nextLine();

        System.out.println("Digite o orçamento total disponível para infraestrutura: ");
        double tempOrcamentoTotalInfra = input.nextDouble();
        input.nextLine();

        Departamento departamento = new Departamento(tempNomeDep, tempOrcamentoTotalInfra);

        double custoAdicionalSeguranca = Calculos.calculoAdicionalSeguranca(app.memoriaRamNecessaria, app.armazenamentoNecessario);
        boolean verificacaoCustoDeploy = Calculos.verificacaoCustoDeploy(app.previsaoFaturamentoMensal, app.memoriaRamNecessaria , app.armazenamentoNecessario);

        System.out.printf("Custo Base: R$ %.2f %n",Calculos.calculoCustoAlocacao(app.memoriaRamNecessaria, app.armazenamentoNecessario));
        System.out.printf("Taxa Segurança: R$ %.2f %n",Calculos.calculoTaxaSeguranca(app.memoriaRamNecessaria ,app.armazenamentoNecessario));
        System.out.printf("Custo Total: R$ %.2f %n", custoAdicionalSeguranca);



        System.out.println("\n-- SIMULAÇÃO SERVIDOR 1 --\n");
        if(infra1.ramTotalDisponivel >= app.memoriaRamNecessaria && infra1.armazenamentoTotalDisponivel >= app.armazenamentoNecessario &&
                custoAdicionalSeguranca <= departamento.orcamentoTotalInfra &&
                verificacaoCustoDeploy) {
            System.out.println("APROVADO");
        } else {
            if (!(infra1.ramTotalDisponivel >= app.memoriaRamNecessaria && infra1.armazenamentoTotalDisponivel >= app.armazenamentoNecessario)) {
                System.out.println("Veredito: Negado (Motivo: Hardware)");
            } else if (!(custoAdicionalSeguranca <= departamento.orcamentoTotalInfra)) {
                System.out.println(custoAdicionalSeguranca);
                System.out.println(departamento.orcamentoTotalInfra);
                System.out.println("Veredito: Negado (Motivo: Orçamento)");
            } else if (!verificacaoCustoDeploy) {
                System.out.println("Veredito: Negado (Motivo: Comercial)");
            }
        }

        System.out.println("\n-- SIMULAÇÃO SERVIDOR 2 --\n");
        if(infra2.ramTotalDisponivel >= app.memoriaRamNecessaria && infra2.armazenamentoTotalDisponivel >= app.armazenamentoNecessario &&
                custoAdicionalSeguranca <= departamento.orcamentoTotalInfra &&
                verificacaoCustoDeploy) {
            System.out.println("APROVADO");
        } else {
            if (!(infra2.ramTotalDisponivel >= app.memoriaRamNecessaria && infra2.armazenamentoTotalDisponivel >= app.armazenamentoNecessario)) {
                System.out.println("Veredito: Negado (Motivo: Hardware)");
            } else if (!(custoAdicionalSeguranca <= departamento.orcamentoTotalInfra)) {
                System.out.println("Veredito: Negado (Motivo: Orçamento)");
            } else if (!verificacaoCustoDeploy) {
                System.out.println("Veredito: Negado (Motivo: Comercial)");
            }
        }

        input.close();
    }
}
