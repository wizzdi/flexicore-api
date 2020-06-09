package com.flexicore.data.jsoncontainers;

import com.flexicore.model.User;

/**
 * Created by Asaf on 16/05/2017.
 */
public class UserContainer extends BasicContainer {
    private String mail;
    private String phonenumber;

    public UserContainer(User base) {
        super(base);
        mail=base.getEmail();
        phonenumber=base.getPhoneNumber();
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
