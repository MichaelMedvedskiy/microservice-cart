package itmo.medve.cart.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(cascade = {CascadeType.ALL})
    private List<Item> items;

    public Cart() {
    }



    public void addItem(Item item){
        items.add(item);
    }


    public void removeItem(Item item){
        items.remove(item);
    }


    public void flushCart(){
        items.clear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(items, cart.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}
