import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Made by christin.jiang, on 06/02/2018
 **/

public class MainGame {

    static Avatar ava;

    public static void saveAvatar(Avatar ava, String filepath) {
        try (ObjectOutputStream objectStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filepath)))) {
            objectStream.writeObject(ava);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Avatar loadAvatar(String filepath){

        try (ObjectInputStream objectStream = new ObjectInputStream(Files.newInputStream(Paths.get(filepath)))) {
             ava = (Avatar)objectStream.readObject();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return ava;

    }

    public static void main(String[] args) {
        Avatar christin = new Avatar(23, "Christin");
        christin.setHaircolor("Black");
        christin.setHeight(173);
        christin.setGender("Female");
        christin.setWeight(68);

        Avatar loadedAvatar = loadAvatar("cstin.dat");
        loadedAvatar.printInfo();
    }
}
