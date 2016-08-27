/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import foodcourtentity.Products;
import foodcourtsessionbean.ProductsFacade;
import javax.faces.bean.ManagedBean;
import java.util.*;
import javax.ejb.EJB;

@ManagedBean(name="protocol")
public class ProductController {

    @EJB
    private ProductsFacade productsFacade;
    private List<Products> lst=new ArrayList<Products>();

    public List<Products> getLst() {
        return productsFacade.findAll();
    }

    public void setLst(List<Products> lst) {
        this.lst = lst;
    }
    
}

