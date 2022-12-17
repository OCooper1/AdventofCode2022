import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        taskOne();
        taskTwo();
    }

    private static void taskOne() {
        int score = 0;
        try {
            File myObj = new File("Day2/resources/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] moves = line.split(" ");
                switch (moves[1]){
                    case "X":
                        if (moves[0].equals("A")) {
                            score +=3;
                        } else if (moves[0].equals("C")) {
                            score += 6;
                        }
                        score += 1;
                        break;
                    case "Y":
                        if (moves[0].equals("B")) {
                            score +=3;
                        } else if (moves[0].equals("A")) {
                            score += 6;
                        }
                        score += 2;
                        break;
                    case "Z":
                        if (moves[0].equals("C")) {
                            score +=3;
                        } else if (moves[0].equals("B")) {
                            score += 6;
                        }
                        score += 3;
                        break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(score);
    }

    private static void taskTwo() {
        int score = 0;
        try {
            File myObj = new File("Day2/resources/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] moves = line.split(" ");
                switch (moves[1]){
                    case "X": // Lose
                        if (moves[0].equals("A")) { // rock
                            score += 3; // scissors
                        } else if (moves[0].equals("B")) { // paper
                            score += 1; // rock
                        } else if (moves[0].equals("C")) { // scissors
                            score += 2; // paper
                        }
                        score += 0;
                        break;
                    case "Y": // Draw
                        if (moves[0].equals("A")) { // rock
                            score += 1; // rock
                        } else if (moves[0].equals("B")) { // paper
                            score += 2; // paper
                        } else if (moves[0].equals("C")) { // scissors
                            score += 3; // scissors
                        }
                        score += 3;
                        break;
                    case "Z": // Win
                        if (moves[0].equals("A")) { // rock
                            score += 2; // paper
                        } else if (moves[0].equals("B")) { // paper
                            score += 3; // scissors
                        } else if (moves[0].equals("C")) { // scissors
                            score += 1;
                        }
                        score += 6;
                        break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(score);
    }
}