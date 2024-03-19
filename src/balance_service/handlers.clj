(ns balance-service.handlers
  (:require [io.pedestal.http :as http]
            [clojure.data.json :as json]
            [balance-service.accounts.services :as services]))

(defn get-account-balance [{:keys [params]}]
  (let [account-id (get params :account-id)]
    (try
      (let [balance (services/get-account-balance account-id)]
        {:status 200
         :body (json/write-str {:account_id account-id
                                :balance balance})})
      (catch Exception e
        {:status 500
         :body (str "Error: " (.getMessage e))}))))