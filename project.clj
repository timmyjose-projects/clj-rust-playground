(defproject clj-rust-playground "0.1.0-SNAPSHOT"
  :description "A simple Clojure client for the Rust playground"
  :url "https://github.com/timmyjose/clj-rust-playground"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/data.json "0.2.6"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [bidi "2.1.4"]
                 [clj-http "3.9.1"]
                 [aero "1.1.3"]
                 [selmer "1.12.3"]]
  :main ^:skip-aot clj-rust-playground.core
  :profiles {:uberjar {:aot :all}})
