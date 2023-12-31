package interfaz;

import analex.Analex;
import analex.Cinta;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

public class Interfaz extends javax.swing.JFrame {

    private final Cinta cinta;
    private final Analex analex;


    boolean openMode = false;
    
    public Interfaz() {
        initComponents();
        getContentPane().setBackground(new Color(33, 37, 43));
        cinta = new Cinta();   

        NumeroLinea numeroLinea;
        numeroLinea = new NumeroLinea(TextPane);
        jScrollPane2.setRowHeaderView(numeroLinea);

        
        analex = new Analex(cinta) {
            @Override
            public void comunicate(int pos, String lexema) {
                Interfaz.this.resaltar(pos, lexema.length());
            }
        };   
    }

//----------------------------------
//    private void resaltar(int pos, int longitud) {
//        desResaltar();
//        HighlightPainter colorResaltado = new DefaultHighlighter.DefaultHighlightPainter(new Color(131, 0, 0));
//        try {         
//           TextPane.getHighlighter().addHighlight(pos, pos + longitud, colorResaltado);
//        } catch (Exception e) {
//        }
//    }

    private void resaltar(int pos, int longitud) {
        desResaltar();
        HighlightPainter colorResaltado = new DefaultHighlighter.DefaultHighlightPainter(new Color(131, 0, 0));
        
        if (openMode) {
           try {         
            TextPane.getHighlighter().addHighlight(pos, pos + longitud, colorResaltado);
           } catch (Exception e) {
           }  
        } else {     
            String texto = TextPane.getText();
        
            int numSaltosLinea = 0;
            for (int i = 0; i < pos; i++) {
                if (texto.charAt(i) == '\n') {
                    numSaltosLinea++;
                }
             }
            int inicioResaltado = pos - numSaltosLinea;
            int finResaltado = pos + longitud - numSaltosLinea;

            try {
                TextPane.getHighlighter().addHighlight(inicioResaltado, finResaltado, colorResaltado);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
    private void desResaltar() {
        TextPane.getHighlighter().removeAllHighlights();
    }
//----------------------------------

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnInit = new javax.swing.JButton();
        btnAvanzar = new javax.swing.JButton();
        lblPreanalisis = new javax.swing.JLabel();
        tfPreanalisis = new javax.swing.JTextField();
        lblLexema1 = new javax.swing.JLabel();
        tfLexema = new javax.swing.JTextField();
        lblLexema2 = new javax.swing.JLabel();
        scrollBar = new javax.swing.JScrollBar();
        btnOpen = new javax.swing.JButton();
        positionLabel = new javax.swing.JLabel();
        positionLabel1 = new javax.swing.JLabel();
        tabAnchorSelector = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextPane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 102, 0));

        jPanel1.setBackground(new java.awt.Color(51, 56, 66));

        btnInit.setBackground(new java.awt.Color(77, 120, 204));
        btnInit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInit.setForeground(new java.awt.Color(255, 255, 255));
        btnInit.setText("Init");
        btnInit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInit.setBorderPainted(false);
        btnInit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInit.setOpaque(true);
        btnInit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInitClick(evt);
            }
        });

        btnAvanzar.setBackground(new java.awt.Color(77, 120, 204));
        btnAvanzar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAvanzar.setForeground(new java.awt.Color(255, 255, 255));
        btnAvanzar.setText("Avanzar");
        btnAvanzar.setBorderPainted(false);
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });

        lblPreanalisis.setBackground(new java.awt.Color(255, 255, 255));
        lblPreanalisis.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblPreanalisis.setForeground(new java.awt.Color(255, 255, 255));
        lblPreanalisis.setText("Preanálisis");

        tfPreanalisis.setEditable(false);
        tfPreanalisis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfPreanalisis.setForeground(new java.awt.Color(255, 153, 255));
        tfPreanalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPreanalisisActionPerformed(evt);
            }
        });

        lblLexema1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblLexema1.setForeground(new java.awt.Color(255, 255, 255));
        lblLexema1.setText("Lexema");

        tfLexema.setEditable(false);
        tfLexema.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblLexema2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblLexema2.setForeground(new java.awt.Color(255, 255, 255));
        lblLexema2.setText("Tamaño de fuente:");

        scrollBar.setMinimum(12);
        scrollBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        scrollBar.setToolTipText("");
        scrollBar.setValue(24);
        scrollBar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                scrollBarPropertyChange(evt);
            }
        });
        scrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                scrollBarAdjustmentValueChanged(evt);
            }
        });

        btnOpen.setBackground(new java.awt.Color(77, 120, 204));
        btnOpen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOpen.setForeground(new java.awt.Color(255, 255, 255));
        btnOpen.setText("Open...");
        btnOpen.setBorderPainted(false);
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPreanalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPreanalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfLexema, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLexema2)
                            .addComponent(btnAvanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInit, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLexema1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnOpen)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnInit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnAvanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lblPreanalisis)
                .addGap(18, 18, 18)
                .addComponent(tfPreanalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLexema1)
                .addGap(18, 18, 18)
                .addComponent(tfLexema, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblLexema2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnOpen)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        positionLabel.setBackground(new java.awt.Color(255, 255, 255));
        positionLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        positionLabel.setForeground(new java.awt.Color(255, 255, 255));
        positionLabel.setText("Fila: 1, Columna: 1");

        positionLabel1.setBackground(new java.awt.Color(255, 255, 255));
        positionLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        positionLabel1.setForeground(new java.awt.Color(255, 255, 255));
        positionLabel1.setText("Ancho del tabulador:");

        tabAnchorSelector.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabAnchorSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        tabAnchorSelector.setSelectedIndex(3);
        tabAnchorSelector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tabAnchorSelectorItemStateChanged(evt);
            }
        });
        tabAnchorSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabAnchorSelectorActionPerformed(evt);
            }
        });
        tabAnchorSelector.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabAnchorSelectorPropertyChange(evt);
            }
        });
        tabAnchorSelector.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tabAnchorSelectorVetoableChange(evt);
            }
        });

        TextPane.setBackground(new java.awt.Color(40, 44, 52));
        TextPane.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        TextPane.setForeground(new java.awt.Color(255, 255, 255));
        Border marginBorder = new EmptyBorder(15, 15, 10, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(null, marginBorder);
        TextPane.setBorder(compoundBorder);

        TextPane.addMouseWheelListener(mouseWheelListener);
        TextPane.addKeyListener(keyListener);

        Coloreador.activarColoreado(TextPane);
        jScrollPane2.setViewportView(TextPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(positionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                        .addComponent(positionLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tabAnchorSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(51, 51, 51)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positionLabel)
                    .addComponent(tabAnchorSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionLabel1))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInitClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitClick
        cinta.init(TextPane.getText());
        analex.init();
        analex.resaltar();

        tfPreanalisis.setText("" + analex.Preanalisis());
        tfLexema.setText(analex.lexema());

    }//GEN-LAST:event_btnInitClick


    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        //Cargar un archivo al textArea ("Editor")
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.showOpenDialog(this);
        
        try {
            File f = fileChooser.getSelectedFile();
            if (f == null) {
                return;
            }

            Scanner scn;
            scn = new Scanner(f);
            String s = "";
            while (scn.hasNext()) {
                s += scn.nextLine() + "\n";
            }

            TextPane.setText(s);
            TextPane.setCaretPosition(0);
        } catch (Exception e) {
        };
        openMode = true;
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        analex.avanzar();
        analex.resaltar();

        tfPreanalisis.setText("" + analex.Preanalisis());
        tfLexema.setText(analex.lexema());
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void tfPreanalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPreanalisisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPreanalisisActionPerformed

    private void scrollBarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_scrollBarPropertyChange

    }//GEN-LAST:event_scrollBarPropertyChange

    private void scrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_scrollBarAdjustmentValueChanged
        int size = scrollBar.getValue();
        Font newFont = TextPane.getFont().deriveFont((float) size);
        TextPane.setFont(newFont);
    }//GEN-LAST:event_scrollBarAdjustmentValueChanged

    private void tabAnchorSelectorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabAnchorSelectorPropertyChange

    }//GEN-LAST:event_tabAnchorSelectorPropertyChange

    private void tabAnchorSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabAnchorSelectorActionPerformed

    }//GEN-LAST:event_tabAnchorSelectorActionPerformed

    private void tabAnchorSelectorVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tabAnchorSelectorVetoableChange

    }//GEN-LAST:event_tabAnchorSelectorVetoableChange

    private void tabAnchorSelectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tabAnchorSelectorItemStateChanged


        StyleContext styleContext = StyleContext.getDefaultStyleContext();
        AttributeSet style = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, createTabSet(tabAnchorSelector.getSelectedIndex() + 1)); // Establece el ancho del tabulador en 4 espacios

        StyledDocument doc = TextPane.getStyledDocument();
        doc.setParagraphAttributes(0, doc.getLength(), style, false);

        //TextArea.setTabSize(tabAnchorSelector.getSelectedIndex()+1);  
    }//GEN-LAST:event_tabAnchorSelectorItemStateChanged

    private static TabSet createTabSet(int tabWidth) {
        TabStop[] tabs = new TabStop[10];
        for (int i = 0; i < tabs.length; i++) {
            tabs[i] = new TabStop((i + 1) * tabWidth * 10);
        }
        return new TabSet(tabs);
    }

    private MouseWheelListener mouseWheelListener = new MouseWheelListener() {

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (e.isControlDown()) {
                int clicks = e.getWheelRotation();
                int newSize = TextPane.getFont().getSize() - clicks;
                if (newSize < 12) {
                    newSize = 12;
                }
                Font newFont = TextPane.getFont().deriveFont((float) newSize);
                scrollBar.setValue(newSize);
                TextPane.setFont(newFont);
            } else {
                Component parent = TextPane.getParent();
                if (parent != null) {
                    parent.dispatchEvent(e);
                }
            }
        }
    };

    private KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            updateCursorPosition(TextPane, positionLabel);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            updateCursorPosition(TextPane, positionLabel);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            updateCursorPosition(TextPane, positionLabel);
        }
    };

    private static void updateCursorPosition(JTextPane textPane, JLabel positionLabel) {
        SwingUtilities.invokeLater(() -> {
            int caretPosition = textPane.getCaretPosition();
            int lineNumber = 1;
            int columnNumber = 1;
            try {
                int caretOffset = caretPosition;
                String text = textPane.getText();
                int lineCount = textPane.getDocument().getDefaultRootElement().getElementCount();
                for (int i = 0; i < lineCount; i++) {
                    int lineStartOffset = textPane.getDocument().getDefaultRootElement().getElement(i).getStartOffset();
                    int lineEndOffset = textPane.getDocument().getDefaultRootElement().getElement(i).getEndOffset() - 1;

                    if (caretOffset >= lineStartOffset && caretOffset <= lineEndOffset) {
                        lineNumber = i + 1;
                        columnNumber = caretOffset - lineStartOffset + 1;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            positionLabel.setText("Fila: " + lineNumber + ", Columna: " + columnNumber);
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Interfaz form = new Interfaz();
                form.setTitle("Editor de codigo GRM123");
                form.setLocationRelativeTo(null);  //Centrar el form
                form.setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane TextPane;
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnInit;
    private javax.swing.JButton btnOpen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLexema1;
    private javax.swing.JLabel lblLexema2;
    private javax.swing.JLabel lblPreanalisis;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JLabel positionLabel1;
    private javax.swing.JScrollBar scrollBar;
    private javax.swing.JComboBox<String> tabAnchorSelector;
    private javax.swing.JTextField tfLexema;
    private javax.swing.JTextField tfPreanalisis;
    // End of variables declaration//GEN-END:variables
}
