public class UnderstandExceptions4 {

    public static double calculateTotalAmount(int amount, double price) throws IllegalArgumentException {
        if (amount < 0 || price < 0) {
            /**
             Mit dem Schlüsselwort throw (vergleiche throws mit "s" im Methodenkopf!!) wirft man eine Exception. In diesem Beispiel wollen wir
             eine IllegalArgumentException werfen wenn einer der Parameter negativ ist
             (https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/IllegalArgumentException.html).

             Schau dir die JavaDoc der Klasse an. Welche Konstruktoren hat diese Klasse noch?
             **/
            throw new IllegalArgumentException();
        }

        return amount * price;
    }

    /**
     * Beispiel für eine eigene Exception. @see IncorrectExerciseNameException für mehr Details.
     * Eigene Exceptions können wie jede Standard Java Exception verwendet werden.
     **/
    public static void printExerciseName(String name) throws IncorrectExerciseNameException {
        if (!name.startsWith("UE")) {
            throw new IncorrectExerciseNameException(name + " startet nicht mit \"UE\".");
        }
        System.out.println("Die Übung lautet " + name);
    }

    public static void run() {
        System.out.println("\n== UnderstandExceptions4 - Exceptions werfen ==\n");

        try {
            calculateTotalAmount(2, -3.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Methode calculateTotalAmount mit ungültigen Argumenten aufgerufen. ");
        }

        try {
            printExerciseName("UE05-Vererbung");
            printExerciseName("Polymorphie");
        } catch (IncorrectExerciseNameException e) {
            System.out.println(e.getMessage());
        }

    }

}