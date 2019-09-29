package itmo.medve.cart.repository;

import itmo.medve.cart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart,Long> {

}
