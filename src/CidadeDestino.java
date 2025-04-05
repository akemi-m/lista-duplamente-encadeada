public class CidadeDestino {
  private String nomeCidadeDestino;
  private double distancia;
  private double fatorTrafego;
  private int nPedagios;

  public CidadeDestino(String nomeCidadeDestino, double distancia, double fatorTrafego, int nPedagios) {
    this.nomeCidadeDestino = nomeCidadeDestino;
    this.distancia = distancia;
    this.fatorTrafego = fatorTrafego;
    this.nPedagios = nPedagios;
  }

  public String getNomeCidade() {
    return nomeCidadeDestino;
  }

  public void setNomeCidade(String nomeCidadeDestino) {
    this.nomeCidadeDestino = nomeCidadeDestino;
  }

  public double getDistancia() {
    return distancia;
  }

  public void setDistancia(double distancia) {
    this.distancia = distancia;
  }

  public double getFatorTrafego() {
    return fatorTrafego;
  }

  public void setFatorTrafego(double fatorTrafego) {
    this.fatorTrafego = fatorTrafego;
  }

  public int getnPedagios() {
    return nPedagios;
  }

  public void setnPedagios(int nPedagios) {
    this.nPedagios = nPedagios;
  }

  @Override
  public String toString() {
    return nomeCidadeDestino + distancia + fatorTrafego + nPedagios;
  }
}
