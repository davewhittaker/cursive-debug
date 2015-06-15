(ns cursive-debug.server.core
  (:require [org.httpkit.server :refer [run-server]]
            [clojure.core.match :refer [match]]
            [clojure.string :as str]))

(defn init-routes
  [system]
  (fn [req]
    (let [method (:request-method req)
          path (->>  (str/split (:uri req) #"/" ) (filterv #(not (str/blank? %))))]
      (match 
        [method path]
        
        [:get _]
        (let [resp "Hello there"
              length (count resp)]
          (println "About to send a good response")
          {:content-type "text/plain"
           :content-length length
           :body resp})

        :else
        (let [resp "Uh oh"
              length (count resp)]
          (println "About to send a bad response")
          {:content-type "text/plain"
           :content-length length
           :body resp})))))

(defn init-handler
  [system]
  (let [routes (init-routes system)]
    (assoc system :handler routes)))

(defn init-system
  []
  (->
    {}
    init-handler))

(defn start
  [system]
  (prn "Server is starting!")
  (assoc system :shutdown (run-server (:handler system) 8090)))

(defn stop
  [system]
  (let [shutdown-fn (:shutdown system)]
    (if shutdown-fn
      (do
        (shutdown-fn)
        (prn "Server is stopped")
        (dissoc system :shutdown))
      (println "Could not shutdown server!"))
    system))
