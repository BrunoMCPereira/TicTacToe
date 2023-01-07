import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class jogoautomatico implements ActionListener {

    JFrame ecra = new JFrame();
    JPanel painelTexto = new JPanel();
    JPanel painelBotoes = new JPanel();
    JLabel campoTexto = new JLabel();
    JButton[][] botoes = new JButton[0][0];
    int limiteJogadas = 0;
    Random random = new Random();
    boolean Jogada_J1;
    private String letra = "";
    String jogador1;
    String jogador2;
    String jogador3;
    int matriz;
    private int countA = 0;

    jogoautomatico(String J1, String J2, int n_s) {

        matriz = n_s;
        botoes = new JButton[matriz][matriz];
        jogador1 = J1;
        jogador2 = J2;
        ecra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ecra.setSize(800, 800);
        ecra.getContentPane().setBackground(new Color(50, 50, 50));
        ecra.setTitle("Tic Tac Toe");
        ecra.setLayout(new BorderLayout());
        ecra.setVisible(true);

        campoTexto.setBackground(new Color(0, 20, 124));
        campoTexto.setForeground(new Color(25, 230, 0));
        campoTexto.setFont(new Font("Ink Free", Font.BOLD, 75));
        campoTexto.setHorizontalAlignment(JLabel.CENTER);
        campoTexto.setVerticalAlignment(JLabel.CENTER);
        campoTexto.setText("Tic Tac Toe");
        campoTexto.setOpaque(true);
        painelTexto.setLayout(new BorderLayout());
        painelTexto.setBounds(0, 0, 800, 100);
        painelBotoes.setLayout(new GridLayout(matriz, matriz));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        campoTexto.setBorder(BorderFactory.createEmptyBorder(20, 3, 3, 3));
        painelBotoes.setBackground(new Color(150, 150, 150));
        for (int i = 0; i < matriz; i++) {
            for (int j = 0; j < matriz; j++) {
                botoes[i][j] = new JButton();
                painelBotoes.add(botoes[i][j]);

            }
        }
        painelBotoes.setVisible(true);
        painelTexto.add(campoTexto);
        ecra.add(painelTexto, BorderLayout.NORTH);
        ecra.add(painelBotoes);
        jogoAutomatico();
    }

    public void jogoAutomatico() {
        String j1 = jogador1.substring(0, 2);
        String j2 = jogador2.substring(0, 2);
        double limite = Math.pow(matriz, 2);
        for (int i = 0; i < limite; i++) {
            jogadacpu("X", matriz);
            verificacaoResultado(matriz);

            jogadacpu("O", matriz);
            verificacaoResultado(matriz);
        }
    }

    public void jogadacpu(String simbolo, int numero) {
        ArrayList<Integer> coluna = new ArrayList();
        ArrayList<Integer> fila = new ArrayList();
        for (int i = 0; i < numero; i++) {
            for (int j = 0; j < numero; j++) {
                if (botoes[i][j].getText() == "") {
                    coluna.add(i);
                    fila.add(j);
                }
            }
        }
        int index = (int) (Math.random() * coluna.size());
        int x = coluna.get(index);
        int y = fila.get(index);
        botoes[x][y].setForeground(new Color(0, 0, 255));
        botoes[x][y].setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
        botoes[x][y].setText(simbolo);


    }

    public void fimDeJogo(String s, String jogador1, String jogador2, int n_s) {
        limiteJogadas = 0;
        Object[] option = { "Reiniciar", "Sair" };
        int n1 = JOptionPane.showOptionDialog(ecra, "Fim de Jogo\n" + s, "Fim de Jogo",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if (n1 == 0) {
            ecra.dispose();
            new jogoautomatico(jogador1, jogador2, matriz);
        } else {
            ecra.dispose();
        }

    }

    public void verificacaoResultado(int matriz) {
        if (matriz == 3) {
            if ((botoes[0][0].getText().equals("X")) && (botoes[0][1].getText().equals("X")) && (botoes[0][2].getText().equals("X"))) {
                xVence(0, 0, 0, 1, 0, 2, -1, -1, -1, -1,-1, -1,-1, -1,-1, -1,matriz); // 1ª linha
            } else if ((botoes[0][0].getText().equals("X")) && (botoes[1][1].getText().equals("X"))
                    && (botoes[2][2].getText().equals("X"))) {
                xVence(0, 0, 1, 1, 2, 2,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz); // Diagonal cima para baixo
            } else if ((botoes[0][0].getText().equals("X")) && (botoes[1][0].getText().equals("X"))
                    && (botoes[2][0].getText().equals("X"))) {
                xVence(0, 0, 1, 0, 2, 0,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz); // 2ª linha
            } else if ((botoes[0][1].getText().equals("X")) && (botoes[1][1].getText().equals("X"))
                    && (botoes[2][1].getText().equals("X"))) {
                xVence(0, 1, 1, 1, 2, 1,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz); // 2ª coluna
            } else if ((botoes[0][2].getText().equals("X")) && (botoes[1][1].getText().equals("X"))
                    && (botoes[2][0].getText().equals("X"))) {
                xVence(0, 2, 1, 1, 2, 0,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz); // Diagonal Baixo para cima
            } else if ((botoes[0][2].getText().equals("X")) && (botoes[1][2].getText().equals("X"))
                    && (botoes[2][2].getText().equals("X"))) {
                xVence(0, 2, 1, 2, 2, 2,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[1][0].getText().equals("X")) && (botoes[1][1].getText().equals("X"))
                    && (botoes[1][2].getText().equals("X"))) {
                xVence(1, 0, 1, 1, 1, 2,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[2][0].getText().equals("X")) && (botoes[2][1].getText().equals("X"))
                    && (botoes[2][2].getText().equals("X"))) {
                xVence(2, 0, 2, 1, 2, 2,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][0].getText().equals("O")) && (botoes[0][1].getText().equals("O"))
                    && (botoes[0][2].getText().equals("O"))) {
                oVence(0, 0, 0, 1, 0, 2,  -1, -1, -1, -1,-1, -1,-1, -1, -1,-1, matriz);
            } else if ((botoes[0][0].getText().equals("O")) && (botoes[1][1].getText().equals("O"))
                    && (botoes[2][2].getText().equals("O"))) {
                oVence(0, 0, 1, 1, 2, 2,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][0].getText().equals("O")) && (botoes[1][0].getText().equals("O"))
                    && (botoes[2][0].getText().equals("O"))) {
                oVence(0, 0, 1, 0, 2, 0,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][1].getText().equals("O")) && (botoes[1][1].getText().equals("O"))
                    && (botoes[2][1].getText().equals("O"))) {
                oVence(0, 1, 1, 1, 2, 1,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][2].getText().equals("O")) && (botoes[1][1].getText().equals("O"))
                    && (botoes[2][0].getText().equals("O"))) {
                oVence(0, 2, 1, 1, 2, 0,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][2].getText().equals("O")) && (botoes[1][2].getText().equals("O"))
                    && (botoes[2][2].getText().equals("O"))) {
                oVence(0, 2, 1, 2, 2, 2,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[1][0].getText().equals("O")) && (botoes[1][1].getText().equals("O"))
                    && (botoes[1][2].getText().equals("O"))) {
                oVence(1, 0, 1, 1, 1, 2,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[2][0].getText().equals("O")) && (botoes[2][1].getText().equals("O"))
                    && (botoes[2][2].getText().equals("O"))) {
                oVence(2, 0, 2, 1, 2, 2,  -1, -1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if (limiteJogadas == 9) {
                campoTexto.setText("Jogo Empatado");
            }
        } else if (matriz == 4) {
            if ((botoes[0][0].getText().equals("X")) && (botoes[0][1].getText().equals("X")) && (botoes[0][2].getText().equals("X"))&& (botoes[0][3].getText() == "X")) {
                xVence(0, 0, 0, 1, 0, 2, 0, 3, -1, -1,-1, -1,-1, -1,-1, -1,matriz);
            } else if ((botoes[0][0].getText().equals("X")) && (botoes[1][1].getText().equals("X"))
                    && (botoes[2][2].getText().equals("X"))&& (botoes[3][3].getText().equals("X"))) {
                xVence(0, 0, 1, 1, 2, 2,  3, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][0].getText().equals("X")) && (botoes[1][0].getText().equals("X"))
                    && (botoes[2][0].getText().equals("X"))&& (botoes[3][0].getText().equals("X"))) {
                xVence(0, 0, 1, 0, 2, 0,  3, 0, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][1].getText().equals("X")) && (botoes[1][1].getText().equals("X"))
                    && (botoes[2][1].getText().equals("X"))&& (botoes[3][1].getText().equals("X"))) {
                xVence(0, 1, 1, 1, 2, 1,  3, 1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][3].getText().equals("X")) && (botoes[1][2].getText().equals("X"))
                    && (botoes[2][1].getText().equals("X"))&& (botoes[3][0].getText().equals("X"))) {
                xVence(0, 2, 1, 2, 2, 1,  3, 0, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][2].getText().equals("X")) && (botoes[1][2].getText().equals("X"))
                    && (botoes[2][2].getText().equals("X"))&& (botoes[3][2].getText().equals("X"))) {
                xVence(0, 2, 1, 2, 2, 2,  3, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[1][0].getText().equals("X")) && (botoes[1][1].getText().equals("X"))
                    && (botoes[1][2].getText().equals("X"))&& (botoes[1][3].getText().equals("X"))) {
                xVence(1, 0, 1, 1, 1, 2,  1, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[2][0].getText().equals("X")) && (botoes[2][1].getText().equals("X"))
                    && (botoes[2][2].getText().equals("X"))&& (botoes[2][3].getText().equals("X"))) {
                xVence(2, 0, 2, 1, 2, 2,  2, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[3][0].getText().equals("X")) && (botoes[3][1].getText().equals("X"))
                    && (botoes[3][2].getText().equals("X"))&& (botoes[3][3].getText().equals("X"))) {
                xVence(3, 0, 3, 1, 3, 2,  3, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            }else if ((botoes[0][3].getText().equals("X")) && (botoes[1][3].getText().equals("X"))
                    && (botoes[2][3].getText().equals("X"))&& (botoes[3][3].getText().equals("X"))) {
                xVence(0, 3, 1, 3, 2, 3,  3, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            }
            else if ((botoes[0][0].getText().equals("O")) && (botoes[0][1].getText().equals("O"))
                    && (botoes[0][2].getText() == "O")&& (botoes[0][3].getText() == "O")) {
                oVence(0, 0, 0, 1, 0, 2, 0, 3, -1, -1,-1, -1,-1, -1,-1, -1,matriz);
            } else if ((botoes[0][0].getText() == "O") && (botoes[1][1].getText() == "O")
                    && (botoes[2][2].getText() == "O")&& (botoes[3][3].getText() == "O")) {
                oVence(0, 0, 1, 1, 2, 2,  3, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][0].getText() == "O") && (botoes[1][0].getText() == "O")
                    && (botoes[2][0].getText() == "O")&& (botoes[3][0].getText() == "O")) {
                oVence(0, 0, 1, 0, 2, 0,  3, 0, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][1].getText() == "O") && (botoes[1][1].getText() == "O")
                    && (botoes[2][1].getText() == "O")&& (botoes[3][1].getText() == "O")) {
                oVence(0, 1, 1, 1, 2, 1,  3, 1, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][3].getText() == "O") && (botoes[1][2].getText() == "O")
                    && (botoes[2][1].getText() == "O")&& (botoes[3][0].getText() == "O")) {
                oVence(0, 2, 1, 2, 2, 1,  3, 0, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][2].getText() == "O") && (botoes[1][2].getText() == "O")
                    && (botoes[2][2].getText() == "O")&& (botoes[3][3].getText() == "O")) {
                oVence(0, 2, 1, 2, 2, 2,  3, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[1][0].getText() == "O") && (botoes[1][1].getText() == "O")
                    && (botoes[1][2].getText() == "O")&& (botoes[1][3].getText() == "O")) {
                oVence(1, 0, 1, 1, 1, 2,  1, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[2][0].getText() == "O") && (botoes[2][1].getText() == "O")
                    && (botoes[2][2].getText() == "O")&& (botoes[2][3].getText() == "O")) {
                oVence(2, 0, 2, 1, 2, 2,  2, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[3][0].getText() == "O") && (botoes[3][1].getText() == "O")
                    && (botoes[3][2].getText() == "O")&& (botoes[3][3].getText() == "O")) {
                oVence(3, 0, 3, 1, 3, 2,  3, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            }else if ((botoes[0][3].getText() == "O") && (botoes[1][3].getText() == "O")
                    && (botoes[2][3].getText() == "O")&& (botoes[3][3].getText() == "O")) {
                oVence(0, 3, 1, 3, 2, 3,  3, 3, -1, -1,-1, -1,-1, -1,-1, -1, matriz);
            }
            else if (limiteJogadas == 16) {
                campoTexto.setText("Jogo Empatado");
            }
        }
        else if (matriz == 5) {
            if ((botoes[0][0].getText().equals("X")) && (botoes[0][1].getText().equals("X")) && (botoes[0][2].getText().equals("X"))
                    && (botoes[0][3].getText().equals("X")) && (botoes[0][4].getText().equals("X"))) {
                xVence(0, 0, 0, 1, 0, 2, 0, 3,0, 4,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][0].getText().equals("X")) && (botoes[1][1].getText().equals("X"))
                    && (botoes[2][2].getText().equals("X")) && (botoes[3][3].getText().equals("X")) && (botoes[4][4].getText() == "X")) {
                xVence(0, 0, 1, 1, 2, 2, 3, 3,4, 4,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][0].getText().equals("X")) && (botoes[1][0].getText().equals("X"))
                    && (botoes[2][0].getText().equals("X")) && (botoes[3][0].getText().equals("X")) && (botoes[4][0].getText() == "X")) {
                xVence(0, 0, 1, 0, 2, 0, 3, 0,4, 0,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][1].getText().equals("X")) && (botoes[1][1].getText().equals("X"))
                    && (botoes[2][1].getText().equals("X")) && (botoes[3][1].getText().equals("X")) && (botoes[4][1].getText() == "X")) {
                xVence(0, 1, 1, 1, 2, 1, 3, 1,4, 1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][4].getText().equals("X")) && (botoes[1][3].getText().equals("X"))
                    && (botoes[2][2].getText().equals("X")) && (botoes[3][1].getText().equals("X")) && (botoes[4][0].getText() == "X")) {
                xVence(0, 4, 1, 3, 2, 2, 3, 1,4, 0,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][2].getText().equals("X")) && (botoes[1][2].getText().equals("X"))
                    && (botoes[2][2].getText().equals("X")) && (botoes[3][2].getText().equals("X")) && (botoes[4][2].getText() == "X")) {
                xVence(0, 2, 1, 2, 2, 2, 3, 2,4, 2,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[1][0].getText().equals("X")) && (botoes[1][1].getText().equals("X"))
                    && (botoes[1][2].getText().equals("X")) && (botoes[1][3].getText().equals("X")) && (botoes[1][4].getText() == "X")) {
                xVence(1, 0, 1, 1, 1, 2, 1, 3,1, 4,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[2][0].getText().equals("X")) && (botoes[2][1].getText().equals("X"))
                    && (botoes[2][2].getText().equals("X")) && (botoes[2][3].getText().equals("X")) && (botoes[2][4].getText() == "X")) {
                xVence(2, 0, 2, 1, 2, 2, 2, 3,2, 4,-1, -1,-1, -1,-1, -1, matriz);
            }else if ((botoes[3][0].getText().equals("X")) && (botoes[3][1].getText().equals("X"))
                    && (botoes[3][2].getText().equals("X"))&& (botoes[3][3].getText().equals("X"))&& (botoes[3][4].getText() == "X")) {
                xVence(3, 0, 3, 1, 3, 2,  3, 3, 3, 4,-1, -1,-1, -1,-1, -1, matriz);
            }else if ((botoes[0][3].getText().equals("X")) && (botoes[1][3].getText().equals("X"))
                    && (botoes[2][3].getText().equals("X"))&& (botoes[3][3].getText().equals("X"))&& (botoes[4][3].getText() == "X")) {
                xVence(0, 3, 1, 3, 2, 3,  3, 3, 4, 3,-1, -1,-1, -1,-1, -1, matriz);
            }else if ((botoes[4][0].getText().equals("X")) && (botoes[4][1].getText().equals("X"))
                    && (botoes[4][2].getText().equals("X"))&& (botoes[4][3].getText().equals("X"))&& (botoes[4][4].getText().equals("X"))) {
                xVence(4, 0, 4, 1, 4, 2,  4, 3, 4, 4,-1, -1,-1, -1,-1, -1, matriz);
            }else if ((botoes[0][4].getText().equals("X")) && (botoes[1][4].getText().equals("X"))
                    && (botoes[2][4].getText().equals("X"))&& (botoes[3][4].getText().equals("X"))&& (botoes[4][4].getText().equals("X"))) {
                xVence(0, 4, 1, 4, 2, 4,  3, 4, 4, 4,-1, -1,-1, -1,-1, -1, matriz);
            }

            else if ((botoes[0][0].getText() == "O") && (botoes[0][1].getText() == "O")
                    && (botoes[0][2].getText() == "O") && (botoes[0][3].getText() == "O") && (botoes[0][4].getText() == "O")) {
                oVence(0, 0, 0, 1, 0, 2, 0, 3,0, 4,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][0].getText() == "O") && (botoes[1][1].getText() == "O")
                    && (botoes[2][2].getText() == "O") && (botoes[3][3].getText() == "O") && (botoes[4][4].getText() == "O")) {
                oVence(0, 0, 1, 1, 2, 2, 3, 3,4, 4,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][0].getText() == "O") && (botoes[1][0].getText() == "O")
                    && (botoes[2][0].getText() == "O") && (botoes[3][0].getText() == "O") && (botoes[4][0].getText() == "O")) {
                oVence(0, 0, 1, 0, 2, 0, 3, 0,4, 0,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][1].getText() == "O") && (botoes[1][1].getText() == "O")
                    && (botoes[2][1].getText() == "O") && (botoes[3][1].getText() == "O") && (botoes[4][1].getText() == "O")) {
                oVence(0, 1, 1, 1, 2, 1, 3, 1,4, 1,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][4].getText() == "O") && (botoes[1][3].getText() == "O")
                    && (botoes[2][2].getText() == "O") && (botoes[3][1].getText() == "O") && (botoes[4][0].getText() == "O")) {
                oVence(0, 4, 1, 3, 2, 2, 3, 1,4, 0,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][2].getText() == "O") && (botoes[1][2].getText() == "O")
                    && (botoes[2][2].getText() == "O") && (botoes[3][2].getText() == "O") && (botoes[4][2].getText() == "O")) {
                oVence(0, 2, 1, 2, 2, 2, 3, 2,4, 2,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[1][0].getText() == "O") && (botoes[1][1].getText() == "O")
                    && (botoes[1][2].getText() == "O") && (botoes[1][3].getText() == "O") && (botoes[1][4].getText() == "O")) {
                oVence(1, 0, 1, 1, 1, 2, 1, 3,1, 4,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[2][0].getText() == "O") && (botoes[2][1].getText() == "O")
                    && (botoes[2][2].getText() == "O") && (botoes[2][3].getText() == "O") && (botoes[2][4].getText() == "O")) {
                oVence(2, 0, 2, 1, 2, 2, 2, 3,2, 4,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[3][0].getText() == "O") && (botoes[3][1].getText() == "O")
                    && (botoes[3][2].getText() == "O")&& (botoes[3][3].getText() == "O")&& (botoes[3][4].getText() == "O")) {
                oVence(3, 0, 3, 1, 3, 2,  3, 3, 3, 4,-1, -1,-1, -1,-1, -1, matriz);
            }else if ((botoes[0][3].getText() == "O") && (botoes[1][3].getText() == "O")
                    && (botoes[2][3].getText() == "O")&& (botoes[3][3].getText() == "O")&& (botoes[4][3].getText() == "O")) {
                oVence(0, 3, 1, 3, 2, 3,  3, 3, 4, 3,-1, -1,-1, -1,-1, -1, matriz);
            }else if ((botoes[4][0].getText() == "O") && (botoes[4][1].getText() == "O")
                    && (botoes[4][2].getText() == "O")&& (botoes[4][3].getText() == "X")&& (botoes[4][4].getText() == "O")) {
                oVence(4, 0, 4, 1, 4, 2,  4, 3, 4, 4,-1, -1,-1, -1,-1, -1, matriz);
            }else if ((botoes[0][4].getText() == "O") && (botoes[1][4].getText() == "O")
                    && (botoes[2][4].getText() == "O")&& (botoes[3][4].getText() == "O")&& (botoes[4][4].getText() == "O")) {
                oVence(0, 4, 1, 4, 2, 4,  3, 4, 4, 4,-1, -1,-1, -1,-1, -1, matriz);
            } else if (limiteJogadas == 25) {
                campoTexto.setText("Jogo Empatado");
            }}
        else if (matriz == 6) {
            if ((botoes[0][0].getText() == "X") && (botoes[0][1].getText() == "X") && (botoes[0][2].getText() == "X")
                    && (botoes[0][3].getText() == "X") && (botoes[0][4].getText() == "X") && (botoes[0][5].getText() == "X")) {
                xVence(0, 0, 0, 1, 0, 2, 0, 3,0,4,0, 5,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][0].getText() == "X") && (botoes[1][1].getText() == "X")
                    && (botoes[2][2].getText() == "X") && (botoes[3][3].getText() == "X") && (botoes[4][4].getText() == "X") && (botoes[5][5].getText() == "X")) {
                xVence(0, 0, 1, 1, 2, 2, 3, 3,4,4,5, 5,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][0].getText() == "X") && (botoes[1][0].getText() == "X")
                    && (botoes[2][0].getText() == "X") && (botoes[3][0].getText() == "X") && (botoes[4][0].getText() == "X") && (botoes[5][0].getText() == "X")) {
                xVence(0, 0, 1, 0, 2, 0, 3, 0,4,0,5, 0,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][1].getText() == "X") && (botoes[1][1].getText() == "X")
                    && (botoes[2][1].getText() == "X") && (botoes[3][1].getText() == "X") && (botoes[4][1].getText() == "X") && (botoes[5][1].getText() == "X")) {
                xVence(0, 1, 1, 1, 2, 1, 3, 1,4,1,5, 1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][5].getText() == "X") && (botoes[1][4].getText() == "X")
                    && (botoes[2][3].getText() == "X") && (botoes[3][2].getText() == "X") && (botoes[4][1].getText() == "X") && (botoes[5][0].getText() == "X")) {
                xVence(0, 5, 1, 4, 2, 3, 3, 2,5,0,-1, -1,-1, -1,-1, -1, matriz);
            } else if ((botoes[0][2].getText() == "X") && (botoes[1][2].getText() == "X")
                    && (botoes[2][2].getText() == "X") && (botoes[3][2].getText() == "X") && (botoes[4][2].getText() == "X") && (botoes[5][2].getText() == "X")) {
                xVence(0, 2, 1, 2, 2, 2, 3, 2,4,2,5, 2,-1, -1,-1, -1, matriz);
            } else if ((botoes[1][0].getText() == "X") && (botoes[1][1].getText() == "X")
                    && (botoes[1][2].getText() == "X") && (botoes[1][3].getText() == "X") && (botoes[1][4].getText() == "X") && (botoes[1][5].getText() == "X")) {
                xVence(1, 0, 1, 1, 1, 2, 1, 3,1,4,1, 5,-1, -1,-1, -1, matriz);
            } else if ((botoes[2][0].getText() == "X") && (botoes[2][1].getText() == "X")
                    && (botoes[2][2].getText() == "X") && (botoes[2][3].getText() == "X") && (botoes[2][4].getText() == "X") && (botoes[2][5].getText() == "X")) {
                xVence(2, 0, 2, 1, 2, 2, 2, 3,2,4,2, 5,-1, -1,-1, -1, matriz);
            }
            else if ((botoes[3][0].getText() == "X") && (botoes[3][1].getText() == "X")
                    && (botoes[3][2].getText() == "X")&& (botoes[3][3].getText() == "X")&& (botoes[3][4].getText() == "X")&& (botoes[3][5].getText() == "X")) {
                xVence(3, 0, 3, 1, 3, 2,  3, 3, 3, 4,3, 5,-1, -1,-1, -1, matriz);
            }else if ((botoes[0][3].getText() == "X") && (botoes[1][3].getText() == "X")
                    && (botoes[2][3].getText() == "X")&& (botoes[3][3].getText() == "X")&& (botoes[4][3].getText() == "X")&& (botoes[5][3].getText() == "X")) {
                xVence(0, 3, 1, 3, 2, 3,  3, 3, 4, 3,5, 3,-1, -1,-1, -1, matriz);
            }}else if ((botoes[4][0].getText() == "X") && (botoes[4][1].getText() == "X")
                && (botoes[4][2].getText() == "X")&& (botoes[4][3].getText() == "X")&& (botoes[4][4].getText() == "X")&& (botoes[4][5].getText() == "X")) {
            xVence(4, 0, 4, 1, 4, 2,  4, 3, 4, 4,4, 5,-1, -1,-1, -1, matriz);
        }else if ((botoes[0][4].getText() == "X") && (botoes[1][4].getText() == "X")
                && (botoes[2][4].getText() == "X")&& (botoes[3][4].getText() == "X")&& (botoes[4][4].getText() == "X")&& (botoes[5][4].getText() == "X")) {
            xVence(0, 4, 1, 4, 2, 4,  3, 4, 4, 4,5, 4,-1, -1,-1, -1, matriz);
        }else if ((botoes[5][0].getText() == "X") && (botoes[5][1].getText() == "X")
                && (botoes[5][2].getText() == "X")&& (botoes[5][3].getText() == "X")&& (botoes[5][4].getText() == "X")&& (botoes[5][5].getText() == "X")) {
            xVence(5, 0, 5, 1, 5, 2,  5, 3, 5, 4,5, 5,-1, -1,-1, -1, matriz);
        }else if ((botoes[0][5].getText() == "X") && (botoes[1][5].getText() == "X")
                && (botoes[2][5].getText() == "X")&& (botoes[3][5].getText() == "X")&& (botoes[4][5].getText() == "X")&& (botoes[5][5].getText() == "X")) {
            xVence(0, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 5, -1, -1, -1, -1, matriz);
        }else if ((botoes[0][0].getText() == "O") && (botoes[0][1].getText() == "O")
                && (botoes[0][2].getText() == "O") && (botoes[0][3].getText() == "O") && (botoes[0][4].getText() == "O") && (botoes[0][5].getText() == "O")) {
            oVence(0, 0, 0, 1, 0, 2, 0, 3,0,4,0, 5,-1, -1,-1, -1, matriz);
        } else if ((botoes[0][0].getText() == "O") && (botoes[1][1].getText() == "O")
                && (botoes[2][2].getText() == "O") && (botoes[3][3].getText() == "O") && (botoes[4][4].getText() == "O") && (botoes[5][5].getText() == "O")) {
            oVence(0, 0, 1, 1, 2, 2, 3, 3,4,4,5, 5,-1, -1,-1, -1, matriz);
        } else if ((botoes[0][0].getText() == "O") && (botoes[1][0].getText() == "O")
                && (botoes[2][0].getText() == "O") && (botoes[3][0].getText() == "O") && (botoes[4][0].getText() == "O") && (botoes[5][0].getText() == "O")) {
            oVence(0, 0, 1, 0, 2, 0, 3, 0,4,0,5, 0,-1, -1,-1, -1, matriz);
        } else if ((botoes[0][1].getText() == "O") && (botoes[1][1].getText() == "O")
                && (botoes[2][1].getText() == "O") && (botoes[3][1].getText() == "O") && (botoes[4][1].getText() == "O") && (botoes[5][1].getText() == "O")) {
            oVence(0, 1, 1, 1, 2, 1, 3, 1,4,1,5, 1,-1, -1,-1, -1, matriz);
        } else if ((botoes[0][5].getText() == "O") && (botoes[1][4].getText() == "O")
                && (botoes[3][2].getText() == "O") && (botoes[2][3].getText() == "O") && (botoes[4][1].getText() == "O") && (botoes[5][0].getText() == "O")) {
            oVence(0, 5, 1, 4, 3, 2, 2, 3,4,1,5, 0,-1, -1,-1, -1, matriz);
        } else if ((botoes[0][2].getText() == "O") && (botoes[1][2].getText() == "O")
                && (botoes[2][2].getText() == "O") && (botoes[3][2].getText() == "O") && (botoes[4][2].getText() == "O") && (botoes[5][2].getText() == "O")) {
            oVence(0, 2, 1, 2, 2, 2, 3, 2,4,2,5, 2,-1, -1,-1, -1, matriz);
        } else if ((botoes[1][0].getText() == "O") && (botoes[1][1].getText() == "O")
                && (botoes[1][2].getText() == "O") && (botoes[1][3].getText() == "O") && (botoes[1][4].getText() == "O") && (botoes[1][5].getText() == "O")) {
            oVence(1, 0, 1, 1, 1, 2, 1, 3,1,4,1, 5,-1, -1,-1, -1, matriz);
        } else if ((botoes[2][0].getText() == "O") && (botoes[2][1].getText() == "O")
                && (botoes[2][2].getText() == "O") && (botoes[2][3].getText() == "O") && (botoes[2][4].getText() == "O") && (botoes[2][5].getText() == "O")) {
            oVence(2, 0, 2, 1, 2, 2, 2, 3,2,4,2, 5,-1, -1,-1, -1, matriz);
        } else if ((botoes[3][0].getText().equals("O")) && (botoes[3][1].getText().equals("O")) && (botoes[3][2].getText().equals("O"))&& (botoes[3][3].getText().equals("O"))&& (botoes[3][4].getText().equals("O"))&& (botoes[3][5].getText().equals("O"))) {
            oVence(3, 0, 3, 1, 3, 2,  3, 3, 3, 4,3, 5,-1, -1,-1, -1, matriz);
        }else if ((botoes[0][3].getText().equals("O")) && (botoes[1][3].getText().equals("O"))
                && (botoes[2][3].getText().equals("O"))&& (botoes[3][3].getText().equals("O"))&& (botoes[4][3].getText().equals("O"))&& (botoes[5][3].getText().equals("O"))) {
            oVence(0, 3, 1, 3, 2, 3,  3, 3, 4, 3,5, 3,-1, -1,-1, -1, matriz);
        }else if ((botoes[4][0].getText().equals("O")) && (botoes[4][1].getText().equals("O"))
                && (botoes[4][2].getText().equals("O"))&& (botoes[4][3].getText().equals("O"))&& (botoes[4][4].getText().equals("O"))&& (botoes[4][5].getText().equals("O"))) {
            oVence(4, 0, 4, 1, 4, 2,  4, 3, 4, 4,4, 5,-1, -1,-1, -1, matriz);
        }else if ((botoes[0][4].getText().equals("O")) && (botoes[1][4].getText().equals("O"))
                && (botoes[2][4].getText().equals("O"))&& (botoes[3][4].getText().equals("O"))&& (botoes[4][4].getText().equals("O"))&& (botoes[5][4].getText().equals("O"))) {
            oVence(0, 4, 1, 4, 2, 4,  3, 4, 4, 4,5, 4,-1, -1,-1, -1, matriz);
        }else if ((botoes[5][0].getText().equals("O")) && (botoes[5][1].getText().equals("O"))
                && (botoes[5][2].getText().equals("O"))&& (botoes[5][3].getText().equals("O"))&& (botoes[5][4].getText().equals("O"))&& (botoes[5][5].getText().equals("O"))) {
            oVence(5, 0, 5, 1, 5, 2,  5, 3, 5, 4,5, 5,-1, -1,-1, -1, matriz);
        }else if ((botoes[0][5].getText().equals("O")) && (botoes[1][5].getText().equals("O"))
                && (botoes[2][5].getText().equals("O"))&& (botoes[3][5].getText().equals("O"))&& (botoes[4][5].getText().equals("O"))&& (botoes[5][5].getText().equals("O"))) {
            oVence(0, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 5, -1, -1, -1, -1, matriz);
        }else if (limiteJogadas == 36) {
            campoTexto.setText("Jogo Empatado");
        }
        else if (matriz == 7) {
            if ((botoes[0][0].getText() == "X") && (botoes[0][1].getText() == "X") && (botoes[0][2].getText() == "X")
                    && (botoes[0][3].getText() == "X") && (botoes[0][4].getText() == "X") && (botoes[0][5].getText() == "X") && (botoes[0][6].getText() == "X")) {
                xVence(0, 0, 0, 1, 0, 2, 0, 3,0,4,0, 5,0, 6,-1,-1, matriz);
            } else if ((botoes[0][0].getText() == "X") && (botoes[1][1].getText() == "X")
                    && (botoes[2][2].getText() == "X") && (botoes[3][3].getText() == "X") && (botoes[4][4].getText() == "X") && (botoes[5][5].getText() == "X")&& (botoes[6][6].getText() == "X")) {
                xVence(0, 0, 1, 1, 2, 2, 3, 3,4,4,5, 5,6, 6,-1,-1, matriz);
            } else if ((botoes[0][0].getText() == "X") && (botoes[1][0].getText() == "X")
                    && (botoes[2][0].getText() == "X") && (botoes[3][0].getText() == "X") && (botoes[4][0].getText() == "X") && (botoes[5][0].getText() == "X")&& (botoes[6][0].getText() == "X")) {
                xVence(0, 0, 1, 0, 2, 0, 3, 0,4,0,5, 0,6, 0,-1,-1, matriz);
            } else if ((botoes[0][1].getText() == "X") && (botoes[1][1].getText() == "X")
                    && (botoes[2][1].getText() == "X") && (botoes[3][1].getText() == "X") && (botoes[4][1].getText() == "X") && (botoes[5][1].getText() == "X")&& (botoes[6][1].getText() == "X")) {
                xVence(0, 1, 1, 1, 2, 1, 3, 1,4,1,5, 1,6, 1,-1,-1, matriz);
            } else if ((botoes[0][6].getText() == "X") && (botoes[1][5].getText() == "X")
                    && (botoes[2][4].getText() == "X") && (botoes[3][3].getText() == "X") && (botoes[4][2].getText() == "X") && (botoes[5][1].getText() == "X")&& (botoes[6][0].getText() == "X")) {
                xVence(0, 6, 1, 5, 2, 4, 3, 3,4,2,5, 1,6, 0,-1,-1, matriz);
            } else if ((botoes[0][2].getText() == "X") && (botoes[1][2].getText() == "X")
                    && (botoes[2][2].getText() == "X") && (botoes[3][2].getText() == "X") && (botoes[4][2].getText() == "X") && (botoes[5][2].getText() == "X") && (botoes[6][2].getText() == "X")) {
                xVence(0, 2, 1, 2, 2, 2, 3, 2,4,2,5, 2,6, 2,-1,-1, matriz);
            } else if ((botoes[1][0].getText() == "X") && (botoes[1][1].getText() == "X")
                    && (botoes[1][2].getText() == "X") && (botoes[1][3].getText() == "X") && (botoes[1][4].getText() == "X") && (botoes[1][5].getText() == "X")&& (botoes[1][6].getText() == "X")) {
                xVence(1, 0, 1, 1, 1, 2, 1, 3,1,4,1, 5,1, 6,-1,-1, matriz);
            } else if ((botoes[2][0].getText() == "X") && (botoes[2][1].getText() == "X")
                    && (botoes[2][2].getText() == "X") && (botoes[2][3].getText() == "X") && (botoes[2][4].getText() == "X") && (botoes[2][5].getText() == "X")&& (botoes[2][6].getText() == "X")) {
                xVence(2, 0, 2, 1, 2, 2, 2, 3,2,4,2, 5,2, 6,-1,-1, matriz);
            }else if ((botoes[3][0].getText() == "X") && (botoes[3][1].getText() == "X")
                    && (botoes[3][2].getText() == "X")&& (botoes[3][3].getText() == "X")&& (botoes[3][4].getText() == "X") && (botoes[3][5].getText() == "X")&& (botoes[3][6].getText() == "X")) {
                xVence(3, 0, 3, 1, 3, 2,  3, 3, 3, 4,3, 5,3, 6,-1, -1, matriz);
            }else if ((botoes[0][3].getText() == "X") && (botoes[1][3].getText() == "X")
                    && (botoes[2][3].getText() == "X")&& (botoes[3][3].getText() == "X")&& (botoes[4][3].getText() == "X")&& (botoes[5][3].getText() == "X")&& (botoes[6][3].getText() == "X")) {
                xVence(0, 3, 1, 3, 2, 3,  3, 3, 4, 3,5, 3,6, 3,-1, -1, matriz);
            }}else if ((botoes[4][0].getText() == "X") && (botoes[4][1].getText() == "X")
                && (botoes[4][2].getText() == "X")&& (botoes[4][3].getText() == "X")&& (botoes[4][4].getText() == "X")&& (botoes[4][5].getText() == "X")&& (botoes[4][6].getText() == "X")) {
            xVence(4, 0, 4, 1, 4, 2,  4, 3, 4, 4,4, 5,4, 6,-1, -1, matriz);
        }else if ((botoes[0][4].getText() == "X") && (botoes[1][4].getText() == "X")
                && (botoes[2][4].getText() == "X")&& (botoes[3][4].getText() == "X")&& (botoes[4][4].getText() == "X")&& (botoes[5][4].getText() == "X")&& (botoes[6][4].getText() == "X")) {
            xVence(0, 4, 1, 4, 2, 4,  3, 4, 4, 4,5, 4,6, 4,-1, -1, matriz);
        }else if ((botoes[5][0].getText() == "X") && (botoes[5][1].getText() == "X")
                && (botoes[5][2].getText() == "X")&& (botoes[5][3].getText() == "X")&& (botoes[5][4].getText() == "X")&& (botoes[5][5].getText() == "X")&& (botoes[5][6].getText() == "X")) {
            xVence(5, 0, 5, 1, 5, 2,  5, 3, 5, 4,5, 5,5, 6,-1, -1, matriz);
        }else if ((botoes[0][5].getText() == "X") && (botoes[1][5].getText() == "X")
                && (botoes[2][5].getText() == "X")&& (botoes[3][5].getText() == "X")&& (botoes[4][5].getText() == "X")&& (botoes[5][5].getText() == "X")&& (botoes[6][5].getText() == "X")) {
            xVence(0, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 5, -1, -1, matriz);
        }else if ((botoes[6][0].getText() == "X") && (botoes[6][1].getText() == "X")
                && (botoes[6][2].getText() == "X")&& (botoes[6][3].getText() == "X")&& (botoes[6][4].getText() == "X")&& (botoes[6][5].getText() == "X")&& (botoes[6][6].getText() == "X")) {
            xVence(6, 0, 6, 1, 6, 2,  6, 3, 6, 4,6, 5,6, 6,-1, -1, matriz);
        }else if ((botoes[0][6].getText() == "X") && (botoes[1][6].getText() == "X")
                && (botoes[2][6].getText() == "X")&& (botoes[3][6].getText() == "X")&& (botoes[4][6].getText() == "X")&& (botoes[5][6].getText() == "X")&& (botoes[6][6].getText() == "X")) {
            xVence(0, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6, 6, -1, -1, matriz);
        }else if ((botoes[0][0].getText() == "O") && (botoes[0][1].getText() == "O")
                && (botoes[0][2].getText() == "O") && (botoes[0][3].getText() == "O") && (botoes[0][4].getText() == "O") && (botoes[0][5].getText() == "O")&& (botoes[0][6].getText() == "O")) {
            oVence(0, 0, 0, 1, 0, 2, 0, 3,0,4,0, 5,0, 6,-1,-1, matriz);
        } else if ((botoes[0][0].getText() == "O") && (botoes[1][1].getText() == "O")
                && (botoes[2][2].getText() == "O") && (botoes[3][3].getText() == "O") && (botoes[4][4].getText() == "O") && (botoes[5][5].getText() == "O")&& (botoes[6][6].getText() == "O")) {
            oVence(0, 0, 1, 1, 2, 2, 3, 3,4,4,5, 5,6, 6,-1,-1, matriz);
        } else if ((botoes[0][0].getText() == "O") && (botoes[1][0].getText() == "O")
                && (botoes[2][0].getText() == "O") && (botoes[3][0].getText() == "O") && (botoes[4][0].getText() == "O") && (botoes[5][0].getText() == "O")&& (botoes[6][0].getText() == "O")) {
            oVence(0, 0, 1, 0, 2, 0, 3, 0,4,0,5, 0,6, 0,-1,-1, matriz);
        } else if ((botoes[0][1].getText() == "O") && (botoes[1][1].getText() == "O")
                && (botoes[2][1].getText() == "O") && (botoes[3][1].getText() == "O") && (botoes[4][1].getText() == "O") && (botoes[5][1].getText() == "O")&& (botoes[6][1].getText() == "O")) {
            oVence(0, 1, 1, 1, 2, 1, 3, 1,4,1,5, 1,6, 1,-1,-1, matriz);
        } else if ((botoes[0][6].getText() == "O") && (botoes[1][5].getText() == "O")
                && (botoes[2][4].getText() == "O") && (botoes[3][3].getText() == "O") && (botoes[4][2].getText() == "O") && (botoes[5][1].getText() == "O")&& (botoes[6][0].getText() == "O")) {
            oVence(0, 6, 1, 5, 2, 4, 3, 3,4,2,5, 1,6, 0,-1,-1, matriz);
        } else if ((botoes[0][2].getText() == "O") && (botoes[1][2].getText() == "O")
                && (botoes[2][2].getText() == "O") && (botoes[3][2].getText() == "O") && (botoes[4][2].getText() == "O") && (botoes[5][2].getText() == "O")&& (botoes[6][2].getText() == "O")) {
            oVence(0, 2, 1, 2, 2, 2, 3, 2,4,2,5, 2,6, 2,-1,-1, matriz);
        } else if ((botoes[1][0].getText() == "O") && (botoes[1][1].getText() == "O")
                && (botoes[1][2].getText() == "O") && (botoes[1][3].getText() == "O") && (botoes[1][4].getText() == "O") && (botoes[1][5].getText() == "O") && (botoes[1][6].getText() == "O")) {
            oVence(1, 0, 1, 1, 1, 2, 1, 3,1,4,1, 5,1, 6,-1,-1, matriz);
        } else if ((botoes[2][0].getText() == "O") && (botoes[2][1].getText() == "O")
                && (botoes[2][2].getText() == "O") && (botoes[2][3].getText() == "O") && (botoes[2][4].getText() == "O") && (botoes[2][5].getText() == "O")&& (botoes[2][6].getText() == "O")) {
            oVence(2, 0, 2, 1, 2, 2, 2, 3,2,4,2, 5,2, 6,-1,-1, matriz);
        }else if ((botoes[0][3].getText().equals("O")) && (botoes[1][3].getText().equals("O"))
                && (botoes[2][3].getText().equals("O"))&& (botoes[3][3].getText().equals("O"))&& (botoes[4][3].getText().equals("O"))&& (botoes[5][3].getText().equals("O"))&& (botoes[6][3].getText().equals("O"))) {
            oVence(0, 3, 1, 3, 2, 3,  3, 3, 4, 3,5, 3,6, 3,-1, -1, matriz);
        }else if ((botoes[4][0].getText().equals("O")) && (botoes[4][1].getText().equals("O"))
                && (botoes[4][2].getText().equals("O"))&& (botoes[4][3].getText().equals("O"))&& (botoes[4][4].getText().equals("O"))&& (botoes[4][5].getText().equals("O"))&& (botoes[4][6].getText().equals("O"))) {
            oVence(4, 0, 4, 1, 4, 2,  4, 3, 4, 4,4, 5,4, 6,-1, -1, matriz);
        }else if ((botoes[0][4].getText().equals("O")) && (botoes[1][4].getText().equals("O"))
                && (botoes[2][4].getText().equals("O"))&& (botoes[3][4].getText().equals("O"))&& (botoes[4][4].getText().equals("O"))&& (botoes[5][4].getText().equals("O"))&& (botoes[6][4].getText().equals("O"))) {
            oVence(0, 4, 1, 4, 2, 4,  3, 4, 4, 4,5, 4,6, 4,-1, -1, matriz);
        }else if ((botoes[5][0].getText().equals("O")) && (botoes[5][1].getText().equals("O"))
                && (botoes[5][2].getText().equals("O"))&& (botoes[5][3].getText().equals("O"))&& (botoes[5][4].getText().equals("O"))&& (botoes[5][5].getText().equals("O"))&& (botoes[5][6].getText().equals("O"))) {
            oVence(5, 0, 5, 1, 5, 2,  5, 3, 5, 4,5, 5,5, 6,-1, -1, matriz);
        }else if ((botoes[0][5].getText().equals("O")) && (botoes[1][5].getText().equals("O"))
                && (botoes[2][5].getText().equals("O"))&& (botoes[3][5].getText().equals("O"))&& (botoes[4][5].getText().equals("O"))&& (botoes[5][5].getText().equals("O"))&& (botoes[6][5].getText().equals("O"))) {
            oVence(0, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 5, -1, -1, matriz);
        }else if ((botoes[6][0].getText().equals("O")) && (botoes[6][1].getText().equals("O"))
                && (botoes[6][2].getText().equals("O"))&& (botoes[6][3].getText().equals("O"))&& (botoes[6][4].getText().equals("O"))&& (botoes[6][5].getText().equals("O"))&& (botoes[6][6].getText().equals("O"))) {
            oVence(6, 0, 6, 1, 6, 2,  6, 3, 6, 4,6, 5,6, 6,-1, -1, matriz);
        }else if ((botoes[0][6].getText().equals("O")) && (botoes[1][6].getText().equals("O"))
                && (botoes[2][6].getText().equals("O"))&& (botoes[3][6].getText().equals("O"))&& (botoes[4][6].getText().equals("O"))&& (botoes[5][6].getText().equals("O"))&& (botoes[6][6].getText().equals("O"))) {
            oVence(0, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6, 6, -1, -1, matriz);
        } else if (limiteJogadas == 49) {campoTexto.setText("Jogo Empatado");
        }else if (matriz == 8) {
            if ((botoes[0][0].getText() == "X") && (botoes[0][1].getText() == "X") && (botoes[0][2].getText() == "X")
                    && (botoes[0][3].getText() == "X") && (botoes[0][4].getText() == "X") && (botoes[0][5].getText() == "X") && (botoes[0][6].getText() == "X") && (botoes[0][7].getText() == "X")) {
                xVence(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, matriz);
            } else if ((botoes[0][0].getText() == "X") && (botoes[1][1].getText() == "X")
                    && (botoes[2][2].getText() == "X") && (botoes[3][3].getText() == "X") && (botoes[4][4].getText() == "X") && (botoes[5][5].getText() == "X") && (botoes[6][6].getText() == "X") && (botoes[7][7].getText() == "X")) {
                xVence(0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, matriz);
            } else if ((botoes[0][0].getText() == "X") && (botoes[1][0].getText() == "X")
                    && (botoes[2][0].getText() == "X") && (botoes[3][0].getText() == "X") && (botoes[4][0].getText() == "X") && (botoes[5][0].getText() == "X") && (botoes[6][0].getText() == "X") && (botoes[7][0].getText() == "X")) {
                xVence(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, matriz);
            } else if ((botoes[0][1].getText() == "X") && (botoes[1][1].getText() == "X")
                    && (botoes[2][1].getText() == "X") && (botoes[3][1].getText() == "X") && (botoes[4][1].getText() == "X") && (botoes[5][1].getText() == "X") && (botoes[6][1].getText() == "X") && (botoes[7][1].getText() == "X")) {
                xVence(0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, matriz);
            } else if ((botoes[0][7].getText() == "X") && (botoes[1][6].getText() == "X")
                    && (botoes[2][5].getText() == "X") && (botoes[3][4].getText() == "X") && (botoes[4][3].getText() == "X") && (botoes[5][2].getText() == "X") && (botoes[6][1].getText() == "X") && (botoes[7][0].getText() == "X")) {
                xVence(0, 7, 1, 6, 2, 5, 3, 4, 4, 3, 5, 2, 6, 1, 7, 0, matriz);
            } else if ((botoes[0][2].getText() == "X") && (botoes[1][2].getText() == "X")
                    && (botoes[2][2].getText() == "X") && (botoes[3][2].getText() == "X") && (botoes[4][2].getText() == "X") && (botoes[5][2].getText() == "X") && (botoes[6][2].getText() == "X") && (botoes[7][2].getText() == "X")) {
                xVence(0, 2, 1, 2, 2, 2, 3, 2, 4, 2, 5, 2, 6, 2, 7, 2, matriz);
            } else if ((botoes[1][0].getText() == "X") && (botoes[1][1].getText() == "X")
                    && (botoes[1][2].getText() == "X") && (botoes[1][3].getText() == "X") && (botoes[1][4].getText() == "X") && (botoes[1][5].getText() == "X") && (botoes[1][6].getText() == "X") && (botoes[1][7].getText() == "X")) {
                xVence(1, 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, matriz);
            } else if ((botoes[2][0].getText() == "X") && (botoes[2][1].getText() == "X")
                    && (botoes[2][2].getText() == "X") && (botoes[2][3].getText() == "X") && (botoes[2][4].getText() == "X") && (botoes[2][5].getText() == "X") && (botoes[2][6].getText() == "X") && (botoes[2][7].getText() == "X")) {
                xVence(2, 0, 2, 1, 2, 2, 2, 3, 2, 4, 2, 5, 2, 6, 2, 7, matriz);
            } else if ((botoes[3][0].getText() == "X") && (botoes[3][1].getText() == "X")
                    && (botoes[3][2].getText() == "X") && (botoes[3][3].getText() == "X") && (botoes[3][4].getText() == "X") && (botoes[3][5].getText() == "X") && (botoes[3][6].getText() == "X") && (botoes[3][7].getText() == "X")) {
                xVence(3, 0, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 3, 7, matriz);
            } else if ((botoes[0][3].getText() == "X") && (botoes[1][3].getText() == "X")
                    && (botoes[2][3].getText() == "X") && (botoes[3][3].getText() == "X") && (botoes[4][3].getText() == "X") && (botoes[5][3].getText() == "X") && (botoes[6][3].getText() == "X") && (botoes[7][3].getText() == "X")) {
                xVence(0, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 3, 7, 3, matriz);
            } else if ((botoes[4][0].getText() == "X") && (botoes[4][1].getText() == "X")
                    && (botoes[4][2].getText() == "X") && (botoes[4][3].getText() == "X") && (botoes[4][4].getText() == "X") && (botoes[4][5].getText() == "X") && (botoes[4][6].getText() == "X") && (botoes[4][7].getText() == "X")) {
                xVence(4, 0, 4, 1, 4, 2, 4, 3, 4, 4, 4, 5, 4, 6, 4, 7, matriz);
            } else if ((botoes[0][4].getText() == "X") && (botoes[1][4].getText() == "X")
                    && (botoes[2][4].getText() == "X") && (botoes[3][4].getText() == "X") && (botoes[4][4].getText() == "X") && (botoes[5][4].getText() == "X") && (botoes[6][4].getText() == "X") && (botoes[7][4].getText() == "X")) {
                xVence(0, 4, 1, 4, 2, 4, 3, 4, 4, 4, 5, 4, 6, 4, 7, 4, matriz);
            } else if ((botoes[5][0].getText() == "X") && (botoes[5][1].getText() == "X")
                    && (botoes[5][2].getText() == "X") && (botoes[5][3].getText() == "X") && (botoes[5][4].getText() == "X") && (botoes[5][5].getText() == "X") && (botoes[5][6].getText() == "X") && (botoes[5][7].getText() == "X")) {
                xVence(5, 0, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 5, 7, matriz);
            } else if ((botoes[0][5].getText() == "X") && (botoes[1][5].getText() == "X")
                    && (botoes[2][5].getText() == "X") && (botoes[3][5].getText() == "X") && (botoes[4][5].getText() == "X") && (botoes[5][5].getText() == "X") && (botoes[6][5].getText() == "X") && (botoes[7][5].getText() == "X")) {
                xVence(0, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 5, 7, 5, matriz);
            } else if ((botoes[6][0].getText() == "X") && (botoes[6][1].getText() == "X")
                    && (botoes[6][2].getText() == "X") && (botoes[6][3].getText() == "X") && (botoes[6][4].getText() == "X") && (botoes[6][5].getText() == "X") && (botoes[6][6].getText() == "X") && (botoes[6][7].getText() == "X")) {
                xVence(6, 0, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6, 6, 7, matriz);
            } else if ((botoes[0][6].getText() == "X") && (botoes[1][6].getText() == "X")
                    && (botoes[2][6].getText() == "X") && (botoes[3][6].getText() == "X") && (botoes[4][6].getText() == "X") && (botoes[5][6].getText() == "X") && (botoes[6][6].getText() == "X") && (botoes[7][6].getText() == "X")) {
                xVence(0, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6, 6, 7, 6, matriz);
            } else if ((botoes[7][0].getText() == "X") && (botoes[7][1].getText() == "X")
                    && (botoes[7][2].getText() == "X") && (botoes[7][3].getText() == "X") && (botoes[7][4].getText() == "X") && (botoes[7][5].getText() == "X") && (botoes[7][6].getText() == "X") && (botoes[7][7].getText() == "X")) {
                xVence(7, 0, 7, 1, 7, 2, 7, 3, 7, 4, 7, 5, 7, 6, 7, 7, matriz);
            } else if ((botoes[0][7].getText() == "X") && (botoes[1][7].getText() == "X")
                    && (botoes[2][7].getText() == "X") && (botoes[3][7].getText() == "X") && (botoes[4][7].getText() == "X") && (botoes[5][7].getText() == "X") && (botoes[6][7].getText() == "X") && (botoes[7][7].getText() == "X")) {
                xVence(0, 7, 1, 7, 2, 7, 3, 7, 4, 7, 5, 7, 6, 7, 7, 7, matriz);
            } else if ((botoes[0][0].getText() == "O") && (botoes[0][1].getText() == "O")
                    && (botoes[0][2].getText() == "O") && (botoes[0][3].getText() == "O") && (botoes[0][4].getText() == "O") && (botoes[0][5].getText() == "O")&& (botoes[0][6].getText() == "O") && (botoes[0][7].getText() == "O")) {
                oVence(0, 0, 0, 1, 0, 2, 0, 3,0,4,0, 5,0, 6,0,7, matriz);
            } else if ((botoes[0][0].getText() == "O") && (botoes[1][1].getText() == "O")
                    && (botoes[2][2].getText() == "O") && (botoes[3][3].getText() == "O") && (botoes[4][4].getText() == "O") && (botoes[5][5].getText() == "O")&& (botoes[6][6].getText() == "O") && (botoes[7][7].getText() == "O")) {
                oVence(0, 0, 1, 1, 2, 2, 3, 3,4,4,5,5,6,6,7,7, matriz);
            } else if ((botoes[0][0].getText() == "O") && (botoes[1][0].getText() == "O")
                    && (botoes[2][0].getText() == "O") && (botoes[3][0].getText() == "O") && (botoes[4][0].getText() == "O") && (botoes[5][0].getText() == "O")&& (botoes[6][0].getText() == "O")&& (botoes[7][0].getText() == "O")) {
                oVence(0, 0, 1, 0, 2, 0, 3, 0,4,0,5,0,6,0,7,0, matriz);
            } else if ((botoes[0][1].getText() == "O") && (botoes[1][1].getText() == "O")
                    && (botoes[2][1].getText() == "O") && (botoes[3][1].getText() == "O") && (botoes[4][1].getText() == "O") && (botoes[5][1].getText() == "O")&& (botoes[6][1].getText() == "O")&& (botoes[7][1].getText() == "O")) {
                oVence(0, 1, 1, 1, 2, 1, 3, 1,4,1,5,1,6,1,7,1, matriz);
            } else if ((botoes[0][7].getText() == "O") && (botoes[1][6].getText() == "O")
                    && (botoes[2][5].getText() == "O") && (botoes[3][4].getText() == "O") && (botoes[4][3].getText() == "O") && (botoes[5][2].getText() == "O")&& (botoes[6][1].getText() == "O")&& (botoes[7][0].getText() == "O")) {
                oVence(0, 7, 1, 6, 2, 5, 3, 4,4,3,5,2,6,1,7,0, matriz);
            } else if ((botoes[0][2].getText() == "O") && (botoes[1][2].getText() == "O")
                    && (botoes[2][2].getText() == "O") && (botoes[3][2].getText() == "O") && (botoes[4][2].getText() == "O") && (botoes[5][2].getText() == "O")&& (botoes[6][2].getText() == "O")&& (botoes[7][2].getText() == "O")) {
                oVence(0, 2, 1, 2, 2, 2, 3, 2,4,2,5,2,6,2,7,2, matriz);
            } else if ((botoes[1][0].getText() == "O") && (botoes[1][1].getText() == "O")
                    && (botoes[1][2].getText() == "O") && (botoes[1][3].getText() == "O") && (botoes[1][4].getText() == "O") && (botoes[1][5].getText() == "O") && (botoes[1][6].getText() == "O")&& (botoes[1][7].getText() == "O")) {
                oVence(1, 0, 1, 1, 1, 2, 1, 3,1,4,1,5,1,6,1,7, matriz);
            } else if ((botoes[2][0].getText() == "O") && (botoes[2][1].getText() == "O")
                    && (botoes[2][2].getText() == "O") && (botoes[2][3].getText() == "O") && (botoes[2][4].getText() == "O") && (botoes[2][5].getText() == "O")&& (botoes[2][6].getText() == "O")&& (botoes[2][7].getText() == "O")) {
                oVence(2, 0, 2, 1, 2, 2, 2, 3,2,4,2,5,2,6,2,7, matriz);
            } else if ((botoes[3][0].getText().equals("O")) && (botoes[3][1].getText().equals("O"))
                    && (botoes[3][2].getText().equals("O"))&& (botoes[3][3].getText().equals("O"))&& (botoes[3][4].getText().equals("O")) && (botoes[3][5].getText().equals("O"))&& (botoes[3][6].getText().equals("O"))&& (botoes[3][7].getText().equals("O"))) {
                oVence(3, 0, 3, 1, 3, 2,  3, 3, 3, 4,3, 5,3, 6,3, 7, matriz);
            }else if ((botoes[0][3].getText().equals("O")) && (botoes[1][3].getText().equals("O"))
                    && (botoes[2][3].getText().equals("O"))&& (botoes[3][3].getText().equals("O"))&& (botoes[4][3].getText().equals("O"))&& (botoes[5][3].getText().equals("O"))&& (botoes[6][3].getText().equals("O"))&& (botoes[7][3].getText().equals("O"))) {
                oVence(0, 3, 1, 3, 2, 3,  3, 3, 4, 3,5, 3,6, 3,7, 3, matriz);
            }else if ((botoes[4][0].getText().equals("O")) && (botoes[4][1].getText().equals("O"))
                    && (botoes[4][2].getText().equals("O"))&& (botoes[4][3].getText().equals("O"))&& (botoes[4][4].getText().equals("O"))&& (botoes[4][5].getText().equals("O"))&& (botoes[4][6].getText().equals("O"))&& (botoes[4][7].getText().equals("O"))) {
                oVence(4, 0, 4, 1, 4, 2,  4, 3, 4, 4,4, 5,4, 6,4, 7, matriz);
            }else if ((botoes[0][4].getText().equals("O")) && (botoes[1][4].getText().equals("O"))
                    && (botoes[2][4].getText().equals("O"))&& (botoes[3][4].getText().equals("O"))&& (botoes[4][4].getText().equals("O"))&& (botoes[5][4].getText().equals("O"))&& (botoes[6][4].getText().equals("O"))&& (botoes[7][4].getText().equals("O"))) {
                oVence(0, 4, 1, 4, 2, 4,  3, 4, 4, 4,5, 4,6, 4,7, 4, matriz);
            }else if ((botoes[5][0].getText().equals("O")) && (botoes[5][1].getText().equals("O"))
                    && (botoes[5][2].getText().equals("O"))&& (botoes[5][3].getText().equals("O"))&& (botoes[5][4].getText().equals("O"))&& (botoes[5][5].getText().equals("O"))&& (botoes[5][6].getText().equals("O"))&& (botoes[5][7].getText().equals("O"))) {
                oVence(5, 0, 5, 1, 5, 2,  5, 3, 5, 4,5, 5,5, 6,5, 7, matriz);
            }else if ((botoes[0][5].getText().equals("O")) && (botoes[1][5].getText().equals("O"))
                    && (botoes[2][5].getText().equals("O"))&& (botoes[3][5].getText().equals("O"))&& (botoes[4][5].getText().equals("O"))&& (botoes[5][5].getText().equals("O"))&& (botoes[6][5].getText().equals("O"))&& (botoes[7][5].getText().equals("O"))) {
                oVence(0, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 5, 7, 5, matriz);
            }else if ((botoes[6][0].getText().equals("O")) && (botoes[6][1].getText().equals("O"))
                    && (botoes[6][2].getText().equals("O"))&& (botoes[6][3].getText().equals("O"))&& (botoes[6][4].getText().equals("O"))&& (botoes[6][5].getText().equals("O"))&& (botoes[6][6].getText().equals("O"))&& (botoes[6][7].getText().equals("O"))) {
                oVence(6, 0, 6, 1, 6, 2,  6, 3, 6, 4,6, 5,6, 6,6, 7, matriz);
            }else if ((botoes[0][6].getText().equals("O")) && (botoes[1][6].getText().equals("O"))
                    && (botoes[2][6].getText().equals("O"))&& (botoes[3][6].getText().equals("O"))&& (botoes[4][6].getText().equals("O"))&& (botoes[5][6].getText().equals("O"))&& (botoes[6][6].getText().equals("O"))&& (botoes[7][6].getText().equals("O"))) {
                oVence(0, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6, 6, 7, 6, matriz);
            }else if ((botoes[7][0].getText().equals("O")) && (botoes[7][1].getText().equals("O"))
                    && (botoes[7][2].getText().equals("O"))&& (botoes[7][3].getText().equals("O"))&& (botoes[7][4].getText().equals("O"))&& (botoes[7][5].getText().equals("O"))&& (botoes[7][6].getText().equals("O"))&& (botoes[7][7].getText().equals("O"))) {
                oVence(7, 0, 7, 1, 7, 2,  7, 3, 7, 4,7, 5,7, 6,7, 7, matriz);
            }else if ((botoes[0][7].getText().equals("O")) && (botoes[1][7].getText().equals("O"))
                    && (botoes[2][7].getText().equals("O"))&& (botoes[3][7].getText().equals("O"))&& (botoes[4][7].getText().equals("O"))&& (botoes[5][7].getText().equals("O"))&& (botoes[6][7].getText().equals("O"))&& (botoes[7][7].getText().equals("O"))) {
                oVence(0, 7, 1, 7, 2, 7, 3, 7, 4, 7, 5, 7, 6, 7, 7, 7, matriz);
            }else if (limiteJogadas == 64) {
                campoTexto.setText("Jogo Empatado");
            }}}

    public void xVence(int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, int controlo) {
        if (controlo == 3) {
            botoes[x1][x2].setBackground(Color.RED);
            botoes[x3][x4].setBackground(Color.RED);
            botoes[x5][x6].setBackground(Color.RED);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador1 + " ganhou");
            fimDeJogo("Vitória de " + jogador2 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        } else if (controlo == 4){
            botoes[x1][x2].setBackground(Color.BLUE);
            botoes[x3][x4].setBackground(Color.BLUE);
            botoes[x5][x6].setBackground(Color.BLUE);
            botoes[x7][x8].setBackground(Color.BLUE);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador2 + " ganhou");
            fimDeJogo("Vitória de " + jogador2 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        }

    }

    public void xVence(int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, int x9,int x10,int x11,int x12,int x13,int x14,int x15,int x16, int controlo) {
        if (controlo == 3) {
            botoes[x1][x2].setBackground(Color.RED);
            botoes[x3][x4].setBackground(Color.RED);
            botoes[x5][x6].setBackground(Color.RED);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador1 + " ganhou");
            fimDeJogo("Vitória de " + jogador1 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        } else if (controlo == 4) {
            botoes[x1][x2].setBackground(Color.BLUE);
            botoes[x3][x4].setBackground(Color.BLUE);
            botoes[x5][x6].setBackground(Color.BLUE);
            botoes[x7][x8].setBackground(Color.BLUE);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador1 + " ganhou");
            fimDeJogo("Vitória de " + jogador1 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        }else if (controlo == 5) {
            botoes[x1][x2].setBackground(Color.BLUE);
            botoes[x3][x4].setBackground(Color.BLUE);
            botoes[x5][x6].setBackground(Color.BLUE);
            botoes[x7][x8].setBackground(Color.BLUE);
            botoes[x9][x10].setBackground(Color.BLUE);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador1 + " ganhou");
            fimDeJogo("Vitória de " + jogador1 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        }else if (controlo == 6) {
            botoes[x1][x2].setBackground(Color.BLUE);
            botoes[x3][x4].setBackground(Color.BLUE);
            botoes[x5][x6].setBackground(Color.BLUE);
            botoes[x7][x8].setBackground(Color.BLUE);
            botoes[x9][x10].setBackground(Color.BLUE);
            botoes[x11][x12].setBackground(Color.BLUE);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador1 + " ganhou");
            fimDeJogo("Vitória de " + jogador1 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        }else if (controlo == 7) {
            botoes[x1][x2].setBackground(Color.BLUE);
            botoes[x3][x4].setBackground(Color.BLUE);
            botoes[x5][x6].setBackground(Color.BLUE);
            botoes[x7][x8].setBackground(Color.BLUE);
            botoes[x9][x10].setBackground(Color.BLUE);
            botoes[x11][x12].setBackground(Color.BLUE);
            botoes[x13][x14].setBackground(Color.BLUE);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador1 + " ganhou");
            fimDeJogo("Vitória de " + jogador1 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        }else if (controlo == 7) {
            botoes[x1][x2].setBackground(Color.BLUE);
            botoes[x3][x4].setBackground(Color.BLUE);
            botoes[x5][x6].setBackground(Color.BLUE);
            botoes[x7][x8].setBackground(Color.BLUE);
            botoes[x9][x10].setBackground(Color.BLUE);
            botoes[x11][x12].setBackground(Color.BLUE);
            botoes[x13][x14].setBackground(Color.BLUE);
            botoes[x15][x16].setBackground(Color.BLUE);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador1 + " ganhou");
            fimDeJogo("Vitória de " + jogador1 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        }

    }

    public void oVence(int o1, int o2, int o3, int o4, int o5, int o6, int o7, int o8,int o9,int o10,int o11,int o12,int o13,int o14,int o15, int o16, int controlo) {
        if (controlo == 3) {
            botoes[o1][o2].setBackground(Color.BLUE);
            botoes[o3][o4].setBackground(Color.BLUE);
            botoes[o5][o6].setBackground(Color.BLUE);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador2 + " ganhou");
            fimDeJogo("Vitória de " + jogador2 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        } else if (controlo == 4) {
            botoes[o1][o2].setBackground(Color.BLUE);
            botoes[o3][o4].setBackground(Color.BLUE);
            botoes[o5][o6].setBackground(Color.BLUE);
            botoes[o7][o8].setBackground(Color.BLUE);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador2 + " ganhou");
            fimDeJogo("Vitória de " + jogador2 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        }else if (controlo == 5) {
            botoes[o1][o2].setBackground(Color.BLUE);
            botoes[o3][o4].setBackground(Color.BLUE);
            botoes[o5][o6].setBackground(Color.BLUE);
            botoes[o7][o8].setBackground(Color.BLUE);
            botoes[o9][o10].setBackground(Color.BLUE);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador2 + " ganhou");
            fimDeJogo("Vitória de " + jogador2 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        }else if (controlo == 6) {
            botoes[o1][o2].setBackground(Color.BLUE);
            botoes[o3][o4].setBackground(Color.BLUE);
            botoes[o5][o6].setBackground(Color.BLUE);
            botoes[o7][o8].setBackground(Color.BLUE);
            botoes[o9][o10].setBackground(Color.BLUE);
            botoes[o11][o12].setBackground(Color.BLUE);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador2 + " ganhou");
            fimDeJogo("Vitória de " + jogador2 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        }else if (controlo == 7) {
            botoes[o1][o2].setBackground(Color.BLUE);
            botoes[o3][o4].setBackground(Color.BLUE);
            botoes[o5][o6].setBackground(Color.BLUE);
            botoes[o7][o8].setBackground(Color.BLUE);
            botoes[o9][o10].setBackground(Color.BLUE);
            botoes[o11][o12].setBackground(Color.BLUE);
            botoes[o13][o14].setBackground(Color.BLUE);
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador2 + " ganhou");
            fimDeJogo("Vitória de " + jogador2 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        }else if (controlo == 7) {
            botoes[o1][o2].setBackground(Color.BLUE);
            botoes[o3][o4].setBackground(Color.BLUE);
            botoes[o5][o6].setBackground(Color.BLUE);
            botoes[o7][o8].setBackground(Color.BLUE);
            botoes[o9][o10].setBackground(Color.BLUE);
            botoes[o11][o12].setBackground(Color.BLUE);
            botoes[o13][o14].setBackground(Color.BLUE);
            botoes[o15][o16].setBackground(Color.BLUE);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++)
                    botoes[i][j].setEnabled(false);
            }
            campoTexto.setText(jogador2 + " ganhou");
            fimDeJogo("Vitória de " + jogador2 + ". Muitos Parabéns", jogador1, jogador2, controlo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Jogada_J1 = true;
        int n = matriz;
        countA++;
        String j1 = jogador1.substring(0, 2);
        String j2 = jogador2.substring(0, 2);
        if ((j1 != "CPU")) {
            if (countA % 2 == 0)
                letra = "X";
            else
                letra = "O";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (botoes[i][j].getText() == "") {
                            botoes[i][j].setForeground(new Color(255, 0, 0));
                            botoes[i][j].setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
                            botoes[i][j].setText("X");
                            Jogada_J1 = false;
                            limiteJogadas++;
                            verificacaoResultado(n);
                            campoTexto.setText("CPU a processar a sua Jogada...");
                            jogadacpu("O", 3);
                            verificacaoResultado(n);
                            Jogada_J1 = true;
                            campoTexto.setText(jogador1 + ", selecione");
                            limiteJogadas++;
                            }
                        }
                    }
                }
            } else {
                if (countA % 2 == 0)
                    letra = "O";
                else
                    letra = "X";
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (e.getSource() == botoes[i][j]) {
                            if (botoes[i][j].getText() == "") {
                                botoes[i][j].setForeground(new Color(255, 0, 0));
                                botoes[i][j].setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
                                botoes[i][j].setText("O");
                                Jogada_J1 = false;
                                limiteJogadas++;
                                verificacaoResultado(n);
                                campoTexto.setText("CPU a processar a sua Jogada...");
                                jogadacpu("X", n);
                                verificacaoResultado(n);
                                Jogada_J1 = true;
                                campoTexto.setText(jogador2 + ", selecione");
                                limiteJogadas++;
                            }
                        }
                    }
                }
            }
        }
    }

