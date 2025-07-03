import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empresa";
        String user = "root";
        String password = "senha";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
