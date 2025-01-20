import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import javax.swing.JFileChooser;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        Scanner fileScanner = null;

        try {
            System.out.println("Please select a file to read.");
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                fileScanner = new Scanner(selectedFile);

                System.out.printf("%-12s %-15s %-25s %-8s%n", "ID#", "Name", "Description", "Cost");
                System.out.println("============================================================");

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] data = line.split(",");

                    if (data.length == 4) {
                        String formattedLine = String.format("%-12s %-15s %-25s %-8s%n",
                                data[0].trim(),
                                data[1].trim(),
                                data[2].trim(),
                                data[3].trim());
                        System.out.println(formattedLine);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("There was an error finding the file.");
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }
    }
}