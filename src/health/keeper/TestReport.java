package health.keeper;

import java.io.Serializable;

public class TestReport implements Serializable{
    String date;
    boolean isdue;
    String result;
    String nameoftest;

    public TestReport(String nameoftest) {
        this.isdue = true;
        this.nameoftest = nameoftest;
    }
    
    
    
}
