public class Funcionario extends Pessoa {
    private String matricula;
    private String departamento;

    public Funcionario(String nome, String email, String matricula, String departamento) {
        super(nome, email);
        this.matricula = matricula;
        this.departamento = departamento;
    }

    // Getters e Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
}
