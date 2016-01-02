# Clojure Scrypt Library

scrypt is a tiny Clojure library for the scrypt key derivation function.

## Why Use Scrypt

Scrypt has a significantly higher cost of carrying out brute force attacks on hashed values:

![Key derivation function comparison](https://raw.github.com/pbhogan/scrypt/master/kdf-comparison.png)

For more details, see the [Scrypt paper](https://www.tarsnap.com/scrypt/scrypt.pdf).


## Community

To subscribe for announcements of releases, important changes and so on, please follow [@ClojureWerkz](https://twitter.com/#!/clojurewerkz) on Twitter.


## Project Maturity

ClojureWerkz Scrypt is a fairly young project built on top of a Java
implementation of Scrypt that has been around for a couple of years.


## Artifacts

Scrypt artifacts are [released to Clojars](https://clojars.org/clojurewerkz/scrypt). If you are using Maven, add the following repository
definition to your `pom.xml`:

``` xml
<repository>
  <id>clojars.org</id>
  <url>http://clojars.org/repo</url>
</repository>
```

### The Most Recent Release

With Leiningen:

    [clojurewerkz/scrypt "1.2.0"]


With Maven:

    <dependency>
      <groupId>clojurewerkz</groupId>
      <artifactId>scrypt</artifactId>
      <version>1.2.0</version>
    </dependency>



## Documentation

Scrypt has a single namespace: `clojurewerkz.scrypt.core`, and two functions:

 * `clojurewerkz.scrypt.core/encrypt` encrypts a string using Scrypt
 * `clojurewerkz.scrypt.core/verify` verifies a string against a hash produced by `encrypt`

An example to demonstrate them:

``` clojure
(require '[clojurewerkz.scrypt.core :as sc])

(let [h (sc/encrypt "secret" 16384 8 1)]
        (sc/verify "secret" h))
;= true

(let [h (sc/encrypt "secret" 16384 8 1)]
        (sc/verify "another value" h))
;= false
```

Arguments that `clojurewerkz.scrypt.core/encrypt` takes control CPU, RAM and parallelization
cost. The values in the example above are optimal starting points for many applications.

See the [Scrypt paper](https://www.tarsnap.com/scrypt/scrypt.pdf)
for a detailed information.

### Native Scrypt Implementation

It is possible to use a native implementation as of ClojureWerkz Scrypt `1.1.0`.
From [Lambdaworks Scrypt documentation](https://github.com/wg/scrypt/blob/master/README):

```
  When the native library can be loaded it will be used instead of the pure
  Java implementation. On a J2SE compliant JVM the native library will be
  extracted from the jar and loaded, and on other VMs System.loadLibrary will
  be called.

  The system property "com.lambdaworks.jni.loader" may be set to override
  the default native library loader with one of the following values:

   * nil: refuse to load native libraries and revert to pure Java implementation
   * jar: extract native library from jar and load with System.load
   * sys: use System.loadLibrary, which may require java.library.path to be set
```


## Supported Clojure Versions

scrypt requires Clojure 1.4+.


## Continuous Integration Status

[![Continuous Integration status](https://secure.travis-ci.org/clojurewerkz/scrypt.png)](http://travis-ci.org/clojurewerkz/scrypt)



## Scrypt Is a ClojureWerkz Project

This library is part of the [group of Clojure libraries known as ClojureWerkz](http://clojurewerkz.org), together with
 * [Monger](http://clojuremongodb.info)
 * [Langohr](https://github.com/michaelklishin/langohr)
 * [Elastisch](https://github.com/clojurewerkz/elastisch)
 * [Welle](http://clojureriak.info)
 * [Neocons](http://clojureneo4j.info)
 * [Quartzite](https://github.com/michaelklishin/quartzite) and several others.


## Development

scrypt uses [Leiningen
2](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md). Make
sure you have it installed and then run tests against supported
Clojure versions using

    lein all test

Then create a branch and make your changes on it. Once you are done
with your changes and all tests pass, submit a pull request on GitHub.



## License

Copyright (C) 2013-2016 Michael S. Klishin, Alex Petrov.

Double licensed under the [Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html) (the same as Clojure) or
the [Apache Public License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
