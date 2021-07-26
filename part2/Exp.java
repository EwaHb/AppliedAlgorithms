import java.io.IOException;

public class Exp {

    public static void main(String[] args) throws IOException {
        System.out.println("------- Running Task4 experiment -------- \n\n\n");
        Task4 t4 = new Task4();
        t4.runCorrectnessTest(10999);
        System.out.println("------- Running Task5 experiment -------- \n\n\n");
        Task5 t5 = new Task5();
        t5.completeBenchmark();
    }
}
