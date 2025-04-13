import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Main {

  static ListaDupla<CidadeOrigem> listaCidadeOrigem = new ListaDupla<>();

  public static void main(String[] args) {
    menuPrincipal();
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
    nomeCidadeOrigem = showInputDialog("Nome da cidade de origem a ser cadastrada: ");
    if (nomeCidadeOrigem == null || nomeCidadeOrigem.isEmpty()) {
      showMessageDialog(null, "O cadastro da cidade de origem pede um nome.");
      return null;
    }
    CidadeOrigem cidadeOrigem = new CidadeOrigem(nomeCidadeOrigem);
    cidadeOrigem.setConexoesDiretas(new ListaDupla<>());

    showMessageDialog(null, "Cidade de origem " + cidadeOrigem + " criada com sucesso.");

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
      String resposta = showInputDialog("Deseja cadastrar uma cidade de origem? [s, n]").trim().toLowerCase();
      if (resposta.equals("s")) {
        cidadeOrigem = cadastrarCidadeOrigem();
      } else {
        return;
      }
    }

    if (cidadeOrigem == null) {
      return;
    }

    nomeCidadeDestino = showInputDialog("Nome da cidade de destino a ser cadastrada: ");
    if (nomeCidadeDestino == null || nomeCidadeDestino.isEmpty()) {
      showMessageDialog(null, "O cadastro da cidade de destino pede um nome.");
      return;
    }

    while (true) {
      distancia = parseDouble(showInputDialog("Distância em quilômetros: "));
      if (distancia <= 0.0) {
        showMessageDialog(null, "A distância informada não é válida. Tente novamente.");
        continue;
      }
      break;
    }

    while (true) {
      fatorTrafego = parseDouble(showInputDialog("Fator de tráfego (entre 0.0 e 2.0):"));
      if (fatorTrafego < 0 || fatorTrafego > 2.0) {
        showMessageDialog(null, "O fato de tráfego informado não é válido. Tente novamente.");
        continue;
      }
      break;
    }

    while (true) {
      nPedagios = parseInt(showInputDialog("Número de pedágios no trajeto:"));
      if (nPedagios < 0) {
        showMessageDialog(null, "O número de pedágios no trajeto é inválido. Tente novamente.");
        continue;
      }
      break;
    }

    CidadeDestino cidadeDestino = new CidadeDestino(nomeCidadeDestino, distancia, fatorTrafego, nPedagios);

    cidadeOrigem.getConexoesDiretas().inserir(cidadeDestino);
    showMessageDialog(null, "Cidade de destino " + nomeCidadeDestino + " criada com sucesso.");
  }

  public static CidadeOrigem verificarCidadeOrigem() {
    CidadeOrigem cidadeOrigem = null;
    No<CidadeOrigem> aux;

    String nomeCidade = showInputDialog("Digite o nome da cidade de origem para pesquisar: ");
    if (nomeCidade == null || nomeCidade.isEmpty()) {
      showMessageDialog(null, "A verificação da cidade de origem pede um nome.");
      return null;
    }
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
    No<CidadeOrigem> aux = listaCidadeOrigem.getInicio();
    String msg = "";

    while (aux != null) {
      CidadeOrigem cidadeOrigem = aux.getDado();
      msg += "\nCidade de origem: " + cidadeOrigem.getnomeCidadeOrigem() + "\n";
      ListaDupla<CidadeDestino> conexoesDiretas = cidadeOrigem.getConexoesDiretas();
      if (!conexoesDiretas.estaVazia()) {
        msg += "Conexões Diretas:\n";
        No<CidadeDestino> auxDestino = conexoesDiretas.getInicio();
        while (auxDestino != null) {
          CidadeDestino cidadeDestino = auxDestino.getDado();
          msg += "→ Cidade de Destino: " + cidadeDestino.getNomeCidade();
          msg += " | Distância: " + cidadeDestino.getDistancia() + "km";
          msg += " | Fator de tráfego: " + cidadeDestino.getFatorTrafego();
          msg += " | Número de pedágios: " + cidadeDestino.getnPedagios();
          msg += " | Tempo: " + cidadeDestino.tempoEstimadoDeEntrega() + " min\n";

          auxDestino = auxDestino.getProximo();
        }
      } else {
        msg += "Cidade não possui conexões diretas.\n\n";
      }

      aux = aux.getProximo();
    }
    showMessageDialog(null, msg);
  }

  public static void verificarLigacoes() {
    String nomeCidadeOrigem = showInputDialog(
        "Para verificar a ligação entre cidades, digite o nome da cidade de origem: ");
    if (nomeCidadeOrigem == null || nomeCidadeOrigem.isEmpty()) {
      showMessageDialog(null, "A verificação de ligação pede por um nome de cidade de origem.");
      return;
    }
    String nomeCidadeDestino = showInputDialog(
        "Agora, digite o nome da cidade de destino: ");
    if (nomeCidadeDestino == null || nomeCidadeDestino.isEmpty()) {
      showMessageDialog(null, "A verificação de ligação pede por um nome de cidade de destino.");
      return;
    }

    No<CidadeOrigem> aux = listaCidadeOrigem.pesquisar(new CidadeOrigem(nomeCidadeOrigem));

    if (aux == null) {
      showMessageDialog(null, "Cidade de destino não encontrada.");
      return;
    }

    ListaDupla<CidadeDestino> conexoesDiretas = aux.getDado().getConexoesDiretas();
    No<CidadeDestino> aux2 = conexoesDiretas.pesquisar(new CidadeDestino(nomeCidadeDestino));

    if (aux2 == null) {
      showMessageDialog(null, "Não existe ligação direta entre " + nomeCidadeOrigem + " e " + nomeCidadeDestino + ".");
      return;
    }

    showMessageDialog(null, "Existe ligação direta entre " + nomeCidadeOrigem + " e " + nomeCidadeDestino
        + "\nTempo estimado: " + aux2.getDado().tempoEstimadoDeEntrega() + " minutos.");
    return;
  }

  public static void consultarTempoMaximo() {
    double tempoLimite = parseDouble(showInputDialog("Digite o tempo máximo em minutos: "));
    if (tempoLimite < 0) {
      showMessageDialog(null, "Valor inválido.");
      return;
    }
    String msg = "Entregas possíveis com tempo ≤ " + tempoLimite + " minutos.\n\n";
    boolean encontrouLigacoes = false;

    No<CidadeOrigem> noCidadeOrigem = listaCidadeOrigem.getInicio();

    while (noCidadeOrigem != null) {
      CidadeOrigem cidadeOrigem = noCidadeOrigem.getDado();
      ListaDupla<CidadeDestino> listaConexoesDiretas = cidadeOrigem.getConexoesDiretas();

      if (!listaConexoesDiretas.estaVazia()) {
        No<CidadeDestino> noCidadeDestino = listaConexoesDiretas.getInicio();
        while (noCidadeDestino != null) {
          double tempoEstimadoDeEntrega = noCidadeDestino.getDado().tempoEstimadoDeEntrega();
          if (tempoEstimadoDeEntrega <= tempoLimite) {
            msg += cidadeOrigem.getnomeCidadeOrigem() + " → " + noCidadeDestino.getDado().getNomeCidade() + " ("
                + noCidadeDestino.getDado().tempoEstimadoDeEntrega() + " min)\n";
            encontrouLigacoes = true;
          }
          noCidadeDestino = noCidadeDestino.getProximo();
        }
      }
      noCidadeOrigem = noCidadeOrigem.getProximo();
    }
    if (encontrouLigacoes == false) {
      msg = "Nenhuma ligação direta encontrada dentro do tempo limite de " + tempoLimite + " minutos.";
    }
    showMessageDialog(null, msg);
  }
}