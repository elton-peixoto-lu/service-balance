(ns balance-service.config.routes
  (:require [io.pedestal.http.route :as route]))

(def routes
  (route/expand-routes
    ["/api/accounts/{account-id}/transactions" :post ::transactions/record-transaction
     "/api/accounts/{account-id}" :get ::accounts/get-account-balance]))