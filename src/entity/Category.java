package entity;

import java.io.Serializable;

/**
 * Created by Siren Chen.
 */
public class Category implements Serializable {
    private int cid;
    private String cname;  // category name
    private String cdesc;  // category description

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }
}
