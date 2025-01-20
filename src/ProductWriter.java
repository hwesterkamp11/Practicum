
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> productList = new ArrayList();
        boolean more = true;

        System.out.println("Welcome to the product writer!");

        while(more) {
            String id = SafeInput.getNonZeroLenString(scan, "Enter product id");
            String name = SafeInput.getNonZeroLenString(scan, "Enter product name");
            String description = SafeInput.getNonZeroLenString(scan, "Enter product description");
            double cost = SafeInput.getRangedDouble(scan, "Enter the item price", .01, 1000000000);

            String record = id + ", " + name + ", " + description + ", " + cost;
            productList.add(record);

            more = SafeInput.getYNConfirm(scan, "Enter another product?");
        }

        String fileName = SafeInput.getNonZeroLenString(scan, "Enter the name of the file to write to.");

        try(FileWriter fileWriter = new FileWriter(fileName)) {
            for(String product : productList) {
                fileWriter.write(product + "\n");
            }
            System.out.println("Data saved successfully to " + fileName);
        } catch(IOException e) {
            System.out.println("An error occurred recording the data.");
            e.printStackTrace();
        }
    }
}
