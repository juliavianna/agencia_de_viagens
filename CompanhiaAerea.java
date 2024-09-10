public class CompanhiaAerea  {
    private int codigo;
    private String razaoSocial;
    private String cnpj;
    private String nome;
    private double valorBagagem;
    private double valorBagagemAdc;

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
    
    public double getValorBagagem() {
        return valorBagagem;
    }

    public double getValorBagagemAdc() {
        return valorBagagemAdc;
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
    
    public void setValorBagagem(double valorBagagem) {
        this.valorBagagem = valorBagagem;
    }

    public void setValorBagagemAdc(double valorBagagemAdc) {
        this.valorBagagemAdc = valorBagagemAdc;
    }



    public CompanhiaAerea(int codigo, String razaoSocial, String cnpj, String nome){
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.nome = nome;
    }
}
