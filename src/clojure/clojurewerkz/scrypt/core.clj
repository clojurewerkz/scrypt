;; Copyright (c) 2013-2014 Michael S. Klishin, Alex Petrov, and the ClojureWerkz Team
;;
;; This file is provided to you under the Apache License, Version 2.0 (the
;; "License"); you may not use this file except in compliance with the License.
;; You may obtain a copy of the License at
;;
;; http://www.apache.org/licenses/LICENSE-2.0
;;
;; Unless required by applicable law or agreed to in writing, software
;; distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
;; WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
;; License for the specific language governing permissions and limitations under
;; the License.

(ns clojurewerkz.scrypt.core
  "Scrypt encryption function.

   To learn more about scrypt, see https://www.tarsnap.com/scrypt/scrypt.pdf"
  (:import com.lambdaworks.crypto.SCryptUtil))


;;
;; API
;;

(defn ^String encrypt
  "Encrypts a string value using scrypt.

   Arguments are:

   s (string): a string to encrypt
   n (integer): CPU cost parameter (16834 is a good starting value)
   r (integer): RAM cost parameter (8 is a good starting value)
   p (integer): parallelism parameter (1 is a good starting value)"
  [^String s ^long n ^long r ^long p]
  (SCryptUtil/scrypt s n r p))

(defn verify
  "Verifies a value against a hash produced by scrypt"
  [^String candidate ^String hash]
  (SCryptUtil/check candidate hash))
