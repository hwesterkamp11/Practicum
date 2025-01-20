import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> personList = new ArrayList();
        boolean more = true;

        System.out.println("Welcome to the person generator!");

        while(more) {
            int id = SafeInput.getInt(scan, "Enter ID number");
            String firstName = SafeInput.getNonZeroLenString(scan, "Enter first name");
            String lastName = SafeInput.getNonZeroLenString(scan, "Enter last name");
            String title = SafeInput.getNonZeroLenString(scan, "Enter the title");
            int birthyear = SafeInput.getRangedInt(scan, "Enter the year of birth", 1000, 2025);

            String record = id + ", " + firstName + ", " + lastName + ", " + title + ", " + birthyear;
            personList.add(record);

            more = SafeInput.getYNConfirm(scan, "Do you want to add someone else?");
        }

        String fileName = SafeInput.getNonZeroLenString(scan, "Enter the file name to save the new people to");

        try(FileWriter fileWriter = new FileWriter(fileName)) {
            for(String person : personList) {
                fileWriter.write(person + "\n");
            }
            System.out.println("Data saved successfully to " + fileName);
        } catch(IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
