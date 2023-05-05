![](https://cdn.mathpix.com/cropped/2023_05_05_641bc44074ac8f348f08g-1.jpg?height=326&width=1627&top_left_y=208&top_left_x=226)

\title{
Projeto Prático (30 pontos)
}

![](https://cdn.mathpix.com/cropped/2023_05_05_641bc44074ac8f348f08g-1.jpg?height=560&width=1604&top_left_y=642&top_left_x=226)

\section{Introdução}

Corra das Fake News é um jogo de computador colaborativo para até quatro pessoas com o objetivo de combater as fake news. Cada jogador deve assumir o papel de leitor de notícias, percorrendo as posições de um tabuleiro, evitando ou eliminando as fake news que encontrar pelo caminho. O jogo termina quando todas as fake news forem eliminadas e pelo menos um jogador sobreviver.

\section{Regras do Jogo}

O jogo possui dois personagens principais, os jogadores e as fake news e é baseado em um sistema de turnos, onde cada jogador presente no tabuleiro executa um movimento/ação para fugir das fake news ou para elimina-las. No decorrer do jogo, itens são distribuídos pelo tabuleiro para auxiliar os jogadores, mas cuidado, alguns itens podem ser boatos que vão te deixar desinformado.

\section{Jogadores}

Existe apenas um tipo de jogador conforme descrito a seguir:

1. Os jogadores (no mínimo 1, no máximo 4) devem ser posicionados no tabuleiro conforme mostrado na Figura 1 da Seção 6 - Tabuleiros do Jogo.

2. Um jogador possui somente a habilidade de se movimentar no tabuleiro, uma vez por turno, nos sentidos norte, sul, leste e oeste. Se um item for encontrado após o movimento, o mesmo deve ser armazenado pelo jogador.

3. Um jogador pode executar uma ação por turno desde que tenha um item armazenado. Lembrando que a ação só pode ser executada antes do jogador realizar seu movimento no tabuleiro. Cada item possibilitará ao jogador uma das seguintes ações: 1) denunciar fake news, 2) fugir, 3) ler uma notícia real ou 4) ouvir um boato. Mais detalhes sobre as ações são apresentadas na Seção 5 - Itens do Jogo. 

\section{Fake news}

Os inimigos no jogo são as fake news que se encontram espalhadas no tabuleiro (no mínimo 6).

1. Existem 3 (três) tipos de fake news, diferenciadas pela forma como se movimentam:

a) Fake news 1 (F1): movimenta uma casa em um dos sentidos: norte, sul, leste ou oeste.

b) Fake news 2 (F2): movimenta duas casas em um dos sentidos: norte, sul, leste ou oeste.

c) Fake news 3 (F3): movimenta uma casa nos sentidos diagonais noroeste, nordeste, sudoeste e sudeste.

2. Caso uma fake news saia da margem do tabuleiro ou colida com outra, a mesma é eliminada.

3. Caso a fake news colida com um jogador, esse jogador é eliminado.

4. Caso uma fake news colida com um item presente em uma posição do tabuleiro, a mesma elimina o item do tabuleiro e cria uma cópia dela mesma em uma das 8 (oito) posições adjacentes livres, ou seja, a fake news é duplicada.

\section{Itens do jogo}

Os itens do jogo estão sempre visíveis no tabuleiro e representados por "??" (dois sinais de interrogação), conforme ilustrado na Figura 1 da Seção 6 - Tabuleiros do Jogo.

1. Inicialmente, 2 (dois) itens são adicionados ao tabuleiro em posições aleatórias.

2. Quando um jogador se movimentar para uma posição do tabuleiro que houver um item, o jogador deve armazenar esse item e eliminá-lo do tabuleiro. Na sequência, um novo item qualquer deverá surgir em outra posição do tabuleiro.

3. Os tipos de itens e a ação de cada um deles são:

a. Denunciar fake news: esse item oferece a ação de denunciar qualquer fake news em volta do jogador, eliminando-as (se houver) nas 8 (oito) posições adjacentes à posição do jogador.

b. Fugir: esse item permite que o jogador mude para qualquer outra posição do tabuleiro.

c. Ler uma notícia real: esse item permite que o jogador elimine uma fake news qualquer presente no tabuleiro.

d. Ouvir um boato: esse item infelizmente é feito para atrapalhar os jogadores. Caso um jogador o armazene, no próximo turno o movimento desse jogador é realizado de forma aleatória.

\section{Tabuleiro do jogo}

O cenário do jogo é formado por um tabuleiro 9x9, conforme ilustrado na Figura 1.

1. Os jogadores iniciam o jogo nas posições representadas no tabuleiro (posições J1, J2, J3 e/ou J4).

2. Cada posição do tabuleiro corresponde a um setor que o jogador deve percorrer, até que todas as fake news sejam eliminadas, restando pelo menos um jogador.

3. Cada setor possui uma posição no tabuleiro $([x, y])$ e um item, conforme descrito na Seção 5 - Itens do Jogo. 4. Podem existir 2 (dois) tipos de setores:

a. Setor normal: não existe nenhuma restrição, ou seja, todos os movimentos e ações dos jogadores e das fake news podem ser executadas.

b. Setor restrito: representado pelos caracteres "XX". Este setor não pode ser acessado por jogadores ou fake news. Caso um destes se movimente para este setor, o mesmo é eliminado do jogo.

5. Os setores restritos, representados por " $X X$ ", devem ser definidos antes de iniciar 0 jogo e colocados de forma visível em quatro posições quaisquer do tabuleiro, conforme ilustrado na Figura 1.

6. Devem ser criadas no mínimo 6 (seis) fake news no tabuleiro, sendo duas de cada tipo (F1, F2 e F3).

7. As fake news, inicialmente, devem ser colocadas em qualquer posição do tabuleiro com exceção dos setores situados nas bordas (linha 1, linha 9, coluna 1 e coluna 9), conforme ilustrado na Figura 1.

![](https://cdn.mathpix.com/cropped/2023_05_05_641bc44074ac8f348f08g-3.jpg?height=816&width=1054&top_left_y=937&top_left_x=501)

Figura 1 - Exemplo ilustrativo do tabuleiro do jogo onde, inicialmente, as seis fake news, dois itens e quatro setores restritos ocupam posições aleatórias do tabuleiro.

\section{Turno}

O jogo deve funcionar em sistema de turnos, alternando entre jogadores e fake news. Um turno finaliza quando todos os jogadores e fake news completarem seus movimentos.

1. Os jogadores possuem até 20 turnos para eliminar todas as fake news.

2. Os jogadores iniciam nas posições determinadas na Figura 1, e devem selecionar um movimento para outro setor diferente do atual. O primeiro a jogar é sempre 0 jogador 1 (J1), seguido pelo jogador 2 (J2), jogador 3 (J3) elou jogador 4 (J4).

3. Quando um jogador se movimentar para um setor que contém um item:

a. O item deve ser armazenado pelo jogador e eliminado do tabuleiro;

b. Um novo item qualquer deve ser gerado e colocado no tabuleiro em uma posição aleatória. Lembrando que sempre devem existir 2 itens espalhados pelo tabuleiro.

c. Caso o item seja "Ouvir um boato", o jogador é movimentado para uma das 8 posições do tabuleiro adjacentes à sua posição atual (de forma aleatória).

d. No caso dos outros itens (denunciar fake news, fugir, ler uma notícia real), o jogador pode utilizá-los no início do próximo turno antes de se movimentar. e. A movimentação do jogador para outro setor encerra o seu turno.

4. Após finalizar os turnos dos jogadores, as fake news que estiverem no tabuleiro iniciam seu turno de movimentação. Cada fake news se movimenta uma única vez e de forma aleatória no tabuleiro (F1, F2 e F3). O jogo deve exibir uma mensagem informando o movimento realizado por cada fake news (com um intervalo de no mínimo 2 segundos).

5. Caso uma fake news entre em um setor que contenha um item, esta fake news é duplicada em uma das posições 8 (oito) adjacentes à posição que ela se encontra. $\mathrm{O}$ item atual deve ser removido do tabuleiro e um novo item deve surgir em uma posição qualquer do tabuleiro.

6. Após todas as fake news se movimentarem, um novo turno é iniciado, começando pelo jogador 1 (J1).

7. O jogo termina em dois casos:

a. Quando todas as fake news forem eliminadas do tabuleiro, restando pelo menos um jogador.

b. Quando todos os jogadores forem eliminados.

\section{Avaliação}

A avaliação será realizada em duas etapas: 1) entrega do código do projeto e relatório em formato PDF, e 2) entrevista dos membros do grupo. Os alunos que não enviarem o código fonte/relatório e/ou não participarem da entrevista receberão automaticamente a nota zero.

Para avaliação do trabalho, o sistema deverá atender aos conceitos da orientação a objetos listados abaixo:

1. Classes (atributos e métodos)

2. Construtores

3. Encapsulamento

4. Herança

5. Interface

6. Classe Abstrata

7. Polimorfismo

8. Coleção

\section{Observações importantes}

- Grupos de no MÁXIMO 03 estudantes.

- Sobre o Trabalho:

- Deve ser implementado na linguagem Java.

- Deve conter o nome e GRR dos integrantes do grupo como comentário na classe que contém o método main().

- Deve ser entregue pelo site replit.com, seguindo os seguintes passos:

1. Criar um usuário no replit.com.

2. Criar um projeto Java público com o nome "2023TrabalhoCl1062" (sem espaços).

3. Fazer o upload dos arquivos ".java".

4. Clicar no nome do trabalho (parte superior esquerda da tela) e no botão Publish. 5. Na nova janela, adicionar na descrição (Repl description) o primeiro nome e GRR de todos os membros do grupo e clicar nos botões "Next" até surgir o botão "Publish to Community".

6. Copiar o link da "Cover Page" e adicionar ao relatório.

- Sobre o Relatório:

- Deve ser entregue em um arquivo .pdf nomeado com o GRR de um dos membros do grupo. Ex.: grr1.pdf.

- Deve conter o nome completo de todos os membros do grupo seguido do respectivo GRR.

- Deve ser entregue via Moodle C3SL na área da disciplina de Cl1062 - Paradigmas de Programação (https://moodle.c3sl.ufpr.br/login/index.php).

- Deve ter no máximo três páginas, utilizando espaçamento simples e coluna dupla, ou no máximo quatro páginas com espaçamento 1,5 ou duplo e formato de uma coluna.

- Deve mostrar e/ou explicar onde foram usados os conceitos da orientação a objetos, principalmente os conceitos de Herança, Interface, classe Abstrata, Polimorfismo e Coleção. Na apresentação do conceito polimorfismo é importante especificar os tipos que foram utilizados.

- Pode incluir diagramas ou outro recurso visual que julgar necessário, de forma a tornar o relatório mais informativo. Não adicione imagens com o print do código. Caso queira dar destaque a alguma parte da implementação, copie o trecho de código e adicione a explicação.

- Sobre a Entrevista:

- Serão realizadas nos dias 21, 23, 28 e 30 de junho. O horário das entrevistas para cada grupo será definido pela professora da disciplina.

- A nota da entrevista será contabilizada individualmente para cada membro do grupo.

- Os alunos que receberem nota zero na entrevista, automaticamente receberão nota zero no projeto/relatório.

- O trabalho deverá estar disponível no Replit e o relatório entregue no Moodle C3SL até 16/06/2023 às 23:59. Em nenhuma hipótese serão recebidos trabalhos por outro meio e fora do prazo. Após a data de entrega, o programa não poderá ser alterado no Replit. Caso seja feita alguma alteração, o grupo automaticamente receberá nota zero.

\section{Distribuição da Nota}

A nota do trabalho é composta por $60 \%$ referente a completude e qualidade de implementação, 20\% referente ao relatório e $20 \%$ referente a entrevista. Esses valores podem variar para casos específicos. Por exemplo, os grupos que deixarem de entregar o relatório e/ou a implementação do trabalho receberão nota zero. O mesmo vale para os alunos que não participarem das entrevistas.

Alguns descontos padrão, considerando uma nota entre 0 e 100 pontos para o trabalho e relatório:

- Plágio: perda total da pontuação para todos os envolvidos. Isso é válido mesmo para casos onde o plágio se refere a apenas um trecho do código.

- Arquivos implementados em linguagens diferentes de Java serão desconsiderados.

- Arquivos com problemas ou erros de compilação/execução são de inteira responsabilidade dos grupos: desconto de 5 a 60 pontos. - Erros e avisos de compilação: desconto de 5 a 60 pontos.

- Entrega do trabalho sem o nome e GRR dos integrantes: desconto de 5 pontos.

- Entrega do relatório no formato e nome incorreto: desconto de 5 pontos.

- Erros e informações inconsistentes no relatório: desconto de 5 a 20 pontos.

\section{Dicas}

\subsection{Gerar números aleatórios}

Para gerar números aleatórios no Java utilize a classe Random. Para isso, você deve adicionar a biblioteca: import java. util. Random. Abaixo segue um exemplo de código em que cinco números aleatórios são gerados no intervalo de 1 a 10.

![](https://cdn.mathpix.com/cropped/2023_05_05_641bc44074ac8f348f08g-6.jpg?height=281&width=681&top_left_y=795&top_left_x=236)

\subsection{Adicionar cores ao Terminal}

Para adicionar cores às letras e fundo do texto, utilize a classe Cores abaixo. Na sequência, segue um exemplo de execução no método main().

![](https://cdn.mathpix.com/cropped/2023_05_05_641bc44074ac8f348f08g-6.jpg?height=1288&width=1552&top_left_y=1290&top_left_x=232)