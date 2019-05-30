package health.keeper;

import java.io.Serializable;
import java.util.Date;


//no need for encapsulation...
public class Medicine implements Serializable{
    String name;
    int duration;
    String comment;
    int quatitityPerDay;
    String type;
    boolean isForbidden;
    boolean isSuggested;
    Doctor suggestedBy;
    Date startDate;

    public Medicine(String name, int duration, String comment, int quatitityPerDay, Doctor suggestedBy,String type) {
        this.name = name;
        this.duration = duration;
        this.comment = comment;
        this.quatitityPerDay = quatitityPerDay;
        this.suggestedBy = suggestedBy;
        this.type = type;
        
        this.isSuggested = true;
        this.isForbidden = false;
        this.startDate=null;
    }

    
   
    
}
