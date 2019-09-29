package itmo.medve.cart.controller;


import itmo.medve.cart.model.Cart;
import itmo.medve.cart.model.Item;
import itmo.medve.cart.repository.CartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CartController {
    private CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @RequestMapping("/carts")
    public String getAllCreatedCarts(Model model) {
        model.addAttribute("carts", cartRepository.findAll());
        return "carts";
    }

    @RequestMapping("/new")
    @ResponseBody
    public void addNewCart() {
        cartRepository.save(new Cart());
    }


    @RequestMapping("/addItem/{id}")

    @ResponseBody
    public void addItemToCart(@PathVariable("id") long id) {
        Cart c= cartRepository.findById(id).get();
        Item ni = new Item();
        ni.setPrice(1337.);
        ni.setDescription("Жепппа");
        c.addItem(ni);
        cartRepository.save(c);
    }


}
