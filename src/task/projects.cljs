(ns task.projects
  (:require [task.db :as db]
            [goog.dom.forms :as gforms]))


(defn project-list  
  [app-state]
  [:div
   [:h2 "Projects"]
   [:form {:on-submit (fn add-project-pressed [e]
                        (.preventDefault e)
                        (db/add-project!
                         app-state
                         (gforms/getValuewByName (.-target e)
                                                 "project-title")))}
    [:input {:type "text"
             :name "project-title"}]
    [:input {:type "submit"
             :value "Add"}]]
   [:ul.projects
    (for [[id {:keys [title]}] @app-state]
      [:li.project
       [:a {:href (str  "#/project/" id)}
        [:h3 title]]])]])
