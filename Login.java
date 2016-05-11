import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;



class Login
{

    Login()
    {
        JFrame frame = new JFrame("Login/Register");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.setLayout(new GridLayout(2,2));
        JButton register = new JButton("Register");
        JButton signIn = new JButton("Sign in");
        JLabel label = new JLabel();
        JLabel username = new JLabel("Username");
        JLabel password = new JLabel("Password");
        JTextField uname = new JTextField(8);
        JTextField pword = new JTextField(8);


        frame.add(username);
        frame.add(uname);
        frame.add(password);
        frame.add(pword);
        frame.add(signIn);
        frame.add(register);
        frame.add(label);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    User details;
                    FileOutputStream fout= new FileOutputStream("Passwords");
                    ObjectOutputStream oout = new ObjectOutputStream(fout);
                    details = new User(uname.getText(),pword.getText());
                    oout.writeObject(details);
                    oout.flush();
                    oout.close();
                    fout.close();
                }
                catch(Exception m)
                {
                    System.out.println(m);
                }
            }
        });

        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    FileInputStream fin = new FileInputStream("Passwords.txt");
                    ObjectInputStream oin = new ObjectInputStream(fin);
                    User m;
                    m = (User)oin.readObject();
                    if (m.name.equals(uname.getText()) && m.password.equals(pword.getText()))
                    {
                        label.setText("Password and Username are correct.");
                    }
                }
                catch(Exception m)
                {
                    System.out.println(m);
                }

            }
        });

    }
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }

}
class User implements Serializable
{
    String name;
    String password;
    User(String name,String password)
    {
        this.name = name;
        this.password = password;

    }
}

