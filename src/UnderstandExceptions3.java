import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Exceptions müssen nicht direkt mit try-catch-finally Statements behandelt werden, sondern
 * können auch an die aufrufende Stelle "weiter geworfen" werden. Das passiert mit "throws" und den Namen
 * der Exception(s).  Dadurch zeigt die Methode an, dass sie eine bestimmte Exception nicht selbst behandelt, sondern diese an die
 * aufrufende Methode weitergibt.
 * <p>
 * Da unchecked Exceptions (alle Subklassen von RuntimeException) nicht behandelt werden müssen, können sie bei "throws" angegeben werden,
 * müssen aber nicht. Checked Exceptions müssen angegeben werden wenn man möchte, dass sie weiter geworfen werden.
 *
 * */
public class UnderstandExceptions3 {


     /**
      * Tritt also in doSomething() eine IOException auf, wird der Code sofort beendet
      * und die Exception ausgelöst. Da eine IOException eine checked Exception ist, muss sie entweder mit einem try-catch Block
      * abgefangen werden oder mit throws an die aufrufende Methode weitergeworfen werden - was hier passiert.
     **/
    private static void doSomething() throws IOException {
        Files.delete(Paths.get("resources/nofile.xy"));
    }

    /**
     * Es können auch mehrere Exceptions weiter gegeben werden. Die Exceptions werden durch Beistriche getrennt.
     * IndexOutOfBounds ist dabei eine unchecked Exception und kann daher, muss aber nicht, behandelt werden.
     * Man kann sich die Angabe bei throws also auch sparen.
     **/
    private static void doSomethingElse() throws IOException, IndexOutOfBoundsException {
        String[] words = new String[]{"3", "7", "5"};
        int[] numbers = new int[words.length];

        Files.delete(Paths.get("resources/nofile.xy"));
    }


    public static void run() {
        System.out.println("\n== UnderstandExceptions3 - throws Statement ==\n");
        //doSomething() kann eine ArrayIndexOutOfBoundsException "weiter werfen". Wir fangen sie an dieser Stelle mit einem try-catch Block. Alternativ könnte die run()-Methode ebenfalls die Exception weiter werfen.
        try {
            doSomething();
            doSomethingElse();
        } catch (IOException e) {
            System.out.println("FEHLER! " + e.getLocalizedMessage());
        }

        /**
         In der Java API Dokumentation sehen wir bei jeder Methode auch, welche Exceptions diese Methoden werfen.
         Wirf zum Beispiel einen Blick auf die substring()-Methode der Klasse String (https://docs.oracle.com/javase/9/docs/api/java/lang/String.html). Unter "throws" siehst du das diese Methode eine IndexOutOfBoundsException werfen kann.
         **/
        try {
            String s = "Semmel";
            String sub = s.substring(0, 10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Fehler beim Erzeugen des Substrings.");
        }


    }

}