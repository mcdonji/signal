package com.emidium.signal.repository;

import com.emidium.signal.bootstrap.AppProperties;
import com.emidium.signal.domain.FoodGroup;
import com.emidium.signal.repository.csvload.FoodGroupsFromCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

@Service
public class FoodGroupRepository {
    // Pretend DB for now
    public HashMap<String, FoodGroup> foodGroupsCache = new HashMap<String, FoodGroup>();

    // Exception? WTF
    public void InitializeWithCsv(String foodGroupsCsvFilePath) throws Exception {
        FoodGroupsFromCsv foodGroupsFromCsv = new FoodGroupsFromCsv();
        try {
            foodGroupsFromCsv.Load(foodGroupsCsvFilePath).forEach(foodGroup -> { foodGroupsCache.put(foodGroup.getCode(), foodGroup); } );
        } catch (IOException e) {
            throw new Exception(String.format("Unable to load food groups from csv file: %s", foodGroupsCsvFilePath));
        }
    }

    public Collection<FoodGroup> getFoodGroups() {
        return foodGroupsCache.values();
    }

    public FoodGroup getFoodGroup(String code) {
        return foodGroupsCache.get(code);
    }

    public void addFoodGroup(FoodGroup foodGroup) {
        foodGroupsCache.put(foodGroup.getCode(), foodGroup);
    }
}
