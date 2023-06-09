import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
* Main class.
*
* @author Logan S
* @version 1.0
* @since 2023-06-05
*/


public final class Main {

    /**
    * For style checker.
    *
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */

    private Main() {
        throw new IllegalStateException("Utility class");
    }


    /**
    * This is the main method.
    *
    * @param args Unused.
    */

    public static void main(String[] args) {

        // Declare list and variables.
        final ArrayList<Student> studentList = new ArrayList<Student>();
        boolean iep = false;
        int counter = 0;
        String output = "";
        /* newLine: variable - Make sure the next text goes on 
        a new line, idea from Alex M */
        final String newLine = "\n";


        try {
            // Create input file and scanner for input file.
            final File inputFile = new File("input.txt");
            final Scanner scanner = new Scanner(inputFile);

            // Create output file and writer for output file.
            final FileWriter outputFile = new FileWriter("output.txt");

            // Reading each input file line.
            while (scanner.hasNextLine()) {
                // Add student on next line.
                final String[] student = scanner.nextLine().split(" ");

                // Check if student owns iep.
                if (student[student.length - 1].equals("y")) {
                    iep = true;
                } else {
                    iep = false;
                }

                // Check info to write to output file.
                if (student.length == 4) {
                    final Student finalStudent = new Student(student[0],
                        student[1], Integer.parseInt(student[2]),
                        iep);
                    studentList.add(finalStudent);
                    output += studentList.get(counter).print() + newLine;
                } else if (student.length == 5) {
                    final Student finalStudent = new Student(student[0],
                        student[2], student[1].charAt(0),
                            Integer.parseInt(student[3]), iep);
                    studentList.add(finalStudent);
                    output += studentList.get(counter).print() + newLine;
                } else {
                    // Invalid input.
                    output += "Error.\n";
                }
                counter++;
            }


            // Output information, including number of students.
            final String numStudents = "There are " + studentList.size()
                + " students.\n";
            System.out.print(numStudents);
            System.out.println(output);
            outputFile.write(numStudents);
            outputFile.write(output);


            // Close writer.
            outputFile.close();


        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }
}
