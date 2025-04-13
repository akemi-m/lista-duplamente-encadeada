public class ListaDupla<T> {
  private No<T> inicio;
  private No<T> fim;

  public ListaDupla() {
    this.inicio = null;
    this.fim = null;
  }

  public void inserir(T dado) {
    No<T> novoDado = new No<>(dado);

    if (estaVazia()) {
      inicio = novoDado;

    } else {
      novoDado.setAnterior(fim);
      fim.setProximo(novoDado);
    }
    fim = novoDado;
  }

  public void imprimir() {
    No<T> aux = inicio;
    while (aux != null) {
      System.out.println(aux.getDado());
      aux = aux.getProximo();
    }
  }

  public No<T> pesquisar(T dado) {
    No<T> aux = fim;

    while (aux != null) {
      if (aux.getDado().equals(dado)) {
        return aux;
      }
      aux = aux.getAnterior();
    }
    return null;
  }

  public boolean estaVazia() {
    if (inicio == null) {
      return true;
    } else {
      return false;
    }
  }

  public No<T> getInicio() {
    return inicio;
  }

  public No<T> getFim() {
    return fim;
  }

}
