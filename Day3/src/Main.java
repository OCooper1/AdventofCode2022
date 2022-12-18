import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        taskOne();
        taskTwo();
    }

    private static Scanner loadFile(String filepath) {
        Scanner myReader = null;
        try {
            File myObj = new File(filepath);
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return myReader;
    }

    private static void taskTwo() {
        Scanner fileScanner = loadFile("Day3/resources/input.txt");
        int sum = 0;
        while (fileScanner.hasNextLine()) {
            String line1 = fileScanner.nextLine();
            String line2 = fileScanner.nextLine();
            String line3 = fileScanner.nextLine();
            List<Character> chars1 = line1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            List<Character> chars2 = line2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            List<Character> chars3 = line3.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            chars1.retainAll(chars2);
            chars1.retainAll(chars3);
            Character finalChar = chars1.get(0);
            sum += Score.valueOf(String.valueOf(finalChar)).value;
        }
        System.out.println(sum);
    }

    private static void taskOne() {
        Scanner fileScanner = loadFile("Day3/resources/input.txt");
        int sum = 0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            final int mid = line.length() / 2;
            String[] parts = {line.substring(0, mid), line.substring(mid)};
            int partLen = parts[0].length();
            for (int i = 0; i < partLen; i++){
                for (int x = 0; x < partLen; x++){
                    if (parts[1].toCharArray()[x] == parts[0].toCharArray()[i]) {
                        sum += Score.valueOf(String.valueOf(parts[1].toCharArray()[x])).value;
                        x = partLen +1;
                        i = partLen +1;
                    }
                }
            }
        }
        fileScanner.close();
        System.out.println(sum);
    }
    enum Score {
        a("a", 1), b("b", 2), c("c", 3), d("d", 4), e("e", 5), f("f", 6), g("g", 7), h("h", 8), i("i", 9), j("j", 10),
        k("k", 11), l("l", 12), m("m", 13), n("n", 14), o("o", 15), p("p", 16), q("q", 17), r("r", 18), s("s", 19), t("t", 20),
        u("u", 21), v("v", 22), w("w", 23), x("x", 24), y("y", 25), z("z", 26), A("A", 27), B("B", 28), C("C", 29), D("D", 30),
        E("E", 31), F("F", 32), G("G", 33), H("H", 34), I("I", 35), J("J", 36),
        K("K", 37), L("L", 38), M("M", 39), N("N", 40), O("O", 41), P("P", 42), Q("Q", 43), R("R", 44), S("S", 45), T("T", 46),
        U("U", 47), V("V", 48), W("W", 49), X("X", 50), Y("Z", 51), Z("Z", 52);

        private final String character;
        private final int value;

        Score(String character, int value) {
            this.character = character;
            this.value = value;
        }
    }
}