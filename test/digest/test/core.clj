(ns digest.test.core
  (:use [digest.core] :reload)
  (:use [clojure.test]))

(deftest test-md5str
  (are [x y] (= x y)
    "5d41402abc4b2a76b9719d911017c592" (md5str "hello")
    "7d793037a0760186574b0282f2f435e7" (md5str "world")
    )
  )

(deftest test-sha1str
  (are [x y] (= x y)
    "aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d" (sha1str "hello")
    "7c211433f02071597741e6ff5a8ea34789abbf43" (sha1str "world")
    )
  )

