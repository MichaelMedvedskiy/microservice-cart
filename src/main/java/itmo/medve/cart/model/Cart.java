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
    private List<ItemClass> itemClasses;

    public Cart() {
    }



    public void addItem(ItemClass itemClass){
        itemClasses.add(itemClass);
    }


    public void removeItem(ItemClass itemClass){
        itemClasses.remove(itemClass);
    }


    public void flushCart(){
        itemClasses.clear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemClass> getItemClasses() {
        return itemClasses;
    }

    public void setItemClasses(List<ItemClass> itemClasses) {
        this.itemClasses = itemClasses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(itemClasses, cart.itemClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemClasses);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", itemClasses=" + itemClasses +
                '}';
    }
}
