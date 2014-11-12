//import java.util.Random;
import java.util.Vector;

public class exObjects {

 static int DifNum = 10;
 static int Total = 20;

 public static void main(String args[]) {
   Vector vec;
   int i;

   System.out.println("Inicio");
   vec = preenche();
   Imprime( vec );
   System.out.println("Fim"); 
  }


  public static Vector preenche () {
    int i,j,T=Total,op;
    java.util.Random r = new java.util.Random(DifNum);
    String [] msg = {"insere","remove"};
    Vector v = new Vector();


    for (i=0; i<Total; i++) {
        Object g;
        op = 0;
        g = new Integer( java.lang.Math.abs( r.nextInt() )%100 );
        v.addElement(g); // insere elemento no Vector
        }

      //System.out.println("Operacao: "+msg[op]+" Elemento: "+g);
      return v;
  }

  private static void Imprime(Vector vec) {
    int i;
    if (vec.isEmpty()) {
       System.out.println("Vector vazio");
       return;
       }
    else
       System.out.println("#Vector="+vec.size());
    for (i=0; i<vec.size(); i++)
        System.out.print(vec.elementAt(i) + " - ");
    System.out.println();
    }
}
