(ns jida.views.welcome
  (:require [jida.views.common :as common]
            [jida.datomic :as jida]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]
        [hiccup.element :only [link-to]]))

(defpage "/" []
         (common/layout
            [:h1 "Jida - Explore Clojure Projects"]
            [:ul#nav.nav.nav-tabs
             [:li [:a {:href "#query" :data-toggle "tab"} "Query"]]
             [:li [:a {:href "#repos" :data-toggle "tab"} "Repos"]]
             [:li [:a {:href "#info" :data-toggle "tab"} "Getting started"]]
             ]
           [:div.tab-content
            [:div#query.tab-pane
             [:div.row
              [:div.span8
               [:p
                [:strong#query-title]
                [:span#description]]
               [:textarea#query-text
                {:rows 3
                 :placeholder "Your query"}
                "[:find ?repo-names :where [?repos :repo/uri ?repo-names]]"]
               [:div.controls
                [:input#query-save.btn.btn-large.btn-safe {:value "save" :type "submit"}]
                [:input#query-submit.btn.btn-large.btn-primary {:value "run" :type "submit"}]
                [:img#loader {:style "display:none;" :src "https://www.zenboxapp.com/assets/loading.gif"}]
                [:div#error-messages.alert {:style "display:none;"} ]
                ]
               ]
              [:div.span3.sidebar
               [:div
                [:label "Recent saved queries"]
                [:div#query-history]]
               ]
              ]
             [:div.row
              [:div.span11
               [:p#results]]]]
            [:div#repos.tab-pane
             [:div.repos
              [:p "Available repos: "
               [:div#available-repos]]]
             [:div
              [:label "Add your repo"]
              [:input#repo-address.input-xlarge
               {:type "text"
                :value "https://github.com/clojure/clojure.git"}]
              [:input#import-repo-btn.btn.btn-small
               {:value "import"
                :type "submit"}]
              [:div#import-status.alert.alert-info ""]]
             ]
            [:div#info.tab-pane
             [:p "Some relevant links:"]
             [:ul.schema
              [:li
               [:a {:target "_blank" :href "http://cloud.github.com/downloads/Datomic/codeq/codeq.pdf"} "Codeq schema"]]
              [:li
               [:a {:target "_blank" :href "http://docs.datomic.com/tutorial.html"} "Datomic query tutorial"]]
              [:li
               [:a {:target "_blank" :href "https://github.com/devn/codeq-playground/blob/master/src/com/thinkslate/codeq_playground/core.clj"} "Useful example queries"]]
              [:li
               [:a {:target "_blank" :href "https://github.com/yayitswei/jida"} "Jida Source"]]]
             ]]
            ))
