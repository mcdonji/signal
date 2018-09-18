package com.emidium.signal.repository.csvload;
import com.emidium.signal.ResourcesTest;
import com.emidium.signal.domain.FoodGroup;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoadFoodGroupsTest extends ResourcesTest {

    @Test
    public void testCanLoadFoodGroupsFromActualCsvFile() throws IOException {
        FoodGroupsFromCsv sut = new FoodGroupsFromCsv();
        List<FoodGroup> foodGroups = new ArrayList<>();
        sut.Load(resourcePath("foodgroups-en_ONPP.csv")).forEach(foodGroups::add);
        assertEquals("Test file has 9 lines but 4 food groups.", 4, foodGroups.size());
    }

}
