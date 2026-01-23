# Lernperiode 8 - Programming Technology

**Zeitraum:** 09.01.2026 – 13.02.2026  
**Technologie:** Kotlin  

---

## Ausgangslage und Zielsetzung

In der Lernperiode 8 besteht das Ziel darin, sich selbstständig in eine neue, frei gewählte Technologie einzuarbeiten. Der Fokus liegt dabei nicht nur auf dem Ergebnis, sondern insbesondere auf dem **Lernprozess**, der Dokumentation sowie der Reflexion des eigenen Vorgehens.

Der empfohlene Ablauf umfasst:
- eine erste Einführung (Hello World),
- das Nachvollziehen eines Tutorials,
- eigene Anpassungen,
- sowie die strukturierte Dokumentation im `README.md`.

---

## Beschreibung der Technologie

Kotlin ist eine moderne, statisch typisierte Programmiersprache, die von **JetBrains** entwickelt wurde. Sie läuft auf der **Java Virtual Machine (JVM)** und ist vollständig interoperabel mit Java. Das bedeutet, dass Kotlin problemlos mit bestehenden Java-Bibliotheken und -Projekten zusammenarbeiten kann.

Die Sprache legt besonderen Wert auf:
- gute Lesbarkeit,
- weniger Boilerplate-Code,
- sowie erhöhte Sicherheit durch integrierte Null-Safety.

Kotlin wird unter anderem in der Android-Entwicklung, im Backend-Bereich und zunehmend auch im Modding-Umfeld eingesetzt.

---

## Begründung der Technologienwahl

Ich habe mich für Kotlin entschieden, da ich einen Einstieg in das **Minecraft-Modding** anstrebe. Minecraft selbst ist in Java programmiert, weshalb Kotlin als moderne und kompatible JVM-Sprache besonders geeignet ist.

Im **Fabric-Modding-Umfeld** wird Kotlin aktiv unterstützt, beispielsweise durch *Fabric Language Kotlin*. Kotlin ermöglicht eine übersichtlichere Code-Struktur und erleichtert das Arbeiten an grösseren Projekten, was für Mod-Entwicklung von Vorteil ist.

---

## Lernziele

- Grundlegende Syntax von Kotlin verstehen  
- Unterschiede zwischen Kotlin und Java kennenlernen  
- Objektorientierte Konzepte anwenden  
- Vorbereitung auf einfache Minecraft-Modding-Projekte  

---

## Arbeitsjournal

### Sitzung 1 – Freitag, 09.01.2026
**Arbeitspakete:**
- [X] **Hello World:** Ein einfaches „Hello World“-Programm in Kotlin schreiben, um die Entwicklungsumgebung zu testen.
- [X] **Variablen und Datentypen:** Verschiedene Variablen (`val`/`var`) und Datentypen erstellen, einfache Rechenoperationen durchführen und Ergebnisse auf der Konsole ausgeben.
- [X] **Bedingungen und Schleifen:** Ein kleines Programm schreiben, das `if`/`when` und `for`/`while` verwendet, um Entscheidungen zu treffen und Wiederholungen zu demonstrieren.
- [X] **Funktionen und Klassen:** Eine kleine Klasse mit Methoden für einfache Berechnungen erstellen, Kotlin-spezifische Features wie Null-Safety und Standardparameter verwenden.


**Lernbericht:**

Heute habe ich die Grundlagen von **Kotlin** praktisch geübt.  
Ich habe ein erstes „Hello World“-Programm erstellt und mit **Variablen, Datentypen und Operatoren** gearbeitet, darunter `Int` und `Char`.  
Anschliessend habe ich **Schleifen** (`while` und `for`) getestet, Bedingungen mit `if` und `when` implementiert und mit Arrays gearbeitet.  
Aussserdem habe ich einfache **Benutzereingaben** verarbeitet, z. B. um einen Wochentag auszuwählen oder Werte für einen Taschenrechner einzugeben.  
Zum Schluss habe ich eine **Calculator-Klasse** geschrieben, die zwei Zahlen mit einem Operator verarbeitet und das Ergebnis ausgibt, einschliesslich einer Prüfung auf ungültige Operatoren oder Division durch null.  
Durch diese Arbeit konnte ich die **Kotlin-Syntax, Kontrollstrukturen, Benutzerinteraktionen und einfache Klassen** praktisch anwenden.

---

### Sitzung 2 - Freitag, 16.01.2026

**Arbeitspakete:**

- [X] **Funktionen & Parameter:** Mehrere eigene Funktionen in Kotlin schreiben, die einfache Aufgaben übernehmen (z. B. Rechenoperationen, Überprüfen von Bedingungen, Rückgabe von Werten). Dabei Parameterübergabe, Rückgabewerte und Standardparameter anwenden und testen.
- [X] **Collections & Schleifen:** Mit grundlegenden Collections wie `List`, `Array`, `Set` und `Map` arbeiten. Schleifen (`for`, `while`) verwenden, um über Collections zu iterieren. Einfache Aufgaben wie Filtern von Werten, Summenberechnung oder Durchschnittsberechnung umsetzen.
- [X] **Exception Handling & Benutzerinteraktionen:** Benutzereingaben über die Konsole einlesen und auf gültige Werte prüfen. Fehler mithilfe von `try/catch` abfangen (z. B. ungültige Zahlen oder Division durch null) und Programme stabil gestalten.
- [X] **Klassen & Objekte erweitern:** Eine eigene Klasse (z. B. `BankAccount`, `Player` oder `Calculator`) mit mehreren Eigenschaften und Methoden erstellen. Konstruktoren, Methoden und Objekt-Erstellung in `main()` üben und testen.

**Lernbericht:**

Heute habe ich mein Kotlin-Projekt in mehreren Schritten weiterentwickelt.  
Zunächst habe ich mit **Funktionen, Arrays und Maps** experimentiert, um den Umgang mit grundlegenden Sprachkonstrukten und Collections in Kotlin zu vertiefen.
Darauf aufbauend habe ich eine eigene **ShoppingList-Klasse** implementiert, mit der Produkte, Mengen und Preise strukturiert verwaltet werden können. Dabei habe ich objektorientierte Konzepte wie Klassen, Eigenschaften und Methoden praktisch angewendet.
Zum Abschluss habe ich die **Code-Struktur sowie das CLI-Design überarbeitet**, um die Anwendung übersichtlicher und benutzerfreundlicher zu gestalten. Die Navigation wurde verbessert und der Code klarer organisiert.
Die Entwicklung erfolgte schrittweise und wurde mit **Git versioniert**, sodass die einzelnen Lern- und Entwicklungsschritte über die Commit-History nachvollziehbar sind.  
Durch diese Arbeit konnte ich meine Kenntnisse in **Funktionen, Datenstrukturen, objektorientierter Programmierung und sauberem Code-Design in Kotlin** weiter vertiefen.

---

### Sitzung 3 - Freitag, 23.01.2026

**Arbeitspakete:**

- [ ] **Kotlin-Tutorial durcharbeiten:** Ein von Fred AI erstelltes Kotlin-Tutorial durcharbeiten, um die bisherigen Grundlagen zu festigen und neue Konzepte kennenzulernen.
- [ ] **Aufgaben selbstständig umsetzen:** Die im Tutorial enthaltenen Aufgaben eigenständig in Kotlin lösen und testen.
- [ ] **Objektorientierte Konzepte vertiefen:** Den Einsatz von Klassen, Datenklassen und Methoden anhand praktischer Beispiele weiter üben.
- [ ] **Projekt erweitern:** Die im Tutorial gelernten Konzepte durch eigene Anpassungen oder neue Funktionen im bestehenden Projekt anwenden.

>**Hinweis:**  
>Das Tutorial wird mithilfe von **Fred AI** erstellt. Fred AI ist ein von mir entwickelter AI-Tutor, basierend auf **qwen2.5:32b-instruct**, und wird ausschliesslich als **Lernhilfe** eingesetzt (z. B. zur Erklärung von Konzepten und zur >Erstellung von Übungsaufgaben). Die Aufgaben werden selbstständig gelöst; Fred AI dient nicht zur direkten Lösung der Aufgaben.

**Lernbericht:**

Heute habe ich mein Kotlin-Projekt weiterentwickelt und neue Konzepte praktisch angewendet.  
Ich habe mit **Klassen, Datenklassen und Enums** gearbeitet und den Code so umgebaut, dass **Logik und Benutzereingaben** klar getrennt sind.  
Ausserdem habe ich **Extension Functions**, **Lambdas** und einfache **Collection-Funktionen** genutzt, um den Code übersichtlicher zu gestalten.

Zum Testen neuer Funktionen habe ich ein separates **TutorialPlayground-File** verwendet.  
Dadurch konnte ich meine Kenntnisse in **Kotlin und objektorientierter Programmierung** weiter vertiefen.
