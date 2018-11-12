(ns clj-rust-playground.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.util.response :as res])
  (:gen-class))


(defn handler
  [req]
  (res/response "OK"))

(defn- start-server
  []
  (jetty/run-jetty handler {:port 9999}))

(defn -main
  [& args]
  (start-server))

