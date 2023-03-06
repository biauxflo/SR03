package fr.utc.sr03;

import java.awt.geom.Point2D;
import java.io.Serializable;

public class Restaurant implements Serializable {
    private String name;
    private String tel;
    private point2D geo;

    Restaurant(String name, String tel, point2D geo){
        this.name = name;
        this.tel = tel;
        this.geo = geo;
    }

    public point2D getGeo() {
        return geo;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public void setGeo(point2D geo) {
        this.geo = geo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "Nom : " + name + '\'' +
                ", Numéro de téléphone :" + tel + '\'' +
                ", Localisation :" + geo +
                '}';
    }
}