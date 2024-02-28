package ru.mts.homework6.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "animal")
public class AnimalProperties {

    private String[] bearNames;
    private String[] catNames;
    private String[] parrotNames;
    private String[] wolfNames;

    public String[] getBearNames() {
        return bearNames;
    }

    public void setBearNames(String[] bearNames) {
        this.bearNames = bearNames;
    }

    public String[] getCatNames() {
        return catNames;
    }

    public void setCatNames(String[] catNames) {
        this.catNames = catNames;
    }

    public String[] getParrotNames() {
        return parrotNames;
    }

    public void setParrotNames(String[] parrotNames) {
        this.parrotNames = parrotNames;
    }

    public String[] getWolfNames() {
        return wolfNames;
    }

    public void setWolfNames(String[] wolfNames) {
        this.wolfNames = wolfNames;
    }
}
