public class Paciente {
    private final String nome;
    private final String cpf;
    private final String telefone;
    private final String dataNascimento;
    private final int senha;

    public Paciente(String nome, String cpf, String telefone, String dataNascimento, int senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public int getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Senha: " + senha
                + "\nNome: " + nome
                + "\nCPF: " + cpf
                + "\nTelefone: " + telefone
                + "\nData de nascimento: " + dataNascimento;
    }
}
