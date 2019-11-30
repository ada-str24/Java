package kalendarz;

import javax.swing.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;


public class Scroll extends JScrollBar implements AdjustmentListener {

    private Calendar calendar;

    public Scroll(Calendar c)
    {
        super(JScrollBar.HORIZONTAL,c.get_year(),1,0,2200);
        addAdjustmentListener(this);
        calendar = c;
        //setValue(0);
    }

    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        calendar.set_year(e.getValue());
    }

    public void act()
    {
        setValue(calendar.get_year());
    }
}
