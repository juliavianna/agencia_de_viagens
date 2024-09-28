import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AgenciaDeViagem agenciaCentral = new AgenciaDeViagem();
    private static Funcionario funcionarioLogado = null;

    public static void main(String[] args) {
        System.out.println("Olá! Bem vindo à agência de viagens :)");

        while (true) {
            if (funcionarioLogado == null) {
                menuInicial();
            } else {
                menuPrincipal();
            }

            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (funcionarioLogado == null) {
                switch (escolha) {
                    case 1:
                        cadastradoDeFuncionario();
                        break;
                    case 2:
                        loginFuncionario();
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } else {
                switch (escolha) {
                    case 1:
                        System.out.println("-------- Busca de Passagens --------");
                        Utils.imprimirDivisoriaComQuebraDeLinha();
                        break;
                    case 2:
                        cadastradoDeFuncionario();
                        break;
                    case 3:
                        cadastroDeCompanhiaAerea();
                        break;
                    case 4:
                        cadastroDeAeroporto();
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    case 6:
                        funcionarioLogado = null;
                        System.out.println("Logout realizado com sucesso.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        }
    }
 
    public static void menuInicial() {
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Fazer Login");
    }

    public static void menuPrincipal() {
        System.out.println("1. Busca de Passagens");
        System.out.println("2. Cadastro de Funcionário");
        System.out.println("3. Cadastro de Companhia Aérea");
        System.out.println("4. Cadastro de Aeroporto");
        System.out.println("5. Sair");
        System.out.println("6. Logout");
    }

    public static void loginFuncionario() {
        System.out.println("-------- Login de Funcionário --------");

        System.out.println("Digite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        for (Funcionario funcionario : agenciaCentral.getFuncionarios()) {
            if (funcionario.getCpf().equals(cpf) && funcionario.getSenha().equals(senha)) {
                funcionarioLogado = funcionario;
                System.out.println("\nLogin realizado com sucesso. Bem-vindo, " + funcionario.getNome() + "!");
                Utils.imprimirDivisoriaComQuebraDeLinha();
                return;
            }
        }

        System.out.println("CPF ou senha inválidos. Tente novamente.");
        Utils.imprimirDivisoriaComQuebraDeLinha();
    }

    public static void cadastradoDeFuncionario() {
        System.out.println("-------- Cadastro de Funcionario --------");

        String nome;
        while (true) {
            System.out.println("Digite o nome do funcionário: ");
            nome = scanner.nextLine();
            if (Utils.validarString(nome, 0)) {
                break;
            }
            System.out.println("Nome inválido. Tente novamente.");
        }

        String cpf;
        while (true) {
            System.out.println("Digite o CPF (apenas os 11 numeros) : ");
            cpf = scanner.nextLine();
            if (cpf.length() == 11) {
                break;
            }
            System.out.println("CPF inválido. Tente novamente.");
        }

        String email;
        while (true) {
            System.out.println("Digite o Email: ");
            email = scanner.nextLine();
            if (Utils.validarString(email, 3) && email.contains("@")) {
                break;
            }
            System.out.println("Email inválido. Tente novamente.");
        }

        String senha;
        while (true) {
            System.out.println("Digite a senha: ");
            senha = scanner.nextLine();
            if (Utils.validarString(senha, 7)) {
                break;
            }
            System.out.println("Senha inválida. Tente novamente.");
        }

        Funcionario funcionario = new Funcionario(nome, cpf, email, senha);
        agenciaCentral.adicionarFuncionario(funcionario);
        System.out.println("Funcionario " + funcionario.getNome() + " cadastrado com sucesso");
        Utils.imprimirDivisoriaComQuebraDeLinha();
    }

    public static void cadastroDeCompanhiaAerea() {
        System.out.println("-------- Cadastro de Companhia Aerea --------");

        String nomeCiaAerea;
        while (true) {
            System.out.println("Digite o nome da companhia: ");
            nomeCiaAerea = scanner.nextLine();
            if (Utils.validarString(nomeCiaAerea, 3)) {
                break;
            }
            System.out.println("Nome inválido. Tente novamente.");
        }

        String rSocial;
        while (true) {
            System.out.println("Digite a razao social: ");
            rSocial = scanner.nextLine();
            if (Utils.validarString(rSocial, 3)) {
                break;
            }
            System.out.println("Razão social inválida. Tente novamente.");
        }

        String cnpj;
        while (true) {
            System.out.println("Digite o CNPJ: ");
            cnpj = scanner.nextLine();
            if (Utils.validarString(cnpj, 3)) {
                break;
            }
            System.out.println("CNPJ inválido. Tente novamente.");
        }

        int codigoCiaAerea = Utils.gerarCodigoDeID();
        CompanhiaAerea companhia = new CompanhiaAerea(codigoCiaAerea, nomeCiaAerea, rSocial, cnpj);
        agenciaCentral.adicionarCompanhiaAerea(companhia);
        System.out.println("Companhia Aérea " + companhia.getNome() + " cadastrada com sucesso");
        Utils.imprimirDivisoriaComQuebraDeLinha();
    }

    public static void cadastroDeAeroporto() {
        System.out.println("-------- Cadastro de Aeroporto --------");
        System.out.println("Digite o nome do aeroporto: ");
        String nome = scanner.nextLine();

        System.out.println("Digite a sigla aeroporto: ");
        String sigla = scanner.nextLine();

        System.out.println("Digite a cidade: ");
        String cidade = scanner.nextLine();

        System.out.println("Digite o estado: ");
        String estado = scanner.nextLine();

        System.out.println("Digite o pais: ");
        String pais = scanner.nextLine();

        Aeroporto aerop = new Aeroporto(nome, sigla, cidade, estado, pais);
        System.out.println("Aeroporto " + aerop.getNome() + " cadastrado com sucesso");
        Utils.imprimirDivisoriaComQuebraDeLinha();
        }
}