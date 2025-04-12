public class ListaDupla<T> {
  private No<T> inicio;
  private No<T> fim;

  public ListaDupla() {
    this.inicio = null;
    this.fim = null;
  }

  // método para inserir um nó no final da lista
  public void inserir(T dado) {
    No<T> novoDado = new No<>(dado);

    // se a lista estiver vazia
    if (estaVazia()) {
      inicio = novoDado;

    } else {
      // define como anterior do aux o fim do objeto anterior
      novoDado.setAnterior(fim);
      // define o objeto guardado no fim o próximo ser o aux, o atual
      fim.setProximo(novoDado);
    }
    // atualiza o valor do fim com o aux
    fim = novoDado;
  }

  // método para imprimir os elementos da lista
  public void imprimir() {
    No<T> aux = inicio;
    // começa com o inicio do primeiro elemento e termina quando o próximo for null
    while (aux != null) {
      System.out.println(aux.getDado());
      aux = aux.getProximo();
    }
  }

  // método que recebe um objeto e retorna o seu endereço, caso exista, senão
  // retorna null
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

  // método para verificar se a lista está vazia
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
