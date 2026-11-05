import java.util.LinkedList;
import java.util.Queue;

public class FilaAtendimento {
    private Queue<Paciente> fila = new LinkedList<>();
    private int proximaSenha = 1;

   
    public int adicionar(String nome, String cpf, String telefone, String dataNascimento) {
        Paciente paciente = new Paciente(nome, cpf, telefone, dataNascimento, proximaSenha);
        fila.add(paciente);

        int senhaGerada = proximaSenha;
        proximaSenha++;
        return senhaGerada;
    }

   
    public Paciente chamarProximo() {
        return fila.poll();
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public int tamanho() {
        return fila.size();
    }

   
    public boolean cpfJaCadastrado(String cpf) {
        String cpfDigitado = cpf.replaceAll("\\D", "");

        for (Paciente paciente : fila) {
            String cpfSalvo = paciente.getCpf().replaceAll("\\D", "");
            if (cpfSalvo.equals(cpfDigitado)) {
                return true;
            }
        }

        return false;
    }

    public void listar() {
        for (Paciente paciente : fila) {
            System.out.println("\n" + paciente);
        }
    }
}
