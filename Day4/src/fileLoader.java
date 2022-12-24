import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileLoader {
    public static Scanner loadFile(String filepath) {
        Scanner myReader = null;
        try {
            File myObj = new File(filepath);
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return myReader;
    }
}
