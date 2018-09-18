package com.emidium.signal.repository.csvload;

import com.emidium.signal.domain.FoodGroup;

import java.io.*;
import java.util.HashSet;

import org.apache.commons.csv.*;

public class FoodGroupsFromCsv {
    public static final String FGID = "fgid";
    public static final String FOOD_GROUP = "foodgroup";

    public static final String[] FOOD_GROUP_HEADERS = { FGID, FOOD_GROUP,"fgcat_id","fgcat" };

    public Iterable<FoodGroup> Load(String pathToCsvFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(pathToCsvFile), 1048576 * 10) ;
        return ParseFoodGroups(reader);
    }

    public Iterable<FoodGroup> ParseFoodGroups(BufferedReader reader) throws IOException {
        HashSet<FoodGroup> foodGroups = new HashSet<FoodGroup>();

        Iterable<CSVRecord> records =
                CSVFormat.DEFAULT
                .withHeader(FOOD_GROUP_HEADERS)
                .withFirstRecordAsHeader()
                .parse(reader);

        for (CSVRecord record: records) {
            foodGroups.add(ParseFoodGroup(record));
        }

        return foodGroups;
    }

    public FoodGroup ParseFoodGroup(CSVRecord record) {
        String foodGroupCode = record.get(FGID);
        String foodGroupName = record.get(FOOD_GROUP);
        return new FoodGroup(foodGroupCode, foodGroupName);
    }
}

