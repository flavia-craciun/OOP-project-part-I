package main;

import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import common.Constants;
import enums.Category;
import input.ChildInput;
import input.Gifts;
import input.InputData;
import lombok.SneakyThrows;
import nicelist.AgeRangeFactory;
import nicelist.Child;
import nicelist.NiceList;
import nicelist.YoungAdult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


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
            NiceList list = new NiceList();

            // Every year a new list of nice children
            NiceList.AnnualChildren niceList = new NiceList.AnnualChildren();
            for (ChildInput child : input.getInitialData().getChildren()) {
                double budget = input.getSantaBudget();
                int age = child.getAge();
                Child niceChild;
                niceChild = AgeRangeFactory.chooseRange(getAgeRange(age), child);
                if (!(niceChild instanceof YoungAdult)) {
                    niceChild.calculateAverageScore();
                    niceList.addToNiceList(niceChild);
                }
            }

            // Assign budget for each child
            Double budgetUnit = calculateBudgetUnit(input.getSantaBudget(), niceList);
            for (Child child : niceList.getChildren()) {
                child.setAssignedBudget(child.getAverageScore() * budgetUnit);
                getGifts(input.getInitialData().getSantaGiftsList(), child);
            }

            // TODO: Method to update preferences list

            list.addAnnualNiceChildren(niceList);

            //  Writing the results in the output file
            File outputFile = new File(Constants.OUTPUT_PATH + testNumber
                    + Constants.FILE_EXTENSION);
            outputFile.createNewFile();
            objectMapper.writeValue(outputFile, list); // to change
        }

        Checker.calculateScore();
    }

    private static AgeRangeFactory.AgeRange getAgeRange(final int age) {
        if (age < 5) {
            return AgeRangeFactory.AgeRange.Baby;
        } else if (age >= 5 && age < 12) {
            return AgeRangeFactory.AgeRange.Kid;
        } else if (age >= 12 && age < 18) {
            return AgeRangeFactory.AgeRange.Teen;
        }
        return AgeRangeFactory.AgeRange.YoungAdult;
    }

    private static Double calculateBudgetUnit(Double santaBudget, NiceList.AnnualChildren children) {
        Double budgetUnit;
        Double allAverageNiceScore = 0.0;
        for (Child child : children.getChildren()){
            allAverageNiceScore += child.getAverageScore();
        }
        budgetUnit = santaBudget / allAverageNiceScore;
        return budgetUnit;
    }

    private static void getGifts(List<Gifts> santaGiftsList, Child child) {
        Double budget = child.getAssignedBudget();
        List<Category> childGiftsPreferences = new LinkedList<>();
        childGiftsPreferences.addAll(child.getGiftsPreferences());
        for (Category giftPreference : childGiftsPreferences) {
            List<Gifts> giftsFromCategory = getGiftsFromCategory(giftPreference, santaGiftsList);
            for (Gifts gift : giftsFromCategory) {
                if (gift.getPrice() <= budget) {
                    child.getReceivedGifts().add(gift);
                    budget = budget - gift.getPrice();
                    break;
                }
            }
        }
    }

    private static List<Gifts> getGiftsFromCategory (Category category, List<Gifts> santaGiftsList) {
        HashMap<Gifts, Double> giftsFromCategory = new HashMap<>();
        for (Gifts gift : santaGiftsList) {
            if (gift.getCategory().equals(category)) {
                giftsFromCategory.put(gift, gift.getPrice());
            }
        }

        return sortByPrice(giftsFromCategory);
    }

    public static List<Gifts> sortByPrice(HashMap<Gifts, Double> gifts)
    {
        List<Map.Entry<Gifts, Double>> list = new LinkedList<>();
        list.addAll(gifts.entrySet());

        Collections.sort(list, Map.Entry.comparingByValue());

        List <Gifts> sortedGifts = new LinkedList<>();
        for (Map.Entry<Gifts, Double> entry : list) {
            sortedGifts.add(entry.getKey());
        }

        return sortedGifts;
    }
}
