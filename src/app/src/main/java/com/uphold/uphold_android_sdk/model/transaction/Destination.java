package com.uphold.uphold_android_sdk.model.transaction;

import java.io.Serializable;

/**
 * Destination model.
 */

public class Destination implements Serializable {

    private final String AccountId;
    private final String CardId;
    private final String accountType;
    private final String amount;
    private final String base;
    private final String commission;
    private final String currency;
    private final String description;
    private final String fee;
    private final String rate;
    private final String type;
    private final String username;

    /**
     * Constructor.
     *
     * @param AccountId The id of the account from the destination of the transaction.
     * @param cardId The card id of the card from the destination of the transaction.
     * @param accountType The type of the account from the destination of the transaction.
     * @param amount The amount from the destination of the transaction.
     * @param base The base from the destination of the transaction.
     * @param commission The commission from the destination of the transaction.
     * @param currency The currency from the destination of the transaction.
     * @param description The description from the destination of the transaction.
     * @param fee The fee from the destination of the transaction.
     * @param rate The rate from the destination of the transaction.
     * @param type The type from the destination of the transaction.
     * @param username The username from the destination of the transaction.
     */

    public Destination(String AccountId, String cardId, String accountType, String amount, String base, String commission, String currency, String description, String fee, String rate, String type, String username) {
        this.AccountId = AccountId;
        this.CardId = cardId;
        this.accountType = accountType;
        this.amount = amount;
        this.base = base;
        this.commission = commission;
        this.currency = currency;
        this.description = description;
        this.fee = fee;
        this.rate = rate;
        this.type = type;
        this.username = username;
    }

    /**
     * Gets the id of the account from the destination of the transaction.
     *
     * @return the id of the account from the destination of the transaction.
     */

    public String getAccountId() {
        return AccountId;
    }

    /**
     * Gets the card id of the card from the destination of the transaction.
     *
     * @return the id of the card from the destination of the transaction.
     */

    public String getCardId() {
        return CardId;
    }

    /**
     * Gets the type of the account from the destination of the transaction.
     *
     * @return the type of the account from the destination of the transaction.
     */

    public String getAccountType() {
        return accountType;
    }

    /**
     * Gets the amount from the destination of the transaction.
     *
     * @return the amount from the destination of the transaction.
     */

    public String getAmount() {
        return amount;
    }

    /**
     * Gets the base from the destination of the transaction.
     *
     * @return the base from the destination of the transaction.
     */

    public String getBase() {
        return base;
    }

    /**
     * Gets the commission from the destination of the transaction.
     *
     * @return the commission from the destination of the transaction.
     */

    public String getCommission() {
        return commission;
    }

    /**
     * Gets the currency from the destination of the transaction.
     *
     * @return the currency from the destination of the transaction.
     */

    public String getCurrency() {
        return currency;
    }

    /**
     * Gets the description from the destination of the transaction.
     *
     * @return the description from the destination of the transaction.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Gets the fee from the destination of the transaction.
     *
     * @return the fee from the destination of the transaction.
     */

    public String getFee() {
        return fee;
    }

    /**
     * Gets the rate from the destination of the transaction.
     *
     * @return the rate from the destination of the transaction.
     */

    public String getRate() {
        return rate;
    }

    /**
     * Gets the type from the destination of the transaction.
     *
     * @return the type from the destination of the transaction.
     */

    public String getType() {
        return type;
    }

    /**
     * Gets the username from the destination of the transaction.
     *
     * @return the username from the destination of the transaction.
     */

    public String getUsername() {
        return username;
    }

}
