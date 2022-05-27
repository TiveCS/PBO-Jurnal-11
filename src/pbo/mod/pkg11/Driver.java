/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pbo.mod.pkg11;

import java.io.*;
import java.time.LocalDate;

/**
 * @author Fathan
 */
public class Driver {

    public static void main(String[] args) {
        Email a = new Email(1, "Eren", "Makan cuy", "Mari ke foodcourt", LocalDate.now(), false),
                b = new Email(2, "Tayo", "Gorengan", "Murah digoreng dadakan", LocalDate.now(), true),
                c = new Email(3, "Juned", "Seblak", "Memang mantap!", LocalDate.of(2022, 2, 12), false);
        Email d = new Email(), e = new Email(), f = new Email();

        File emailDat = new File("email.dat");
        if (!emailDat.exists()){
            try {
                emailDat.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        try (FileOutputStream fos = new FileOutputStream(emailDat);
             ObjectOutputStream outStream = new ObjectOutputStream(fos);){
            a.save(outStream);
            b.save(outStream);
            c.save(outStream);

            System.out.println("Data setelah di save: ");
            a.display();
            b.display();
            c.display();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(emailDat);
            ObjectInputStream inputStream = new ObjectInputStream(fis);

            d.load(inputStream);
            e.load(inputStream);
            f.load(inputStream);

            System.out.println("---");
            System.out.println("Data setelah di load: ");
            d.display();
            e.display();
            f.display();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
