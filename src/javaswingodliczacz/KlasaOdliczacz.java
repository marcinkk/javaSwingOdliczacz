/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingodliczacz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author marcin
 */
public class KlasaOdliczacz extends JFrame implements ActionListener{
    
    private int wysokosc = 150;
    private int szerokosc = 300;
    private int pozycja_okna_x = 500;
    private int pozycja_okna_y = 400;
    private JPanel jPanel = new JPanel();
    private JPanel jPanelLewy = new JPanel();
    private JPanel jPanelPrawy = new JPanel();
    private JButton jButtonStart = new JButton();
    private JButton jButtonStop = new JButton();
    private JButton jButtonReset = new JButton();
    private JTextArea jTextArea = new JTextArea();
    private JScrollPane jScrollPane = new JScrollPane(jTextArea); 
    private GridLayout gridLayoutGlowny = new GridLayout(1, 2);
    private BorderLayout borderLayout = new BorderLayout();
    private GridLayout gridLayoutPrawy = new GridLayout(3, 1);
    private Timer timer;
    private int i = 0;

    public KlasaOdliczacz() {
        setTitle("odliczacz !!!");
        setLocation(pozycja_okna_x, pozycja_okna_y);
        setSize(szerokosc, wysokosc);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel);
        
        timer = new Timer(1000, actionListener);
        
        jTextArea.setText("");
        jTextArea.setLineWrap(true);
        
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        jButtonStart.setText("start");
        jButtonStart.addActionListener(this);
        jButtonReset.setText("reset");
        jButtonReset.addActionListener(this);
        jButtonStop.setText("stop");
        jButtonStop.addActionListener(this);
        
        jPanel.setLayout(gridLayoutGlowny);
        jPanel.add(jPanelLewy);
        jPanel.add(jPanelPrawy);
        
        jPanelLewy.setLayout(borderLayout);
        jPanelLewy.add(jScrollPane, BorderLayout.CENTER);
        
        jPanelPrawy.setLayout(gridLayoutPrawy);
        jPanelPrawy.add(jButtonStart);
        jPanelPrawy.add(jButtonStop);
        jPanelPrawy.add(jButtonReset);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if(object == jButtonStart){
            timer.start();
            jButtonStart.setEnabled(false);
            jButtonStop.setEnabled(true);
        } if(object == jButtonStop){
            timer.stop();
            jButtonStop.setEnabled(false);
            jButtonStart.setEnabled(true);
        } if(object == jButtonReset){
            i = 0;
            jTextArea.setText("");
            timer.start();
            jButtonStop.setEnabled(true);
            jButtonStart.setEnabled(false);
        }
    }
    
    ActionListener actionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            i++;
            jTextArea.append(i + "\n");
        }
    };
    
}
