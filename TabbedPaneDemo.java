import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/*
 <applet code=TabbedPaneDemo width=500 height=500>
 </applet>
 */

public class TabbedPaneDemo extends JApplet
{
    public void init()
    {
        try
        {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    makeGUI();
                }
            });
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private void makeGUI()
    {
        setLayout(new FlowLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Cities",new CitiesPanel());
        tabbedPane.add("Colors",new ColorPanel());
        tabbedPane.add("Flavours",new FlavoursPanel());
        add(tabbedPane);
    }

}

class CitiesPanel extends JPanel implements ActionListener
{
    JLabel label;
    public CitiesPanel()
    {
        JButton newYork = new JButton("New York");
        add(newYork);
        newYork.addActionListener(this);
        JButton london = new JButton("London");
        add(london);
        london.addActionListener(this);
        JButton hongKong = new JButton("Hong Kong");
        add(hongKong);
        hongKong.addActionListener(this);
        JButton tokyo = new JButton("Tokyo");
        tokyo.addActionListener(this);
        add(tokyo);
        label = new JLabel("Press a button.");
        add(label);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        label.setText("You pressed "+e.getActionCommand());
    }
}

class ColorPanel extends JPanel implements ActionListener
{
    JLabel label;
    public ColorPanel()
    {
        JButton red = new JButton("Red");
        red.addActionListener(this);
        add(red);
        JButton blue = new JButton("Blue");
        blue.addActionListener(this);
        add(blue);
        JButton green = new JButton("Green");
        add(green);
        JButton yellow = new JButton("Yellow");
        add(yellow);
        label=new JLabel("Press a button.");
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("You have pressed " +e.getActionCommand());
    }
}

class FlavoursPanel extends JPanel implements ActionListener
{
    JLabel label;
    public  FlavoursPanel()
    {
        JButton vanilla = new JButton("Vanilla");
        add(vanilla);
        vanilla.addActionListener(this);

        JButton blackCurrent = new JButton("Black Current");
        add(blackCurrent);
        blackCurrent.addActionListener(this);

        JButton chocalate = new JButton("Chocalate");
        add(chocalate);
        chocalate.addActionListener(this);

        JButton rose = new JButton("Rose");
        add(rose);
        rose.addActionListener(this);

        label = new JLabel("Press any button.");
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("You have pressed "+e.getActionCommand());
    }
}
