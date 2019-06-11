(ns task.core
  (:require [task.db :as db]
            [task.navbar :as nav]
            [task.project :as prj]
            [task.projects :as prjs]
            [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)


;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom db/data))


(defn task-ui []
  [:div.content
   [:div.header
    [nav/navbar app-state]]
   [:div.main
    [prjs/project-list app-state]]
   [:div.footer 
    {:style {:font-family "fantasy"}}
    [:center "Using ClojureScript, Reagent and React..."]]])

(reagent/render-component [task-ui]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
