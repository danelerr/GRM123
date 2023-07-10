
package analex;

import java.util.HashMap;
import java.util.Map;

public class Token {
        //Para el NOMBRE del token. No modifique estos valores.
    public static final int FIN        = 0;
    public static final int ERROR      = 1;
    public static final int MAIN       = 2;
    public static final int VOID       = 3;
    public static final int IF         = 4;
    public static final int ELSE       = 5;
    public static final int FOR        = 6;
    public static final int TO         = 7;    
    public static final int WHILE      = 8;
    public static final int REPEAT     = 9;
    public static final int UNTIL      = 10;
    public static final int READLN     = 11;
    public static final int PRINT      = 12;
    public static final int PRINTLN    = 13;
    public static final int COMA       = 14;
    public static final int PTOCOMA    = 15;
    public static final int DOSPUNTOS  = 16;    //":"
    public static final int PA         = 17;    //"("
    public static final int PC         = 18;    //")"
    public static final int LA         = 19;    //"{"
    public static final int LC         = 20;    //"}"
    public static final int ASSIGN     = 21;    //":="
    public static final int NOT        = 22;    //"!" y "not"
    public static final int AND        = 23;    //"&" y "and"   
    public static final int OR         = 24;    //"|" y "or"
    public static final int FALSE      = 25;
    public static final int TRUE       = 26;    
    public static final int MAS        = 27;
    public static final int MENOS      = 28;
    public static final int POR        = 29;
    public static final int MOD        = 30;
    public static final int DIV        = 31;
    public static final int INC        = 32;    //"++"
    public static final int DEC        = 33;    //"--"
    public static final int RETURN     = 34;
    public static final int NUM        = 35;
    public static final int ID         = 36;
    public static final int STRINGctte = 37;
    public static final int OPREL      = 38;
    public static final int TIPO       = 39;
    
        //Atributos del token OPREL
    public static final int IGUAL = 0;  //"="
    public static final int MEN   = 1;
    public static final int MAY   = 2;
    public static final int MEI   = 3;
    public static final int MAI   = 4;
    public static final int DIS   = 5;  //"!="
    
        //Atributos del token TIPO
    public static final int STRING=-4, BOOLEAN = -3, INT=-2;
          
     //Campos de la class
    private int nom, atr;   //<nom, atr>
    
    public Token(){
       this(FIN); 
    }
    
    public Token(int nombre){
        this(nombre, 0);
    }
    
    public Token(int nombre, int atributo){
        nom = nombre;   atr=atributo;
    }

    
    public void set(int nombre, int atributo){
        nom = nombre;   atr=atributo;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    public void setAtr(int atr) {
        this.atr = atr;
    }

    public int getNom() {
        return nom;
    }

    public int getAtr() {
        return atr;
    }
    
 
//---------- 
    @Override
    public String toString(){
        return "<" + get(NOMtokenSTR, nom) + "," + atrToString(nom) + ">";
    }
       
    private String atrToString(int nom){   //Corrutina de toString()
        if (FIN <= nom && nom <=RETURN)
            return "_";
        
        if (nom == OPREL)
            return get(OPRELstr, atr);
        
        if (nom == TIPO)
            return get(TIPOstr, atr-STRING);
        
        return ""+atr;
    }

    private String get(String v[], int i){
        try {
            return v[i]; 
        } catch (Exception e) {
            return DESCONOCIDO;
        }
    }
    
    
    private static final String DESCONOCIDO = "??";
    
    private static final String OPRELstr[]={"IGUAL", "MEN", "MAY", "MEI", "MAI", "DIS"};
    private static final String TIPOstr[] ={"STRING", "BOOLEAN", "INT"};
    
    private static final String NOMtokenSTR[] ={
       "FIN", "ERROR", "MAIN", "VOID", "IF", "ELSE", "FOR", "TO", "WHILE",
       "REPEAT", "UNTIL", "READLN", "PRINT", "PRINTLN", 
       "COMA", "PTOCOMA", "DOSPUNTOS", "PA", "PC", "LA", "LC","ASSIGN",
       "NOT", "AND", "OR", "FALSE", "TRUE",
       "MAS", "MENOS", "POR", "MOD", "DIV","INC","DEC",
       "RETURN",
       "NUM", "ID", "STRINGctte", "OPREL", "TIPO"
    };  
    
    
    //Para las keywords
    public static final Map<String, Integer> keywords = new HashMap<String, Integer>() {
        {
            put("main", MAIN);
            put("void", VOID);
            put("if", IF);
            put("else", ELSE);
            put("for", FOR);
            put("to", TO);
            put("while", WHILE);
            put("repeat", REPEAT);
            put("until", UNTIL);
            put("readln", READLN);
            put("print", PRINT);
            put("println", PRINTLN);
            put("not", NOT);
            put("and", AND);
            put("or", OR);
            put("false", FALSE);
            put("true", TRUE);
            put("mod", MOD);
            put("div", DIV);
            put("return", RETURN);
            put("string", STRING);
            put("boolean", BOOLEAN);
            put("int", INT);
        }
    };
    
    
}