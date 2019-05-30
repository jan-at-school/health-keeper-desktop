package health.keeper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




//stores all the user data...so only this class needs to be stored.
public class User implements Serializable {
    String name;
    int age;
    String sex;
    int pin;
    String info;
    List<Medicine> medicines = new ArrayList<Medicine>();
    List<Doctor> doctors = new ArrayList<Doctor>();
    List<TestReport> tests = new ArrayList<TestReport>();
    List<Double> heartRateLog = new ArrayList<Double>();
    List<Double> weightLog = new ArrayList<Double>();
    List<Day> days = new ArrayList<Day>();

    public User(String name, int age, String sex, int pin, String all) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.pin = pin;
        this.info=all;
    }
   
    
    
}
