/**
 * B. Postnikoff
 * Aesthetics Panel
 * Holds the aestheic controls for the graph
 * 2016-04-09
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AestheticsPanel extends Panel
{
    private JLabel aesthetics = new JLabel("Choose aesthetics: ");
    private JButton eades = new JButton("(Step through) Eades");

    // AestheticsPanel object constructor
    public AestheticsPanel(Window window)
    {
        super(window);
        this.setBorder(BorderFactory.createEmptyBorder(0,10,550,0));

        aesthetics.setForeground(Color.WHITE);
        this.add(aesthetics);
        setButtonDetails(eades);
    }

    // Sets button details, adds action listener, adds to panel
    public void setButtonDetails(JButton button)
    {
        button.addActionListener(this);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        this.add(button);
    }

    // Repaints the graph based on the aesthetic choices of the user
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == eades) {
            eades.setSelected(true);
            window.updateAesthetic(0);
        }

        window.repaint();
    }
}
