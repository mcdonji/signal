package com.emidium.signal.repository;

import static org.assertj.core.api.Assertions.*;
import com.emidium.signal.domain.FoodGroup;
import org.junit.Test;

public class FoodGroupRepositoryTest {
    @Test
    public void testRepositoryReturnsNullOnInvalidFoodGroupCode() {
        FoodGroupRepository foodGroupRepository = new FoodGroupRepository();
        foodGroupRepository.addFoodGroup(new FoodGroup("FGC1", "Food group name"));
        FoodGroup returnedFoodGroup = foodGroupRepository.getFoodGroup("OMG");
        assertThat(returnedFoodGroup).isNull();
    }

    @Test
    public void testAddGetFoodGroup() {
        FoodGroupRepository foodGroupRepository = new FoodGroupRepository();
        FoodGroup givenFoodGroup = new FoodGroup("FGC1", "Food group name");
        foodGroupRepository.addFoodGroup(givenFoodGroup);
        FoodGroup returnedFoodGroup = foodGroupRepository.getFoodGroup(givenFoodGroup.getCode());
        assertThat(returnedFoodGroup).isEqualTo(givenFoodGroup);

    }
}
