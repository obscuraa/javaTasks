package ISolver;

import java.util.Stack;

public class Number extends ISolver {
    @Override
    String GetStringRegex() {
        return "^\\d+$";
    }

    @Override
    public void Execute(String input_data, Stack<Integer> data) {
        data.push(Integer.valueOf(input_data));
    }
}
