import java.util.*;

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
        boolean cycle = true;
        ArrayList<Alumno> alumnos = new ArrayList<>();

        while(cycle){
            System.out.println("Select an option:\n 1.-Register alumn \n 2.-Print students with their qualifications \n 3.-Exit");
            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(option){
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter enrollment number: ");
                    int enrolled = sc.nextInt();
                    System.out.print("Enter grade for P1: ");
                    double p1 = sc.nextDouble();
                    System.out.print("Enter grade for P2: ");
                    double p2 = sc.nextDouble();
                    System.out.print("Enter grade for P3: ");
                    double p3 = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    Alumno alumno = new Alumno(name, enrolled, p1, p2, p3);
                    alumnos.add(alumno);
                    System.out.println("Alumno registered!\n");
                    break;
                case 2:
                    if(alumnos.isEmpty()){
                        System.out.println("No students registered.\n");
                    } else {
                        for(Alumno a : alumnos){
                            System.out.println("Name: " + a.getName() + ", Enrollment: " + a.getenrolled() +
                                ", P1: " + a.getp1() + ", P2: " + a.getp2() + ", P3: " + a.getp3());
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    cycle = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.\n");
                    System.out.println("Please select a valid option.");
                    break;
            }
        }
    }
}
