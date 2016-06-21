package br.com.teste.appteste.domain;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import br.com.teste.appteste.util.CurrencyUtils;
import br.com.teste.appteste.util.DateUtils;

/**
 * Created by rabsouza on 19/06/16.
 */
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String desc;
    private Calendar date;
    private BigDecimal value;
    private Boolean notification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getFormattedTitle() {
        if (Strings.isNullOrEmpty(title)) {
            return "";
        } else if (title.length() > 100) {
            return title.substring(0, 100).concat("...");
        } else {
            return title;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getFormattedValue() {
        return CurrencyUtils.format(value);
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public Sale id(Long id) {
        this.id = id;
        return this;
    }

    public Sale title(String title) {
        this.title = title;
        return this;
    }

    public Sale desc(String desc) {
        this.desc = desc;
        return this;
    }

    public Sale date(Calendar date) {
        this.date = date;
        return this;
    }

    public Sale value(BigDecimal value) {
        this.value = value;
        return this;
    }

    public String getResume() {
        StringBuilder resume = new StringBuilder();
        resume.append("id ")
                .append(id)
                .append(" * ")
                .append(DateUtils.format(date));
        return resume.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale)) return false;
        Sale sale = (Sale) o;
        return Objects.equal(getId(), sale.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", date=" + date +
                ", value=" + value +
                ", notification=" + notification +
                '}';
    }

    public Sale notification(Boolean notification) {
        this.notification = notification;
        return this;
    }
}
