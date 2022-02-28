/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package utils;

import java.util.ArrayList;

public class TreePrinter {
  private TreeDelegate delegate;
  private static final int DEFAULT_INDENT = 3;
  private int indent;
  private String branchPrefix;
  private String passPrefix;
  private String emptyPrefix;

  public TreePrinter(TreeDelegate delegate) {
    this(delegate, DEFAULT_INDENT);
  }
  public TreePrinter(TreeDelegate delegate, int indent) {
    this.delegate = delegate;
    this.indent = indent;
    branchPrefix = "+";
    passPrefix = "|";
    emptyPrefix = " ";
    for (int i = 0; i < indent - 1; ++i) {
      branchPrefix += "-";
      passPrefix += " ";
      emptyPrefix += " ";
    }
  }
  public String getTree(Object o) {
    StringBuffer buf = new StringBuffer();
    getTree(o, 0, new ArrayList(), buf);
    return buf.toString();
  }
  private void getTree(
    Object comp,
    int depth,
    ArrayList finishedDepths,
    StringBuffer buf) {

    for (int i = finishedDepths.size(); i <= depth; ++i) {
      finishedDepths.add(Boolean.FALSE);
    }

    //create prefix
    String prefix = "";
    if (depth > 0) {
      for (int i = 0; i < depth - 1; ++i) {
        boolean finished = ((Boolean)finishedDepths.get(i)).booleanValue();
        if (finished) {
          //prefix += "   ";
          prefix += emptyPrefix;
        } else
          //prefix += "|  ";
          prefix += passPrefix;
      }
			//prefix += "+--";
			prefix += branchPrefix;
    }
    if (delegate.shouldTreatLikeParent(comp)) {
      buf.append(prefix + delegate.parentToString(comp) + "\n");
      Object[] children = delegate.getChildren(comp);
      finishedDepths.set(depth, Boolean.FALSE);
      for (int i = 0; i < children.length; ++i) {
        if (i == children.length - 1) {
          finishedDepths.set(depth, Boolean.TRUE);
        }
        getTree(children[i], depth + 1, finishedDepths, buf);
      }
    } else {
      buf.append(prefix + delegate.childToString(comp) + "\n");
    }
  }
  public interface TreeDelegate {
    public String childToString(Object o);
    public String parentToString(Object o);
    public boolean shouldTreatLikeParent(Object o);
    public Object[] getChildren(Object parent);
  }
}
