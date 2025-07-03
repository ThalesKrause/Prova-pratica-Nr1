import java.sql.*;

public class ProjetoDAO {
    private Connection connection;

    public ProjetoDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Projeto projeto) throws SQLException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connection);
        if (!funcionarioDAO.exists(projeto.getIdFuncionario())) {
            System.out.println("Erro: Projeto não pode ser criado sem vínculo com um funcionário existente.");
            return;
        }

        String sql = "INSERT INTO projeto (nome, descricao, id_funcionario) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setInt(3, projeto.getIdFuncionario());
            stmt.executeUpdate();
            System.out.println("Projeto cadastrado com sucesso: " + projeto.getNome());
        }
    }

    public boolean isFuncionarioLinked(int funcionarioId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM projeto WHERE id_funcionario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, funcionarioId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
}
