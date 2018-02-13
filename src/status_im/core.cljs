(ns status-im.core
  (:require [status-im.utils.error-handler :as error-handler]
            [status-im.ui.components.react :as react]
            [re-frame.core :as re-frame]
            [reagent.core :as reagent]
            [status-im.native-module.core :as status]
            [taoensso.timbre :as log]
            [status-im.data-store.core :as data-store]
            [status-im.utils.config :as config]
            [goog.object :as object]))

(when js/goog.DEBUG
  (object/set js/console "ignoredYellowBox" #js ["re-frame: overwriting"]))

(defn init [app-root]
  (log/set-level! config/log-level)
  (log/debug "[INIT] log/set-level!")
  (error-handler/register-exception-handler!)
  (log/debug "[INIT] error-handler/register-exception-handler!")
  (status/init-jail)
  (log/debug "[INIT] status/init-jail")
  (data-store/init)
  (log/debug "[INIT] data-store/init")
  (.registerComponent react/app-registry "StatusIm" #(reagent/reactify-component app-root))
  (log/debug "[INIT] .registerComponent")
  (re-frame/dispatch-sync [:initialize-app]))
