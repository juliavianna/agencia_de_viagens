import java.util.Random;

public class Utils {

    public static boolean validarString(String str, int tamanhoMinimo) {
        return !str.isEmpty() && str.length() > tamanhoMinimo;
    }

    public static void imprimirDivisoriaComQuebraDeLinha() {
        System.out.println("-------------------------------------------\n");
    }

    
    public static String getSigla(String nome) {
        return nome.substring(0, 3).toUpperCase();
    }
    
    public static int gerarCodigoDeID() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }
    
    public static String gerarLetrasAleatorias() {
        Random random = new Random();
        char letra1 = (char) ('A' + random.nextInt(26));
        char letra2 = (char) ('A' + random.nextInt(26));
        return "" + letra1 + letra2;
    }

    public static String gerarCodigoVoo() {
        String letras = gerarLetrasAleatorias();
        int numeros = gerarCodigoDeID();
        return letras + numeros;
    }
}