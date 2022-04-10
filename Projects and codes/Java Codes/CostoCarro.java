import java.io.*;

public class CostoCarro {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        double COMISION = 0.10, IMPUESTO = 0.30;
        double valorCarro, valorFinal;

        Titulo();

        out.println("Inserte acá el valor del costo del vehiculo?");
        valorCarro = Double.parseDouble(in.readLine());

        valorFinal = ((valorCarro * COMISION) + (valorCarro * IMPUESTO) + valorCarro);

        out.println("El valor del vehiculo con los impuestos y la comision seria de " + valorFinal);

    }

    static void Titulo() {
        out.println("--------------------------------------");
        out.println("Herramienta de costo final de vehiculo");
        out.println("--------------------------------------");
    }
}
