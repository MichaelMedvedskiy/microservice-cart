package itmo.medve.cart.controller;


import itmo.medve.cart.model.Cart;
import itmo.medve.cart.model.ItemClass;
import itmo.medve.cart.repository.CartRepository;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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



    @RequestMapping(value ="/{id}/{itemId}", method = POST,  consumes = "application/json")
    @ResponseBody
    public void addItemToCart(@PathVariable("id") long id,@PathVariable("itemId") long itemId) {

        Cart c= cartRepository.findById(id).get();



        RestTemplate restTemplate = new RestTemplate();

        ItemClass itemClass = restTemplate.getForObject("http://localhost:8081/"+itemId,ItemClass.class);
        if (itemClass!=null){
//            HttpEntity<ItemClass> request = new HttpEntity<>(new ItemClass());
//            if (restTemplate.postForObject("http://localhost:8081/warehouse/isOfferable", request, Boolean.class)){
//
//            }


        }

       ;

        ItemClass itemClass = restTemplate.getForObject("http://localhost:8081/warehouse/"+rating.getMovieId(), Movie.class);

        c.addItem(ni);
        cartRepository.save(c);
    }

    @RequestMapping("/addItem/{id}")
    @ResponseBody
    public void payForItems(){

    }


}
