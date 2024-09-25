import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        AgenciaDeViagem agenciaCentral = new AgenciaDeViagem();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Olá! Bem vindo a agencia de viagens :)");
        
        while (true) {

            menuPrincipal();

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("-------- Busca de Passagens --------");
                    System.out.println("a complementar");
                    imprimirDivisoriaComQuebraDeLinha();
                    break;

                case 2:
                    System.out.println("-------- Cadastro de Funcionario --------");

                    String nome;
                    while (true) {
                        System.out.println("Digite o nome do funcionário: ");
                        nome = scanner.nextLine();
                        if (!nome.isEmpty()) {
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
                        if (!email.isEmpty() && email.contains("@")) {
                            break;
                        }
                        System.out.println("Email inválido. Tente novamente.");
                    }

                    String senha;
                    while (true) {
                        System.out.println("Digite a senha: ");
                        senha = scanner.nextLine();
                        if (!senha.isEmpty() && senha.length() > 3) {
                            break;
                        }
                        System.out.println("Senha inválida. Tente novamente.");
                    }

                    Funcionario funcionario = new Funcionario(nome, cpf, email, senha);
                    agenciaCentral.adicionarFuncionario(funcionario);
                    System.out.println("Funcionario " + funcionario.getNome() + " cadastrado com sucesso");
                    imprimirDivisoriaComQuebraDeLinha();
                    break;

                    case 3:
                    System.out.println("-------- Cadastro de Companhia Aerea --------");
                    
                    String nomeCiaAerea;
                    while (true) {
                        System.out.println("Digite o nome da companhia: ");
                        nomeCiaAerea = scanner.nextLine();
                        if (!nomeCiaAerea.isEmpty() && nomeCiaAerea.length() > 2) {
                            break;
                        }
                        System.out.println("Nome inválido. Tente novamente.");
                    }
                
                    String rSocial;
                    while (true) {
                        System.out.println("Digite a razao social: ");
                        rSocial = scanner.nextLine();
                        if (!rSocial.isEmpty() && rSocial.length() > 3) {
                            break;
                        }
                        System.out.println("Razão social inválida. Tente novamente.");
                    }
                    
                    String cnpj;
                    while (true) {
                        System.out.println("Digite o CNPJ: ");
                        cnpj = scanner.nextLine();
                        if (!cnpj.isEmpty() && cnpj.length() > 3) {
                            break;
                        }
                        System.out.println("CNPJ inválido. Tente novamente.");
                    }
                    
                    int codigoCiaAerea = gerarCodigoCiaAerea();
                    CompanhiaAerea companhia = new CompanhiaAerea(codigoCiaAerea, nomeCiaAerea, rSocial, cnpj);
                    agenciaCentral.adicionarCompanhiaAerea(companhia);
                    System.out.println("Companhia Aérea " + companhia.getNome() + " cadastrada com sucesso");
                    imprimirDivisoriaComQuebraDeLinha();
                    break;

                case 4:
                    System.out.println("-------- Cadastro de Aeroporto --------");
                    System.out.println("Digite o nome do aeroporto: ");
                    nome = scanner.nextLine();
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
                    break;

                case 5:
                    agenciaCentral.listarFuncionarios();
                    imprimirDivisoriaComQuebraDeLinha();
                    break;

                case 6:
                    agenciaCentral.listarCompanhiasAereas();
                    imprimirDivisoriaComQuebraDeLinha();
                    break;

                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void menuPrincipal() {
        System.out.println("--------------------------------------");
        System.out.println("O que deseja fazer?");
        System.out.println("1- Buscar passagens");
        System.out.println("2- Cadastrar funcionario");
        System.out.println("3- Cadastrar companhia aerea");
        System.out.println("4- Cadastrar aeroporto");
        System.out.println("5- Listar funcionários");
        System.out.println("6- Listar companhias aéreas");
        System.out.println("7- SAIR");
        System.out.println("");
    }

    public static int gerarCodigoCiaAerea() {
        Random random = new Random();
        return 10 + random.nextInt(90);
    }

    public static void imprimirDivisoriaComQuebraDeLinha(){
        System.out.println("-------------------------------------------\n");
    }
}

/*
 * Passagem p1 = new Passagem("GRU", "BPS", 540.99);
 * Passagem p2 = new Passagem("SDU", "GRU", 270);
 * Passagem p3 = new Passagem("CNF", "FEN", 1020.00);
 
 * Voo bhPortoSeguro = new Voo("Belo Horizonte", "Porto Seguro",
 * "15/09/2024 10:00", "HH1234", gol, 200.00, 400, 750.50);
 * Voo bhPsp = new Voo("Belo Horizonte", "Sao Paulo", "27/12/2024 10:00",
 * "LL0000", gol, 170.00, 200, 550.50);
 * Voo spPMadrid = new Voo("Sao Paulo", "Madrid", "20/11/2024 15:00", "MM0000",
 * copa, 3100.00, 4500, 7500.50);
 * Voo bhPrj = new Voo("Belo Horizonte", "Rio de Janeiro", "1/10/2024 12:00",
 * "RJ1000", latam, 190.00, 400, 700.50);
 */