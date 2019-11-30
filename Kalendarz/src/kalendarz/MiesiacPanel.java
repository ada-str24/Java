package kalendarz;

import javax.swing.*;

public class MiesiacPanel extends JPanel {

    private Calendar calendar;
    private JList prev;
    private JList next;
    private JList current;
    private List nextlist;
    private List prevlist;
    private List currentlist;

    public MiesiacPanel(Calendar c)
    {
        calendar = c;
        currentlist = new List(calendar.get_month(), calendar.get_year());
        current = new JList(currentlist);

        nextlist = new List(calendar.get_next_month(), calendar.get_next_months_year());
        next = new JList(nextlist);

        prevlist = new List(calendar.get_prev_month(), calendar.get_prev_months_year());
        prev = new JList(prevlist);

        current.setCellRenderer(new ListView(currentlist));
        next.setCellRenderer(new ListView(nextlist));
        prev.setCellRenderer(new ListView(prevlist));
        add(prev);
        add(current);
        add(next);
    }

    public void act()
    {
        currentlist.act(calendar.get_month(), calendar.get_year());
        prevlist.act(calendar.get_prev_month(), calendar.get_prev_months_year());
        nextlist.act(calendar.get_next_month(), calendar.get_next_months_year());
    }
}
