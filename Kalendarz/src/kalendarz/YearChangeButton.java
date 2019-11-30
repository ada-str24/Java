package kalendarz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YearChangeButton extends JButton implements ActionListener {

    public static boolean NEXT = true;
    public static boolean PREV = false;



    private Calendar calendar;
    private boolean type;

    public YearChangeButton(boolean tp,Calendar c)
    {
        super();
        type = tp;
        if(type == PREV) setText("prev");
        else if(type == NEXT) setText("next");
        calendar = c;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        int tab = calendar.window.tabbedpane.getSelectedIndex();
        if(tab == 0)
        {
            if (type == PREV) {
                calendar.year_dec();
            }
            else if( type == NEXT) calendar.year_inc();
        }
        else
        {
            if (type == PREV) {
                calendar.month_dec();
            } else if(type == NEXT) calendar.month_inc();
        }
    }
}
