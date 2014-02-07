/*
 * RendererArbol.java
 *
 * Created on 24 de noviembre de 2008, 18:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package interfaz;

import javax.swing.tree.*;
import javax.swing.*;
import java.awt.*;

public class NodoTreeCellRenderer implements TreeCellRenderer {
        private JLabel label;
 
        public NodoTreeCellRenderer() {
            label = new JLabel();
        }
 
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                boolean expanded, boolean leaf, int row, boolean hasFocus) {
            Object o = ((DefaultMutableTreeNode) value).getUserObject();
            if (o instanceof ModeloNodoArbol) {
                ModeloNodoArbol hoja = (ModeloNodoArbol) o;
                label.setIcon(new ImageIcon(hoja.getFlagIcon()));
                label.setText(getNombreFormato(hoja.getName()));
                label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            } else {
                label.setIcon(null);
                label.setText("" + value);
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            return label;
        }
        
        private String getNombreFormato(String palabra){
            palabra = palabra.charAt(0) +palabra.substring(1, palabra.length()).toLowerCase();
            return palabra;
        }
    }