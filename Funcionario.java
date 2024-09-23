import java.util.List;
import java.util.ArrayList;

public class Funcionario {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private static List<Funcionario> funcionarios = new ArrayList<>();


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public void setCpf(String cpf) {
        if (cpf != null && !cpf.isEmpty() && cpf.length() == 11) {
            this.cpf = cpf;
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
    }

    public void setSenha(String senha) {
        if (senha != null && !senha.isEmpty()) {
            this.senha = senha;
        }
    }

    public Funcionario(String nome, String cpf, String email, String senha){ 
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;

        funcionarios.add(this);
    }
    
    @Override
    public String toString() {
        return "Funcionario{" + "nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + ", email='" + email + '\'' + ", senha='" + senha + '\'' +'}';
    }
    

}
