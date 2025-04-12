public class CidadeOrigem {
  private String nomeCidadeOrigem;
  private ListaDupla<CidadeDestino> conexoesDiretas;

  public CidadeOrigem(String nomeCidadeOrigem, ListaDupla<CidadeDestino> conexoesDiretas) {
    this.nomeCidadeOrigem = nomeCidadeOrigem;
    this.conexoesDiretas = conexoesDiretas;
  }

  public CidadeOrigem(String nomeCidadeOrigem) {
    this(nomeCidadeOrigem, null);
  }

  public String getnomeCidadeOrigem() {
    return nomeCidadeOrigem;
  }

  public void setnomeCidadeOrigem(String nomeCidadeOrigem) {
    this.nomeCidadeOrigem = nomeCidadeOrigem;
  }

  public ListaDupla<CidadeDestino> getConexoesDiretas() {
    return conexoesDiretas;
  }

  public void setConexoesDiretas(ListaDupla<CidadeDestino> conexoesDiretas) {
    this.conexoesDiretas = conexoesDiretas;
  }

  @Override
  public String toString() {
    return nomeCidadeOrigem;
  }

  @Override
  public boolean equals(Object obj) {
      CidadeOrigem cidadeOrigem = (CidadeOrigem) obj;
      // A comparação de String é feita com equals, não com ==
      return cidadeOrigem.nomeCidadeOrigem.equalsIgnoreCase(nomeCidadeOrigem);
  }
}
