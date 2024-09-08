public class Passagem {
    private String aeropOrigem;
    private String aeropDestino;
    private double valorBasico;
    private double valorBusiness;
    private double valorPremium;
    private double valorBagagem;
    private double valorBagagemAdc;
    private static final String moeda = "real";
    private double valorTotal;
    private double taxaComissaoAgencia;

    public String getAeropOrigem() {
        return aeropOrigem;
    }

    public String getAeropDestino() {
        return aeropDestino;
    }

    public double getValorBasico() {
        return valorBasico;
    }

    public double getValorBusiness() {
        return valorBusiness;
    }

    public double getValorPremium() {
        return valorPremium;
    }

    public double getValorBagagem() {
        return valorBagagem;
    }

    public double getValorBagagemAdc() {
        return valorBagagemAdc;
    }

    public static String getMoeda() {
        return moeda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getTaxaComissaoAgencia() {
        return taxaComissaoAgencia;
    }

    public void setAeropOrigem(String aeropOrigem) {
        this.aeropOrigem = aeropOrigem;
    }

    public void setAeropDestino(String aeropDestino) {
        this.aeropDestino = aeropDestino;
    }

    public void setValorBasico(double valorBasico) {
        this.valorBasico = valorBasico;
    }

    public void setValorBusiness(double valorBusiness) {
        this.valorBusiness = valorBusiness;
    }

    public void setValorPremium(double valorPremium) {
        this.valorPremium = valorPremium;
    }

    public void setValorBagagem(double valorBagagem) {
        this.valorBagagem = valorBagagem;
    }

    public void setValorBagagemAdc(double valorBagagemAdc) {
        this.valorBagagemAdc = valorBagagemAdc;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setTaxaComissaoAgencia(double taxaComissaoAgencia) {
        this.taxaComissaoAgencia = taxaComissaoAgencia;
    }

    public Passagem(String aeropOrigem, String aeropDestino, double valorBasico, double valorBusiness, double valorPremium, double valorBagagem, double valorBagagemAdc, double valorTotal, double taxaComissaoAgencia){
        this.aeropOrigem= aeropOrigem;
        this.aeropDestino = aeropDestino;
        this.valorBasico = valorBasico;
        this.valorBusiness = valorBusiness;
        this.valorPremium = valorPremium;
        this.valorBagagem = valorBagagem;
        this.valorBagagemAdc = valorBagagemAdc;
       // this.moeda = getMoeda(); //????
        this.valorTotal = valorTotal;
        this.taxaComissaoAgencia = taxaComissaoAgencia;
    }
}
