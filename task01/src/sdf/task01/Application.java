package sdf.task01;

public class Application {

    private String appName; 
    private String category;
    private String rating; 

    public Application(String appName, String category, String rating){
        this.appName = appName;
        this.category = category;
        this.rating = rating;
    }
    
    public Application(String rating){
        this.rating = rating;
    }

    public Application (){

    }

    // so that we can access the private variables 

    public String getAppName() { return appName; }

    public void setAppName(String appName) { this.appName = appName; }

    public String getCategory() {return category;}

    public void setCategory(String category) { this.category = category;}

    public String getRating() { return rating;}

    public void setRating(String rating) {this.rating = rating; }
    
   

}
