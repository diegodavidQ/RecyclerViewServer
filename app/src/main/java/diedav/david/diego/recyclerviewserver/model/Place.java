package diedav.david.diego.recyclerviewserver.model;

/**
 * Created by root on 31/07/16.
 */
public class Place {
        public String image_url;
        public String name;
        public String country;

    public Place(String image_url, String name, String country) {
        this.image_url = image_url;
        this.name = name;
        this.country = country;
    }

    public Place() {
    }

    public String getImage_url() { return image_url;}

    public void setImage_url(String image_url) {this.image_url = image_url;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getCountry() { return country;}

    public void setCountry(String country) {this.country = country;}
}
