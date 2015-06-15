(ns user
  (:require [cursive-debug.server.core :as cursive-debug]
            [clojure.tools.namespace.repl :refer [refresh disable-reload!]]
            [clojure.pprint :refer [pprint]]))

(def system nil)

(defn init
  "Constructs the current development system."
  []
  (alter-var-root #'system
                  (constantly (cursive-debug/init-system))))

(defn start
  "Starts the current development system."
  []
  (alter-var-root #'system cursive-debug/start))

(defn stop
  "Shuts down and destroys the current development system."
  []
  (alter-var-root #'system
                  (fn [s] (when s (cursive-debug/stop s)))))

(defn go
  "Initializes the current development system and starts it running."
  []
  (init)
  (start))

(defn reset
  []
  "Refreshes the user namespace and re-starts the app"
  (stop)
  (refresh :after 'user/go))