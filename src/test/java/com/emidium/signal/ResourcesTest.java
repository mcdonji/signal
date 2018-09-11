package com.emidium.signal;

import java.io.IOException;

public class ResourcesTest {
    private String baseDir = "";

    public ResourcesTest() {
        this.baseDir = baseDir;
        try {
            String current = new java.io.File( "." ).getCanonicalPath();
            baseDir = current + "/src/test/resources/";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String resourcePath(String resourceName) {
        return baseDir + resourceName;
    }
}
