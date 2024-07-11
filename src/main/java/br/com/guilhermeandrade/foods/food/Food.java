package br.com.guilhermeandrade.foods.food;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private BigDecimal price;


    public Food() {
    }

    public Food(FoodRequestDTO data){
        this.image = data.image();
        this.title = data.title();
        this.price = data.price();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
