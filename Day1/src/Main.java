import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> elf = new ArrayList<Integer>();
        elf.add(0);
        int i = 0;
        int highestElf = 0;
        int[] topThree = new int[3];
        int topThreeTotal = 0;
        try {
            File myObj = new File("resources/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if (line.equals("")) {
                    if (elf.get(i) > elf.get(highestElf)){
                        highestElf = i;
                    }
                    updateTopThree(topThree, elf.get(i));
                    i++;
                    elf.add(0);
                } else {
                    elf.set(i, elf.get(i) + Integer.parseInt(line));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int topElf:topThree) {
            topThreeTotal += topElf;
        }
        System.out.println(elf.get(highestElf));
        System.out.println(topThreeTotal);
    }

    private static int[] updateTopThree(int[] topThree, int newValue) {
        if (newValue < topThree[2]) {
            return topThree;
        } else if (newValue < topThree[1]) {
            topThree[2] = newValue;
        } else if (newValue < topThree[0]) {
            topThree[2] = topThree[1];
            topThree[1] = newValue;
        } else if (newValue > topThree[0]) {
            topThree[2] = topThree[1];
            topThree[1] = topThree[0];
            topThree[0] = newValue;
        }
        return topThree;
    }
}