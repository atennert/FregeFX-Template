# FregeFX-Template

## What is this template for?
This is a template for starting a FregeFX project. There are already a few of those, for instance thanks to @Dierk. What is different about this one?

So far, all FregeFX projects which I've found make use of declaring the UI by creating the UI elements in the Frege code, which is similar to creating the UI by writing Java. JavaFX, however, also allows to create the UI in the XML dialect FXML. FregeFX already has the methods to use FXML, thankfully. But trying to do, what I usually do with JavaFX (for instance linking a controller for the UI inside FXML), I stumbled over quite a few issues.

Now, this template makes use of FXML to generate a UI. It also uses a controller instance to react to user input and executes Frege code when an action happens. It also has an extended build.gradle, which helps me to develop FregeFX applications in the above-mentioned setup.

## Why is a template necessary?
Linking a controller instance in FXML means you need(?) to have a Java class, which act as the controller. As far as I've seen, it can't be done in Frege(FX), because the UI events will be passed as Objects, for instance of type `ActionEvent`. Frege functions, when being compiled to Java code, would require a `Lazy<ActionEvent>`, to support lazy evaluation.

So we need a Java class, but the actual logic should be in Frege again. That means, that calls from Java to Frege must be possible. There is an Eclipse plugin that seems to help a lot in this matter. I'm a regular user of IntelliJ though. To get IDE support during the time of writing the Java code, which calls Frege functions, it's necessary to have the Java representation of the Frege code in the sources. (I ended up with no success trying to use the files, which were compiled into the build directory.)

The build.gradle defines a special source set for the Frege code and will compile the corresponding Java code into this source set as well. The Java tooling has a source link to the folders with the generated code and therefore can work with it during development time while Java and Frege code are created in parallel. In my setup IntelliJ doesn't compile files automatically, including the Frege files. If this is the same for you, then you need to execute the fregeCompile task after changes in Frege.

The build.gradle also contains a jar section for building an executable jar file.

## What are the important parts of this template?
* Hello.fr - The main module
* main_screen.fxml - The UI description (together with hello.css)
* HelloController.java - The controller for the UI (referenced in main_screen.fxml)
* build.gradle - the gradle build file
* There are test file dummies included as well

## Sources, that were really helpful during the development of this template
* [Frege Goodness](https://dierk.gitbooks.io/fregegoodness/)
* [FregeFX](https://github.com/Frege/FregeFX)
* [fregeTutorial](https://github.com/Dierk/fregeTutorial)
* [Frege API](http://www.frege-lang.org/doc/fregedoc.html)
* [Calling Frege from Java](https://github.com/Frege/frege/wiki/Calling-Frege-from-Java-(from-release-3.24-on))
* [FregeChat](https://github.com/Dierk/FregeChat)
* [JavaFX API](https://docs.oracle.com/javase/8/javafx/api/toc.htm)
