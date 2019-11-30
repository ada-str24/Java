import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Plotno extends Canvas{
    private String filename = "eksplorator2.gif";
    private Image badacz;
    private int n;
    private int m;
    private int height;
    private int width;
    private Labirynt labirynt;
    public Plotno(int nn,int mm,int h,int w ,Labirynt l)
    {
        super();
        height = h;
        width = w;
        n = nn;
        m = mm;
        labirynt = l;
        try{
            badacz = ImageIO.read(new File(filename));
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void paint(Graphics gr)
    {
        if(labirynt.koniec() == false)
        {
            int x = width/2 + labirynt.get_position_x()*width;
            int y = height/2 + labirynt.get_position_y()*height;

            gr.clearRect(0, 0, 20*width, 20*height);
            gr.drawImage(badacz,x-3,y-3,6,6,this);

            gr.setColor(new Color(99,255,143));
            gr.fillOval((n-1)*width+5, (m-1)*height+5,30,30);
            
            gr.setColor(Color.CYAN);

            for(int i=0;i<=(n-2);i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(labirynt.are_connected(j*n+i,j*n+i+1)) continue;
                    gr.fillRect(((i+1)*width)-1, j*height , 2, height);
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<=(m-2);j++)
                {
                    if(labirynt.are_connected(j*n+i,j*n+i+n)) continue;
                    gr.fillRect(i*width, (j+1)*height-1 , width, 2);
                }
            }
        }
        else
        {
            gr.clearRect(0, 0, 20*40, 20*40);

            try{
                Image end = ImageIO.read(new File("win.jpg"));
                gr.drawImage(end,55,100,this);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}