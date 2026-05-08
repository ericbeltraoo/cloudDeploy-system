package entities;

public class Departamento {
    public String nome;
    public double orcamentoTotalInfra;

    public Departamento(String tempNomeDep, double tempOrcamentoTotalInfra) {
        this.nome = tempNomeDep;
        this.orcamentoTotalInfra = tempOrcamentoTotalInfra;
    }
}
