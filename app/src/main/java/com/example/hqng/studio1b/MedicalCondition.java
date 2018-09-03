package com.example.hqng.studio1b;

public class MedicalCondition {
    private String conditionId;
    private String conditionTitle;
    private String conditionDescription;

    public MedicalCondition(String conditionId, String conditionTitle, String conditionDescription){
        this.conditionId = conditionId;
        this.conditionTitle = conditionTitle;
        this.conditionDescription = conditionDescription;
    }

    public String getConditionId(){
        return this.conditionId;
    }

    public String getConditionTitle() {
        return this.conditionTitle;
    }

    public String getConditionDescription(){
        return this.conditionDescription;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public void setConditionTitle(String conditionTitle) {
        this.conditionTitle = conditionTitle;
    }
}
