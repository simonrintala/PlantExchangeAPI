package com.example.uppgift_backend.backend_uppgift1.models;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plants")
public class Plants {
    @Id
    private String id;

    private String plantName;

    private String plantSize;

    private String plantType;

    private String plantLightNeeds;

    private String plantWaterNeeds;

    @Min(value = 0, message = "Difficulty cannot be lower than 0")
    @Max(value = 5, message = "Difficulty cannot be higher than 5")
    private Integer plantDifficulty;

    private String plantTrade;

    private Double plantPrice;

    private String plantPicture;

    private String plantStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantSize() {
        return plantSize;
    }

    public void setPlantSize(String plantSize) {
        this.plantSize = plantSize;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public String getPlantLightNeeds() {
        return plantLightNeeds;
    }

    public void setPlantLightNeeds(String plantLightNeeds) {
        this.plantLightNeeds = plantLightNeeds;
    }

    public String getPlantWaterNeeds() {
        return plantWaterNeeds;
    }

    public void setPlantWaterNeeds(String plantWaterNeeds) {
        this.plantWaterNeeds = plantWaterNeeds;
    }

    public @Min(value = 0, message = "Difficulty cannot be lower than 0") @Max(value = 5, message = "Difficulty cannot be higher than 5") Integer getPlantDifficulty() {
        return plantDifficulty;
    }

    public void setPlantDifficulty(@Min(value = 0, message = "Difficulty cannot be lower than 0") @Max(value = 5, message = "Difficulty cannot be higher than 5") Integer plantDifficulty) {
        this.plantDifficulty = plantDifficulty;
    }

    public String getPlantTrade() {
        return plantTrade;
    }

    public void setPlantTrade(String plantTrade) {
        this.plantTrade = plantTrade;
    }

    public Double getPlantPrice() {
        return plantPrice;
    }

    public void setPlantPrice(Double plantPrice) {
        this.plantPrice = plantPrice;
    }

    public String getPlantPicture() {
        return plantPicture;
    }

    public void setPlantPicture(String plantPicture) {
        this.plantPicture = plantPicture;
    }

    public String getPlantStatus() {
        return plantStatus;
    }

    public void setPlantStatus(String plantStatus) {
        this.plantStatus = plantStatus;
    }

    public Plants() {
    }
}
