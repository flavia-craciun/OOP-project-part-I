package main;

import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import common.Constants;
import input.AnnualChange;
import input.InputData;
import lombok.SneakyThrows;
import nicelist.rounds.AnnualChildren;
import nicelist.NiceList;
import nicelist.rounds.Round0;
import nicelist.rounds.YearlyRound;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * This method is used to call the checker which calculates the score
     *
     * @param args the arguments used to call the main method
     */
    @SneakyThrows // change
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

            // Entry point to the program

            // Final list of nice children for every year
            NiceList niceList = new NiceList();

            // Every year a new list of nice children
            AnnualChildren niceChildrenList = new Round0();
            ((Round0) niceChildrenList).makeNiceList(input.getInitialData().getChildren());

            // Assign budget for each child
            ((Round0) niceChildrenList).receiveGifts(input);

            //  Add the list of nice children to the nice list
            niceList.addAnnualNiceChildren(niceChildrenList);

            // Update the list of nice children annually
            for (int year = 0; year < input.getNumberOfYears(); year++) {
                AnnualChildren newNiceChildrenList = new YearlyRound();
                AnnualChange change = input.getAnnualChanges().get(year);

                // Update the already existing children's ages, nice score history
                // and gifts preferences
                ((YearlyRound) newNiceChildrenList).makeNiceList(niceChildrenList
                        .getChildren(), change);

                // Adding the new children to the list
                AnnualChildren newChildrenList = new Round0();
                ((Round0) newChildrenList).makeNiceList(input.getAnnualChanges().
                        get(year).getNewChildren());
                newNiceChildrenList.getChildren().addAll(newChildrenList.getChildren());

                // Assign the budget to each child
                ((YearlyRound) newNiceChildrenList).receiveGifts(year, input);

                niceList.addAnnualNiceChildren(newNiceChildrenList);
                niceChildrenList = newNiceChildrenList;
            }

            //  Writing the results in the output files
            File outputFile = new File(Constants.OUTPUT_PATH + testNumber
                    + Constants.FILE_EXTENSION);
            outputFile.createNewFile();
            objectMapper.writeValue(outputFile, niceList);
        }

        Checker.calculateScore();
    }

}
