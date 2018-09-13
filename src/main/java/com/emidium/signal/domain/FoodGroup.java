package com.emidium.signal.domain;

public class FoodGroup {

    private String code;
    private String name;

    public FoodGroup(String foodGroupCode, String foodGroupName) {
        this.code = foodGroupCode;
        this.name = foodGroupName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodGroup foodGroup = (FoodGroup) o;

        if (code != null ? !code.equals(foodGroup.code) : foodGroup.code != null) return false;
        return name != null ? name.equals(foodGroup.name) : foodGroup.name == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
