/*
 * Bei Programmen kann es immer zu Fehlern kommen. Einerseits durch logische Denkfehler (z.B. Array-Index wird zu groß), andererseits
 * durch äußere Ereignisse auf die man keinen Einfluss hat (Usereingaben, Netzwerkfehler, kein Speicherplatz...).
 * <p>
 * Bis jetzt ist unser Programm bei solchen Fehlern meist abgestürzt und der Fehler wurde auf der Kommandzeile ausgegeben.
 * Ab jetzt wollen wir uns aktiv um diese Fehler kümmern (und z.B. das Programm mit einer Fehlermeldung weiterlaufen lassen).
 * <p>
 * Manchmal haben wir Fehler schon behandelt indem wir Methoden z.B. bestimmte Werte im Fehlerfall zurück liefern haben lassen.
 * Das ist erstens nicht immer möglich und macht unseren Code sehr unübersichtlich. Wir wollen den "normalen" Programmablauf
 * und die Behandlung von Fehlern getrennt behandeln. Dabei helfen uns Exceptions.
 * <p>
 * Exceptions sind primär einmal Objekte der Klasse Exception und
 * deren Subklassen (@see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Exception.html">Java API</a>).
 * Sie unterscheiden sich in zwei Kategorien:
 * - „Checked“ Exceptions: Diese MÜSSEN behandelt werden. Alle Objekte der Klasse Exception und ihrer Subklassen mit Ausnahme der Subklasse "RuntimeException" stellen "Checked" Exceptions" dar.
 * - "Unchecked Exceptions": Diese können behandelt werden, müssen aber nicht. Alle Objekte der Klasse "RuntimeException" und ihrer Subklassen stellen "Unchecked Exceptions" dar.
 * <p>
 * <p>
 * Achtung: Die folgenden Beispiele sind künstlich um Exceptions zu verstehen. Wir setzen Exceptions ein, wenn potentiell
 * Fehler auftreten können (Logikfehler, äußere Ereignisse wie Benutzereingaben) und wir diese behandeln wollen. In den Beispielen wissen wir
 * ja bereits beim Programmieren, dass diese Fehler auftreten - in diesen Fällen würden wir natürlich den Code korrigieren, damit die Fehler
 * nicht auftreten.
 */


class Main {
    public static void main(String[] args) {

        UnderstandExceptions1.run(); //try-catch-finally Konstrollstruktur

        UnderstandExceptions2.run(); //Beispiel für "Checked" Exception

        UnderstandExceptions3.run(); //throws Anweisung

        UnderstandExceptions4.run(); //selbst Exception werfen


    }
}