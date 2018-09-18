package com.emidium.signal.bootstrap;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class AppProperties {

    private String foodGroupCsvFileName;
    private String description;
    public String getFoodGroupCsvFileName() {
        return foodGroupCsvFileName;
    }
    public void setFoodGroupCsvFileName(String title) {
        this.foodGroupCsvFileName = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean hasFoodGroupCsvFileName() {
        return this.foodGroupCsvFileName != null;
    }
}
