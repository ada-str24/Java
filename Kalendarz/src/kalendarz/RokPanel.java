package kalendarz;

import javax.swing.*;
import java.awt.*;

public class RokPanel  extends JPanel {

    private Calendar calendar;

    public RokPanel(Calendar c)
    {
        super();
        calendar = c;
        setLayout(new GridLayout(4,3,15,15));
        act();
        repaint();
    }

    public void act()
    {
        removeAll();
        for(int i=1;i<=12;i++)
        {
            add(new MiescwRokuPanel(i,calendar));
        }
        repaint();
    }
}
