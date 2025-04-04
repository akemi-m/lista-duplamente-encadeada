public class CidadeSecundaria {
  private String nomeCidade;
  private double distancia;
  private double fatorTrafego;
  private int nPedagios;

  // lista secundária
  public CidadeSecundaria(String nomeCidade, double distancia, double fatorTrafego, int nPedagios) {
    this.nomeCidade = nomeCidade;
    this.distancia = distancia;
    this.fatorTrafego = fatorTrafego;
    this.nPedagios = nPedagios;
  }

  @Override
  public String toString() {
    return nomeCidade + distancia + fatorTrafego + nPedagios;
  }
}
