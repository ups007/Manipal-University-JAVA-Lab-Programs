import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
Modify the above program to draw a shape with the mouse.
The shape should be allowed to choose from an oval,
an arc, a line, a rectangle with rounded corners and predefined polygon.
Also display the mouse coordinates in the status bar
 */

class Display extends Frame implements ActionListener,MouseMotionListener,MouseListener
{
    int x,y;
    int x1,y1;
    String shape="";
    Display(String title)
    {
        super(title);
        Button oval = new Button("Oval");
        Button rectanlge = new Button("Rectangle");
        Button arc = new Button("Arc");
        Button line = new Button("Line");

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(oval);
        add(rectanlge);
        add(arc);
        add(line);

        oval.addActionListener(this);
        rectanlge.addActionListener(this);
        arc.addActionListener(this);
        line.addActionListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("oval"))
        {
            shape = "oval";

        }
        if(e.getActionCommand().equalsIgnoreCase("Rectangle"))
        {
            shape = "rectangle";

        }
        if(e.getActionCommand().equalsIgnoreCase("Line"))
        {
            shape = "line";

        }
        if(e.getActionCommand().equalsIgnoreCase("Arc"))
        {
            shape = "arc";

        }
    }
    public void mouseClicked(MouseEvent e)
    {
        x=e.getX();
        y=e.getY();
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

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    public void paint(Graphics g) {
        if(shape.equalsIgnoreCase("line"))
        {
            g.drawLine(x,y,x1,y1);
        }
        if(shape.equalsIgnoreCase("rectangle"))
        {
            g.drawRect(x,y,Math.abs(x-x1),Math.abs(y-y1));
        }
        if(shape.equalsIgnoreCase("oval"))
        {
            g.drawOval(x,y,Math.abs(x-x1),Math.abs(y-y1));
        }
        if(shape.equalsIgnoreCase("arc"))
        {
            g.drawArc(x,y,Math.abs(x-x1),Math.abs(y-y1),0,75);
        }
    }
}
class DrawShapes
{
    public static void main(String args[])
    {
        Display d = new Display("Shapes");
        d.setVisible(true);
    }
}
