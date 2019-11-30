package kalendarz;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MiescwRokuPanel extends JPanel {


    private JLabel nazwa;
    private JPanel dni = new JPanel();

    private int month;

    private Calendar calendar;


    public MiescwRokuPanel(int m, Calendar c)
    {
        calendar = c;
        month = m;
        nazwa = new JLabel(Miesiac.nazwy_miesiecy[month],SwingConstants.CENTER);
        nazwa.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e)
            {
                calendar.set_month(month);
                calendar.window.tabbedpane.setSelectedIndex(1);
            }
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
        });

        setLayout(new GridLayout(2,1));
        add(nazwa);
        dni.setLayout(new GridLayout(0,7,4,4));


        int first = Miesiac.day_of_the_week(1,month,calendar.get_year());
        int counter = 1;
        for(int i=1;i<first;i++)
        {
            JLabel lab = new JLabel();
            dni.add(lab);
            counter++;
        }
        Miesiac.new_day_stream(month,calendar.get_year());
        while(!Miesiac.stream_end())
        {
            String day = Miesiac.next_day();
            JLabel lab = new JLabel(day,SwingConstants.RIGHT);
            if(counter % 7 == 0) lab.setForeground(Color.RED);
            counter++;
            dni.add(lab);
        }
        dni.setBorder(new LineBorder(Color.LIGHT_GRAY));
        add(dni);
        repaint();
    }
}
