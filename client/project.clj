(defproject cursive-debug-client "0.1.0-SNAPSHOT"
  :description "Test of Cursive debugging - Client"
  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [org.clojure/clojurescript "0.0-3308"]
                 [org.omcljs/om "0.8.8" :exclusions [cljsjs/react]]
                 [cljsjs/react-with-addons "0.12.2-4"]
                 [prismatic/om-tools "0.3.10"]]
  :plugins [[lein-cljsbuild "1.0.4"]]
  :clean-targets ^{:protect false}["../webapp/generated/cursive-debug.js"
                                   "../webapp/generated/dev"
                                   "../webapp/generated/release"]
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :compiler {:main anyma.client.core
                                   :output-to "../webapp/generated/cursive-debug.js"
                                   :output-dir "../webapp/generated/dev"
                                   :asset-path "/generated/dev"
                                   :optimizations :none
                                   :source-map true
                                   :pretty-print true}}
                       {:id "release"
                        :source-paths ["src"]
                        :compiler {:output-to "../webapp/generated/cursive-debug.js"
                                   :output-dir "../webapp/generated/release"
                                   :asset-path "/generated/release"
                                   :optimizations :advanced
                                   ;:source-map true
                                   :pretty-print false}}]})
