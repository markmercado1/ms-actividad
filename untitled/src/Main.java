import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        for (int i = 1; i <= 4; i++) {

            List list = new ArrayList();

            for (int j = 1; j <= i; j++) {
                list.add("*");
            }


            System.out.println(list);
        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i); // imprime el número de la fila
            }
            System.out.println(); // nueva línea
        }



    }
}