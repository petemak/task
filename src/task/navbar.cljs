(ns task.navbar)


(defn navbar
  [app-state]
  [:nav 
   [:ul.nav-list
    [:li
     [:a {:href "https://clojure.org"}
      [:img
       {:src "img/realtime-48.png"}]     
      [:span
       {:style {:font-family "fantasy"}}
        " Simply Task - no deep s**t"]]]
    [:ul.nav-list
     {:style {:float "right"
              :font-family "fantasy"}}
     [:li [:a {:href "#/search"} "Search"]]
     [:li [:a {:href "#/info"}  "Info"]]
     [:li 
      (if-let [name (get-in @app-state [:user :user-name])]
        [:a {:href "#/settings"} name]
        [:a {:href "#/login"} "Login"])]]]])

