import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

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


    System.out.println("Olá! Bem vindo a agencia de viagens :)");
    System.out.println("---------------------------------------------");
    System.out.println("O que deseja fazer?");
    System.out.println("/t 1- Buscar passagens");
    int escolha = scanner.nextInt(); 

    if( escolha == 1){
        
        System.out.println("---------------------------------------------");
        System.out.println("Aeroporto de origem: ");
        String aeropOrigem = scanner.nextLine(); 
        System.out.println("Aeroporto de destino: ");
        String aeropDestino = scanner.nextLine();
        System.out.println("Data de saída (insira no formato dd/MM/yyyy): ");
        String data = scanner.nextLine(); 

        pesquisarPassagem(aeropOrigem, aeropDestino, data);
        
    }


  

    
}