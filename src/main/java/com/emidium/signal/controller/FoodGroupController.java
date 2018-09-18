package com.emidium.signal.controller;

import com.emidium.signal.bootstrap.AppProperties;
import com.emidium.signal.domain.FoodGroup;
import com.emidium.signal.model.Greeting;
import com.emidium.signal.repository.FoodGroupRepository;
import com.emidium.signal.repository.IFoodGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class FoodGroupController {
    @Autowired
    FoodGroupRepository foodGroupRepository;


    public FoodGroupController() {
    }

    @RequestMapping("/foodgroups")
    public Iterable<FoodGroup> foodGroups() {
        return foodGroupRepository.getFoodGroups();
    }
}
