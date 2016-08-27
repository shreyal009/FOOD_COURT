/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;


import foodcourtentity.Products;
import foodcourtsessionbean.Item;
import foodcourtsessionbean.ProductsFacade;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "sp")
@SessionScoped
 public class Shoppingcart {

    @EJB
    private ProductsFacade productsFacade;

    
    
    private List<Item> cart=new ArrayList<Item>();
    private float total;

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public float getTotal() {
        total=0;
        for (Item item : cart)
        {
            total=total+(item.getQuantity()*Float.parseFloat(item.getP().getPrice()));
            
            
        }
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    public String addtocart(Products p)
    {
        for (Item item : cart) {
            if(item.getP().getId()== (p.getId()))
            {
                item.setQuantity(item.getQuantity()+1);
                return "cart";
            }
            
        }
        
        //creating a new item
        
        Item i = new Item();
        i.setQuantity(1);
        i.setP(p);
        cart.add(i);
        
        return "cart";
    }
    
    public void update()
    {
        
    }
        
    public void remove(Item i)
    {
        for(Item item : cart){
        if(item.equals(i)){
            cart.remove(item);
            break;
        }
    }
    }
    
}
