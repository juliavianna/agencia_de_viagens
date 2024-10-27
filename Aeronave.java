import java.util.HashMap;

public class Aeronave {
     private String nome;
     private boolean[][] assentos;
     private HashMap<Character, Integer> colunas = new HashMap<>();

     public Aeronave(String nome, int numColunas) {
          this.nome = nome;
          assentos = new boolean[6][numColunas];

          // setar todos os assentos para true, pq se for true ele esta livre
          // se for false pq esta ocupado 
          for (int i = 0; i < assentos.length; i++) {
               for (int j = 0; j < assentos[i].length; j++) {
                    assentos[i][j] = true;
               }
          }

          int valor = 140;
          for(int i = 1;i <= numColunas;i++){
               colunas.put((char)valor,i);
               valor++;
          }
          
     }

     public void reservarAssento(String assento) { // 3d
          int fila = assento.charAt(0) - '0';
          int coluna = colunas.get(assento.charAt(1));
          assentos[fila][coluna] = false; // seta pra ocupado
     }

     public void mostrarAssentosLivres(){
          int valor = 140;
          for (int i = 0; i < assentos.length; i++) {
               for (int j = 0; j < assentos[i].length; j++) {
                    if(assentos[i][j] == true){
                         System.out.println("Assento: "+i+""+(char)valor);
                         valor++;
                    }
               }
          }
     }

}
