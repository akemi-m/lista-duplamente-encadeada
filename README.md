# Atividade II - Lista Duplamente Encadeada

Este repositório armazena uma aplicação da estrutra de dados "Lista Duplamente Encadeada", como parte da disciplina Estrutura de Dados (ESPM - Sistemas de Informação - 3° semestre) lecionada pelo Prof. Dr. Antonio Marcos Selmini.

Esta atividade foi desenvolvida por:

- Gabriel Cardoso Campos Rodrigues
- Julia Akemi Mullis

## Enunciado

A empresa ExpressLine opera entregas entre cidades e deseja modelar sua rede de conexões diretas.

A cidade de origem possui:

- Nome da cidade
- Referência para uma **lista de ligações diretas** (também uma lista duplamente encadeada genérica)

E poderá ter zero ou mais conexões diretas com outras cidades. Cada cidade da ligação direta possui:

- **Nome da cidade de destino** (`String`)
- **Distância** em quilômetros (`double`)
- **Fator de tráfego** (`double`): valor entre 0 (sem tráfego) e 2 (tráfego intenso)
- **Número de pedágios** (`int`)

### Cálculo do Tempo Estimado de Entrega

`tempo = (distância * fator_tráfego) + (número_de_pedágios * 2)`

## Funcionalidades do Sistema

A aplicação deverá apresentar um **menu com janelas gráficas (JOptionPane)** com as seguintes opções:

1. **Cadastrar cidades** na lista principal.
2. **Cadastrar ligações diretas** entre cidades.
3. **Listar todas as cidades** com suas ligações diretas.
4. **Verificar ligação direta** entre duas cidades e exibir o tempo estimado.
5. **Exibir todas as ligações possíveis** com tempo inferior ou igual a um tempo limite fornecido pelo usuário.

## Exemplo de Uso

Cidade: São Paulo → Campinas | Distância: 90.0 | Tráfego: 1.2 | Pedágios: 2 | Tempo: 110.00 min

Cidade: Campinas → Ribeirão Preto | Distância: 180.0 | Tráfego: 1.1 | Pedágios: 4 | Tempo: 206.00 min

## Exemplo de Consulta

Existe ligação direta entre São Paulo e Campinas? Sim. Tempo estimado: 110.0 minutos.

## Consulta com Tempo Máximo

Entregas possíveis com tempo ≤ 120 minutos: São Paulo → Campinas (110.0 min)

## Restrições

- **Não utilizar** bibliotecas prontas como `ArrayList`, `LinkedList`, `HashMap`, etc.
- **Toda manipulação** deve ser feita com estruturas implementadas manualmente.
- **Composição de listas**: cada cidade possui sua própria lista de ligações diretas.
