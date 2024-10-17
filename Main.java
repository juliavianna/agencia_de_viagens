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
                        cadastroDeCliente();
                        break;
                    case 6:
                        cadastroDePassagemAerea();
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
    }

    public static void menuInicial() {
        System.out.println("MENU INICIAL");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Fazer Login");
    }

    public static void menuPrincipal() {
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Busca de Passagens");
        System.out.println("2. Cadastro de Funcionário");
        System.out.println("3. Cadastro de Companhia Aérea");
        System.out.println("4. Cadastro de Aeroporto");
        System.out.println("5. Cadastro de Cliente");
        System.out.println("6. Cadastro passagem aérea");
        System.out.println("7. Sair");
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
            System.out.println("Digite a senha de no mínimo 8 dígitos: ");
            senha = scanner.nextLine();
            if (Utils.validarString(senha, 7)) {
                break;
            }
            System.out.println("\nSenha inválida. Tente novamente.");
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
            System.out.println("CNPJ deve possuir mais de 3 caracteres. Tente novamente.");
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

        System.out.println("Digite a sigla do aeroporto: ");
        String sigla = scanner.nextLine();

        System.out.println("Digite a cidade: ");
        String cidade = scanner.nextLine();

        System.out.println("Digite a sigla do estado: ");
        String estado = scanner.nextLine();

        System.out.println("Digite a sigla do pais: ");
        String pais = scanner.nextLine();

        Aeroporto aerop = new Aeroporto(nome, sigla, cidade, estado, pais);
        System.out.println("Aeroporto " + aerop.getNome() + " cadastrado com sucesso. Sigla: " + aerop.getSigla());
        Utils.imprimirDivisoriaComQuebraDeLinha();
    }

    public static void cadastroDeCliente() {
        System.out.println("-------- Cadastro de Cliente --------");

        String nome;
        while (true) {
            System.out.println("Digite o nome do cliente: ");
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

        Cliente cliente = new Cliente(nome, cpf);
        agenciaCentral.adicionarCliente(cliente);
        System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso");
        Utils.imprimirDivisoriaComQuebraDeLinha();
    }

    public static void cadastroDePassagemAerea() {
        System.out.println("-------- Cadastro de Passagem Aérea --------");
        if(AgenciaDeViagem.getCompanhiasAereas().isEmpty()){
            System.out.println("Não há companhias aéreas cadastradas. Cadastre uma companhia aérea antes de cadastrar uma passagem aérea.");
            return;
        }
        if((Aeroporto.getAeroportos().isEmpty())){
            System.out.println("Não há aeroportos cadastrados. Cadastre um aeroporto antes de cadastrar uma passagem aérea.");
            return;
        }
        
        System.out.println("Digite a sigla do Aeroporto de Origem: ");
        String siglaAeroportoOrigem = scanner.nextLine();
        boolean existe = Aeroporto.verificaAeroporto(siglaAeroportoOrigem);
        if(existe == false){
            System.out.println("Aeroporto de Origem não encontrado");
            return;
        }

        System.out.println("Digite a sigla do Aeroporto de Destino: ");
        String siglaAeroportoDestino = scanner.nextLine();
        existe = Aeroporto.verificaAeroporto(siglaAeroportoDestino);
        if(existe == false){
            System.out.println("Aeroporto de Destino não encontrado");
            return;
        }

        System.out.println("Digite a Data e Horário do Voo (formato: YYYY-MM-DD HH:MM): ");
        String dataHoraVoo = scanner.nextLine();

        System.out.println("Digite a Companhia Aérea: ");
        String companhiaAerea = scanner.nextLine();

        System.out.println("Digite o Valor da Tarifa Básica: ");
        double tarifaBasica = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite o Valor da Tarifa Business: ");
        double tarifaBusiness = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite o Valor da Tarifa Premium: ");
        double tarifaPremium = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite o Valor da Primeira Bagagem: ");
        double valorPrimeiraBagagem = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite o Valor das Bagagens Adicionais: ");
        double valorBagagensAdicionais = scanner.nextDouble();
        scanner.nextLine();

        String moeda = "BRL";
       // Cliente cliente = new Cliente(nome, cpf);
       // agenciaCentral.adicionarCliente(cliente);
        
        PassagemAerea passagem = new PassagemAerea(siglaAeroportoOrigem, siglaAeroportoDestino, dataHoraVoo, companhiaAerea,
            tarifaBasica, tarifaBusiness, tarifaPremium, valorPrimeiraBagagem, valorBagagensAdicionais, moeda);
        

                System.out.println("\nPassagem cadastrada com sucesso!");
                System.out.println("Código do Voo: " + passagem.getCodigoVoo());
                System.out.println("Aeroporto de Origem: " + passagem.getAeroportoOrigem());
                System.out.println("Aeroporto de Destino: " + passagem.getAeroportoDestino());
                System.out.println("Data e Hora do Voo: " + passagem.getDataHoraVoo());
                System.out.println("Companhia Aérea: " + passagem.getCompanhiaAerea());
                System.out.println("Tarifa Básica: R$" + passagem.getTarifaBasica());
                System.out.println("Tarifa Business: R$" + passagem.getTarifaBusiness());
                System.out.println("Tarifa Premium: R$" + passagem.getTarifaPremium());
                System.out.println("Valor da Primeira Bagagem: R$" + passagem.getValorPrimeiraBagagem());
                System.out.println("Valor das Bagagens Adicionais: R$" + passagem.getValorBagagensAdicionais());
                System.out.println("Moeda: " + passagem.getMoeda());
        Utils.imprimirDivisoriaComQuebraDeLinha();
    }
}