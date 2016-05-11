import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;;
import java.awt.*;

/*
<applet code=JTreeDemo width=500 height=500>
</applet>
 */

public class JTreeDemo extends JApplet
{
    JTree tree;
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
        DefaultMutableTreeNode india = new DefaultMutableTreeNode("India");
        DefaultMutableTreeNode mumbai = new DefaultMutableTreeNode("Mumbai");
        DefaultMutableTreeNode bangalore = new DefaultMutableTreeNode("Bangalore");
        DefaultMutableTreeNode karnataka = new DefaultMutableTreeNode("Karnatak");
        DefaultMutableTreeNode mangalore = new DefaultMutableTreeNode("Mangalore");
        DefaultMutableTreeNode maharashtra = new DefaultMutableTreeNode("Maharashtra");

        india.add(maharashtra);
        india.add(karnataka);
        maharashtra.add(mumbai);
        karnataka.add(bangalore);
        karnataka.add(mangalore);

        tree=new JTree(india);
        JScrollPane jsp = new JScrollPane(tree);
        add(jsp);
        label = new JLabel();
        add(label,BorderLayout.SOUTH);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                label.setText("Selection is " + e.getPath());
            }
        });
    }


}
