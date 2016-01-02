/**
 * 
 */
package hu.infokristaly.homework.quartz.middle.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 * @author pzoli
 *
 */
@Named
@Stateless
public class MailService {

    @Inject
    private EntityManager em;
    
    public void sendMail() {
        System.out.println("EntityManager:"+em);
        System.out.println("Mail sent");
    }

}
