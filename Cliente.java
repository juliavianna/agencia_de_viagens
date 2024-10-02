public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
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

    @Override
    public String toString() {
        return "\nCLIENTE:" +
                "\nNome: " + nome +
                "\nCPF: " + cpf;
    }
}