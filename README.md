# Corra das fake news

Um jogo para a disciplina de Paradigmas de Programação da UFPR.
***

a especificação do trabalho pode ser acessada em PDF aqui -> [especificação](ProjetoPratico_CI1062_novo.pdf)
ou em [markdown](ProjetoPratico_CI1062_novo.md)

## Formato dos commits

Por organização, vamos seguir o seguinte padrão para os commits:

```text
[<tipo>] <mensagem>
```

Onde `<tipo>` pode ser:

- `[add]` para adição de novas funcionalidades
- `[fix]` para correção de bugs
- `[refactor]` para refatoração de código
- `[style]` para alterações que não afetam o código (ex: mudanças no README)
- `[test]` para adição de testes
- `[change]` para mudanças que não se encaixam em nenhum dos anteriores
- `[remove]` para remoção de funcionalidades ou arquivos

***

## Sobre o jogo

Corra das Fake News é um jogo de computador colaborativo para até quatro pessoas com
o objetivo de combater as fake news. Cada jogador deve assumir o papel de leitor de
notícias, percorrendo as posições de um tabuleiro, evitando ou eliminando as fake news que
encontrar pelo caminho. O jogo termina quando todas as fake news forem eliminadas e pelo
menos um jogador sobreviver

***

## Estrutura

Precisaremos de alguns elementos chave para o funcionamento do jogo. São eles:

- [ ] Tabuleiro
- [ ] Jogador
- [ ] Fake News
- [ ] Itens

Estes elementos irão se relacionar por meio de orientação a objetos. A seguir descrevemos como eles se relacionam

### Tabuleiro

## autores

- [https://github.com/herijooj] (Heric Camargo)
- [https://github.com/FontouraAbreu] (Vinicius Fontoura)
- [https://github.com/amalra1] (Pedro Amaral)

## anotações

- [ ] até 4 personagens
- [ ] itens espalhados aleatoriamente pelo tabuleiro
- [ ] existem itens ruins
- [ ] jogadas em turno
- [ ] Os jogadores (no mínimo 1, no máximo 4) devem ser posicionados no tabuleiro
conforme mostrado na Figura 1 da Seção 6 - Tabuleiros do Jogo.
- [ ] Um jogador possui somente a habilidade de se movimentar no tabuleiro, uma vez por
turno, nos sentidos norte, sul, leste e oeste. Se um item for encontrado após o
movimento, o mesmo deve ser armazenado pelo jogador.
- [ ] Um jogador pode executar uma ação por turno desde que tenha um item armazenado.
Lembrando que a ação só pode ser executada antes do jogador realizar seu
movimento no tabuleiro. Cada item possibilitará ao jogador uma das seguintes ações 1) denunciar fake news, 2) fugir, 3) ler uma notícia real ou 4) ouvir um boato.
- [ ] no minimo 6 fake news

## roadmap
