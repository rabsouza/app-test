package br.com.teste.appteste.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import br.com.teste.appteste.util.CurrencyUtils;

/**
 * Created by rabsouza on 21/06/16.
 */
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int MAX_MESSAGES_COUNTER = 20;

    private List<Sale> sales;
    private List<Message> messages;

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Profile sales(List<Sale> sales) {
        this.sales = sales;
        return this;
    }

    public Profile messages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    public String getFormattedCounterMessages() {
        if (messages == null || messages.isEmpty()) {
            return "0";
        } else if (messages.size() > MAX_MESSAGES_COUNTER) {
            return "+" + MAX_MESSAGES_COUNTER;
        }
        return "" + messages.size();
    }

    public String getFormattedCurrentAccountBalance() {
        if (sales != null && !sales.isEmpty()) {
            BigDecimal sumValues = BigDecimal.ZERO;
            for (Sale sale : sales) {
                sumValues = sumValues.add(sale.getValue());
            }
            return CurrencyUtils.format(sumValues);
        }
        return "0";
    }

    @Override
    public String toString() {
        return "Profile{" +
                "sales=" + sales +
                ", messages=" + messages +
                '}';
    }
}
