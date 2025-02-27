package com.example.uppgift_backend.backend_uppgift1.models;


import com.example.uppgift_backend.backend_uppgift1.PlantStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

    @Min(value = 50, message = "minimum price is 50.")
    @Max(value = 1000, message = "Maximum price is 1000.")
    private Double plantPrice;
    //Prissatta växter måste ha ett fast pris mellan 50-1000 kr AFFÄRSREGEL 4

    private String plantPicture;
    private PlantStatus plantStatus;
    //kunde använt Set<Role> roles

    public void validateTradeRules() {
        if ("YES".equalsIgnoreCase(this.plantTrade) && this.plantPrice != null && this.plantPrice > 0) {
            throw new IllegalArgumentException("A plant up for trade can't be sold.");
        }
    }       //Växter markerade för byte kan endast bytas mot andra växter, inte säljas AFFÄRSREGEL 2


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @DBRef
    @JsonIgnore //Den började loopa i en evighet i postman och gjorde min dator helt oanvändbar, detta var det jag hitta online.
    private Users user;

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

    public @Min(value = 50, message = "minimum price is 50.") @Max(value = 1000, message = "Maximum price is 1000.") Double getPlantPrice() {
        return plantPrice;
    }

    public void setPlantPrice(@Min(value = 50, message = "minimum price is 50.") @Max(value = 1000, message = "Maximum price is 1000.") Double plantPrice) {
        this.plantPrice = plantPrice;
    }

    public String getPlantPicture() {
        return plantPicture;
    }

    public void setPlantPicture(String plantPicture) {
        this.plantPicture = plantPicture;
    }

    public PlantStatus getPlantStatus() {
        return plantStatus;
    }

    public void setPlantStatus(PlantStatus plantStatus) {
        this.plantStatus = plantStatus;
    }

    public Plants() {
    }
}
