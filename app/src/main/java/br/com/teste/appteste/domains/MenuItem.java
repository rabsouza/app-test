package br.com.teste.appteste.domains;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Created by rabsouza on 18/06/16.
 */
public class MenuItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idRes;

    private int textIdRes;

    private int imgIdRes;

    private String counter;

    public int getIdRes() {
        return idRes;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    public int getTextIdRes() {
        return textIdRes;
    }

    public void setTextIdRes(int textIdRes) {
        this.textIdRes = textIdRes;
    }

    public int getImgIdRes() {
        return imgIdRes;
    }

    public void setImgIdRes(int imgIdRes) {
        this.imgIdRes = imgIdRes;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public MenuItem idRes(int idRes) {
        this.idRes = idRes;
        return this;
    }

    public MenuItem textIdRes(int textIdRes) {
        this.textIdRes = textIdRes;
        return this;
    }

    public MenuItem imgIdRes(int imgIdRes) {
        this.imgIdRes = imgIdRes;
        return this;
    }

    public MenuItem counter(String counter) {
        this.counter = counter;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;
        MenuItem menuItem = (MenuItem) o;
        return getIdRes() == menuItem.getIdRes();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdRes());
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "idRes=" + idRes +
                ", textIdRes=" + textIdRes +
                ", imgIdRes=" + imgIdRes +
                ", counter='" + counter + '\'' +
                '}';
    }
}
