/**
 *
 * http://www.ibstaff.net/fmartinez/?p=57
 *
 */
package hu.infokristaly.homework.quartz.front.manager;

import hu.infokristaly.homework.quartz.back.model.BaseScheduleEvent;
import hu.infokristaly.homework.quartz.back.timed.MailJobJoinedToDeliveryDate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.component.schedule.Schedule;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.ee.servlet.QuartzInitializerListener;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.quartz.JobBuilder.*;
import static org.quartz.CalendarIntervalScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;

/**
 * @author pzoli
 * 
 */
@Named
@SessionScoped
public class ScheduleManager implements Serializable {

    private static final long serialVersionUID = 620934289508314544L;

    private ScheduleModel eventModel = new DefaultScheduleModel();

    private SchedulerFactory schedulerfactory;

    private Scheduler scheduler;

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    @PostConstruct
    private void init() {
        ServletContext context = (ServletContext) (FacesContext.getCurrentInstance().getExternalContext().getContext());

        Object scheduleFactoryObject = context.getAttribute(QuartzInitializerListener.QUARTZ_FACTORY_KEY);
        if (scheduleFactoryObject instanceof SchedulerFactory) {
            schedulerfactory = (SchedulerFactory) scheduleFactoryObject;
            try {
                scheduler = schedulerfactory.getScheduler();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }

    public void onEventSelect(SelectEvent selectEvent) {
        Object value = selectEvent.getObject();
        if (value != null) {
            System.out.println(value);
        }
    }

    public void onDateSelect(SelectEvent selectEvent) {
        Date event = (Date) selectEvent.getObject();
        Schedule schedule = (Schedule) selectEvent.getComponent();
        
        final TimeZone timeZone = schedule.calculateTimeZone();
        System.out.println(event + ": is in DaylightTime:" + timeZone.inDaylightTime(event) + ", getDSTSavings: " + timeZone.getDSTSavings());
        Calendar startDate = new GregorianCalendar();
        startDate.setTime(event);
        if (timeZone.inDaylightTime(event)) {
            startDate.add(Calendar.MILLISECOND, timeZone.getDSTSavings()*-1);
            event = startDate.getTime();
        }
        
        System.out.println("event start: "+event);
        Date now = new Date();
        startDate.setTime(now);
        startDate.add(Calendar.SECOND, 10);
        Trigger trigger = newTrigger().withIdentity("eventName", "eventGroup").startAt(startDate.getTime()).build();
        JobDetail job = newJob(MailJobJoinedToDeliveryDate.class).withIdentity("deliverydate.isnull{" + startDate.getTime() + "}", "group-name").build();
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        Calendar endDate = new GregorianCalendar();
        endDate.setTime(startDate.getTime());
        endDate.add(Calendar.HOUR, 1);
        
        BaseScheduleEvent scevent = new BaseScheduleEvent();
        scevent.setStartDate(startDate.getTime());
        scevent.setEndDate(endDate.getTime());
        scevent.setId("1");
        scevent.setTitle("teszt");
        eventModel.addEvent(scevent);

    }

    public void onEventMove(ScheduleEntryMoveEvent selectEvent) {
        
    }

    public void onEventResize(ScheduleEntryResizeEvent selectEvent) {
    }
}
