package kalendarz;

import javax.swing.*;
import java.awt.*;

public class ListView extends JLabel implements ListCellRenderer<String> {

    private List list;

    public ListView(List l)
    {
        super();
        list = l;
    }

    public Component getListCellRendererComponent (JList lista, String elem, int index, boolean zazn, boolean fokus)
    {
        String napis = elem;
        setText(napis);
        if(elem.charAt(0) == 'N')
        {
            setForeground(Color.RED);
        }
        else setForeground(Color.BLACK);
        return this;
    }
}
