import java.util.*;


public class Labirynt{
    
    //////////////////////////////////////////////////////////////
    private para krawedzie[];
    private int V[];
    private int maska[];
    ///////////////////////////////////////////////////////////


    //private Generator generator;
    private int position_x = 0;
    private int position_y = 0;
    private int n;
    private int m;
    private boolean end = false;

    public boolean koniec()
    {
        return end;
    }

    public int get_position_x()
    {
        return position_x;
    }
    public int get_position_y()
    {
        return position_y;
    }

    public Labirynt(int nn,int mm)
    {
        n = nn;
        m = mm;
        //generator = new Generator(n,m);
        generator();

    }
    /*public boolean are_connected(int a,int b)
    {
        return generator.are_connected(a,b);
    }*/

    public void przesun_gora()
    {
        if(position_y == 0) return;
        int y = position_y;
        int x = position_x;
        if(are_connected(n*y+x,n*y+x-n))
        {
            position_y -= 1;
        }
    }
    public void przesun_dol()
    {
        if(position_y == m-1) return;
        int y = position_y;
        int x = position_x;
        if(are_connected(n*y+x,n*y+x+n))
        {
            position_y += 1;
        } 
        if((position_y == m-1) && (position_x == n-1)) end=true; 
    }
    public void przesun_lewo()
    {
        if(position_x == 0) return;
        int y = position_y;
        int x = position_x;
        if(are_connected(n*y+x,n*y+x-1))
        {
            position_x -= 1;
        } 
    }
    public void przesun_prawo()
    {
        if(position_x == n-1) return;
        int y = position_y;
        int x = position_x;
        if(are_connected(n*y+x,n*y+x+1))
        {
            position_x += 1;
        } 
        if((position_y == m-1) && (position_x == n-1)) end=true; 
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    public boolean are_connected(int a,int b)
    {
        if(a>b)
        {
            int temp =a;
            a=b;
            b=temp;
        }
        if(a + 1 == b)
        {
            if(maska[a]==1 || maska[a]==3) return true;
            else return false;
        }
        if(a + n == b)
        {
            if(maska[a]==2 || maska[a]==3) return true;
            else return false;
        }
        else return false;
    }

    private class para{
        public int a;
        public int b;
        para(int aa,int bb)
        {
            a=aa;
            b=bb;
        }
    }


    private void generator()
    {
        krawedzie = new para[n*m*4];
        V = new int [n*m];
        maska = new int[n*m];
        int liczbakrawedzi = 0;
        for(int j=0;j<m-1;j++)
        {
            for(int i=0;i<n-1;i++)
            {
                krawedzie[liczbakrawedzi] = new para(idx_to_vertex(i,j), idx_to_vertex(i,j)+1);
                krawedzie[liczbakrawedzi+1] = new para(idx_to_vertex(i,j), idx_to_vertex(i,j)+n);
                liczbakrawedzi+=2;
            }
            krawedzie[liczbakrawedzi] =  new para(idx_to_vertex(n-1,j), idx_to_vertex(n-1,j)+n);
            liczbakrawedzi++;
        }
        for(int i=0;i<n-1;i++)
        {
            krawedzie[liczbakrawedzi] = new para(idx_to_vertex(i,m-1), idx_to_vertex(i,m-1)+1);
            liczbakrawedzi+=1;
        }
        shuffleArray(liczbakrawedzi);
        for(int i=0;i<n*m;i++)
        {
            V[i]=i;
        }
        for(int i=0;i<n;i++)
        {
            maska[i]=0;
        }
        for(int i=0;i<liczbakrawedzi;i++)
        {
            if(Find(krawedzie[i].a) == Find(krawedzie[i].b)) continue;
            Union(krawedzie[i].a,krawedzie[i].b);
        }
    }

    private int idx_to_vertex(int i,int j)
    {
        return n*j + i;
    }
    private void shuffleArray(int liczbakrawedzi)
    {
        Random rnd = new Random();
        for (int i = liczbakrawedzi-1; i > 0; i--)
        {
            int index = (Math.abs(rnd.nextInt()))%liczbakrawedzi;
            para a = krawedzie[index];
            krawedzie[index] = krawedzie[i];
            krawedzie[i] = a;
        }
    }
    private int Find(int a)
    {
        if(V[a]==a) return a;
        else return V[a]=Find(V[a]);
    }
    private void Union(int a,int b)
    {
        V[Find(b)]=Find(a);
        if(a>b)
        {
            int temp =a;
            a=b;
            b=temp;
        }
        if(a+1 == b) 
        {
            maska[a] += 1;
        }
        else
        {
            maska[a] += 2;
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
}