package kalendarz;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class YearSpinner extends JSpinner implements ChangeListener {

    private Calendar calendar;
    private SpinnerModel model;

    public YearSpinner(Calendar c)
    {
        super();
        calendar = c;
        model = new SpinnerNumberModel(calendar.get_year(),0,2200,1);
        setModel(model);
        addChangeListener(this);
    }

    public void stateChanged(ChangeEvent e)
    {
        int y = Integer.parseInt(getValue().toString());
        calendar.set_year(y);
    }

    public void act()
    {
        model.setValue(calendar.get_year());
    }
}
