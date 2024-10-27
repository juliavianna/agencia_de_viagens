import java.util.ArrayList;
import java.util.List;

public class CompanhiaAerea  {
    private String nome;
    private int codigo;
    private String razaoSocial;
    private String cnpj;
    private static ArrayList<CompanhiaAerea> companhias = new ArrayList<CompanhiaAerea>();
    private double valorBagagensAdicionais;
    private double valorPrimeiraBagagem;

    public CompanhiaAerea(int codigo, String nome, String razaoSocial, String cnpj, double valorPrimeiraBagagem, double valorBagagensAdicionais){
        this.codigo = codigo;
        this.razaoSocial = razaoSocial.toLowerCase();
        this.cnpj = cnpj;
        this.nome = nome.toLowerCase();
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
        this.valorBagagensAdicionais = valorBagagensAdicionais;

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

    public double getValorBagagensAdicionais() {
        return valorBagagensAdicionais;
    }

    public double getValorPrimeiraBagagem() {
        return valorPrimeiraBagagem;
    }

    public List<CompanhiaAerea> getCompanhias() {
        return companhias;
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

    public void setValorBagagensAdicionais(double valorBagagensAdicionais) {
        this.valorBagagensAdicionais = valorBagagensAdicionais;
    }

    public void setValorPrimeiraBagagem(double valorPrimeiraBagagem) {
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
    }

    @Override
    public String toString() {
        return "\nAGÊNCIA:" +
                "\n Código: " + codigo +
                "\n Nome: " + nome +
                "\n Razão social: " + razaoSocial + 
                "\n CNPJ: " + cnpj;
               // "\n Valor da primeira bagagem: " + getValorPrimeiraBagagem();
               // "\n Valor das bagagens adicionais: " + valorBagagensAdicionais();
    }

    public static boolean verificaCompanhia(String nome) {
        for (CompanhiaAerea companhiaAerea : companhias) {
            if (companhiaAerea.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public static CompanhiaAerea buscarCompanhiaAerea(String nome) {

        for (CompanhiaAerea companhiaAerea : companhias) {
            if (companhiaAerea.getNome().toLowerCase().equals(nome.toLowerCase())) {
                return companhiaAerea;
            }
        }
        return null;
    }

}