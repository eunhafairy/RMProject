
package models;

import java.io.File;


public class Food {
    
    
    private String name;
    private double price;
    private String description;
    private File imageFile;
    private String category;
    public Food(String name, double price, String description, String category) {
        setName(name);
        setPrice(price);
        setDescription(description);
        setCategory(category);
        setImageFile(new File("./src/image/default.jpg"));
     
    }

   

    public Food(String name, double price, String description, String category, File imageFile) {
        this(name, price, description, category);
        setImageFile(imageFile);
    }
 public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }
    
    
    
}
