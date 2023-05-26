import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solver {
    static HashMap<String, KeyValue> data = new HashMap<>();
    static ArrayList<KeyValue> list_data = new ArrayList<>();
    static WordData wordData = new WordData(10);

    public static void main(String[] args) throws IOException {
        //String in = "aa aa bbb bbb bbb bbb bbb c c c c c c c c c";

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner reader = new Scanner(in.readLine());

        while (reader.hasNext()) {
            String split = reader.next();
            try {
                data.get(split).Increment();
            } catch (NullPointerException err) {
                KeyValue contain_data = new KeyValue(split, wordData);
                data.put(split, contain_data);
                list_data.add(contain_data);
            }
        }

        list_data.sort((o1, o2) -> {
            if (o1.GetCount() > o2.GetCount()) {
                return 1;
            } else if (o1.GetCount() < o2.GetCount()) {
                return -1;
            } else {
                return 0;
            }
        });

        for (KeyValue kv : list_data) {
            System.out.print(kv.toString()+"\n");
        }
    }
}