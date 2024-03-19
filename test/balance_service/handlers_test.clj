(ns balance-service.handlers-test
  (:require [clojure.test :refer [deftest is]]
            [balance-service.handlers :as handlers]
            [clojure.test :refer [deftest is testing]]))

(deftest test-record-handler
  (testing "Record a new transaction"
           (let [response (handlers/record-handler {:path-params {:account-id "123"}
                                                    :body-params {:operation "credit"
                                                                  :operation_amount 500
                                                                  :authorized_at 1706260888}})]
             (is (= 200 (:status response)))
             (is (contains? (:body response) :transaction_id)))))

(deftest test-balance-handler
  (testing "Get balance of an account"
           (let [response (handlers/balance-handler {:path-params {:account-id "123"}})]
             (is (= 404 (:status response))))))