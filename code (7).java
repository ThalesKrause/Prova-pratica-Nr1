import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/empresa"; // URL do banco de dados
    private static final String USER = "root"; // Nome de usuário do banco de dados
    private static final String PASSWORD = "senha"; // Senha do banco de dados

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Estabelecendo a conexão
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return connection;
    }
}
