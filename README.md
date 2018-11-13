# clj-rust-playground

This is a Proof of Concept to interact with the Rust Playground via a simple Clojure-backed page.

The user should be able to enter code either through the RESTful interface, or via the simple
page provided to send code to the Rust Playground, and see the results of code execution.


## Usage

From the project root:

```
$ lein run
```

or if you prefer a runnable JAR instead:

```
$ lein uberjar

$ java -jar java -jar target/clj-rust-playground-0.1.0-SNAPSHOT-standalone.jar
```

## License

Copyright © 2018 Timmy Jose

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
