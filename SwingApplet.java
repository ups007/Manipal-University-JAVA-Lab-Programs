import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
<applet code="SwingApplet" width=300 height=400>
</applet>

 */

public class SwingApplet extends JApplet
{
    JButton alpha,beta;
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
        setLayout(new FlowLayout());

        alpha = new JButton("Alpha");
        beta = new JButton("Beta");
        label= new JLabel("Press a button");

        add(label);
        add(beta);
        add(alpha);

        alpha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Alpha was pressed");
            }
        });

        beta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Beta was pressed");
            }
        });

    }
}
