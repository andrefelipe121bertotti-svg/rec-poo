
public class Appteste {

    public static void main(String[] args) {

        FilaAtendimento fila = new FilaAtendimento();

        System.out.println("===== INICIANDO TESTES =====");

        // TESTE 1 - Verificar se a fila começa vazia
        verificar(fila.estaVazia(), "Fila inicia vazia");

        // TESTE 2 - Cadastrar pacientes
        int senha1 = fila.adicionar(
            "Ana Silva",
            "123.456.789-00",
            "41999990000",
            "01/01/2000"
        );

        int senha2 = fila.adicionar(
            "Bruno Souza",
            "987.654.321-00",
            "41988887777",
            "02/02/1999"
        );

        verificar(senha1 == 1, "Primeira senha gerada corretamente");
        verificar(senha2 == 2, "Segunda senha gerada corretamente");

        // TESTE 3 - Verificar quantidade de pacientes
        verificar(fila.tamanho() == 2, "Quantidade de pacientes correta");

        // TESTE 4 - Verificar CPF duplicado
        verificar(
            fila.cpfJaCadastrado("12345678900"),
            "Identificação de CPF duplicado"
        );

        // TESTE 5 - Verificar ordem de atendimento
        Paciente primeiro = fila.chamarProximo();

        verificar(
            primeiro != null && primeiro.getNome().equals("Ana Silva"),
            "Primeiro paciente chamado corretamente"
        );

        Paciente segundo = fila.chamarProximo();

        verificar(
            segundo != null && segundo.getNome().equals("Bruno Souza"),
            "Segundo paciente chamado corretamente"
        );

        // TESTE 6 - Verificar fila vazia após atendimentos
        verificar(fila.estaVazia(), "Fila fica vazia após os atendimentos");

        verificar(
            fila.chamarProximo() == null,
            "Não retorna paciente quando a fila está vazia"
        );

        

        System.out.println("============================");
        System.out.println("TESTES FINALIZADOS!");
    }

    // Método auxiliar para verificar os resultados
    public static void verificar(boolean resultado, String descricao) {

        if (resultado) {
            System.out.println("[OK] " + descricao);
        } else {
            System.out.println("[ERRO] " + descricao);
            throw new AssertionError("Falha no teste: " + descricao);
        }
    }
}
