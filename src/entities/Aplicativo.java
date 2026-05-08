package entities;

public class Aplicativo {
    public String nome;
    public int memoriaRamNecessaria;
    public double previsaoFaturamentoMensal, armazenamentoNecessario;

    public Aplicativo(String tempNome,int tempMemoriaRamNecessaria, double tempArmazenamentoNecessario, double tempPrevisaoFaturamentoMensal) {
        this.nome = tempNome;
        this.memoriaRamNecessaria = tempMemoriaRamNecessaria;
        this.previsaoFaturamentoMensal = tempPrevisaoFaturamentoMensal;
        this.armazenamentoNecessario = tempArmazenamentoNecessario;
    }
}
