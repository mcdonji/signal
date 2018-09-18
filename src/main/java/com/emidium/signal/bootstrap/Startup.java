package com.emidium.signal.bootstrap;

import com.emidium.signal.repository.FoodGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.io.IOException;

@Component
public class Startup implements ApplicationListener<ApplicationReadyEvent> {


    @Autowired
    AppProperties myAppProperties;
    @Autowired
    FoodGroupRepository foodGroupRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        try {
            String current = new java.io.File( "." ).getCanonicalPath();
            String resourcesDir = current + "/data/";
            String foodGroupCsvFileName = myAppProperties.getFoodGroupCsvFileName();
            foodGroupRepository.InitializeWithCsv(resourcesDir + foodGroupCsvFileName);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

} //