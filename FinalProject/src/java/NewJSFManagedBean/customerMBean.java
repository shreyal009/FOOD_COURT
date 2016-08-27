/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewJSFManagedBean;

import foodcourtsessionbean.CustomerFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Shreyal
 */
@ManagedBean(name = "customerMBean")
@SessionScoped
public class customerMBean {

    @Resource(mappedName = "jms/SendEmail")
    private Queue sendEmail;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    

   

    @EJB
    private CustomerFacade customerFacade;
 
  
    
    /**
     * Creates a new instance of customerMBean
     */
    public customerMBean() {
    }
  
        
    private Long custId;
    private String custFname;
    private String custLname;
    private String custMobile;
    private String custEmail;
    private String custPass;
    
    @Resource
    private javax.transaction.UserTransaction utx;
   

    private Customer customer;

    /**
     * Get the value of cutomer
     *
     * @return the value of cutomer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set the value of cutomer
     *
     * @param cutomer new value of cutomer
     */
    public void setCustomer(Customer cutomer) {
        this.customer = cutomer;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }
    
    public String getCustFname() {
        return custFname;
    }

    public void setCustFname(String custFname) {
        this.custFname = custFname;
    }

    public String getCustLname() {
        return custLname;
    }

    public void setCustLname(String custLname) {
        this.custLname = custLname;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustPass() {
        return custPass;
    }

    public void setCustPass(String custPass) {
        this.custPass = custPass;
    }
    
      public String createUser()
    {
        FacesContext context = FacesContext.getCurrentInstance();
    
       
       
       
       Customer customer=new Customer();
        customer.setCustEmail(custEmail);
        customer.setCustFname(custFname);
        customer.setCustLname(custLname);
        customer.setCustMobile(custMobile);
        customer.setCustPass(custPass);
        customerFacade.create(customer);
        return "success";
    }
      
    
      public String loginUser()
    {
         FacesContext context = FacesContext.getCurrentInstance();
        Customer user = getUser();
        if (user != null) {
            if (!user.getCustPass().equals(custPass)) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                           "Login Failed!",
                                           "The password specified is not correct.");
                context.addMessage(null, message);
                return null;
            }
            
           
            return "success";
        } else {           
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Login Failed!",
                    "Username '"
                    + custEmail
                    +
                    "' does not exist.");
            context.addMessage(null, message);
            return null;
        }
    }
     
       private Customer getUser() {
       return customerFacade.getU(custEmail);
       }
       


    private void sendJMSMessageToSendEmail(String messageData) {
        context.createProducer().send(sendEmail, messageData);
    }

    

}


