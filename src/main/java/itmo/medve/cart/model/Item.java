package itmo.medve.cart.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    String description;

    Double price;

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(description, item.description) &&
                Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
