package com.grantcs.eatlikethis.bootstrap;

import com.grantcs.eatlikethis.model.FoodData;
import com.grantcs.eatlikethis.repository.FoodDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {
    private final FoodDataRepository foodDataRepository;

    public DataLoader(final FoodDataRepository foodDataRepository) {
        this.foodDataRepository = foodDataRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (foodDataRepository.count() == 0) {
            log.info("Food Repository is Empty");
            populateFoodDataDatabase();
        }
    }

    private void populateFoodDataDatabase() throws FileNotFoundException {
        log.info("Populating Food Repository");
        final Scanner scanner = new Scanner(new File("src/main/resources/static/food-database.csv"));
        final String header = scanner.nextLine();
        while (scanner.hasNextLine()) {
            String currLine = scanner.nextLine();
            String[] record = currLine.split(",");
            FoodData foodData = new FoodData();
            foodData.setName(record[0]);
            foodData.setFoodGroup(record[1]);
            foodData.setCalories(Double.parseDouble(record[2]));
            foodData.setFat(Double.parseDouble(record[3]));
            foodData.setProtein(Double.parseDouble(record[4]));
            foodData.setCarbohydrate(Double.parseDouble(record[5]));
            foodDataRepository.save(foodData);
        }
    }
}
