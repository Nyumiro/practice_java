import java.io.IOException;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<Integer> list = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
            } };

        var test_1 = task_1.solution_1(list);
        var test_2 = task_1.solution_2(list);
        System.out.println(test_1);
        System.out.println(test_2);

        var file_1 = "/Applications/World of Warcraft/_classic_/World of Warcraft Classic.app/Contents/MacOS/World of Warcraft Classic";
        var file_2 = "/Applications/World of Warcraft/_retail_/World of Warcraft.app/Contents/MacOS/World of Warcraft";
        boolean task2 = task_2.compareFiles(file_1, file_2);
        System.out.println(task2);

        task_3.solution();

        task_4.solution();
        task_5._1();
        task_5._2();
    }
}