(ns clj-rust-playground.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.util.response :as res]
            [ring.middleware.params :refer (wrap-params)]
            [ring.middleware.resource :refer (wrap-resource)]
            [ring.middleware.json :refer (wrap-json-body wrap-json-response)]
            [bidi.ring :refer (make-handler)]
            [clj-rust-playground.config :as config]
            [clj-rust-playground.handlers.execute :as execute])
  (:gen-class))


(defn default-handler
  [req]
  (res/response ""))


(def handler
  (-> (make-handler ["/" {"" (fn [req] (res/redirect "/execute"))
                          "execute" {:get execute/get-handler
                                     :post execute/post-handler}
                          "favicon.ico" default-handler}])))

(def app
  (-> handler
      (wrap-resource "html-templates")
      wrap-params
      wrap-json-response
      (wrap-json-body {:keywords false})))


(defn- start-server
  [port]
  (jetty/run-jetty app {:port port}))


(defn -main
  [& args]
  (config/load-config :default)
  (let [port (config/get-port)]
    (start-server port)))

