/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourtentity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shreyal
 */
@Entity
@Table(name = "menu_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuItems.findAll", query = "SELECT m FROM MenuItems m"),
    @NamedQuery(name = "MenuItems.findByMenuId", query = "SELECT m FROM MenuItems m WHERE m.menuId = :menuId"),
    @NamedQuery(name = "MenuItems.findByMenuNonVeg", query = "SELECT m FROM MenuItems m,Category c WHERE m.menuId=c.menuId and c.foodType='NONVEG'"),
    @NamedQuery(name = "MenuItems.findByMenuVeg", query = "SELECT m FROM MenuItems m,Category c WHERE m.menuId=c.menuId and c.foodType='VEG'"),
    @NamedQuery(name = "MenuItems.findByFoodMenuItemName", query = "SELECT m FROM MenuItems m WHERE m.foodMenuItemName = :foodMenuItemName"),
    @NamedQuery(name = "MenuItems.findByPrice", query = "SELECT m FROM MenuItems m WHERE m.price = :price"),
    @NamedQuery(name = "MenuItems.findByRestId", query = "SELECT m FROM MenuItems m WHERE m.restId = :restId")})
public class MenuItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_id")
    private Long menuId;
    @Size(max = 26)
    @Column(name = "food_menu_item_name")
    private String foodMenuItemName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private long price;
    @Column(name = "rest_id")
    private BigInteger restId;

    public MenuItems() {
    }

    public MenuItems(Long menuId) {
        this.menuId = menuId;
    }

    public MenuItems(Long menuId, long price) {
        this.menuId = menuId;
        this.price = price;
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

    public BigInteger getRestId() {
        return restId;
    }

    public void setRestId(BigInteger restId) {
        this.restId = restId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuItems)) {
            return false;
        }
        MenuItems other = (MenuItems) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "foodcourtentity.MenuItems[ menuId=" + menuId + " ]";
    }
    
}
