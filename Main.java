import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilaAtendimento fila = new FilaAtendimento();

        try (Scanner scanner = new Scanner(System.in)) {
            int opcao = -1;

            while (opcao != 0) {
                exibirMenu();

                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Digite um número válido.");
                    continue;
                }

                switch (opcao) {
                    case 1:
                        cadastrarPaciente(scanner, fila);
                        break;
                    case 2:
                        chamarProximo(fila);
                        break;
                    case 3:
                        verFila(fila);
                        break;
                    case 0:
                        System.out.println("Programa encerrado.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("\n--- Fila de atendimento ---");
        System.out.println("1 - Cadastrar paciente");
        System.out.println("2 - Chamar próximo da fila");
        System.out.println("3 - Ver fila");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarPaciente(Scanner scanner, FilaAtendimento fila) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("O nome não pode ficar vazio.");
            return;
        }

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        if (cpf.replaceAll("\\D", "").length() != 11) {
            System.out.println("CPF inválido. Ele precisa ter 11 números.");
            return;
        }

        if (fila.cpfJaCadastrado(cpf)) {
            System.out.println("Já existe um paciente na fila com esse CPF.");
            return;
        }

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();

        int senha = fila.adicionar(nome, cpf, telefone, dataNascimento);
        System.out.println("Paciente cadastrado com sucesso!");
        System.out.println("Senha do paciente: " + senha);
    }

    public static void chamarProximo(FilaAtendimento fila) {
        Paciente proximo = fila.chamarProximo();

        if (proximo == null) {
            System.out.println("Não há pacientes na fila.");
        } else {
            System.out.println("\n--- Chamando paciente ---");
            System.out.println(proximo);
            System.out.println("\nPacientes restantes: " + fila.tamanho());
        }
    }

    public static void verFila(FilaAtendimento fila) {
        if (fila.estaVazia()) {
            System.out.println("Nenhum paciente na fila.");
        } else {
            System.out.println("\n--- Fila de pacientes (" + fila.tamanho() + ") ---");
            fila.listar();
        }
    }
}
