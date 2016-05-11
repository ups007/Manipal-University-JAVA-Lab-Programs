import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
<applet code=ButtonApplet width=500 height=500>
</applet>
 */

public class ButtonApplet extends JApplet
{
    JLabel label ;
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
        setLayout(new FlowLayout(FlowLayout.LEFT));

        ImageIcon france = new ImageIcon("france.gif");
        JButton buttonFrance = new JButton("France",france);
        add(buttonFrance);

        ImageIcon italy = new ImageIcon("italy.gif");
        JButton buttonItaly = new JButton("Italy",italy);
        add(buttonFrance);

        label = new JLabel("Choose a flag.");

        add(buttonFrance);
        add(buttonItaly);
        add(label);

        buttonFrance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("You selected France");
            }
        });
        buttonItaly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("You selected Italy");
            }
        });

    }
}

