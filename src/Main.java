public class Main {
  public static void main(String[] args) {
    ListaDupla<CidadeSecundaria> listaDupla = new ListaDupla<>();

    listaDupla.inserir(new CidadeSecundaria("Batata", 15));
    listaDupla.inserir(new CidadeSecundaria("Alface", 5));
    listaDupla.inserir(new CidadeSecundaria("Selmini", 100));
    listaDupla.inserir(new CidadeSecundaria("Arroz", 8));

    listaDupla.imprimir();
    System.out.println();
  }
}
