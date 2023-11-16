package sdf.task02;

public class Product {

    private int productId;
    private String nameOfProduct;
    private double price; 
    private double rating;


    public Product(String value) {
    }

    public int getProductId() {return productId; }
    
    public void setProductId(int productId) { this.productId = productId;}
    
    public String getNameOfProduct() { return nameOfProduct;}
    
    public void setNameOfProduct(String nameOfProduct) { this.nameOfProduct = nameOfProduct;}
    
    public double getPrice() { return price;}
    
    public void setPrice(double price) {this.price = price;}
    
    public double getRating() {return rating;}
    
    public void setRating(double rating) {this.rating = rating; } 

    
    
}
