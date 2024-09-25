import java.util.Scanner;
import java.util.Random;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AgenciaDeViagem agenciaCentral = new AgenciaDeViagem();

    public static void main(String[] args) {

        System.out.println("Olá! Bem vindo a agencia de viagens :)");

        while (true) {

            menuPrincipal();

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("-------- Busca de Passagens --------");
                    imprimirDivisoriaComQuebraDeLinha();
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

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void imprimirDivisoriaComQuebraDeLinha() {
        System.out.println("-------------------------------------------\n");
    }

    public static void menuPrincipal() {
        System.out.println("--------------------------------------");
        System.out.println("O que deseja fazer?");
        // System.out.println("1- Buscar passagens");
        System.out.println("2- Cadastrar funcionario");
        System.out.println("3- Cadastrar companhia aerea");
        System.out.println("4- Cadastrar aeroporto");
        System.out.println("5- SAIR");
        System.out.println("");
    }

    public static void cadastradoDeFuncionario() {
        System.out.println("-------- Cadastro de Funcionario --------");

        String nome;
        while (true) {
            System.out.println("Digite o nome do funcionário: ");
            nome = scanner.nextLine();
            if (validarString(nome, 0)) {
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
            if (validarString(email, 4) && email.contains("@")) {
                break;
            }
            System.out.println("Email inválido. Tente novamente.");
        }

        String senha;
        while (true) {
            System.out.println("Digite a senha: ");
            senha = scanner.nextLine();
            if (validarString(senha, 6)) {
                break;
            }
            System.out.println("Senha inválida. Tente novamente.");
        }

        Funcionario funcionario = new Funcionario(nome, cpf, email, senha);
        agenciaCentral.adicionarFuncionario(funcionario);
        System.out.println("Funcionario " + funcionario.getNome() + " cadastrado com sucesso");
        imprimirDivisoriaComQuebraDeLinha();
    }

    public static boolean validarString(String str, int tamanhoMinimo) {
        return !str.isEmpty() && str.length() > tamanhoMinimo;
    }

    public static void cadastroDeCompanhiaAerea() {
        System.out.println("-------- Cadastro de Companhia Aerea --------");

        String nomeCiaAerea;
        while (true) {
            System.out.println("Digite o nome da companhia: ");
            nomeCiaAerea = scanner.nextLine();
            if (validarString(nomeCiaAerea, 3)) {
                break;
            }
            System.out.println("Nome inválido. Tente novamente.");
        }

        String rSocial;
        while (true) {
            System.out.println("Digite a razao social: ");
            rSocial = scanner.nextLine();
            if (validarString(rSocial, 3)) {
                break;
            }
            System.out.println("Razão social inválida. Tente novamente.");
        }

        String cnpj;
        while (true) {
            System.out.println("Digite o CNPJ: ");
            cnpj = scanner.nextLine();
            if (validarString(cnpj, 3)) {
                break;
            }
            System.out.println("CNPJ inválido. Tente novamente.");
        }

        int codigoCiaAerea = gerarCodigoCiaAerea();
        CompanhiaAerea companhia = new CompanhiaAerea(codigoCiaAerea, nomeCiaAerea, rSocial, cnpj);
        agenciaCentral.adicionarCompanhiaAerea(companhia);
        System.out.println("Companhia Aérea " + companhia.getNome() + " cadastrada com sucesso");
        imprimirDivisoriaComQuebraDeLinha();
    }

    public static int gerarCodigoCiaAerea() {
        Random random = new Random();
        return 10 + random.nextInt(90);
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
        imprimirDivisoriaComQuebraDeLinha();
    }
}