(ns digest.core
  (:require [clojure.contrib.string :as string])
  (:import [java.security MessageDigest])
  )

(defn- bytes->hex-str [bytes]
  (apply str (map #(string/tail 2 (str "0" (Integer/toHexString (bit-and 0xff %)))) bytes))
  )

(defn- digest [algorithm s]
  (if-not (string/blank? s)
    (.digest (MessageDigest/getInstance algorithm) (.getBytes s))
    )
  )

(def md5byte (partial digest "MD5"))
(def sha1byte (partial digest "SHA1"))

(def md5str (comp bytes->hex-str md5byte))
(def sha1str (comp bytes->hex-str sha1byte))

