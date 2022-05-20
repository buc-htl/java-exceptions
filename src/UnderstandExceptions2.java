import java.net.*;

public class UnderstandExceptions2 {

    public static void run() {
        System.out.println("\n== UnderstandExceptions2 - \"Checked\" Exceptions ==\n");
        /**
         Der folgende Code (den du nicht verstehen musst) wirft möglicherweise eine
         MalformedURLException (siehe https://docs.oracle.com/javase/9/docs/api/java/net/MalformedURLException.html).
         Da diese Klasse nicht von RuntimeException ableitet, handelt es sich um eine "checked" Exception, die
         behandelt werden muss.

         Entferne die Kommentare und du wirst sehen, dass der Code nicht mehr läuft.
         **/
        //String urlString = "http://htl.rennweg.at";
        //URL url = new URL(urlString);

        /**
         Die mögliche Exception wird mit einem try-catch behandelt und der Code ist lauffähig.
         **/
        try {
            String urlString = "http://htl.rennweg.at";
            URL url = new URL(urlString);
        } catch (MalformedURLException ex) {
            System.out.println("Ungültige URL!");
        }

        /**
         Der folgende Code löst die Exception auch aus.
         **/
        try {
            String urlString = "htt://htl.rennweg.at";
            URL url = new URL(urlString);
        } catch (MalformedURLException ex) {
            System.out.println("Ungültige URL!");
        }


    }

}