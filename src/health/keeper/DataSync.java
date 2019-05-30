/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package health.keeper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author arifu
 */




//Does all the data storage into files stuff.... uses serialization .... simple functions
public class DataSync {

    public void saveUser(User user) {
        try {
            
            //serialization doesn't work for the files in src folder somehow....use full path...
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:/test/user.txt",false));
            out.writeObject(user);
            out.close();
            System.out.println("stored");
        } catch (IOException e) {
        }
    }

    public User getUser() {
        try {
            User temp;
            FileInputStream fileIn = new FileInputStream("D:/test/user.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            temp = (User) in.readObject();
            in.close();
            fileIn.close();
            return temp;
        } catch (IOException i) {
            //i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            return null;
        }

    }

}
