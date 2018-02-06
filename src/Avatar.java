import java.io.*;

/**
 * Made by christin.jiang, on 06/02/2018
 **/

public class Avatar implements Serializable{

    private int avatarNumber;
    private int age;
    private int height;
    private int weight;
    private String name;
    private String gender;
    private String haircolor;

    static int avatarCounter = 1;

    public Avatar(int age, String name) {
        this.age = age;
        this.name = name;
        avatarNumber = avatarCounter;
        avatarCounter++;
    }

    public void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        avatarNumber = fields.get("avatarNumber", -1);
        age = fields.get("age", -1);
        height = fields.get("height", -1);
        weight = fields.get("weight", -1);
        name = (String) fields.get("name", null);
        gender = (String)fields.get("gender", null);
        haircolor = (String)fields.get("haircolor", null);
    }


    public void printInfo() {
        System.out.printf("Avatarnumber: %s \nName: %s \nAge: %d \nGender: %s \nHeight: %d \nWeight: %d \nHaircolor: %s\n ", avatarNumber, name, age, gender, height, weight, haircolor);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHaircolor(String haircolor) {
        this.haircolor = haircolor;
    }

    public int getAvatarNumber() {
        return avatarNumber;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getHaircolor() {
        return haircolor;
    }
}
