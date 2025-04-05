import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Main {

  static ListaDupla<CidadeOrigem> listaCidadeOrigem = new ListaDupla<>();
  static ListaDupla<CidadeDestino> listaCidadeDestino = new ListaDupla<>();

  public static void main(String[] args) {
    menuPrincipal();

    // listaDupla.inserir(new CidadeDestino("Batata", 15));
    // listaDupla.inserir(new CidadeDestino("Alface", 5));
    // listaDupla.inserir(new CidadeDestino("Selmini", 100));
    // listaDupla.inserir(new CidadeDestino("Arroz", 8));

  }

  public static void menuPrincipal() {
    String menu = "1. Cadastrar cidades na lista principal\n2. Cadastrar ligações diretas entre cidades\n3. Lista todas as cidades com suas ligações diretas\n4. Verificar ligação direta entre cidades\n5. Consultar com tempo máximo\n6. Finalizar";
    int opcao;
    int resposta;

    while (true) {
      opcao = parseInt(showInputDialog(menu));

      if (opcao == 6) {
        resposta = showConfirmDialog(null, "Tem certeza que deseja sair?");
        if (resposta == YES_OPTION) {
          break;
        } else if (resposta == NO_OPTION || resposta == CANCEL_OPTION) {
          continue;
        }
      }

      if (opcao < 1 || opcao > 5) {
        showMessageDialog(null, "Escolha um número de 1 a 5.");
      }

      switch (opcao) {
        case 1:
          cadastrarCidadeOrigem();
          break;
        case 2:
          cadastrarCidadeDestino();
          break;
        case 3:
          listarCidades();
          break;
        case 4:
          verificarLigacoes();
          break;
        case 5:
          consultarTempoMaximo();
          break;
        default:
          break;
      }
    }
  }

  public static CidadeOrigem cadastrarCidadeOrigem() {
    String nomeCidadeOrigem;
    ListaDupla<CidadeDestino> conexoesDiretas = null;
    CidadeOrigem cidadeOrigem;

    nomeCidadeOrigem = showInputDialog("Nome da cidade de origem: ");
    cidadeOrigem = new CidadeOrigem(nomeCidadeOrigem, conexoesDiretas);
    listaCidadeOrigem.inserir(cidadeOrigem);

    return cidadeOrigem;
  }

  public static void cadastrarCidadeDestino() {
    // retorna se existe ou não CidadeOrigem
    CidadeOrigem cidadeOrigem = verificarCidadeOrigem();
    String nomeCidadeDestino;
    double distancia;
    double fatorTrafego;
    int nPedagios;

    // se retornar null, cria um cidade origem antes
    if (cidadeOrigem == null) {
      cidadeOrigem = cadastrarCidadeOrigem();
    }

    // cadastro do produto
    nomeCidadeDestino = showInputDialog("Nome da cidade de destino: ");
    distancia = parseDouble(showInputDialog("Distância em quilômetros: "));
    fatorTrafego = parseDouble(showInputDialog("Fator de tráfego (entre 0.0 e 2.0):"));
    nPedagios = parseInt(showInputDialog("Número de pedágios no trajeto:"));

    listaCidadeDestino.inserir(new CidadeDestino(nomeCidadeDestino, distancia, fatorTrafego, nPedagios));
  }

  public static CidadeOrigem verificarCidadeOrigem() {
    CidadeOrigem cidadeOrigem = null;
    No<CidadeOrigem> aux;

    String nomeCidade = showInputDialog("Digite o nome da cidade de origem para pesquisar: ");
    // retorna o endereço de memória ou o null
    aux = listaCidadeOrigem.pesquisar(new CidadeOrigem(nomeCidade));

    // existe o obj
    if (aux != null) {
      // pega o endereço de memória do objeto
      cidadeOrigem = aux.getDado();
      showMessageDialog(null, cidadeOrigem.getnomeCidadeOrigem() + " está cadastrado.");
    } else {
      showMessageDialog(null, nomeCidade + " não foi encontrada.");
    }

    return cidadeOrigem;
  }

  public static void listarCidades() {
    listaCidadeOrigem.imprimir();

  }
}
