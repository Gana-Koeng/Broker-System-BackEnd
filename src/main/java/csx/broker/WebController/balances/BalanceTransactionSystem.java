package csx.broker.WebController.balances;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This class implements a balance transaction system.
 * It allows users to deposit and withdraw money from their accounts.
 */
public class BalanceTransactionSystem {
    private static final Logger LOGGER = Logger.getLogger(BalanceTransactionSystem.class.getName());
    private Map<String, Double> accounts;

    /**
     * Constructor for BalanceTransactionSystem
     */
    public BalanceTransactionSystem() {
        this.accounts = new HashMap<>();
    }

    /**
     * This method deposits the given amount to the given account.
     *
     * @param accountId the account to deposit to
     * @param amount    the amount to deposit
     * @return true if the deposit was successful, false otherwise
     */
    public boolean deposit(String accountId, double amount) {
        if (amount < 0) {
            LOGGER.warning("Cannot deposit negative amount: " + amount);
            return false;
        }
        if (accounts.containsKey(accountId)) {
            accounts.put(accountId, accounts.get(accountId) + amount);
        } else {
            accounts.put(accountId, amount);
        }
        return true;
    }

    /**
     * This method withdraws the given amount from the given account.
     *
     * @param accountId the account to withdraw from
     * @param amount    the amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    public boolean withdraw(String accountId, double amount) {
        if (amount < 0) {
            LOGGER.warning("Cannot withdraw negative amount: " + amount);
            return false;
        }
        if (accounts.containsKey(accountId)) {
            double balance = accounts.get(accountId);
            if (balance < amount) {
                LOGGER.warning("Cannot withdraw more than the balance: " + balance);
                return false;
            }
            accounts.put(accountId, balance - amount);
            return true;
        } else {
            LOGGER.warning("Account not found: " + accountId);
            return false;
        }
    }

    /**
     * This method returns the balance of the given account.
     *
     * @param accountId the account to get the balance of
     * @return the balance of the account, or 0 if the account does not exist
     */
    public double getBalance(String accountId) {
        if (accounts.containsKey(accountId)) {
            return accounts.get(accountId);
        } else {
            return 0;
        }
    }
}