public class CidadePrimaria {
  private String nomeCidade;
  // ListaDuplaSecundaria = null;

  // lista primária
  public CidadePrimaria(String nomeCidade) {
    this.nomeCidade = nomeCidade;
  }

  @Override
  public String toString() {
    return nomeCidade;
  }
}
