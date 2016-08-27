/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchMBean;

import foodcourtentity.MenuItems;
import foodcourtentity.Restaurant;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.event.SelectEvent;
 
@ManagedBean
public class InputTextareaView {

    @PersistenceContext(unitName = "FinalProjectPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
   static String query1;
   static String query2;
   List<Restaurant> rest; 
   List<MenuItems> menu;
   
   Restaurant restMenu;

    public List<MenuItems> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItems> menu) {
        this.menu = menu;
    }

   
    public Restaurant getRestMenu() {
        return restMenu;
    }

    public void setRestMenu(Restaurant restMenu) {
        this.restMenu = restMenu;
    }
   
   
   public List<String> completeArea(String query) {
        
        List<String> results = new ArrayList<>();
         results=em.createNamedQuery("City.findName")
    .setParameter("query", query.concat("%"))
    .getResultList();  
         
        return results;
    }

     
    public List<String> completeArea1(String query) {
        List<String> results = new ArrayList<>();
         results=em.createNamedQuery("Location.findName")
    .setParameter("query", query.concat("%")).setParameter("query1", query1)
    .getResultList();  
         
        return results;
    }
    
   public void onItemSelect(SelectEvent event) {
        query1 = event.getObject().toString();
       
    }
  
   public void onItemSelect1(SelectEvent event) {
        query2 = event.getObject().toString();
       
    }

    public List<Restaurant> getRest() {
        return rest;
    }

    public void setRest(List<Restaurant> rest) {
        this.rest = rest;
    }
    
   public void completeArea2() {
        rest=new ArrayList<>();
                rest=em.createNamedQuery("Restaurant.findRestaurant")
    .setParameter("query1", query1).setParameter("query2", query2)
    .getResultList();  
    
    }
   
     public void vegMenuItem() {
        menu=new ArrayList<>();
                menu=em.createNamedQuery("MenuItems.findByMenuVeg").getResultList();  
    
    }
   
       public void nonVegMenuItem() {
        menu=new ArrayList<>();
                menu=em.createNamedQuery("MenuItems.findByMenuNonVeg").getResultList();  
    
    }
       
    public void onRowSelect(SelectEvent event) {
        
       restMenu = (Restaurant)event.getObject();
       System.out.println(restMenu);
    }

    
   
   public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
}
