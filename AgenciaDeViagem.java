import java.util.List;
import java.util.ArrayList;

public class AgenciaDeViagem {
    private List<Funcionario> funcionarios;
    private static List<CompanhiaAerea> companhiasAereas;
    private List<Cliente> clientes;
    private static double taxaFixa = 50.0;

    public AgenciaDeViagem() {
        this.funcionarios = new ArrayList<>();
        this.companhiasAereas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public static double getTaxaFixa() { // Adiciona um método para obter a taxa fixa
        return taxaFixa;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    public void adicionarCompanhiaAerea(CompanhiaAerea companhiaAerea) {
        companhiasAereas.add(companhiaAerea);
    }

    public static List<CompanhiaAerea> getCompanhiasAereas() {
        return companhiasAereas;
    }

    public void listarCompanhiasAereas() {
        for (CompanhiaAerea companhiaAerea : companhiasAereas) {
            System.out.println(companhiaAerea);
        }
    }
    
}