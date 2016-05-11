import javax.swing.*;

public class SimpleSwing
{
    SimpleSwing()
    {
        JFrame frame = new JFrame("Simple Swing");
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("This is my first swing program.");
        frame.add(label);

        frame.setVisible(true);
    }
    public static void main(String args[])
    {
        try
        {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    new SimpleSwing();
                }
            });
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

