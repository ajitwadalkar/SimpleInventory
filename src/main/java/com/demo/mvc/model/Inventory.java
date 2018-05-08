package com.demo.mvc.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inventory")
@EntityListeners(AuditingEntityListener.class)
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inv_id")
    private long invId;

    @Column(name = "inv_UPA")
    private String invUpa;
    private String invThumbnail;
    private long invRtnQty;
    private String invSeller;
    private String invItemBrand;
    private String invItemDesc;
    private double invAmount;
    private String invModel;
    private long invLoad;
    private double invWidth;
    private double invDepth;
    private double invHeight;
    private double invWeight;
    private String invAdditionalInfo;
    private String invTodo;


    public long getInvId() {
        return invId;
    }

    public void setInvId(long invId) {
        this.invId = invId;
    }


    public String getInvUpa() {
        return invUpa;
    }

    public void setInvUpa(String invUpa) {
        this.invUpa = invUpa;
    }


    public String getInvThumbnail() {
        return invThumbnail;
    }

    public void setInvThumbnail(String invThumbnail) {
        this.invThumbnail = invThumbnail;
    }


    public long getInvRtnQty() {
        return invRtnQty;
    }

    public void setInvRtnQty(long invRtnQty) {
        this.invRtnQty = invRtnQty;
    }


    public String getInvSeller() {
        return invSeller;
    }

    public void setInvSeller(String invSeller) {
        this.invSeller = invSeller;
    }


    public String getInvItemBrand() {
        return invItemBrand;
    }

    public void setInvItemBrand(String invItemBrand) {
        this.invItemBrand = invItemBrand;
    }


    public String getInvItemDesc() {
        return invItemDesc;
    }

    public void setInvItemDesc(String invItemDesc) {
        this.invItemDesc = invItemDesc;
    }


    public double getInvAmount() {
        return invAmount;
    }

    public void setInvAmount(double invAmount) {
        this.invAmount = invAmount;
    }


    public String getInvModel() {
        return invModel;
    }

    public void setInvModel(String invModel) {
        this.invModel = invModel;
    }


    public long getInvLoad() {
        return invLoad;
    }

    public void setInvLoad(long invLoad) {
        this.invLoad = invLoad;
    }


    public double getInvWidth() {
        return invWidth;
    }

    public void setInvWidth(double invWidth) {
        this.invWidth = invWidth;
    }


    public double getInvDepth() {
        return invDepth;
    }

    public void setInvDepth(double invDepth) {
        this.invDepth = invDepth;
    }


    public double getInvHeight() {
        return invHeight;
    }

    public void setInvHeight(double invHeight) {
        this.invHeight = invHeight;
    }


    public double getInvWeight() {
        return invWeight;
    }

    public void setInvWeight(double invWeight) {
        this.invWeight = invWeight;
    }


    public String getInvAdditionalInfo() {
        return invAdditionalInfo;
    }

    public void setInvAdditionalInfo(String invAdditionalInfo) {
        this.invAdditionalInfo = invAdditionalInfo;
    }


    public String getInvTodo() {
        return invTodo;
    }

    public void setInvTodo(String invTodo) {
        this.invTodo = invTodo;
    }
}
