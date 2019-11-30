package kalendarz;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {


    public JTabbedPane tabbedpane = new JTabbedPane();

    private RokPanel rok;
    private MiesiacPanel miesiac;
    private Tools tools;
    private Calendar calendar;

    public Window(Calendar c) {
        super("Kalendarz");
        calendar = c;
        setVisible(true);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout( new BorderLayout(20, 20));


        rok = new RokPanel(calendar);
        miesiac = new MiesiacPanel(calendar);
        tools = new Tools(calendar);
        tabbedpane.add(String.valueOf(calendar.get_year()),rok);
        tabbedpane.add(Miesiac.nazwy_miesiecy[(calendar.get_month())],miesiac);
        add(tabbedpane);
        add(tools, BorderLayout.PAGE_END);
        setSize(800, 800);
        repaint();
    }
    public void act()
    {
        tabbedpane.setTitleAt(1, Miesiac.nazwy_miesiecy[calendar.get_month()]);
        tabbedpane.setTitleAt(0, String.valueOf(calendar.get_year()));
        rok.act();
        miesiac.act();
        tools.act();
    }
}
