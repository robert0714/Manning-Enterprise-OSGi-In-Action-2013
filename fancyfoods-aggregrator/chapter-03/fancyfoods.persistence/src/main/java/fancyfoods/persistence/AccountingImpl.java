package fancyfoods.persistence;

import javax.persistence.EntityManager;

import fancyfoods.food.Accounting;

public class AccountingImpl implements Accounting {
    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    
    public CustomerImpl getCustomer(String name) {
        return em.find(CustomerImpl.class, name);
    }

    
    
    public void chargeToAccount(String name, double purchaseAmount) {
        CustomerImpl customer = getCustomer(name);
        if (customer == null) {
            customer = new CustomerImpl();
            customer.setName(name);
            customer.setCreditLimit(20);
            em.persist(customer);
        }
        double currentLevel = customer.getBalance();
        double creditLimit = customer.getCreditLimit();
        double newBalance = currentLevel + purchaseAmount;
        if (newBalance <= creditLimit) {
            customer.setBalance(newBalance);
            em.persist(customer);
        } else {
            throw new IllegalArgumentException("�" + 
                      customer.getCreditLimit() + 
                      " is not enough credit for a �" + newBalance
                    + " purchase.");
        }
    } 

}
