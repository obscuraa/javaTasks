import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import ISolver.ISolver;
import ISolver.Add;
import ISolver.Divide;
import ISolver.Multiply;
import ISolver.Subtract;
import ISolver.Number;

public class Solver {
    public static void main(String[] args) throws IOException {
        //String in = "5 10 + 10 * 14 -";
        Stack<Integer> data = new Stack<>();

        ArrayList<ISolver> commands = new ArrayList<>();
        commands.add(new Number());
        commands.add(new Add());
        commands.add(new Subtract());
        commands.add(new Multiply());
        commands.add(new Divide());

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner reader = new Scanner(in.readLine());

        while (reader.hasNext()) {
            String split = reader.next();
            ISolver current_solver = null;

            for (ISolver solver:commands) {
                if (solver.Check(split)) {
                    current_solver = solver;
                    break;
                }
            }

            if (current_solver != null) {
                current_solver.Execute(split, data);
            }
        }

        System.out.println(data.peek());
    }
}