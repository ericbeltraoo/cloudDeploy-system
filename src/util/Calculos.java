package util;

public class Calculos {
    public static final double CUSTO_ALOCACAO_RAM = 28.50;
    public static final double CUSTO_ALOCACAO_ARMAZENAMENTO = 2.15;
    public static final double ADICIONAL_SEGURANCA = 0.08;
    public static final double PORCENTAGEM_FATURAMENTO_APLICATIVO = 0.15;

    // FAZ O CALCULO DO VALOR QUE O ARMAZENAMENTO  E A MEMORIA IRA GASTAR
    public static double calculoCustoAlocacao(double memoriaRamNecessaria, double armazenamentoNecessario) {
        return memoriaRamNecessaria * CUSTO_ALOCACAO_RAM + armazenamentoNecessario * CUSTO_ALOCACAO_ARMAZENAMENTO;
    }

    // FAZ O CALCULO DA TAXA DE SEGURANÇA
    public static double calculoTaxaSeguranca(double memoriaRamNecessaria, double armazenamentoNecessario) {
        return calculoCustoAlocacao(memoriaRamNecessaria,armazenamentoNecessario) * ADICIONAL_SEGURANCA;
    }

    // FAZ O CALCULO DO CUSTO ALOCACAO + 8% || CUSTO TOTAL DO DEPLOY
    public static double calculoAdicionalSeguranca(double memoriaRamNecessaria, double armazenamentoNecessario) {
        return calculoCustoAlocacao(memoriaRamNecessaria,armazenamentoNecessario) + calculoTaxaSeguranca(memoriaRamNecessaria,armazenamentoNecessario);
    }

    // VERIFICA SE O VALOR TOTAL É MENOR OU IGUAL A 15% DO FATURAMENTO PREVISTO PELO APP
    public static boolean verificacaoCustoDeploy(double previsaoFaturamentoMensal,double memoriaRamNecessaria, double armazenamentoNecessario) {
        double calculoPorcentagem = previsaoFaturamentoMensal * PORCENTAGEM_FATURAMENTO_APLICATIVO;
        return calculoAdicionalSeguranca(memoriaRamNecessaria, armazenamentoNecessario) <= calculoPorcentagem;
    }


}
