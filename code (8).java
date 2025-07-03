public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                // Aqui você pode chamar seus DAOs e realizar operações
                PessoaDAO pessoaDAO = new PessoaDAO(connection);
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connection);
                ProjetoDAO projetoDAO = new ProjetoDAO(connection);

                // Exemplo de uso
                Pessoa pessoa = new Pessoa("João Silva", "joao@example.com");
                pessoaDAO.create(pessoa);

                Funcionario funcionario = new Funcionario(pessoa.getId(), "F001", "TI");
                funcionarioDAO.create(funcionario);

                Projeto projeto = new Projeto("Projeto A", "Descrição do Projeto A", funcionario.getId());
                projetoDAO.create(projeto);

                // Excluir funcionário
                funcionarioDAO.delete(funcionario.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
