import java.util.ArrayList;
import java.util.List;

public class CompanhiaAerea  {
    private String nome;
    private int codigo;
    private String razaoSocial;
    private String cnpj;
    private static ArrayList<CompanhiaAerea> companhias = new ArrayList<CompanhiaAerea>();
    
    public CompanhiaAerea(int codigo, String nome, String razaoSocial, String cnpj){
        this.codigo = codigo;
        this.razaoSocial = razaoSocial.toLowerCase();
        this.cnpj = cnpj;
        this.nome = nome.toLowerCase();

        companhias.add(this);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nAGÊNCIA:" +
                "\n Código: " + codigo +
                "\n Nome: " + nome +
                "\n Razão social: " + razaoSocial + 
                "\n CNPJ: " + cnpj;
    }

    public static boolean verificaCompanhia(String nome) {
        for (CompanhiaAerea companhiaAerea : companhias) {
            if (companhiaAerea.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
}