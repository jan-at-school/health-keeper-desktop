package health.keeper;

import java.io.Serializable;

public class Doctor implements Serializable{
    
    private String hospital;
    String name;
    String info;
    int pin;

    public Doctor(String name, String hospital,String info, int pin) {
        this.name = name;
        this.hospital = hospital;
        this.pin = pin;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
    
}
