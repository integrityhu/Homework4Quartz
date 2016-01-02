/**
 * 
 */
package hu.infokristaly.homework.quartz.back.model;

import java.util.Date;

import org.primefaces.model.ScheduleEvent;

/**
 * @author pzoli
 *
 */
public class BaseScheduleEvent implements ScheduleEvent {

    private String title;
    private Date endDate;
    private Date startDate;
    /* (non-Javadoc)
     * @see org.primefaces.model.ScheduleEvent#getId()
     */
    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.primefaces.model.ScheduleEvent#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.primefaces.model.ScheduleEvent#getData()
     */
    @Override
    public Object getData() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.primefaces.model.ScheduleEvent#getStartDate()
     */
    @Override
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /* (non-Javadoc)
     * @see org.primefaces.model.ScheduleEvent#getEndDate()
     */
    @Override
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    /* (non-Javadoc)
     * @see org.primefaces.model.ScheduleEvent#isAllDay()
     */
    @Override
    public boolean isAllDay() {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.primefaces.model.ScheduleEvent#getStyleClass()
     */
    @Override
    public String getStyleClass() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.primefaces.model.ScheduleEvent#isEditable()
     */
    @Override
    public boolean isEditable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
