package analex;

public class Analex {
    private Cinta M;
    private Token R;
    private String ac;
    private int pos;        //Posición de inicio del lexema del preanalisis(), calculado en el dt(). 
                            //Use Cinta.getPos() o sea pos=M.getPos();
    
    public Analex(Cinta c) {
        M = c;
        R = new Token();
        init();
    }
     
    public final void init() {
        M.init();
        avanzar();      //Calcular el primer preanalisis.
    }
    
    public Token Preanalisis() {
        return R;
    }
    
    public String lexema() {
        return ac;
    }
    
    public void avanzar(){
       dt();
    }
    
    private void dt() {
       int estado = 0;
       ac = "";
       //System.out.println("\n\n----Nueva llama al dt---- \n\n");
       while (true) {
            //System.out.println("---------------");
            //System.out.println("Estado: = " + estado);
            char cc = M.cc();
            int cn = cc;
            //System.out.println("cc = " + cc + "(" + cn + ")");
            //System.out.println("ac = " + ac);
           // System.out.println("pos = " + pos);
            //System.out.println("la cinta esta mirando: " + M.getPos());
            switch (estado) {
                case 0:   
                    if (cc == Cinta.EOF) {estado=1; continue;}
                    pos = M.getPos();
                    M.avanzar();
                    if (espacio(cc)) {estado = 0; continue;}
                    ac += cc;  
                    if (letra(cc)) estado=3;
                    else if (cc == ',') estado = 5;
                    else if (cc == ';') estado = 6;
                    else if (cc == ':') estado = 7;
                    else if (cc == '(') estado = 10;
                    else if (cc == ')') estado = 11;
                    else if (cc == '+') estado = 12;
                    else if (cc == '-') estado = 15;
                    else if (cc == '>') estado = 18;
                    else if (cc == '<') estado = 21;
                    else if (cc == '!') estado = 24;
                    else if (cc == '/') estado = 27;
                    else if (cc == '"') estado = 33;
                    else if (digito(cc))estado = 32;
                    else if (cc == '|') estado = 36;
                    else if (cc == '%') estado = 37;
                    else if (cc == '}') estado = 38;
                    else if (cc == '{') estado = 39;
                    else if (cc == '*') estado = 40;
                    else if (cc == '&') estado = 41;
                    else if (cc == '=') estado = 42;
                    else estado = 2;
                    break;
                case 1:
                    R.set(Token.FIN, 0);
                    return;
                case 2:
                    R.set(Token.ERROR, 0);
                    return;
                case 3:
                    if (letra(cc) || digito(cc)) {ac += cc; M.avanzar();}
                    else estado = 4;
                    break;
                case 4:
                    if (Token.keywords.containsKey(ac)) {
                        if (Token.keywords.get(ac) < 0) {
                            R.set(Token.TIPO, Token.keywords.get(ac));
                        }
                        else R.set(Token.keywords.get(ac), 0);
                    } else R.set(Token.ID, -1);           
                    return;
                case 5:
                    R.set(Token.COMA, 0);
                    return;
                case 6:
                    R.set(Token.PTOCOMA, 0);
                    return;
                case 7:
                    if (cc == '=') {M.avanzar(); estado=9; ac+=cc;}
                    else estado = 8;
                    break;
                case 8:
                    R.set(Token.DOSPUNTOS, 0);
                    return;
                case 9:
                    R.set(Token.ASSIGN, 0);
                    return;
                case 10:
                    R.set(Token.PA, 0);
                    return;          
                case 11:
                    R.set(Token.PC, 0);
                    return;
                case 12:
                    if (cc == '+') {M.avanzar(); estado=13; ac+= cc;}
                    else estado = 14;
                    break;
                case 13:
                    R.set(Token.INC, 0);
                    return;
                case 14:
                    R.set(Token.MAS, 0);
                    return;
                case 15:
                    if (cc == '-') {M.avanzar(); estado=16; ac+=cc;}
                    else estado = 17;
                    break;
                case 16:
                    R.set(Token.DEC, 0);
                    return;
                case 17:
                    R.set(Token.MENOS, 0);
                    return;
                case 18:
                    if (cc == '=') {M.avanzar(); estado=19; ac+=cc;}
                    else estado = 20;
                    break;
                case 19:
                    R.set(Token.OPREL, Token.MAI);
                    return;
                case 20:
                    R.set(Token.OPREL, Token.MAY);
                    return;                 
                case 21:
                    if (cc == '=') {M.avanzar(); estado=23; ac+=cc;}
                    else estado = 22;
                    break;                    
                case 22:
                    R.set(Token.OPREL, Token.MEN);
                    return;
                case 23:
                    R.set(Token.OPREL, Token.MEI);
                    return;
                case 24:
                    if (cc == '=') {M.avanzar(); estado=26; ac+=cc;}
                    else estado = 25;
                    break;                     
                case 25:
                    R.set(Token.NOT, 0);
                    return;
                case 26:
                    R.set(Token.OPREL, Token.DIS);
                    return;
                case 27:
                    if (cc == '*') {M.avanzar(); estado = 30; ac = "";}
                    else if (cc == '/') {M.avanzar(); estado = 29; ac = "";}
                    else estado = 28;
                    break;
                case 28:
                    R.set(Token.DIV, 0);
                    return;
                case 29:
                    System.out.println("cc = " + cc);
                    if (cc != Cinta.EOLN && cc != Cinta.EOF) M.avanzar();
                    else estado = 0;
                    break;
                case 30:
                    if (cc != '*' && cc != Cinta.EOF) M.avanzar();
                    else if (cc == '*') {M.avanzar(); estado=31;}
                    else estado = 2;
                    break;                    
                case 31:
                    if (cc == '/') {M.avanzar(); estado=0;}
                    else estado = 30;
                    break;
                case 32:
                    if (digito(cc)) {ac+=cc; M.avanzar();}
                    else estado=34;
                    break;
                case 33:
                    if (cc != '"' && cc != Cinta.EOLN && cc != Cinta.EOF) {M.avanzar(); ac+=cc;}
                    else if (cc == '"') {estado=35; M.avanzar(); ac+=cc;}
                    else estado = 2;
                    break;
                case 34:
                    R.set(Token.NUM, Integer.parseInt(ac));
                    return;
                case 35:
                    R.set(Token.STRINGctte, 0);
                    return;
                case 36:
                    R.set(Token.OR, 0);
                    return;
                case 37:
                    R.set(Token.MOD, 0);
                    return;
                case 38:
                    R.set(Token.LC, 0);
                    return;
                case 39:
                    R.set(Token.LA, 0);
                    return;
                case 40:
                    R.set(Token.POR, 0);
                    return;
                case 41:
                    R.set(Token.AND, 0);
                    return;
                case 42:
                    R.set(Token.OPREL, Token.IGUAL);
                    return;     
            }
       }
    }
    
    public void resaltar() {    //Para resaltar el lexema del Preanalisis en el progFuente.
        comunicate(pos, lexema());
    }
    
    public void comunicate(int pos, String lexema) { //Overridable. Para la Interfaz.
        
    }
    
    //definiciones regulares 
    private boolean digito(char cc) {
        if (cc >= '0' && cc <= '9')
            return true;
        return false;
    }
    
    private boolean letra(char cc) {
        if ((cc >= 'A' && cc <= 'Z') || (cc >= 'a' && cc <= 'z'))
            return true;
        return false;
    }
    
    private boolean espacio(char cc) {
        if (cc == Cinta.EOLN || cc == Cinta.TAB || cc == Cinta.espacio)
            return true;
        return false;
    }    
}
