import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Okno extends Frame
{
    private int n;
    private int m;
    private int height = 40;
    private int width = 40;
    private Plotno plotno;
    private Labirynt labirynt;

    private WindowListener frameList = new WindowAdapter()
    {
        @Override
        public void windowClosing (WindowEvent ev)
        {
            Okno.this.dispose();
        }
    };
    private KeyListener keyList = new KeyAdapter()
    {
        @Override
        public void keyPressed (KeyEvent ev)
        {
            int keyCode = ev.getKeyCode();
            switch( keyCode ) { 
                case KeyEvent.VK_UP:
                    labirynt.przesun_gora();
                    break;
                case KeyEvent.VK_DOWN:
                    labirynt.przesun_dol();
                    break;
                case KeyEvent.VK_LEFT:
                    labirynt.przesun_lewo();
                    break;
                case KeyEvent.VK_RIGHT :
                    labirynt.przesun_prawo();
                    break;
            }
            plotno.paint(plotno.getGraphics());
        }
    };

    public Okno(int nn,int mm)
    {
        super("Labirynt");
        n = nn;
        m = mm;
        
        labirynt = new Labirynt(n,m);
        plotno = new Plotno(n,m,height,width,labirynt);
        plotno.addKeyListener(keyList);
        plotno.setFocusable(true);
        plotno.requestFocus();

        setSize(n*40, m*40+25);
        setLocation(100, 100);
        setBackground(Color.BLACK);
        add(plotno, BorderLayout.CENTER);
        addWindowListener(frameList);
        setResizable(false);
        setVisible(true);
    }
}