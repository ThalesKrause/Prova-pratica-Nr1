import java.sql.*;

public class FuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Funcionario funcionario) throws SQLException {
        PessoaDAO pessoaDAO = new PessoaDAO(connection);
        if (!pessoaDAO.exists(funcionario.getId())) {
            System.out.println("Erro: ID da pessoa não existe.");
            return;
        }

        String sql = "INSERT INTO funcionario (id, matricula, departamento) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getMatricula());
            stmt.setString(3, funcionario.getDepartamento());
            stmt.executeUpdate();
            System.out.println("Funcionário cadastrado com sucesso: " + funcionario.getNome());
        }
    }

    public void delete(int id) throws SQLException {
        // Verificar se o funcionário está vinculado a algum projeto
        ProjetoDAO projetoDAO = new ProjetoDAO(connection);
        if (projetoDAO.isFuncionarioLinked(id)) {
            System.out.println("Erro: Funcionário não pode ser excluído, está vinculado a um projeto.");
            return;
        }

        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Funcionário excluído com sucesso.");
        }
    }
}
