package kalendarz;

import javax.swing.*;
import java.awt.*;

public class Tools extends JToolBar {

    private Calendar calendar;

    private YearChangeButton prev;
    private YearChangeButton next;
    private Scroll scroll;
    private YearSpinner spin;

    public Tools(Calendar c)
    {
        super(HORIZONTAL);
        calendar = c;
        prev = new YearChangeButton(YearChangeButton.PREV, calendar);
        next = new YearChangeButton(YearChangeButton.NEXT, calendar);
        scroll = new Scroll(calendar);
        spin = new YearSpinner(calendar);
        add(prev);
        add(next);
        add(scroll, BorderLayout.PAGE_END);
        add(spin);
    }
    public void act()
    {
        spin.act();
        scroll.act();
    }
}
