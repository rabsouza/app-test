package br.com.teste.appteste.domain;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Created by rabsouza on 20/06/16.
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String urlPhoto;
    private String fromContact;
    private String toContact;
    private int colorIdRes;
    private Boolean notification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getFromContact() {
        return fromContact;
    }

    public void setFromContact(String fromContact) {
        this.fromContact = fromContact;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equal(getId(), message.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    public String getToContact() {
        return toContact;
    }

    public void setToContact(String toContact) {
        this.toContact = toContact;
    }

    public Message id(Long id) {
        this.id = id;
        return this;
    }

    public Message urlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
        return this;
    }

    public Message fromContact(String fromContact) {
        this.fromContact = fromContact;
        return this;
    }

    public Message toContact(String toContact) {
        this.toContact = toContact;
        return this;
    }

    public int getColorIdRes() {
        return colorIdRes;
    }

    public void setColorIdRes(int colorIdRes) {
        this.colorIdRes = colorIdRes;
    }

    public Message colorIdRes(int colorIdRes) {
        this.colorIdRes = colorIdRes;
        return this;
    }

    public Message notification(Boolean notification) {
        this.notification = notification;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", urlPhoto='" + urlPhoto + '\'' +
                ", fromContact='" + fromContact + '\'' +
                ", toContact='" + toContact + '\'' +
                ", colorIdRes=" + colorIdRes +
                ", notification=" + notification +
                '}';
    }
}
