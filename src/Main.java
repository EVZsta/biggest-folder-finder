import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i<args.length; i++){
            System.out.println(i +"==>"+args[i]);
        }
        System.exit(0);
        String folderPath = "H:\\books";

        File file = new File(folderPath);
        Node root = new Node(file, 50 * 1024 * 1024);
        long start = System.currentTimeMillis();
        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration + " ms");
    }
}