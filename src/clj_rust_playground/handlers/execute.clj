(ns clj-rust-playground.handlers.execute
  (:require [clj-rust-playground.handlers.helper :as helper]
            [ring.util.response :as res]
            [clojure.data.json :as json]
            [clj-http.client :as client]
            [clj-rust-playground.config :as config]))


(defn get-handler
  [req]
  (-> (res/resource-response "execute.html" {:root "html-templates"})
      (res/content-type "text/html")))


(defn post-handler
  [{:keys [form-params] :as req}]
  (let [payload (-> {}
                    (assoc :backtrace true)
                    (assoc :channel (get form-params "channel"))
                    (assoc :edition (get form-params "edition"))
                    (assoc :mode (get form-params "mode"))
                    (assoc :crateType (if (= "run" (get form-params "operation")) "bin" "lib"))
                    (assoc :tests (if (= "run" (get form-params "operation")) false true))
                    (assoc :code (get form-params "code"))
                    json/write-str)
        post-payload (assoc {:content-type :json :accept :json} :body payload)]
    (-> (client/post (config/get-playground-url) post-payload)
        :body
        json/read-str
        helper/construct-response-page
        res/response)))
