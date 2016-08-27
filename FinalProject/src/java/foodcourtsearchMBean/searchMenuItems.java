/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourtsearchMBean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@ManagedBean(name = "searchMenuItems")
@SessionScoped
public class searchMenuItems {

    @PersistenceContext(unitName = "FinalProjectPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    private Long menuId;
    private String foodMenuItemName;
    private Long price;
    /**
     * Creates a new instance of searchMenuItems
     */
    public searchMenuItems() {
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getFoodMenuItemName() {
        return foodMenuItemName;
    }

    public void setFoodMenuItemName(String foodMenuItemName) {
        this.foodMenuItemName = foodMenuItemName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
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
