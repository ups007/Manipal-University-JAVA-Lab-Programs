import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code=RadioButtonDemo width=500 height=500>
</applet>
 */

public class RadioButtonDemo extends JApplet implements ActionListener
{
    JRadioButton save,load,start;
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

        save=new JRadioButton("Save");
        save.addActionListener(this);
        add(save);

        load=new JRadioButton("Load");
        load.addActionListener(this);
        add(load);

        start=new JRadioButton("Start");
        start.addActionListener(this);
        add(start);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(save);
        buttonGroup.add(load);
        buttonGroup.add(start);

        label = new JLabel("Select anyone button.");
        add(label);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        label.setText("You selected "+e.getActionCommand());
    }
}
