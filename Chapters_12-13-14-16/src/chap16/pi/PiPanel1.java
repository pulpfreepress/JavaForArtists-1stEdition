/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.pi;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class PiPanel1 extends JPanel implements ActionListener {
  private JTextArea textArea;
  private JButton spigotButton;
  private PiSpigot spigot;
  private int numDigits = 0;
  private JScrollBar vScrollBar;
  private JScrollPane scrollPane;

  private boolean paused = true;

  /* producerThread is protected so that a subclass can reference it. */
  protected Thread producerThread;

  /* buttonPanel is protected so that a subclass can reference it. */
  protected final JPanel buttonPanel;

  public PiPanel1() {
    setLayout(new BorderLayout());

    textArea = new JTextArea(20, 123);
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
    textArea.setEditable(false);
    scrollPane = new JScrollPane(textArea);
    scrollPane.setHorizontalScrollBarPolicy(
      JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setVerticalScrollBarPolicy(
      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    add(scrollPane, BorderLayout.CENTER);

    vScrollBar = scrollPane.getVerticalScrollBar();

    spigotButton = new JButton("Play");
    spigotButton.addActionListener(this);
    buttonPanel = new JPanel(new BorderLayout());
    buttonPanel.add(spigotButton, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    spigot = new PiSpigot();
    startProducer();
  }

  /* Thread-related methods */
  private void startProducer() {
    producerThread = new Thread() {
      public void run() {
        while (true) {
          Thread.yield();
          while (paused) {
            pauseImpl();
          }
          int digit = spigot.nextDigit();
          handleDigit(digit);
        }
      }
    };
    producerThread.start();
  }

  /* pauseImpl will be implemented differently in a future subclass */
  protected void pauseImpl() {
    try {
      Thread.sleep(Long.MAX_VALUE);
    } catch (InterruptedException e) {}
  }
  private void play() {
    paused = false;
    playImpl();
  }
  /* playImpl will be implemented differently in a future subclass */
  protected void playImpl() {
    producerThread.interrupt();
  }
  private void pause() {
    paused = true;
  }

  /* Play/Pause Button */
  public void actionPerformed(ActionEvent e) {
    String action = spigotButton.getText();
    if ("Play".equals(action)) {
      play();
      spigotButton.setText("Pause");
    } else {
      pause();
      spigotButton.setText("Play");
    }
  }

  /* GUI-related methods */
  protected void showLastLine() {
    /*
     * These swing conponent methods are not thread-safe 
     * so we use SwingUtilities.invokeLater
     */
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JScrollBar vScrollBar = scrollPane.getVerticalScrollBar();
        int numLines = textArea.getLineCount();
        int lineHeight =
          textArea.getScrollableUnitIncrement(
            scrollPane.getViewport().getViewRect(),
            SwingConstants.VERTICAL,
            -1);
        int visibleHeight = vScrollBar.getVisibleAmount();
        int numVisibleLines = visibleHeight / lineHeight;
        int scroll = (numLines - numVisibleLines) * lineHeight;
        vScrollBar.setValue(scroll);
      }
    });
  }
  protected void displayDigit(int digit) {
    if (numDigits == 1) {
      textArea.append(".");
    }
    textArea.append(String.valueOf(digit));
    numDigits++;
    if (numDigits > 1) {
      if ((numDigits - 1) % 100 == 0) {
        textArea.append("\n  "); //JTextArea.append is thread-safe
        showLastLine();
      } else if ((numDigits - 1) % 5 == 0) {
        textArea.append(" "); //JTextArea.append is thread-safe
      }
    }
  }
  /* handleDigit will be implemented differently in a future subclass */
  protected void handleDigit(int digit) {
    displayDigit(digit);
  }
  public static void main(String[] arg) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new PiPanel1(), BorderLayout.CENTER);
    f.getContentPane().add(new chap16.clock.ClockPanel1(), BorderLayout.NORTH);
    f.pack();
    f.show();
  }
}