/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import utils.TreePrinterUtils;

public class MainFrame extends JFrame {
  protected JPanel displayOptionsPanel;
  protected JButton bgColorButton;
  protected JButton defaultColorButton;

  protected JToggleButton lockingToggleButton;
  protected JTextArea textArea;
  protected JComboBox fontStyleComboBox;
  protected JSlider fontSizeSlider;
  protected JLabel sliderLabel;
  protected JLabel eventLabel;

  protected JList saladList;
  protected JTextField chosenItemTextField;

  protected JPasswordField secretCodeField;

  protected JMenuItem menuItem1;
  protected JMenuItem menuItem2;
  protected JMenuItem menuItem3;
  protected JMenuItem menuItem4;

  protected JCheckBox vegetablesCheckBox;
  protected JCheckBox fruitsCheckBox;
  protected JCheckBox nutsCheckBox;
  protected JCheckBox cheesesCheckBox;

  protected JRadioButton titleBorderRadioButton;
  protected JRadioButton lineBorderRadioButton;
  protected JRadioButton etchedBorderRadioButton;
  protected JRadioButton bevelBorderRadioButton;
  protected JRadioButton noBorderRadioButton;

  protected List vegetables =
    Arrays.asList(
      new String[] { "Tomatoes", "Lettuce", "Cucumbers", "Olives" });
  protected List fruits =
    Arrays.asList(new String[] { "Apples", "Oranges", "Dates" });
  protected List nuts =
    Arrays.asList(new String[] { "Walnuts", "Almonds", "Peanuts" });
  protected List cheeses =
    Arrays.asList(
      new String[] { "Jack Cheese", "Cheddar Cheese", "Jalapeno Cheese" });
  protected Vector saladListItems = new Vector(vegetables);

  public MainFrame() {
    super("Introduction to Swing GUIs");
    JMenuBar menuBar1 = createMenuBar();
    setJMenuBar(menuBar1);

    JPanel contentPane = new JPanel();
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout());

    JPanel centerPanel = createCenterPanel();
    contentPane.add(centerPanel, BorderLayout.CENTER);

    JPanel northPanel = createNorthPanel();
    contentPane.add(northPanel, BorderLayout.NORTH);

    JPanel southPanel = createSouthPanel();
    contentPane.add(southPanel, BorderLayout.SOUTH);

    setSize(600, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    TreePrinterUtils.printLayout(this);
  }
  private JMenuBar createMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    JMenu menu1 = new JMenu("Menu 1");
    menuBar.add(menu1);
    menuItem1 = new JMenuItem("Menu Item 1");
    menu1.add(menuItem1);
    menuItem2 = new JMenuItem("Menu Item 2");
    menu1.add(menuItem2);
    JMenu menu2 = new JMenu("Menu 2");
    menuBar.add(menu2);
    menuItem3 = new JMenuItem("Menu Item 3");
    menu2.add(menuItem3);
    menuItem4 = new JMenuItem("Menu Item 4");
    menu2.add(menuItem4);
    return menuBar;
  }
  private JPanel createCenterPanel() {
    JPanel centerPanel = new JPanel(new BorderLayout());
    JPanel centerNorthPanel = new JPanel(new GridLayout(0, 2));
    eventLabel =
      new JLabel("Textarea events will display here.", JLabel.CENTER);
    eventLabel.setBorder(new LineBorder(Color.red));
    eventLabel.setOpaque(true);
    eventLabel.setBackground(Color.yellow);
    eventLabel.setForeground(Color.red);
    centerNorthPanel.add(eventLabel, BorderLayout.CENTER);
    lockingToggleButton = new JToggleButton("Lock Text Area");
    centerNorthPanel.add(lockingToggleButton, BorderLayout.WEST);
    centerPanel.add(centerNorthPanel, BorderLayout.NORTH);

    textArea = new JTextArea(30, 60);
    textArea.setFont(textArea.getFont().deriveFont((float)24));
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    centerPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
    return centerPanel;
  }
  private JPanel createNorthPanel() {
    JPanel northPanel = new JPanel(new BorderLayout());

    displayOptionsPanel = createDisplayOptionsPanel();
    northPanel.add(displayOptionsPanel, BorderLayout.WEST);

    JPanel saladOptionsPanel = createSaladOptionsPanel();
    northPanel.add(saladOptionsPanel, BorderLayout.CENTER);

    return northPanel;
  }
  private JPanel createDisplayOptionsPanel() {
    displayOptionsPanel = new JPanel();
    displayOptionsPanel.setBorder(new TitledBorder("Panel Options"));

    JPanel colorButtonPanel = new JPanel(new GridLayout(0, 1));
    bgColorButton = new JButton("Choose Background Color");
    bgColorButton.setToolTipText("Click to select background color.");
    colorButtonPanel.add(bgColorButton);
    defaultColorButton = new JButton("Default Background Color");
    defaultColorButton.setToolTipText(
      "Click to restore background color to its default.");
    colorButtonPanel.add(defaultColorButton);
    displayOptionsPanel.add(colorButtonPanel);

    JPanel radioPanel = new JPanel(new GridLayout(0, 1));
    radioPanel.setBorder(new TitledBorder("Borders"));

    noBorderRadioButton = new JRadioButton("No Border");
    radioPanel.add(noBorderRadioButton);
    titleBorderRadioButton = new JRadioButton("TitleBorder");
    titleBorderRadioButton.setSelected(true);
    radioPanel.add(titleBorderRadioButton);
    lineBorderRadioButton = new JRadioButton("LineBorder");
    radioPanel.add(lineBorderRadioButton);
    etchedBorderRadioButton = new JRadioButton("EtchedBorder");
    radioPanel.add(etchedBorderRadioButton);
    bevelBorderRadioButton = new JRadioButton("BevelBorder");
    radioPanel.add(bevelBorderRadioButton);
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(noBorderRadioButton);
    buttonGroup.add(titleBorderRadioButton);
    buttonGroup.add(lineBorderRadioButton);
    buttonGroup.add(etchedBorderRadioButton);
    buttonGroup.add(bevelBorderRadioButton);
    displayOptionsPanel.add(radioPanel);

    return displayOptionsPanel;
  }
  private JPanel createSaladOptionsPanel() {
    JPanel saladOptionsPanel = new JPanel(new BorderLayout());
    saladOptionsPanel.setBorder(new TitledBorder("Salad Options"));

    JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));
    checkBoxPanel.setBorder(new TitledBorder("Ingredients"));
    vegetablesCheckBox = new JCheckBox("Vegetables");
    vegetablesCheckBox.setSelected(true);
    checkBoxPanel.add(vegetablesCheckBox);
    fruitsCheckBox = new JCheckBox("Fruits");
    checkBoxPanel.add(fruitsCheckBox);
    nutsCheckBox = new JCheckBox("Nuts");
    checkBoxPanel.add(nutsCheckBox);
    cheesesCheckBox = new JCheckBox("Cheeses");
    checkBoxPanel.add(cheesesCheckBox);
    saladOptionsPanel.add(checkBoxPanel, BorderLayout.WEST);

    saladList = new JList(vegetables.toArray());
    JScrollPane scrollPane1 = new JScrollPane(saladList);
    saladOptionsPanel.add(scrollPane1, BorderLayout.CENTER);

    chosenItemTextField = new JTextField();
    saladOptionsPanel.add(chosenItemTextField, BorderLayout.SOUTH);
    return saladOptionsPanel;
  }
  private JPanel createSouthPanel() {
    JPanel southPanel = new JPanel();

    JPanel fontPanel = new JPanel(new BorderLayout());
    fontPanel.setBorder(new TitledBorder("Font"));
    fontStyleComboBox =
      new JComboBox(new String[] { "Plain", "Bold", "Italic", "Bold+Italic" });
    fontPanel.add(fontStyleComboBox, BorderLayout.WEST);

    fontSizeSlider = new JSlider(1, 200, 24);
    fontPanel.add(fontSizeSlider, BorderLayout.CENTER);
    sliderLabel = new JLabel(String.valueOf(fontSizeSlider.getValue()));
    fontPanel.add(sliderLabel, BorderLayout.EAST);
    southPanel.add(fontPanel);

    JPanel codePanel = new JPanel();
    codePanel.setBorder(new EtchedBorder());

    codePanel.add(new JLabel("Enter Secret Code:"));
    secretCodeField = new JPasswordField(10);
    codePanel.add(secretCodeField);
    southPanel.add(codePanel);
    return southPanel;
  }
  public static void main(String[] arg) {
    MainFrame frame = new MainFrame();
  }
}