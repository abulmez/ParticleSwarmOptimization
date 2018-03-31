import repository.FileRepo;
import service.Service;

public class Main {
    public static void main(String[] args){
        FileRepo repo = new FileRepo("02_date3.txt");
        Service s = new Service(repo);
        System.out.println("Valoarea determinata prin parcurgere: " + repo.getMinimum());
        System.out.println("Valoarea determinata prin algoritm: " + s.solve(50,10,0.5,2.0,1.0));
    }
}
