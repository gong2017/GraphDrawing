/**
 * B. Postnikoff
 * Button Panel
 * 2016-04-08
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel //implements ActionListener
{
    // private GridLayout gridLayout = new GridLayout(0,1);
    private JLabel graphLabel = new JLabel("Choose graph: ");
    private String[] graphStringList = {"Mid7", "Mid9", "TestFile", "Thomassen"}; 
    private JComboBox graphList;

    private JLabel lineLabel = new JLabel("Choose line shape: ");
    private JRadioButton straightLine = new JRadioButton("Straight");
    private JRadioButton orthogonalLine = new JRadioButton("Orthogonal");
    private JRadioButton polyLine = new JRadioButton("Polyline");

    private JLabel aesthetics = new JLabel("Choose aesthetics: ");
    private JCheckBox minVertexDistance = new JCheckBox("Minimize vertex distance");
    private JCheckBox minEdgeCrossing = new JCheckBox("Minimize edge crossings");
    private JCheckBox minGraphArea = new JCheckBox("Minimize graph area");
    private JCheckBox maxSymmetry = new JCheckBox("Maximize symmetry");

    // Button Panel constructor
    public ButtonPanel()
    {
        //this.setLayout(gridLayout);
        this.graphList = new JComboBox(graphStringList);
        this.add(graphLabel);
        this.add(graphList);

        this.add(lineLabel);
        this.add(straightLine);
        this.add(orthogonalLine);
        
        this.add(aesthetics);
        this.add(minVertexDistance);
        this.add(minEdgeCrossing);
        this.add(minGraphArea);
        this.add(maxSymmetry);
    }
}
