(ns clj-rust-playground.handlers.execute
  (:require [ring.util.response :as res]))


(defn get-handler
  [req]
  (-> (res/resource-response "execute.html" {:root "html-templates"})
      (res/content-type "text/html")))


(defn post-handler
  [req]
  (res/response "OK!"))

