(ns status-im.chat.styles.input.suggestions
  (:require-macros [status-im.utils.styles :refer [defnstyle]])
  (:require [status-im.ui.components.styles :as common]
            [status-im.ui.components.colors :as colors]
            [status-im.utils.platform :as platform]))

(def item-height 52)
(def border-height 1)

(def root
  {:background-color common/color-white
   :border-top-color colors/chat-input-border
   :border-top-width 1})

(defn item-suggestion-container [last?]
  {:flex-direction      :row
   :align-items         :center
   :height              item-height
   :margin-left         14
   :padding-right       14
   :border-bottom-color colors/chat-input-border
   :border-bottom-width (if last? 0 border-height)})

(def item-suggestion-name
  {:color     common/color-black
   :font-size 15})

(def item-suggestion-description
  {:flex        1
   :font-size   15
   :margin-left 10
   :color       colors/chat-input-grey})
