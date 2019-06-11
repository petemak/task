(ns task.project)

(defn project-view
  [app-state project-id]
  [:div.content
   [:h3 (get-in @app-state [:projects project-id :title])]
   (into [:ul]
         (for [[id {:keys [title status]}] (get-in @app-state [:projects project-id :stories])]
           [:li
            (if (= status "done")
              [:del title] 
              [:span
               title
               "  -  "
               [:button
                {:on-click
                 (fn done-click [e]
                   (swap! app-state
                          assoc-in
                          [:projects project-id :stories id :status] "done"))}
                "Done"]])]))])


