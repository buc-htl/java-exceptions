/*
Java Exceptions decken fast alle generellen Ausnahmen ab, die beim Programmieren auftreten. 

Es gibt aber Fälle, in denen man als Programmierer*in eigene Exceptions erzeugen möchte. 
Die Hauptgründe sind:
- Fehler, die sehr spezifisch für den Anwendungsfall des Programms sind. Eigene Exceptions helfen hier besser zu verstehen welches Problem genau aufgetreten ist.
- Eine spezielle Behandlung für eine Teilgruppe einer Java Exception. Ein eigene Exception kann ich in einer catch-Anweisung fangen und speziell behandeln.

Um eine eigene Exception zu erzeugen, benötige ich eine Klasse, die von der Klasse Exception oder einer beliebigen Subklasse ableitet.
Für "Unchecked Exceptions", wie in diesem Beispiel, leitet man von der Klasse RuntimeException ab.

Dann benötige ich mindestens noch einen Konstruktor und die eigene Exception ist fertig!

*/
public class IncorrectExerciseNameException extends RuntimeException {

    public IncorrectExerciseNameException(String message) {
        super(message);
    }


}
