import java.util.Random;

public class Utils {

    public static boolean validarString(String str, int tamanhoMinimo) {
        return !str.isEmpty() && str.length() > tamanhoMinimo;
    }

    public static void imprimirDivisoriaComQuebraDeLinha() {
        System.out.println("-------------------------------------------\n");
    }

    public static int gerarCodigoDeID() {
        Random random = new Random();
        return 10 + random.nextInt(90);
    }

    public static String getSigla(String nome) {
        return nome.substring(0, 3).toUpperCase();
    }
}