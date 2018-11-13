(ns clj-rust-playground.config
  (:require [aero.core :refer [read-config]]))


(def config-atom (atom {}))


(defn load-config
  "Load the configuration from config.end into the atom."
  [profile]
  (reset! config-atom (read-config (clojure.java.io/resource "config.edn") {:profile profile})))


(defn get-port
  []
  (get-in @config-atom [:webserver :port]))


(defn get-plaground-url
  "Retrieve the Rust Playground URL."
  []
  (:rust-playground-url @config-atom))


