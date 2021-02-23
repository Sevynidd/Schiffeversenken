# Schiffeversenken

- [Hinweis wegen verschachtelten Ordnern](#Hinweis-wegen-verschachtelten-Ordnern)
  - [Wie funktioniert das?](#Wie-funktioniert-das-?)

Die beigelieferte [FlatLaf.jar](https://search.maven.org/artifact/com.formdev/flatlaf/1.0-rc3/jar) muss als Classpath integriert werden.

### Zugehöriger Codeabschnitt
``` Java 
try {
  UIManager.setLookAndFeel(new FlatLightLaf());
} catch (Exception ex) {
  System.err.println("Failed to initialize LaF");
}
```

![Spieler](https://github.com/Sevynidd/Schiffeversenken/blob/main/Spieler.png)
![Gegner](https://github.com/Sevynidd/Schiffeversenken/blob/main/Gegner.png)

## Hinweis wegen verschachtelten Ordnern

Dadurch, dass ich mehrere Ordner für eine bessere Struktur verschachtelt habe, muss man in Eclipse erst die `Package Presentation` von `Flat` zu `Hierarchical` umstellen

### Wie funktioniert das?

1. Oben rechts auf den kleinen Pfeil im `Package Explorer` klicken
2. `Package Presentation`
3. `Hierarchical`

![Hinweis](https://github.com/Sevynidd/Schiffeversenken/blob/main/Hinweis.png)
