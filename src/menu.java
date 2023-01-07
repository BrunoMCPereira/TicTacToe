import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class menu extends JFrame implements ChangeListener {

    // declaração de Objectos Globais

    JLabel alertas;

    JLabel numeroJogadores;
    JComboBox jogadorCombobox1;
    JComboBox jogadorCombobox2;

    JLabel legendaComboboxjogador1;
    JLabel legendaComboboxjogador2;

    JLabel legendaJogadores;
    JLabel apresentacaoMatriz;
    JLabel legendaMatriz;

    JSlider opcoesMatrizJogo;
    JPanel alerta;

    JButton iniciarJogo;
    ActionListener inicioJogo;

    // eventos
    ChangeListener barraJ;

    // Construtor
    menu() {
        super("Tic Tac Toe");

        // Instanciação dos objectos

        opcoesMatrizJogo = new JSlider(3, 8, 6);
        numeroJogadores = new JLabel();
        legendaJogadores = new JLabel();
        legendaMatriz = new JLabel();
        apresentacaoMatriz = new JLabel();
        legendaComboboxjogador1 = new JLabel();
        legendaComboboxjogador2 = new JLabel();


        iniciarJogo = new JButton();

        // Formatação de objecto: OPÇÕES Jogadores - Slider
        // Traços

        opcoesMatrizJogo.setPaintTicks(true);
        opcoesMatrizJogo.setPaintTrack(true);
        opcoesMatrizJogo.setMajorTickSpacing(1);
        opcoesMatrizJogo.setPaintLabels(true);// Valores;
        opcoesMatrizJogo.setFont(new Font("MV Boli", Font.PLAIN, 15));// Fonte Letra
        opcoesMatrizJogo.setBounds(500, 350, 350, 50);
        opcoesMatrizJogo.addChangeListener(this); // obtenção da alteração
        add(opcoesMatrizJogo);

        apresentacaoMatriz.setFont(new Font("MV Boli", Font.PLAIN, 25));
        apresentacaoMatriz.setText("Grelha");
        apresentacaoMatriz.setBounds(625, 10, 500, 100);
        add(apresentacaoMatriz); // Total de Jogadores

        legendaMatriz.setFont(new Font("MV Boli", Font.PLAIN, 130));
        legendaMatriz.setText(opcoesMatrizJogo.getValue() + "x" + opcoesMatrizJogo.getValue());
        legendaMatriz.setBounds(520, 150, 500, 150);
        add(legendaMatriz); // Total de Jogadores

        numeroJogadores.setFont(new Font("MV Boli", Font.PLAIN, 20));
        numeroJogadores.setText("Jogadores Humanos ou Jogadores Virtuais");
        numeroJogadores.setBounds(70, 10, 500, 100);
        add(numeroJogadores);

        legendaJogadores.setFont(new Font("MV Boli", Font.PLAIN, 12));
        legendaJogadores.setText("Selecione o Tipo de Jogador");
        legendaJogadores.setBounds(150, 80, 500, 100);
        add(legendaJogadores);

        jogadorCombobox1 = criacaoCaixaOpcoes();
        jogadorCombobox1.setBounds(160, 170, 130, 30);
        legendaComboboxjogador1.setFont(new Font("MV Boli", Font.PLAIN, 15));
        legendaComboboxjogador1.setText("Jogador 1");
        legendaComboboxjogador1.setBounds(190, 150, 120, 25);
        add(jogadorCombobox1);
        add(legendaComboboxjogador1);

        jogadorCombobox2 = criacaoCaixaOpcoes();
        jogadorCombobox2.setBounds(160, 230, 130, 30);
        legendaComboboxjogador2.setFont(new Font("MV Boli", Font.PLAIN, 15));
        legendaComboboxjogador2.setText("Jogador 2");
        legendaComboboxjogador2.setBounds(190, 210, 120, 25);
        add(jogadorCombobox2);
        add(legendaComboboxjogador2);


        iniciarJogo.setFont(new Font("MV Boli", Font.BOLD, 20));
        iniciarJogo.setBounds(340, 520, 200, 100);
        iniciarJogo.setBackground(Color.BLACK);
        iniciarJogo.setForeground(Color.WHITE);
        iniciarJogo.setText(
                "INICIAR JOGO");
        iniciarJogo.setVisible(true);

        inicioJogo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = opcoesMatrizJogo.getValue();
                if ((jogadorCombobox1.getSelectedItem() != "Jogador Humano")
                        && (jogadorCombobox2.getSelectedItem() != "Jogador Humano")) {
                    jogoautomatico jogoautomatico = new jogoautomatico("CPU 1", "CPU 2", n);
                } else if ((jogadorCombobox1.getSelectedItem() == "Jogador Humano")
                            && (jogadorCombobox2.getSelectedItem() == "Jogador Humano")
                            ) {
                        jogotradicional jogotradicional = new jogotradicional(
                                JOptionPane.showInputDialog("Jogador 1, insira o seu Nome:"),
                                JOptionPane.showInputDialog("Jogador 2, insira o seu Nome:"),
                                n);
                    } else if ((jogadorCombobox1.getSelectedItem() == "Jogador Humano")
                            && (jogadorCombobox2.getSelectedItem() != "Jogador Humano")
                            ) {
                        jogohibrido jogohibrido = new jogohibrido(
                                JOptionPane.showInputDialog("Jogador 1, insira o seu Nome:"), "CPU 2",
                                n);
                    } else if ((jogadorCombobox1.getSelectedItem() != "Jogador Humano")
                            && (jogadorCombobox2.getSelectedItem() == "Jogador Humano")
                            ) {
                        jogohibrido jogohibrido = new jogohibrido("CPU 1",
                                JOptionPane.showInputDialog("Jogador 1, insira o seu Nome:"),
                                n);
                    }

                }
        };

        iniciarJogo.addActionListener(inicioJogo);
        add(iniciarJogo);

        // Formatação da super classe - Frame
        // Super indica que quero executar metodos diretamente da superclasse (JFrame)
        // extendida.

        setLayout(null);
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // o que faz quando a janela é fechada (neste caso fecha o
        // s istema)
        setVisible(true); // torna visivel

    }

    private JComboBox criacaoCaixaOpcoes() {
        String[] tipojogadores = { null, "Jogador Humano", "Jogador Virtual" };
        JComboBox caixa = new JComboBox(tipojogadores);
        caixa.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
        caixa.setEditable(true);
        return caixa;
    };

    @Override
    public void stateChanged(ChangeEvent e) {
        legendaMatriz.setText(opcoesMatrizJogo.getValue() + "x" + opcoesMatrizJogo.getValue());
                }

    }
