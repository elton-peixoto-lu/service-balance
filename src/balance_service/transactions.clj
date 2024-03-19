(ns balance-service.transactions)
(def accounts (atom {}))

(defn record-transaction
  [account-id params]
  (let [transaction-id (java.util.UUID/randomUUID)
        operation (:operation params)
        amount (:operation_amount params)
        authorized-at (:authorized_at params)]
    (swap! accounts update-in [account-id transaction-id]
           #(conj % {:operation operation
                     :amount amount
                     :authorized-at authorized-at}))
    {:status 200
     :body {:transaction_id transaction-id
            :account_id account-id
            :operation operation
            :operation_amount amount
            :authorized_at authorized-at}}))

(defn get-balance
  [account-id]
  (if-let [transactions (get @accounts account-id)]
    (apply + (map :amount transactions))
    0))

(defn valid-body?
  [params]
  (and (:operation params)
       (:operation_amount params)
       (:authorized_at params)))