/**
 * 
 */
package hu.infokristaly.homework.quartz.back.timed;

import hu.infokristaly.homework.quartz.middle.service.MailService;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.naming.InitialContext;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author pzoli
 * 
 */
@Stateless
public class MailJobJoinedToDeliveryDate implements Job{


    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //http://entjavastuff.blogspot.hu/2012/01/jboss-7-missing-scheduling-and-jmx.html
        //https://docs.jboss.org/author/display/AS71/EJB+invocations+from+a+remote+client+using+JNDI
        //https://docs.jboss.org/author/display/AS71/JNDI+Reference
        
        try{  
            System.out.println("EntityManager is null");
            System.out.println("because Job isn't ContainerManaged");
            System.out.println("so, we have to lookup in JNDI for service");
            InitialContext ic = new InitialContext();  
            Object service = ic.lookup("java:/global/Homework4Quartz/MailService");
            if ((service != null) && (service instanceof MailService)) {
                System.out.println("service:" + service);
                ((MailService)service).sendMail();
            } else {
                System.out.println("service is null");
            }
          } catch(Throwable t){
              System.out.println("service lookup failed");
          }  
        System.out.println("[MailJobJoinedToDeliveryDate].execute finished ("+dateFormat.format(new Date())+")");
    }

}
