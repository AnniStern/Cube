import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Facet f = new Facet(new R3Vector(0,0,0), new R3Vector(1,0,0), new R3Vector(1,1,0),
                new R3Vector(0,1,0), Color.blue);
        f.out();
        Cube c = new Cube();
        c.scale(150);
        System.out.println("Введите значение углов в цифорках ");
        Scanner scanner=new Scanner(System.in);
        int ux= scanner.nextInt();
        int uy= scanner.nextInt();
        int uz= scanner.nextInt();
        c.rotate(ux,uy,uz);
        Viewer v = new Viewer(c);
    }
}