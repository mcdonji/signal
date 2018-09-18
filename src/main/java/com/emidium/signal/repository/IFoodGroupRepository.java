package com.emidium.signal.repository;

import com.emidium.signal.domain.FoodGroup;

import java.util.Collection;

public interface IFoodGroupRepository {
    Collection<FoodGroup> getFoodGroups();
    FoodGroup getFoodGroup(String code);
    void addFoodGroup(FoodGroup foodGroup);
}
