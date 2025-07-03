import java.sql.*;

public class PessoaDAO {
    private Connection connection;

    public PessoaDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa (nome, email) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                pessoa.setId(generatedKeys.getInt(1));
                System.out.println("Pessoa cadastrada com sucesso: " + pessoa.getNome());
            }
        }
    }

    public boolean exists(int id) throws SQLException {
        String sql = "SELECT COUNT(*) FROM pessoa WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
}
