public class Compra {
    private double valor;
    private String metodo;
    private boolean confirmacao;

    public double getValor() {
        return valor;
    }

    public String getMetodo() {
        return metodo;
    }
    
    public boolean getConfirmacao() {
        return confirmacao;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setConfirmacao(boolean confirmacao) {
        this.confirmacao = confirmacao;
    }


}
