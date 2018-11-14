(ns clj-rust-playground.handlers.execute
  (:require [ring.util.response :as res]
            [clojure.data.json :as json]
            [clj-http.client :as client]
            [clj-rust-playground.config :as config]))


(defn get-handler
  [req]
  (-> (res/resource-response "execute.html" {:root "html-templates"})
      (res/content-type "text/html")))


(def payload-str
  {:channel "stable"
   :mode "debug"
   :crateType "bin"
   :tests false
   :code ""
   :backtrace false})


(defn post-handler
  [{:keys [form-params] :as req}]
  (let [result (client/post (config/get-plaground-url)
                         {:body (json/write-str (assoc payload-str :code (get form-params "code")))
                          :content-type :json
                          :accept :json})]
    (res/response (:body result))))
