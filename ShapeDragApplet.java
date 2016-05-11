import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.ByteOrder;


public class ShapeDragApplet extends Frame implements MouseListener, MouseMotionListener,ActionListener
{
    int x,y;
    int x1,y1;
    Button save;
    Label l;
    ShapeDragApplet(String title)
    {
        super(title);
        l=new Label();
        setLayout(new BorderLayout());
        add(l, BorderLayout.SOUTH);
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
        save=new Button("Save");
        add(save,BorderLayout.EAST);
        save.addActionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        x1=e.getX();
        y1=e.getY();
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        l.setText(String.valueOf(Math.abs(x-x1)*Math.abs(y-y1)));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x=e.getX();
        y=e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try
       {

           PrintWriter printWriter = new PrintWriter("Coordinates.txt");
           printWriter.println(String.valueOf(x));
           printWriter.println(String.valueOf(y));
           printWriter.println(String.valueOf(Math.abs(x-x1)));
           printWriter.println(String.valueOf(Math.abs(y-y1)));
           printWriter.close();
       }
       catch(Exception m)
       {
           System.out.print(m);
       }


    }

    @Override
    public void paint(Graphics g)
    {


            g.drawRect(x,y,Math.abs(x-x1),Math.abs(y-y1));



    }
    public static void main(String args[])
    {
        ShapeDragApplet m = new ShapeDragApplet("Drag");
         m.setVisible(true);
    }

}
