public class Funcionario {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    
    public Funcionario(String nome, String cpf, String email, String senha){ 
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

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
    
    @Override
    public String toString() {
        return "Funcionario{" + "nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + ", email='" + email + '\'' + ", senha='" + senha + '\'' +'}';
    }
}
