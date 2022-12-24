import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner fileScanner = fileLoader.loadFile("Day4/resources/input.txt");
        taskOne(fileScanner);
        fileScanner = fileLoader.loadFile("Day4/resources/input.txt");
        taskTwo(fileScanner);
    }

    private static void taskOne(Scanner fileScanner) {
        int score = 0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] elves = line.split(",");
            String[] elf1 = elves[0].split("-");
            String[] elf2 = elves[1].split("-");
            Boolean x1 = false;
            Boolean x2 = false;
            if (Integer.parseInt(elf1[0]) >= Integer.parseInt(elf2[0])) {
                x1 = true;
            }
            if (Integer.parseInt(elf1[1]) <= Integer.parseInt(elf2[1])) {
                x2 = true;
            }

            Boolean x3 = false;
            Boolean x4 = false;
            if (Integer.parseInt(elf2[0]) >= Integer.parseInt(elf1[0])) {
                x3 = true;
            }
            if (Integer.parseInt(elf2[1]) <= Integer.parseInt(elf1[1])) {
                x4 = true;
            }
            if (x1 && x2) {
                score++;
            } else if (x3 && x4) {
                score++;
            }
        }
        System.out.println(score);
    }

    private static void taskTwo(Scanner fileScanner) {
        int score = 0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] elves = line.split(",");
            String[] elf1 = elves[0].split("-");
            String[] elf2 = elves[1].split("-");

            Boolean x1 = false;
            if (Integer.parseInt(elf1[0]) >= Integer.parseInt(elf2[0]) && Integer.parseInt(elf1[0]) <= Integer.parseInt(elf2[1])) {
                x1 = true;
                System.out.println("A");
            }

            Boolean x3 = false;
            if (Integer.parseInt(elf2[0]) >= Integer.parseInt(elf1[0]) && Integer.parseInt(elf2[0]) <= Integer.parseInt(elf1[1])) {
                x3 = true;
            }

            if (x1) {
                score++;
            } else if (x3) {
                score++;
            }
        }
        System.out.println(score);
    }
}