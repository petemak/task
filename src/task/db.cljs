(ns task.db
  (:require [reagent.core :as reagent :refer [atom]]))


(def data
  {:projects
   {"prj001" {:title "Create Task app"
              :stories {1 {:title "Write user stories"
                           :status "done"
                           :prio 1}
                        2 {:title "Sketch UI"
                           :status "done"
                           :prio 2}
                        3 {:title "Design data model"
                           :status "open"
                           :prio 3}
                        4 {:title "Implement technical spike"
                           :status "open"
                           :prio 4}}}
    "prj002" {:title "Learn Datomic"
              :stories {1 {:title "Read rationale"
                           :status "done"
                           :prio 1}
                        2 {:title "Read overview and architecture"
                           :status "Done"
                           :prio 2}
                        3 {:title "Learn Datalog"
                           :status "done"
                           :prio 3}
                        4 {:title "Use Datomic in Task app"
                           :status "open"
                           :prio 4}}}}})


(defn new-id
  []
  (str "prj" (rand-int 1000)))

(defn add-project!
  [app-state title]
  (swap! app-state assoc-in [:projects (new-id) {:title title
                                                 :stories {} }]))


