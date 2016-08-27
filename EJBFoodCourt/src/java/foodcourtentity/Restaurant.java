/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourtentity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
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
@Table(name = "restaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r"),
    @NamedQuery(name = "Restaurant.findRestaurant", query = "SELECT r FROM Restaurant r,City c,Location l WHERE r.locationId=l.locationId and l.cityId=c.cityId and c.cityName= :query1 and l.locationName=:query2 "),
    @NamedQuery(name = "Restaurant.findByRestId", query = "SELECT r FROM Restaurant r WHERE r.restId = :restId"),
    @NamedQuery(name = "Restaurant.findByRestName", query = "SELECT r FROM Restaurant r WHERE r.restName = :restName"),
    @NamedQuery(name = "Restaurant.findByRating", query = "SELECT r FROM Restaurant r WHERE r.rating = :rating"),
    @NamedQuery(name = "Restaurant.findByContactNo", query = "SELECT r FROM Restaurant r WHERE r.contactNo = :contactNo"),
    @NamedQuery(name = "Restaurant.findByAddress", query = "SELECT r FROM Restaurant r WHERE r.address = :address"),
    @NamedQuery(name = "Restaurant.findByLocationId", query = "SELECT r FROM Restaurant r WHERE r.locationId = :locationId")})
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rest_id")
    private Long restId;
    @Size(max = 25)
    @Column(name = "rest_name")
    private String restName;
    @Column(name = "rating")
    private BigInteger rating;
    @Column(name = "contact_no")
    private BigInteger contactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "address")
    private String address;
    @Column(name = "location_id")
    private BigInteger locationId;
    private List<Restaurant> r;
    
    public Restaurant() {
    }

    public List<Restaurant> getR() {
        return r;
    }

    public void setR(List<Restaurant> r) {
        this.r = r;
    }

    public Restaurant(Long restId) {
        this.restId = restId;
    }

    public Restaurant(Long restId, String address) {
        this.restId = restId;
        this.address = address;
    }

  
 
    
    public Long getRestId() {
        return restId;
    }

    public void setRestId(Long restId) {
        this.restId = restId;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public BigInteger getRating() {
        return rating;
    }

    public void setRating(BigInteger rating) {
        this.rating = rating;
    }

    public BigInteger getContactNo() {
        return contactNo;
    }

    public void setContactNo(BigInteger contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getLocationId() {
        return locationId;
    }

    public void setLocationId(BigInteger locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (restId != null ? restId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.restId == null && other.restId != null) || (this.restId != null && !this.restId.equals(other.restId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "foodcourtentity.Restaurant[ restId=" + restId + " ]";
    }
    
}
