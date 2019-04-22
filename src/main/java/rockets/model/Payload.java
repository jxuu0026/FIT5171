package rockets.model;

import static org.apache.commons.lang3.Validate.notBlank;

public class Payload extends Entity{

    private String type;


    private String description;

    public String getDescription(){return description;}

    public String getType(){
        return type;
    }


    public void setType(String type){

        notBlank(type,"type cannot be null or empty");
        this.type = type;
    }



    public void setDescription(String description){
        notBlank(description,"description cannot be null");
        this.description = description;
    }





}
