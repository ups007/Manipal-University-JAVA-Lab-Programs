import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code=CalculatorApplet width=500 height=500>
</applet>
 */

public class CalculatorApplet extends JApplet implements ActionListener
{
    JButton addition,subtract,divide,multiply;
    JLabel number1,number2,result;
    JTextField n1,n2,r;
    int x,y;
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
        addition = new JButton("Add");
        subtract = new JButton("Subtract");
        divide = new JButton("Divide");
        multiply = new JButton("Multiply");
        number1=new JLabel("Enter Number 1  ");
        number2=new JLabel("Enter Number 2 ");
        result=new JLabel("Result");
        n1=new JTextField(8);
        n2=new JTextField(8);
        r=new JTextField(8);
        n1.setBounds(150,200,100,20);

        setLayout(new GridLayout(5,2));
        add(number1);
        add(n1);
        add(number2);
        add(n2);
        add(result);
        add(r);
        add(addition);
        add(subtract);
        add(divide);
        add(multiply);

        addition.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add"))
        {
            x=Integer.parseInt(n1.getText());
            y=Integer.parseInt(n2.getText());
            r.setText(String.valueOf(x+y));
        }
        if(e.getActionCommand().equals("Subtract"))
        {
            x=Integer.parseInt(n1.getText());
            y=Integer.parseInt(n2.getText());
            r.setText(String.valueOf(x-y));
        }
        if(e.getActionCommand().equals("Multiply"))
        {
            x=Integer.parseInt(n1.getText());
            y=Integer.parseInt(n2.getText());
            r.setText(String.valueOf(x*y));
        }
        if(e.getActionCommand().equals("Divide"))
        {
            x=Integer.parseInt(n1.getText());
            y=Integer.parseInt(n2.getText());
            r.setText(String.valueOf(x/y));
        }
    }
}


