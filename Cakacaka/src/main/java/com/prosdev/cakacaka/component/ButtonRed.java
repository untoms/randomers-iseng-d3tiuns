/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prosdev.cakacaka.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 *
 * @author bustomi
 */
public class ButtonRed extends JButton{
    
    private Paint paint;
    
    private Shape shape;
    
    private boolean over;
    
    private boolean press;

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
        repaint();
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    public ButtonRed() {
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                setOver(true);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setOver(false);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setPress(true);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                setPress(false);
            }
        
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D gd=(Graphics2D) g.create();        
        
        shape=new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10);
        
        
        if (isEnabled()) {
            
            if (over) {
                gd.setComposite(AlphaComposite.SrcOver.derive(0.3f));
                gd.setPaint(Color.white);
            }else {
                gd.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                gd.setPaint(Color.RED);
            }

            if (press) {
                gd.setComposite(AlphaComposite.SrcOver.derive(1f));
                gd.setPaint(Color.RED);
            }
            
        } else {
            if (over) {
                gd.setComposite(AlphaComposite.SrcOver.derive(0.3f));
                gd.setPaint(Color.white);
            }else {
                gd.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                gd.setPaint(Color.GRAY);
            }

            if (press) {
                gd.setComposite(AlphaComposite.SrcOver.derive(1f));
                gd.setPaint(Color.GRAY);
            }            
        }
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        gd.fill(shape);               
        
        super.paintComponent(g);
        
        setForeground(Color.white);
        gd.dispose();
        
        
    }
    
}
