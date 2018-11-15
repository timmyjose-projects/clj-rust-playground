(ns clj-rust-playground.handlers.helper)


(defn get-header
  []
  "<head><title>Execution Result Page</title><head>")


(defn get-header
  []
  (str "<head><title>Result Page</title></head>"))


(defmacro get-section
  [tag section value]
  `(str "<" ~tag "/>" "<bold>" ~section "</bold>: " ~value "</" ~tag "><br>"))


(defn construct-response-page
  [result]
  (let [status (get result "success")
        stdout (get result "stdout")
        stderr (get result "stderr")]
    (str "<html>"
         (get-header)
         "<body>"
         "<ul>"
         (get-section "li" "Success" status)
         (get-section "li" "Stdout" stdout)
         (get-section "li" "Stderr" stderr)
         "</ul>"
         "</body>"
         "</html>")))
