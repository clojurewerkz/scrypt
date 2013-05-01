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

(ns clojurewerkz.scrypt.core-test
  (:require [clojurewerkz.scrypt.core :as sc])
  (:use clojure.test)
  (:import java.util.UUID))


(deftest test-encrypt-and-check
  (let [pwd    "secret"
        hashed (sc/encrypt pwd 16384 8 1)]
    (is (sc/check pwd hashed))
    (dotimes [i 50]
      (let [uid (str (UUID/randomUUID))]
        (is (not (sc/verify uid hashed)))))))

