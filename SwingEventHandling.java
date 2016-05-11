import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingEventHandling
{
    JLabel label;
    SwingEventHandling()
    {
        JFrame frame = new JFrame("Exploring Event Handling");
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.setLayout(new FlowLayout());
        JButton alpha = new JButton("Alpha");
        JButton beta = new JButton("Beta");

        label = new JLabel("Press a Button");

        frame.add(alpha);
        frame.add(beta);
        frame.add(label);

        alpha.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event)
            {
                label.setText("Alpha is pressed.");
            }
        });

        beta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event)
            {
                label.setText("Beta is pressed.");
            }
        });
    }

    public static void main(String args[])
    {
        try
        {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new SwingEventHandling();
                }
            });
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}

