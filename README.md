# Jogo da Velha (Tic-Tac-Toe) - Android

Este é um projeto desenvolvido no Android Studio que implementa um jogo da velha interativo.

## Funcionalidades
- Tabuleiro 3x3 construído com `GridLayout` contendo botões.
- Alternância de turnos ("X" e "O") sendo "X" o primeiro a jogar.
- Visor de status (indicando de quem é a vez, quem ganhou ou se houve empate).
- Validação automática de vitória (linhas, colunas, diagonais) ou empate.
- Proteção para impedir que células já preenchidas sejam alteradas.
- Bloqueio automático do tabuleiro quando a partida termina.
- Botão "Reiniciar Jogo" para zerar o tabuleiro facilmente e recomeçar a partida.

## Desafio Extra Implementado
- Placar persistente que conta as vitórias do Jogador X, vitórias do Jogador O e empates durante a sessão atual.
- Destaque visual (cor de fundo verde) na linha, coluna ou diagonal vencedora.

## Tecnologias e Conceitos Utilizados
- Kotlin.
- Android XML (LinearLayout e GridLayout).
- Manipulação da UI em tempo de execução.
- Lógica matricial para checagem do estado do tabuleiro.

## Instruções de uso
1. Abra o projeto no Android Studio.
2. Sincronize o Gradle.
3. Rode em um emulador ou smartphone físico (`Run 'app'`).

