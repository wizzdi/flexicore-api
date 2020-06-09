package com.flexicore.data.jsoncontainers;

import com.flexicore.model.Baseclass;

/**
 * Created by Asaf on 14/10/2016.
 */
public class LinkContainer extends BasicContainer {
    private BasicContainer leftside;
    private BasicContainer rightside;
    private BasicContainer value;
    private String simplevalue;


    public LinkContainer(Baseclass base, Baseclass leftside, Baseclass rightside, Baseclass value, String simplevalue) {
        super(base);
        if(leftside!=null){
            this.leftside =new BasicContainer( leftside);

        }
        if(rightside!=null){
            this.rightside =new BasicContainer( rightside);

        }
        if(value!=null){
            this.value  =new BasicContainer(value);

        }
        this.simplevalue = simplevalue;
    }

    public BasicContainer getLeftside() {
        return leftside;
    }

    public void setLeftside(BasicContainer leftside) {
        this.leftside = leftside;
    }

    public BasicContainer getRightside() {
        return rightside;
    }

    public void setRightside(BasicContainer rightside) {
        this.rightside = rightside;
    }

    public BasicContainer getValue() {
        return value;
    }

    public void setValue(BasicContainer value) {
        this.value = value;
    }

    public String getSimplevalue() {
        return simplevalue;
    }

    public void setSimplevalue(String simplevalue) {
        this.simplevalue = simplevalue;
    }
}
