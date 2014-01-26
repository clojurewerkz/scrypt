# Changes Between 1.0.0 and 1.1.0

## Lambdaworks Scrypt Upgrade

[Lambdaworks Scrypt](https://github.com/wg/scrypt) is updated to `1.4.0`,
which makes it possible to use a native implementation of the library.

To quote the docs:

```
The system property "com.lambdaworks.jni.loader" may be set to override
the default native library loader with one of the following values:

 * nil: refuse to load native libraries and revert to pure Java implementation
 * jar: extract native library from jar and load with System.load
 * sys: use System.loadLibrary, which may require java.library.path to be set
```

## Clojure 1.3 Support Dropped

Scrypt no longer officially supports Clojure 1.3.
