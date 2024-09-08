public class Funcionario {
    private String nome;
    private String cpf;
    private String email;
    private String senha;

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
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario(String nome, String cpf, String email, String senha){ //construtor tem o mesmo nome da classe e nao retorna nada
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;

    }

    public static void Main(String[] args){
        Funcionario funcionario1 = new Funcionario("julia", "70043688888", "julia@gmail.com", "123");


    }


}
