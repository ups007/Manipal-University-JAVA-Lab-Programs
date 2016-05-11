import java.awt.*;
import java.awt.event.*;
import java.io.*;

/*
Q2A. Assume that there exists a file with different employee names stored in it.
Every employee name is placed on a separate line.Create an AWT application with a List, a load button, start button and a save button.
On clicking the load button read all the employee names and display it in the List.
Q2B.  Write the random name on to a text file on clicking save button.
Q2C. Displays the first name on status window on clicking start button.

 */

public class EmployeeDemo extends Frame implements ActionListener
{
    Button save,load,start;
    List list;
    TextField name;
    Label addName ;
    Label status;



    EmployeeDemo(String title)
    {
        super(title);
        save=new Button("Save");
        start=new Button("Start");
        load=new Button("Load");
        list=new List();
        name = new TextField();
        addName = new Label("Add Name ");
        status = new Label();
        setLayout(new GridLayout(4,2));
        add(addName);
        add(name);
        add(save);
        add(start);
        add(load);
        add(list);
        add(status,BorderLayout.SOUTH);

        save.addActionListener(this);
        start.addActionListener(this);
        load.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equalsIgnoreCase("save"))
        {

            try
            {
                FileWriter fileWriter = new FileWriter("Employee.txt",true);
                fileWriter.write(name.getText()+"\n");
                fileWriter.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        }
        if(ae.getActionCommand().equalsIgnoreCase("load"))
        {
            list.removeAll();
           try
           {
               FileReader fileReader = new FileReader("Employee.txt");
               BufferedReader bufferedReader = new BufferedReader(fileReader);
               String s;
               while((s=bufferedReader.readLine())!=null)
               {
                   list.add(s+"\n");
               }
               fileReader.close();
               bufferedReader.close();
           }
           catch(Exception e)
           {
               System.out.println(e);
           }
        }
        if(ae.getActionCommand().equalsIgnoreCase("start"));
        {
            try
            {
                FileReader fileReader = new FileReader("Employee.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String s = bufferedReader.readLine();
                status.setText(s);
                fileReader.close();
                bufferedReader.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

    }
    public static void main(String args[])
    {
        EmployeeDemo e = new EmployeeDemo("Employee");
        e.setVisible(true);
    }
}
