import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AgenciaDeViagem agenciaCentral = new AgenciaDeViagem();
    private static Funcionario funcionarioLogado = null;


    public static void main(String[] args) {

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Funcionario teste = new Funcionario("teste", "11111111111", "teste@gmail", "12345678");  //NAO ESQUECER DE REMOVER !!!!!!!!!!!!!!!!!!!
        agenciaCentral.adicionarFuncionario(teste);
        Aeroporto aeroporto = new Aeroporto("Aeroporto Internacional de Guarulhos", "GRU", "Guarulhos", "SP", "br");
        Aeroporto aeroporto2 = new Aeroporto("Aeroporto Internacional de Confins", "CNF", "Belo horizonte", "bh", "br");
        
        CompanhiaAerea companhia = new CompanhiaAerea(1, "Gol", "Gol", "123456789", 30.0, 50.0);
        CompanhiaAerea companhia2 = new CompanhiaAerea(2, "Azul", "Azul", "987654321", 30.0, 50.0);
        agenciaCentral.adicionarCompanhiaAerea(companhia);
        agenciaCentral.adicionarCompanhiaAerea(companhia2);

        agenciaCentral.adicionarCliente(new Cliente("João", "12345678901"));
        
        PassagemAerea p1 = new PassagemAerea ("GRU", "CNF", "2024-10-20 20:00", "Gol", 100.0, 200.0, 300.0, 50.0, 30.0);
        PassagemAerea p2 = new PassagemAerea ("CNF", "GRU", "2024-10-25 20:00", "Azul", 100.0, 200.0, 300.0, 50.0, 30.0);
        List<PassagemAerea> passagens = new ArrayList<>();
        passagens.add(p1);
        passagens.add(p2);

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
                        buscarPassagens();
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
                        comprarPassagem(passagens);
                        break;
                    case 8:
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
        System.out.println("7. Comprar Passagem");
        System.out.println("8. Sair");
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

    public static void buscarPassagens(){
        System.out.println("-------- Busca de Passagens --------");
        System.out.println("O que vocÊ desja buscar?");
        System.out.println("1. Passagens de Ida");
        System.out.println("2. Passagens de Ida e Volta");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        if(escolha == 1){
            buscaDePassagensIda();
        }
        else if(escolha == 2){
            buscaDePassagensIdaVolta();
        }
        else{
            System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public static String buscaDePassagensIda() {
        System.out.println("-------- Busca de Passagens --------");
        boolean passagensCadastradas = !PassagemAerea.getPassagens().isEmpty();
        if (!passagensCadastradas) {
            System.out.println("Não há PASSAGENS. Cadastre uma companhia aérea antes de buscar passagens.\n");
            Utils.imprimirDivisoriaComQuebraDeLinha();
            return "Erro";
        }

        System.out.println("Digite o aeroporto de Origem: "); 
        String origem = scanner.nextLine();
        System.out.println("Digite o aeroporto de Destino: ");
        String destino = scanner.nextLine();
        System.out.println("Digite a data (formato: yyyy-MM-ddTHH:mm:ss): ");
        String dataIda = scanner.nextLine();

        System.out.println("Voo de Ida: ");
        String passagens = PassagemAerea.buscarPassagensIda(origem.toLowerCase(), destino.toLowerCase(), dataIda);
        
        if (passagens.isEmpty()) {
            System.out.println("Nenhuma passagem encontrada para os critérios fornecidos.");
            return "Nenhuma passagem encontrada";
        } else {
            return "Passagens encontradas: " + passagens;
        }
    }

    public static void buscaDePassagensIdaVolta() {
        System.out.println("-------- Busca de Passagens --------");
        boolean passagensCadastradas = !PassagemAerea.getPassagens().isEmpty();
        if (!passagensCadastradas) {
            System.out.println("Não há PASSAGENS. Cadastre uma companhia aérea antes de buscar passagens./n");
            Utils.imprimirDivisoriaComQuebraDeLinha();
            return;
        }

        System.out.println("Digite a cidade de Origem: "); 
        String origem = scanner.nextLine();
        System.out.println("Digite a cidade de Destino: ");
        String destino = scanner.nextLine();
        System.out.println("Digite a data de ida: ");
        String dataIda = scanner.nextLine();
        System.out.println("Digite a data de volta: ");
        String dataVolta = scanner.nextLine();

        System.out.println("Voo de Ida: ");
        PassagemAerea.buscarPassagensIda(origem.toLowerCase(), destino.toLowerCase(), dataIda);
        System.out.println("Voo de Volta: ");
        PassagemAerea.buscarPassagensIda(destino, origem, dataVolta);
        
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

        double bagagem;
        while (true) {
            System.out.println("Digite o valor da Primeira Bagagem: ");
            bagagem = scanner.nextDouble();
            if (bagagem == 0) {
                break;
            }
            System.out.println("Bagagem deve possuir um valor. Tente novamente.");
        }

        double bagagemAdc;
        while (true) {
            System.out.println("Digite o valor das Bagagens adicionais: ");
            bagagemAdc = scanner.nextDouble();
            if (bagagemAdc == 0) {
                break;
            }
            System.out.println("Bagagem deve possuir um valor. Tente novamente.");
        }

        int codigoCiaAerea = Utils.gerarCodigoDeID();
        CompanhiaAerea companhia = new CompanhiaAerea(codigoCiaAerea, nomeCiaAerea, rSocial, cnpj, bagagem, bagagemAdc);
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
            System.out.println("Não há COMPANHIAS AEREAS cadastradas. Cadastre uma companhia aérea antes de cadastrar uma passagem aérea.");
            Utils.imprimirDivisoriaComQuebraDeLinha();
            return;
        }
        if((Aeroporto.getAeroportos().isEmpty() || Aeroporto.getAeroportos().size() == 1)){
            System.out.println("Não há AEROPORTOS cadastrados. Cadastre um aeroporto antes de cadastrar uma passagem aérea.");
            Utils.imprimirDivisoriaComQuebraDeLinha();
            return;
        }
        
        System.out.println("Digite a sigla do Aeroporto de Origem: ");
        String siglaAeroportoOrigem = scanner.nextLine();
        boolean existe = Aeroporto.verificaAeroporto(siglaAeroportoOrigem);
        if(existe == false){
            System.out.println("Aeroporto de Origem não encontrado");
            System.out.println("Digite novamente a sigla do Aeroporto de Origem: ");
            siglaAeroportoOrigem = scanner.nextLine();
            existe = Aeroporto.verificaAeroporto(siglaAeroportoOrigem);
            if(existe == false){
                System.out.println("Aeroporto de Origem não encontrado");
                return;
            }
        }

        System.out.println("Digite a sigla do Aeroporto de Destino: ");
        String siglaAeroportoDestino = scanner.nextLine();
        boolean existe2 = Aeroporto.verificaAeroporto(siglaAeroportoDestino);
        if(existe2 == false){
            System.out.println("Aeroporto de Destino não encontrado");
            System.out.println("Digite novamente a sigla do Aeroporto de Destino: ");
            siglaAeroportoOrigem = scanner.nextLine();
            existe2 = Aeroporto.verificaAeroporto(siglaAeroportoDestino);
            if(existe == false){
                System.out.println("Aeroporto de Destino não encontrado");
                return;
            }       
        }

        System.out.println("Digite a Data e Horário do Voo (formato: YYYY-MM-DD HH:MM): ");
        String dataHoraVoo = scanner.nextLine();

        System.out.println("Digite a Companhia Aérea: ");
        String companhiaAerea = scanner.nextLine();
        existe = CompanhiaAerea.verificaCompanhia(companhiaAerea);
        if(existe == false){
            System.out.println("Companhia Aérea não encontrada");
            System.out.println("Digite novamente a Companhia Aérea: ");
            companhiaAerea = scanner.nextLine();
            existe = CompanhiaAerea.verificaCompanhia(companhiaAerea);
            if(existe == false){
                System.out.println("Companhia Aérea não encontrada");
                return;
            }
        }

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
            tarifaBasica, tarifaBusiness, tarifaPremium, valorPrimeiraBagagem, valorBagagensAdicionais);
        

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

    public static void comprarPassagem(List<PassagemAerea> passagensExistentes) {
        System.out.println("Deseja adicionar voos a uma passagem existente? (s/n)");
        String resposta = scanner.nextLine();
        PassagemAerea passagem;

        if (resposta.equalsIgnoreCase("s")) {
            System.out.println("Selecione a passagem:");
            for (int i = 0; i < passagensExistentes.size(); i++) {
                System.out.println((i + 1) + ": " + passagensExistentes.get(i).toString());
            }
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            passagem = passagensExistentes.get(escolha - 1);
        } else {
            System.out.println("Digite o aeroporto de origem:");
            String aeroportoOrigem = scanner.nextLine();
            System.out.println("Digite o aeroporto de destino:");
            String aeroportoDestino = scanner.nextLine();
            System.out.println("Digite a data e hora do voo (formato: yyyy-MM-dd HH:mm):");
            String dataHoraVoo = scanner.nextLine();
            System.out.println("Digite a companhia aérea:");
            String companhiaAerea = scanner.nextLine();
            System.out.println("Digite a tarifa básica:");
            double tarifaBasica = scanner.nextDouble();
            System.out.println("Digite a tarifa business:");
            double tarifaBusiness = scanner.nextDouble();
            System.out.println("Digite a tarifa premium:");
            double tarifaPremium = scanner.nextDouble();
            System.out.println("Digite o valor da primeira bagagem:");
            double valorPrimeiraBagagem = scanner.nextDouble();
            System.out.println("Digite o valor das bagagens adicionais:");
            double valorBagagensAdicionais = scanner.nextDouble();
            scanner.nextLine();

            passagem = new PassagemAerea(aeroportoOrigem, aeroportoDestino, dataHoraVoo, companhiaAerea, tarifaBasica, tarifaBusiness, tarifaPremium, valorPrimeiraBagagem, valorBagagensAdicionais);
            passagensExistentes.add(passagem);
        }

        boolean adicionarMaisVoos = true;
        while (adicionarMaisVoos) {
            System.out.println("Digite a origem do voo:");
            String origem = scanner.nextLine();
            System.out.println("Digite o destino do voo:");
            String destino = scanner.nextLine();
            System.out.println("Digite a data e hora do voo (formato: yyyy-MM-dd HH:mm):");
            String dataHora = scanner.nextLine();
            System.out.println("Digite o preço do voo:"); // o funcionário é quem realiza a compra da passagem pelo cliente!!!
            double preco = scanner.nextDouble();
            scanner.nextLine();

            Voo voo = new Voo();
            voo.origem = origem;
            voo.destino = destino;
            try {
                voo.setDataHora(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dataHora));
            } catch (ParseException e) {
                System.out.println("Erro ao parsear a data: " + e.getMessage());
                return;
            }
            voo.setValorBasico(preco);

            passagem.adicionarVoo(voo);

            System.out.println("Deseja adicionar mais um voo? (s/n)");
            resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                adicionarMaisVoos = false;
            }
        }

        double tarifaTotal = passagem.calcularTarifaTotal();
        System.out.println("Tarifa total: " + tarifaTotal);
    }

}