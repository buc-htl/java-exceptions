public class UnderstandExceptions1 {

    public static void run() {
        System.out.println("\n== UnderstandExceptions1 - try/catch/finally Statement ==\n");

        int[] a = new int[3];

      /*
      Eine Exception, der wir wohl alle schon begegnet sind, ist die ArrayIndexOutOfBoundsException (siehe https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/IndexOutOfBoundsException.html). Wie in der Dokumentation ersichtlich leitet sie von RuntimeException ab, sie muss also nicht behandelt werden. Tritt sie auf wird unser Programm sofort beendet und die Exception inkl. Stacktrace ausgegeben. 
      */
        //a[4]=8;   //entferne die Kommentare um es auszuprobieren

      /*
      Ein weiteres Beispiel für eine RuntimeException wäre NumberFormatException (siehe https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/NumberFormatException.html)
      */
        //int zahl = Integer.parseInt("fd4"); //entferne die Kommentare um es auszuprobieren


        /**
         Wollen wir eine Exception nun aktiv behandeln, ist die erste Möglichkeit den Code mit einem try-catch zu umschließen.
         - Der Programmablauf wird sofort unterbrochen, wenn eine Exception auftritt
         - Es wird der nächste passende catch-Block gesucht.
         - Die Programmausführung setzt in diesem catch-Block fort.
         - Nachdem der catch Block abgearbeitet wurde, läuft das Programm einfach weiter.
         - Wird kein passender catch-Block gefunden, wird das Programm (so wie bisher) abgebrochen.
         **/
        try {
            a[0] = 5;
            System.out.println("Innerhalb von try-catch kann beliebiger Code stehen.");
            a[4] = 8;
        } catch (ArrayIndexOutOfBoundsException e) {
            //hier kommen wir nur wenn innerhalb vom try-Block eine ArrayIndexOutOfBoundsException (oder von einer Subklasse davon) aufgetreten ist.
            System.out.println("Oh no, falscher Index: " + e.getMessage());
        }
        System.out.println("Programm läuft weiter, obwohl eine Exception aufgetreten ist. Yippieh.");

        /**
         Ein try-catch  kann mehrere catch Blöcke haben. Bei der ersten Exception wird der try Block sofort beendet und der restliche Code nicht mehr ausgeführt.
         **/
        try {
            a[0] = 5;
            System.out.println("Innerhalb von try-catch kann beliebiger Code stehen.");
            a[4] = 8;
            int zahl = Integer.parseInt("fd4");   //diese Zeile wird nicht ausgeführt, weil die vorherige Zeile bereits eine Exception wirft.
        } catch (ArrayIndexOutOfBoundsException e) {
            //hier kommen wir nur wenn innerhalb vom try-Block eine ArrayIndexOutOfBoundsException aufgetreten ist.
            System.out.println("Fehler...." + e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            //hier kommen wir nur wenn innerhalb vom try-Block eine NumberFormatException aufgetreten ist. In diesem Beispiel ist das aber nicht der Fall, weil eine ArrayIndexOutOfBoundsException zuerst auftritt.
            System.out.println("Error," + e.toString() + " !");
        }

        try {
            a[0] = 5;
            int zahl = Integer.parseInt("fd4");
        } catch (ArrayIndexOutOfBoundsException e) {
            //hier kommen wir nur wenn innerhalb vom try-Block eine ArrayIndexOutOfBoundsException aufgetreten ist.
            System.out.println("Das sollte nicht passieren:" + e.getLocalizedMessage());
        } catch (Exception e) {
            //dieser catch Block ist sehr allgemein, weil er alle Exceptions fängt (alle Exceptions der Klasse "Exceptions" UND alle Subklassen!). Die catch-Blöcke werden der Reihe nach abgearbeitet. Bei einer ArrayIndexOutOfBoundsException würde also der vorherige catch-Block ausgeführt und nicht dieser. Probiere es aus in dem du den Index im try Block änderst!
            System.out.println("Tut uns leid. " + e.toString() + " !");
        }
  
/*
Die Reihenfolge der catch-Blöcke ist wichtig! 

Der untenstehende Code ist nicht gültig, weil der catch-Block für ArrayIndexOutOfBoundsException nie erreicht werden kann. Der allgemeinere catch-Block für Exception fängt auch bereits eine ArrayIndexOutOfBoundsException ab.
*/
/*
 try {
      a[8]=5;
    } catch (Exception  e) {
      System.out.println("Ein Fehler ist aufgetreten: "+e.getLocalizedMessage());
    } catch (ArrayIndexOutOfBoundsException e1) {
      System.out.println("Oh no,"+e1.toString()+" !");
    }
*/

/**
 Neben try und catch kann auch ein finally-Block angegeben werden. Der finally-Block wird IMMER ausgeführt.
 Er wird ausgeführt wenn innerhalb vom try Block keine Exception auftritt.
 Er wird ausgeführt nach einem catch-Block.

 Dient meist zum "Aufräumen".....
 **/
        try {
            a[0] = 5;
            int zahl = Integer.parseInt("4");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Das sollte nicht passieren:" + e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("Tut uns leid. " + e.toString() + " !");
        } finally {
            System.out.println("Der finally-Block wird immer ausgeführt."); //Löse im try-Block eine Exception aus und schaue ob der finally Block noch immer ausgeführt wird!
        }

    }

}