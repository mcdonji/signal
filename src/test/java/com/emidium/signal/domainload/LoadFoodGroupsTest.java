package com.emidium.signal.domainload;
import com.emidium.signal.ResourcesTest;
import com.emidium.signal.domain.FoodGroup;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LoadFoodGroupsTest extends ResourcesTest {
    @Test
    public void testCanLoadFoodGroupsFromCsv() {
        FoodGroupsFromCsv sut = new FoodGroupsFromCsv();
        List<FoodGroup> foodGroups = sut.Load(resourcePath("foodgroups-en_ONPP.csv"));
        assertEquals("Test file has 9 lines but 4 food groups.", 4, foodGroups.size());
    }

}
