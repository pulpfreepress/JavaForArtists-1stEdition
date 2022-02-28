/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap14.interlude;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class DemoFrame extends JFrame {

  public DemoFrame() {
    super("Tree and Table Editor Demo");

    DemoTreeOrTableCellHandler handler1 = new DemoTreeOrTableCellHandler();

    JTable table = createTable();
    table.setDefaultRenderer(Object.class, handler1);
    table.setDefaultEditor(Object.class, handler1);

    DemoTreeOrTableCellHandler handler2 = new DemoTreeOrTableCellHandler();

    JTree tree = createTree();
    tree.setCellRenderer(handler2);
    tree.setCellEditor(handler2);

    //uncomment to see what happens.
    //tree.setCellRenderer(handler1);
    //tree.setCellEditor(handler1);

    JPanel contentPane = new JPanel();
    setContentPane(contentPane);
    contentPane.setLayout(new GridLayout(1, 2));
    JPanel treePanel = new JPanel(new BorderLayout());
    JPanel tablePanel = new JPanel(new BorderLayout());
    tablePanel.add(BorderLayout.CENTER, new JScrollPane(table));
    tablePanel.setBorder(BorderFactory.createTitledBorder("Table Demo"));
    treePanel.add(BorderLayout.CENTER, new JScrollPane(tree));
    treePanel.setBorder(BorderFactory.createTitledBorder("Tree Demo"));
    contentPane.add(treePanel);
    contentPane.add(tablePanel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);

  }
  private JTable createTable() {
    Object[][] data = { { "Mickey", "NMI", "Mouse", "mousem" }, {
        "Donald", "NMI", "Duck", "duckd" }, {
        "Felix", "the", "Cat", "catf" }, {
        "Winnie", "ther", "Pooh", "poohw" }
    };
    Object[] columns = { "First", "Middle", "Last", "User Name" };

    DefaultTableModel model = new DefaultTableModel(data, columns);
    JTable table = new JTable(model);

    return table;
  }
  private JTree createTree() {
    DefaultMutableTreeNode food = new DefaultMutableTreeNode("Food");
    DefaultMutableTreeNode fruits = new DefaultMutableTreeNode("Fruits");
    DefaultMutableTreeNode vegetables =
      new DefaultMutableTreeNode("Vegatables");
    DefaultMutableTreeNode apples = new DefaultMutableTreeNode("Apples");
    DefaultMutableTreeNode pears = new DefaultMutableTreeNode("Pears");
    DefaultMutableTreeNode cucumbers = new DefaultMutableTreeNode("Cucumbers");
    DefaultMutableTreeNode tomatoes = new DefaultMutableTreeNode("Tomatoes");
    food.add(fruits);
    food.add(vegetables);
    fruits.add(apples);
    fruits.add(pears);
    vegetables.add(cucumbers);
    vegetables.add(tomatoes);

    DefaultTreeModel model = new DefaultTreeModel(food);
    JTree tree = new JTree(model);
    tree.setEditable(true);

    return tree;
  }
  public static void main(String[] arg) {
    new DemoFrame().setVisible(true);
  }
}