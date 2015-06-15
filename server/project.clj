(defproject cursive-debug-server "0.1.0-SNAPSHOT"
  :description "Test of Cursive debugging - server"
  :source-paths ["src"]
  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [http-kit "2.1.18"]
                 [org.clojure/core.match "0.3.0-alpha4"]]
  :profiles {:dev  {:dependencies [[org.clojure/tools.namespace "0.2.7"]
                                   [org.clojure/java.classpath "0.2.0"]]
                    :source-paths ["dev"]
                    :main user}
             :uberjar {:aot :all}}
  :main cursive-debug.server.main
  :jar-name "cursive-debug.jar"
  :uberjar-name "cursive-debug-all.jar")