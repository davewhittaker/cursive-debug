(ns cursive-debug.client.core
  (:require [om.core :as om :include-macros true]
            [om-tools.dom :as dom :include-macros true]
            [om-tools.core :refer-macros [defcomponent defcomponentk defcomponentmethod]]))

(enable-console-print!)

(defcomponentk page
  [data]
  (render
    [_]
    (dom/div {}
      "Hello")))

(om/root
  page
  app
  {:target (. js/document (getElementById "app"))})
