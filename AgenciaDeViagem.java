import java.util.List;
import java.util.ArrayList;

public class AgenciaDeViagem {
    private List<Funcionario> funcionarios;
    private List<CompanhiaAerea> companhiasAereas;

    public AgenciaDeViagem() {
        this.funcionarios = new ArrayList<>();
        this.companhiasAereas = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
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

    public List<CompanhiaAerea> getCompanhiasAereas() {
        return companhiasAereas;
    }

    public void listarCompanhiasAereas() {
        for (CompanhiaAerea companhiaAerea : companhiasAereas) {
            System.out.println(companhiaAerea);
        }
    }
}