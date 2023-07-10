/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import analex.Token;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Samsung
 */
public class Coloreador {
    
    private static final Pattern regexKeyWords = Pattern.compile("void|for|while|repeat|do|begin|end|if|else|to|not|and|or|mod|div|return|var|until");
    private static final Pattern tiposDeDato = Pattern.compile("int|string|boolean");
    private static final Pattern idDeFuncion = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*\\(");
    private static  final Pattern valoresNumBool = Pattern.compile("\\d\\d*|true|false");                                                                   //por modificar                                                                                                         
    private static final Pattern noKeywords = Pattern.compile("\\b(?!void|for|while|repeat|do|begin|end|if|else|to|not|and|or|mod|var|div|int|until|\\d\\d*|[a-zA-Z]\\w*\\(|string|boolean|return|true|false)\\w+\\b|[|,&*:;(){}%!/=<>+-]");
    private static final Pattern comentarioLinea = Pattern.compile("\\/\\/[^\\n]*$", Pattern.MULTILINE);
    private static final Pattern cometarioMultilinea = Pattern.compile("\\/\\*(?:.|\\n)*?(?:\\*\\/|$)|\\/\\/.*$");
    private static final Pattern stringCtte = Pattern.compile("\"[^\"]*\"");
    private static final Pattern id = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*");
    
    private static void checkForHighlights(JTextPane TextPane) {
        Runnable checker = new Runnable() {
            @Override
            public void run() {
                Matcher keywordMatch;
                Matcher noKeywordMatch;
                Matcher valoresNumBoolMatch;
                Matcher stringCtteMatch;
                Matcher tiposDeDatoMatch;
                Matcher idDeFuncionMatch;
                Matcher comentarioLineaMatch;
                Matcher cometarioMultilineaMatch;
                Matcher idMatch;
                try {
                    keywordMatch = regexKeyWords.matcher(TextPane.getDocument().getText(0, TextPane.getDocument().getLength()));
                    noKeywordMatch = noKeywords.matcher(TextPane.getDocument().getText(0, TextPane.getDocument().getLength()));
                    valoresNumBoolMatch = valoresNumBool.matcher(TextPane.getDocument().getText(0, TextPane.getDocument().getLength()));
                    stringCtteMatch = stringCtte.matcher(TextPane.getDocument().getText(0, TextPane.getDocument().getLength()));
                    tiposDeDatoMatch = tiposDeDato.matcher(TextPane.getDocument().getText(0, TextPane.getDocument().getLength()));
                    idDeFuncionMatch = idDeFuncion.matcher(TextPane.getDocument().getText(0, TextPane.getDocument().getLength()));
                    comentarioLineaMatch = comentarioLinea.matcher(TextPane.getDocument().getText(0, TextPane.getDocument().getLength()));
                    cometarioMultilineaMatch = cometarioMultilinea.matcher(TextPane.getDocument().getText(0, TextPane.getDocument().getLength()));
                    idMatch = id.matcher(TextPane.getDocument().getText(0, TextPane.getDocument().getLength()));
                    
                    
                    StyleContext style = StyleContext.getDefaultStyleContext();
                    
                    
                    AttributeSet white = style.addAttribute(style.getEmptySet(), StyleConstants.Foreground, Color.white);
                    AttributeSet pink = style.addAttribute(style.getEmptySet(), StyleConstants.Foreground, new Color(198, 120, 221));
                    AttributeSet orange = style.addAttribute(style.getEmptySet(), StyleConstants.Foreground, new Color(209, 153, 100));
                    AttributeSet green = style.addAttribute(style.getEmptySet(), StyleConstants.Foreground, new Color(152, 195, 121));
                    AttributeSet yellow = style.addAttribute(style.getEmptySet(), StyleConstants.Foreground, new Color(229, 192, 123));
                    AttributeSet lightblue = style.addAttribute(style.getEmptySet(), StyleConstants.Foreground, new Color(97, 175, 239));
                    AttributeSet gray = style.addAttribute(style.getEmptySet(), StyleConstants.Foreground, new Color(92, 99, 112));
                    TextPane.getStyledDocument().setCharacterAttributes(TextPane.getDocument().getLength(), TextPane.getDocument().getLength(), style.getEmptySet(), true);
                    
                    while (keywordMatch.find()) {
                        TextPane.getStyledDocument().setCharacterAttributes(keywordMatch.start(), keywordMatch.end() - keywordMatch.start(), pink, false);
                    }
                    
                    while (tiposDeDatoMatch.find()) {
                        TextPane.getStyledDocument().setCharacterAttributes(tiposDeDatoMatch.start(), tiposDeDatoMatch.end() - tiposDeDatoMatch.start(), yellow, false);
                    }  
                    
                    while (valoresNumBoolMatch.find()) {
                        TextPane.getStyledDocument().setCharacterAttributes(valoresNumBoolMatch.start(), valoresNumBoolMatch.end() - valoresNumBoolMatch.start(), orange, false);
                    }    
                    
                    while (idMatch.find()) {
                        int ini = idMatch.start();
                        int end = idMatch.end() - idMatch.start();
                        String str = TextPane.getText(ini, end);
                        if (!Token.keywords.containsKey(str))
                            TextPane.getStyledDocument().setCharacterAttributes(idMatch.start(), idMatch.end() - idMatch.start(), white, false);
                    }
                    
                    while (idDeFuncionMatch.find()) {
                        int ini = idDeFuncionMatch.start();
                        int end = idDeFuncionMatch.end() - idDeFuncionMatch.start();
                        String str = TextPane.getText(ini, end-1);            
                        if ("main".equals(str) || "readln".equals(str) || "print".equals(str) || "println".equals(str) || !Token.keywords.containsKey(str)) {
                             TextPane.getStyledDocument().setCharacterAttributes(idDeFuncionMatch.start(), idDeFuncionMatch.end() - idDeFuncionMatch.start(), lightblue, false);
                        }                          
                    }
                                                                          
                    while (noKeywordMatch.find()) {
                         TextPane.getStyledDocument().setCharacterAttributes(noKeywordMatch.start(), noKeywordMatch.end() - noKeywordMatch.start(), white, false);
                    }
                
                    while (stringCtteMatch.find()) {
                        TextPane.getStyledDocument().setCharacterAttributes(stringCtteMatch.start(), stringCtteMatch.end() - stringCtteMatch.start(), green, false);
                    }       
                    
                    while (comentarioLineaMatch.find()) {
                        TextPane.getStyledDocument().setCharacterAttributes(comentarioLineaMatch.start(), comentarioLineaMatch.end() - comentarioLineaMatch.start(), gray, false);
                    }      
                    
                    while (cometarioMultilineaMatch.find()) {
                        TextPane.getStyledDocument().setCharacterAttributes(cometarioMultilineaMatch.start(), cometarioMultilineaMatch.end() - cometarioMultilineaMatch.start(), gray, false);
                    }
                    
                    
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        };
        SwingUtilities.invokeLater(checker);
    }
    
    public static void activarColoreado(JTextPane TextPane) {
    TextPane.getDocument().addDocumentListener(new DocumentListener() 
        {
            @Override
            public void changedUpdate(DocumentEvent event) {
            }

            @Override
            public void insertUpdate(DocumentEvent event)
            {
                checkForHighlights(TextPane);
            }

            @Override
            public void removeUpdate(DocumentEvent event)
            {
                checkForHighlights(TextPane);
            }
        });
    
    }

}
