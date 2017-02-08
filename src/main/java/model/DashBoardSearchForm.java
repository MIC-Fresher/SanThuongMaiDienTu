package model;

import entity.Orders;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DashBoardSearchForm {

    
    private Date fromDate;
    private Date toDate;
    

    public DashBoardSearchForm() {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        this.toDate = cal.getTime();

        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        this.fromDate = cal.getTime();
    }

//----------------------------------------------------------------------------------

   

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

  
  
}
