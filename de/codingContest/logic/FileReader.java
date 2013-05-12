package de.codingContest.logic;


import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J. F. Kammann
 * @email janis.kammann@hotmail.de
 *
 */
public class FileReader {
    
    private String fileContent;

    public FileReader() {
    }
    
    public String read(String filename) {
        Path path = Paths.get(filename);
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                fileContent += scanner.nextLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
            return "-1";
        }
        return fileContent;
    }
}
