/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourtsessionbean;

import NewJSFManagedBean.Customer;
import static NewJSFManagedBean.Customer_.custEmail;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Shreyal
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "FinalProjectPU")
    private EntityManager em;

    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    public void sendEmail() {
    }
    
    public Customer getU(String emailid)
    {
         try {
            Customer user = (Customer)
            getEntityManager().createNamedQuery("Customer.findByCustEmail").
                    setParameter("custEmail", emailid).getSingleResult();
            return user; 
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
