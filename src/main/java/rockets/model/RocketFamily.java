package rockets.model;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;

public class RocketFamily extends Entity{

    private String familyName;

    private String subCategory;

    private String description;

    public String getDescription() {
        return description;
    }

    public void  setDescription(String description) {
        notBlank(description, "description cannot be null or empty");
        this.description = description; }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName){
        notBlank(familyName, "familyName cannot be null or empty");
        this.familyName = familyName; }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        notBlank(subCategory, "subCategory cannot be null or empty");
        this.subCategory = subCategory; }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RocketFamily rocketFamily = (RocketFamily) o;
        return Objects.equals(familyName, rocketFamily.familyName) &&
                Objects.equals(subCategory, rocketFamily.subCategory) &&
                Objects.equals(description, rocketFamily.description);
    }

}
