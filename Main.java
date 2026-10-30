import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        ArrayList<Pacientes> pacientes = new ArrayList<>();
        int proximaSenha = 1;
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- Cadastro de pacientes ---");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Chamar fila de pacientes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("CPF: ");
                String cpf = scanner.nextLine();

                if (cpfJaCadastrado(pacientes, cpf)) {
                    System.out.println("Já existe um paciente cadastrado com esse CPF.");
                } else {
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Data de nascimento: ");
                    String dataNascimento = scanner.nextLine();

                    Pacientes paciente = new Pacientes(nome, cpf, telefone, dataNascimento, proximaSenha);
                    pacientes.add(paciente);
                    System.out.println("Paciente cadastrado com sucesso!");
                    System.out.println("Senha do paciente: " + proximaSenha);
                    proximaSenha++;
                }
            } else if (opcao == 2) {
                if (pacientes.isEmpty()) {
                    System.out.println("Nenhum paciente cadastrado.");
                } else {
                    System.out.println("\n--- Fila de pacientes ---");
                    for (int i = 0; i < pacientes.size(); i++) {
                        Pacientes paciente = pacientes.get(i);
                        System.out.println("\nSenha: " + paciente.getSenha());
                        System.out.println("Nome: " + paciente.getNome());
                        System.out.println("CPF: " + paciente.getCpf());
                        System.out.println("Telefone: " + paciente.getTelefone());
                        System.out.println("Data de nascimento: " + paciente.getDataNascimento());
                    }
                }
            } else if (opcao != 0) {
                System.out.println("Opção inválida.");
            }
        }

        System.out.println("Programa encerrado.");
        }
    }

    public static boolean cpfJaCadastrado(ArrayList<Pacientes> pacientes, String cpf) {
        String cpfDigitado = cpf.replaceAll("\\D", "");

        for (Pacientes paciente : pacientes) {
            String cpfSalvo = paciente.getCpf().replaceAll("\\D", "");
            if (cpfSalvo.equals(cpfDigitado)) {
                return true;
            }
        }

        return false;
    }
}
