/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author truonghxse616
 */
public class Dog {

    private String name;
    private int age;
    private int weight;
    private int price;

    public Dog(String name, int age, int weight, int price) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nname = " + name + "\nage = " + age + "\nweight = " + weight + "\nprice = " + price;
    }
}
