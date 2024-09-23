import java.util.Scanner;
public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
    
    
        System.out.println("Olá! Bem vindo a agencia de viagens :)");
        System.out.println("---------------------------------------------");
        System.out.println("O que deseja fazer?");
        System.out.println("1- Buscar passagens");
        System.out.println("2- Cadastrar funcionario");
        System.out.println("3- Cadastrar companhia aerea");
        System.out.println("4- Cadastrar aeroporto");
        System.out.println("5- Funcionario - fazer login");
        
    
        int escolha = scanner.nextInt(); 
    
        if( escolha == 1){
            /* 
            System.out.println("-------- Busca de Passagens --------");
            System.out.println("Aeroporto de origem: ");
            String aeropOrigem = scanner.nextLine(); 
            System.out.println("Aeroporto de destino: ");
            String aeropDestino = scanner.nextLine();
            System.out.println("Data de saída (insira no formato dd/MM/yyyy): ");
            String data = scanner.nextLine(); 
    
            //pesquisarPassagem(aeropOrigem, aeropDestino, data);
            */
        }
        else if (escolha == 2){
            System.out.println("-------- Cadastro de Funcionario --------");
            System.out.println("Digite o nome do funcionário: ");
            String nome = scanner.nextLine();
            if(nome.equals("")){
                System.out.println("Digite um nome válido:");
                nome = scanner.nextLine();
            }

            System.out.println("Digite o CPF (apenas os 11 numeros) : ");
            String cpf = scanner.nextLine();
            if(cpf.length() < 11){
                System.out.println("Digite um CPF válido:");
                cpf = scanner.nextLine();
            }

            System.out.println("Digite o Email: ");
            String email = scanner.nextLine();

            System.out.println("Digite a senha: ");
            String senha = scanner.nextLine();
    
            Funcionario funcionario = new Funcionario(nome, cpf, email, senha);
            System.out.println("Funcionario " +funcionario.getNome()+ " cadastrado com sucesso");
    
        }
    
        else if(escolha ==3){
            System.out.println("-------- Cadastro de Companhia Aerea --------");
            System.out.println("Digite o nome da companhia: ");
            String nome = scanner.nextLine();
            System.out.println("Digite o código da companhia: ");
            int codigo = scanner.nextInt();
            System.out.println("Digite a razao social: ");
            String rSocial = scanner.nextLine();
            System.out.println("Digite o CNPJ: ");
            String cnpj = scanner.nextLine();
    
            CompanhiaAerea comp = new CompanhiaAerea(codigo, rSocial, cnpj, nome);
            System.out.println("Aeroporto " +comp.getNome()+ " cadastrado com sucesso");
    
        }
    
        else if(escolha ==4){
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
            System.out.println("Aeroporto " +aerop.getNome()+ " cadastrado com sucesso");
    
        }
      
        scanner.close();
        
    }

}




/*
        Passagem p1 = new Passagem("GRU", "BPS", 540.99);
        Passagem p2 = new Passagem("SDU", "GRU", 270);
        Passagem p3 = new Passagem("CNF", "FEN", 1020.00);
    
        CompanhiaAerea gol = new CompanhiaAerea(1, "Gol", "123", "Gol");
        CompanhiaAerea latam = new CompanhiaAerea(2, "Latam", "0987", "Latam");
        CompanhiaAerea copa = new CompanhiaAerea(3, "Copa Airlines", "1111", "Copa Airlines");
    
        Voo bhPortoSeguro = new Voo("Belo Horizonte", "Porto Seguro", "15/09/2024 10:00", "HH1234", gol, 200.00, 400, 750.50);
        Voo bhPsp = new Voo("Belo Horizonte", "Sao Paulo", "27/12/2024 10:00", "LL0000", gol, 170.00, 200, 550.50);
        Voo spPMadrid = new Voo("Sao Paulo", "Madrid", "20/11/2024 15:00", "MM0000", copa, 3100.00, 4500, 7500.50);
        Voo bhPrj = new Voo("Belo Horizonte", "Rio de Janeiro", "1/10/2024 12:00", "RJ1000", latam, 190.00, 400, 700.50);
 */