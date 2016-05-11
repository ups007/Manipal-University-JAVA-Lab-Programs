import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code=CheckBoxDemo width=500 height=500>
</applet>
 */
public class CheckBoxDemo extends JApplet implements ItemListener
{
    JCheckBox c ,cpp,java,perl;
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

        c= new JCheckBox("C");
        c.addItemListener(this);
        add(c);

        cpp=new JCheckBox("C++");
        cpp.addItemListener(this);
        add(cpp);

        java=new JCheckBox("Java");
        java.addItemListener(this);
        add(java);

        perl = new JCheckBox("Perl");
        perl.addItemListener(this);
        add(perl);

        label = new JLabel();
        add(label);

    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        JCheckBox selected = (JCheckBox)e.getItem();

        if(selected.isSelected())
            label.setText(selected.getText()+" is selected.");
        else
            label.setText(selected.getText()+" is unselected.");
    }
}
