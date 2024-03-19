(ns balance-service.service
  (:require [io.pedestal.http :as http]
            [balance-service.handlers :as handlers]))

(def service
  {:env                :prod
   ::http/routes       (handlers/routes)
   ::http/resource-path "public"
   ::http/type         :jetty
   ::http/port         8080})
