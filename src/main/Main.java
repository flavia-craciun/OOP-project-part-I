package main;

import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import common.Constants;
import input.InputData;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    @SneakyThrows //
    public static void main(final String[] args) {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        // Create the directory for the output files
        Path path = Paths.get("output");
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        // Parsing the input from the json files
        for (int testNumber = 1; testNumber <= Constants.TESTS_NUMBER; testNumber++) {
            File inputFile = new File(Constants.INPUT_PATH + testNumber
                    + Constants.FILE_EXTENSION);
            InputData input = objectMapper.readValue(inputFile, InputData.class);

            // Get the results

            //  Writing the results in the output file
            File outputFile = new File(Constants.OUTPUT_PATH + testNumber
                    + Constants.FILE_EXTENSION);
            outputFile.createNewFile();
            objectMapper.writeValue(outputFile, input);
        }

        Checker.calculateScore();
    }
}
