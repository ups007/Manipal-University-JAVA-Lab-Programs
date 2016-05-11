import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 <applet code=ToggleButtonDemo width=800 height=800>
 </applet>
 */
public class ToggleButtonDemo extends JApplet implements ItemListener
{
    JToggleButton onoff;
    JLabel label;
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
        label = new JLabel("Press the button.");
        onoff = new JToggleButton("On/Off");

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(label);
        add(onoff);

        onoff.addItemListener(this);

    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if(onoff.isSelected())
            label.setText("Button is on.");
        else
            label.setText("Button is off");
    }
}
