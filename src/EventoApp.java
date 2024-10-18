import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EventoApp extends JFrame {
    private JTextField nomeEventoField, descricaoEventoField, ruaField, cidadeField, estadoField, capacidadeField, numeroField;
    private JTextField nomeParticipanteField, idadeParticipanteField, cpfParticipanteField, emailParticipanteField;
    private JComboBox<String> tipoParticipanteBox, eventoComboBox;
    private JTextArea displayArea;
    private ArrayList<Evento> eventosList = new ArrayList<>();

    public EventoApp() {
        super("Sistema de Cadastro de Eventos");
        setLayout(new BorderLayout());

        setSize(700, 600);
        setMinimumSize(new Dimension(800, 600)); // Evitar que o tamanho seja menor
        setResizable(false); // Impede o redimensionamento

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setVisible(true);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Aba de Cadastro de Evento
        JPanel eventoPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        eventoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        eventoPanel.add(new JLabel("Nome do Evento:"));
        nomeEventoField = new JTextField(20); // Definindo número de colunas
        eventoPanel.add(nomeEventoField);

        eventoPanel.add(new JLabel("Descrição do Evento:"));
        descricaoEventoField = new JTextField(20); // Definindo número de colunas
        eventoPanel.add(descricaoEventoField);

        eventoPanel.add(new JLabel("Rua do Local:"));
        ruaField = new JTextField(20); // Definindo número de colunas
        eventoPanel.add(ruaField);

        eventoPanel.add(new JLabel("Cidade:"));
        cidadeField = new JTextField(20); // Definindo número de colunas
        eventoPanel.add(cidadeField);

        eventoPanel.add(new JLabel("Estado:"));
        estadoField = new JTextField(20); // Definindo número de colunas
        eventoPanel.add(estadoField);

        eventoPanel.add(new JLabel("Capacidade:"));
        capacidadeField = new JTextField(5); // Definindo número de colunas
        eventoPanel.add(capacidadeField);

        eventoPanel.add(new JLabel("Número do Local:"));
        numeroField = new JTextField(5); // Definindo número de colunas
        eventoPanel.add(numeroField);

        eventoPanel.add(new JLabel(""));
        JButton cadastrarEventoBtn = new JButton("Cadastrar Evento");
        //Estilização do botão
        cadastrarEventoBtn.setForeground(Color.DARK_GRAY); 
        cadastrarEventoBtn.setBackground(Color.cyan);
        cadastrarEventoBtn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        cadastrarEventoBtn.setFont(new Font("Arial", Font.TYPE1_FONT ,14));
        cadastrarEventoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cadastrarEventoBtn.setBackground(Color.lightGray);  // Mudar cor ao passar o mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cadastrarEventoBtn.setBackground(Color.cyan); // Voltar para cor original ao sair com o mouse
            }
        });
        cadastrarEventoBtn.setPreferredSize(new Dimension(50, 25));
        cadastrarEventoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarEvento();
            }
        });

        eventoPanel.add(cadastrarEventoBtn);
        tabbedPane.addTab("Cadastrar Evento", eventoPanel);
        add(tabbedPane, BorderLayout.CENTER);

        // Aba de Cadastro de Participante
        JPanel participantePanel = new JPanel(new GridLayout(8, 2, 10, 10));
        participantePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        participantePanel.add(new JLabel("Nome do Participante:"));
        nomeParticipanteField = new JTextField(20); // Definindo número de colunas
        participantePanel.add(nomeParticipanteField);

        participantePanel.add(new JLabel("Idade:"));
        idadeParticipanteField = new JTextField(3); // Definindo número de colunas
        participantePanel.add(idadeParticipanteField);

        participantePanel.add(new JLabel("CPF:"));
        cpfParticipanteField = new JTextField(11); // Definindo número de colunas
        participantePanel.add(cpfParticipanteField);

        participantePanel.add(new JLabel("Email:"));
        emailParticipanteField = new JTextField(20); // Definindo número de colunas
        participantePanel.add(emailParticipanteField);

        participantePanel.add(new JLabel("Tipo de Participante:"));
        String[] tipos = { "Espectador", "Palestrante" };

        tipoParticipanteBox = new JComboBox<>(tipos);
        participantePanel.add(tipoParticipanteBox);

        participantePanel.add(new JLabel("Evento:"));
        eventoComboBox = new JComboBox<>();
        participantePanel.add(eventoComboBox);

        eventoComboBox.setBorder(new LineBorder(Color.lightGray, 1));

        participantePanel.add(new JLabel(""));
        JButton cadastrarParticipanteBtn = new JButton("Cadastrar Participante");
        //Estilização do botão
        cadastrarParticipanteBtn.setForeground(Color.DARK_GRAY); 
        cadastrarParticipanteBtn.setBackground(Color.cyan);
        cadastrarParticipanteBtn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        cadastrarParticipanteBtn.setFont(new Font("Arial", Font.TYPE1_FONT ,14));
        cadastrarParticipanteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cadastrarParticipanteBtn.setBackground(Color.lightGray);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cadastrarParticipanteBtn.setBackground(Color.cyan); 
            }
        });
        cadastrarParticipanteBtn.setPreferredSize(new Dimension(50, 25));

        cadastrarParticipanteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarParticipante();
            }
        });

        participantePanel.add(cadastrarParticipanteBtn);
        tabbedPane.addTab("Cadastrar Participante", participantePanel);
        add(tabbedPane, BorderLayout.CENTER);

        // Aba para exibir Eventos Cadastrados
        JPanel eventoExibirPanel = new JPanel(new BorderLayout());
        JTextArea eventoInfoArea = new JTextArea();
        eventoInfoArea.setEditable(false);
        JScrollPane eventoScrollPane = new JScrollPane(eventoInfoArea);
        eventoExibirPanel.add(new JLabel("Eventos Cadastrados:"), BorderLayout.NORTH);
        eventoExibirPanel.add(eventoScrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Eventos Cadastrados", eventoExibirPanel);

        // Aba para exibir Participantes Cadastrados
        JPanel participanteExibirPanel = new JPanel(new BorderLayout());
        JTextArea participanteInfoArea = new JTextArea();
        participanteInfoArea.setEditable(false);
        JScrollPane participanteScrollPane = new JScrollPane(participanteInfoArea);
        participanteExibirPanel.add(new JLabel("Participantes Cadastrados:"), BorderLayout.NORTH);
        participanteExibirPanel.add(participanteScrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Participantes Cadastrados", participanteExibirPanel);

        // Área de exibição de dados (log de atividades)
        displayArea = new JTextArea(8, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        JPanel displayPanel = new JPanel();
        displayPanel.setBorder(BorderFactory.createTitledBorder("Log de Atividades"));
        displayPanel.add(scrollPane);

        add(tabbedPane, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.SOUTH);

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Método para cadastrar um evento
    private void cadastrarEvento() {
        try {
            String nomeEvento = nomeEventoField.getText();
            String descricaoEvento = descricaoEventoField.getText();
            String rua = ruaField.getText();
            String cidade = cidadeField.getText();
            String estado = estadoField.getText();
            int capacidade = Integer.parseInt(capacidadeField.getText());
            int numero = Integer.parseInt(numeroField.getText());

            Local local = new Local(rua, cidade, estado, capacidade, numero);
            Evento novoEvento = new Evento(nomeEvento, descricaoEvento, local);
            eventosList.add(novoEvento);

            eventoComboBox.addItem(nomeEvento);

            JOptionPane.showMessageDialog(this, "Evento cadastrado com sucesso!");
            displayArea.append("Evento cadastrado: " + nomeEvento + "\n");

            limparCamposEvento();
            atualizarExibicaoEventos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar evento. Verifique os dados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para cadastrar um participante
    private void cadastrarParticipante() {
        try {
            if (eventosList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, cadastre um evento antes de adicionar participantes.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String nome = nomeParticipanteField.getText();
            nomeParticipanteField.setPreferredSize(new Dimension(200, 30));
            int idade = Integer.parseInt(idadeParticipanteField.getText());
            String cpf = cpfParticipanteField.getText();
            String email = emailParticipanteField.getText();
            String tipo = (String) tipoParticipanteBox.getSelectedItem();
            String tipoFormatado = tipo.toLowerCase();
            String nomeEventoSelecionado = (String) eventoComboBox.getSelectedItem();
        
            if (!tipoFormatado.equals("espectador") && !tipoFormatado.equals("palestrante")) {
                JOptionPane.showMessageDialog(this, "Tipo de participante inválido! Deve ser Espectador ou Palestrante.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Evento eventoSelecionado = eventosList.stream().filter(e -> e.getNome().equals(nomeEventoSelecionado)).findFirst().orElse(null);
            if (eventoSelecionado != null) {
                if(eventoSelecionado.verificarLotacao()){
                    JOptionPane.showMessageDialog(this, "Não foi possível cadastrar participante! Evento lotado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    displayArea.append("Não foi possível cadastrar participante! Evento lotado: " + nomeEventoSelecionado + "\n");
                }else{
                Participante participante = new Participante(nome, idade, cpf, email, tipoFormatado);
                eventoSelecionado.cadastrarParticipante(participante);

                JOptionPane.showMessageDialog(this, "Participante cadastrado com sucesso!");
                displayArea.append("Participante cadastrado: " + nome + " para o evento " + nomeEventoSelecionado + "\n");

                limparCamposParticipante();
                atualizarExibicaoParticipantes();
            }
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar participante. Verifique os dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Atualiza a exibição de eventos cadastrados
    private void atualizarExibicaoEventos() {
        JTextArea eventoInfoArea = (JTextArea)((JScrollPane)((JPanel)((JTabbedPane)getContentPane().getComponent(0)).getComponentAt(2)).getComponent(1)).getViewport().getView();
        eventoInfoArea.setText("");
        for (Evento evento : eventosList) {
            eventoInfoArea.append("Nome do Evento: " + evento.getNome() + "\n");
            eventoInfoArea.append("Descrição: " + evento.getDescricao() + "\n");
            eventoInfoArea.append("Local: " + evento.getLocal().getRua() + ", " + evento.getLocal().getCidade() + ", " + evento.getLocal().getEstado() + "\n");
            eventoInfoArea.append("Capacidade: " + evento.getLocal().getCapacidade() + "\n");
            eventoInfoArea.append("Número: " + evento.getLocal().getNumero() + "\n\n");
        }
    }

    // Atualiza a exibição de participantes cadastrados
    private void atualizarExibicaoParticipantes() {
        JTextArea participanteInfoArea = (JTextArea)((JScrollPane)((JPanel)((JTabbedPane)getContentPane().getComponent(0)).getComponentAt(3)).getComponent(1)).getViewport().getView();
        participanteInfoArea.setText("");

        for (Evento evento : eventosList) {
            for (Participante participante : evento.getParticipantes()) {
                participanteInfoArea.append("Nome: " + participante.getNome() + "\n");
                participanteInfoArea.append("Idade: " + participante.getIdade() + "\n");
                participanteInfoArea.append("CPF: " + participante.getCPF() + "\n");
                participanteInfoArea.append("Email: " + participante.getEmail() + "\n");
                participanteInfoArea.append("Tipo: " + participante.getTipo() + "\n");
                participanteInfoArea.append("Evento: " + evento.getNome() + "\n\n");
            }
        }
    }

    // Limpa os campos do formulário de evento
    private void limparCamposEvento() {
        nomeEventoField.setText("");
        descricaoEventoField.setText("");
        ruaField.setText("");
        cidadeField.setText("");
        estadoField.setText("");
        capacidadeField.setText("");
        numeroField.setText("");
    }

    // Limpa os campos do formulário de participante
    private void limparCamposParticipante() {
        nomeParticipanteField.setText("");
        idadeParticipanteField.setText("");
        cpfParticipanteField.setText("");
        emailParticipanteField.setText("");
    }

    public static void main(String[] args) {
        new EventoApp();
    }
}
