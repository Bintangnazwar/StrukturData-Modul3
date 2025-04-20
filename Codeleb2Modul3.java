import java.util.LinkedList;
import java.util.Queue;

public class Codeleb2Modul3 {
    public static void main(String[] args) {
        Queue<String> hewan = new LinkedList<>();

        hewan.add("Kucing");
        hewan.add("Burung");
        hewan.add("Ikan");
        hewan.add("Gajah");
        hewan.add("Harimau");

        System.out.println("Peek: " + hewan.peek());
        System.out.println("Daftar Hewan: " + hewan);

        hewan.poll();
        hewan.poll();

        System.out.println("Daftar Hewan setelah Poll: " + hewan);
    }
}
