public class PassagemAerea {
    private String aeroportoOrigem;
    private String aeroportoDestino;
    private String dataHoraVoo;
    private String codigoVoo;
    private String companhiaAerea;
    private double tarifaBasica;
    private double tarifaBusiness;
    private double tarifaPremium;
    private double valorPrimeiraBagagem;
    private double valorBagagensAdicionais;
    private String moeda;

    public PassagemAerea(String aeroportoOrigem, String aeroportoDestino, String dataHoraVoo, String companhiaAerea, double tarifaBasica, double tarifaBusiness, double tarifaPremium, double valorPrimeiraBagagem, double valorBagagensAdicionais, String moeda) {
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.dataHoraVoo = dataHoraVoo;
        this.codigoVoo = Utils.gerarCodigoVoo();
        this.companhiaAerea = companhiaAerea;
        this.tarifaBasica = tarifaBasica;
        this.tarifaBusiness = tarifaBusiness;
        this.tarifaPremium = tarifaPremium;
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
        this.valorBagagensAdicionais = valorBagagensAdicionais;
        this.moeda = moeda;
    }

    public String getCodigoVoo() {
        return this.codigoVoo;
    }

    public String getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public String getAeroportoDestino() {
        return aeroportoDestino;
    }

    public String getDataHoraVoo() {
        return dataHoraVoo;
    }

    public String getCompanhiaAerea() {
        return companhiaAerea;
    }

    public double getTarifaBasica() {
        return tarifaBasica;
    }

    public double getTarifaBusiness() {
        return tarifaBusiness;
    }

    public double getTarifaPremium() {
        return tarifaPremium;
    }

    public double getValorPrimeiraBagagem() {
        return valorPrimeiraBagagem;
    }

    public double getValorBagagensAdicionais() {
        return valorBagagensAdicionais;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setAeroportoOrigem(String aeroportoOrigem) {
        this.aeroportoOrigem = aeroportoOrigem;
    }

    public void setAeroportoDestino(String aeroportoDestino) {
        this.aeroportoDestino = aeroportoDestino;
    }

    public void setDataHoraVoo(String dataHoraVoo) {
        this.dataHoraVoo = dataHoraVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public void setCompanhiaAerea(String companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    public void setTarifaBasica(double tarifaBasica) {
        this.tarifaBasica = tarifaBasica;
    }

    public void setTarifaBusiness(double tarifaBusiness) {
        this.tarifaBusiness = tarifaBusiness;
    }

    public void setTarifaPremium(double tarifaPremium) {
        this.tarifaPremium = tarifaPremium;
    }

    public void setValorPrimeiraBagagem(double valorPrimeiraBagagem) {
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
    }

    public void setValorBagagensAdicionais(double valorBagagensAdicionais) {
        this.valorBagagensAdicionais = valorBagagensAdicionais;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }
}