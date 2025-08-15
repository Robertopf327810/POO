
import java.util.Scanner;


class Alumno {

    public String name;
    public int enrolled;
    public double p1;
    public double p2;
    public double p3;

    public Alumno(String name, int enrolled, double p1, double p2, double p3){
        this.name = name;
        this.enrolled = enrolled;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
                
    }

    public String getName(){
        return name;

    }

    public int getenrolled(){
        return enrolled;

    }

    public double getp1(){
        return p1;

    }

    public double getp2(){
        return p2;

    }

    public double getp3(){
        return p3;

    }
}



public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Que quieres hacer:\n 1.-");
    }
}
