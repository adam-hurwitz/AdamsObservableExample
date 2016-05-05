package com.ahurwitz.adamsobservableex;

/**
 * Created by ahurwitz on 5/5/16.
 */
public class Object {

    int id;
    String name;
    Boolean val;

    public Object (int id, String name, Boolean val){
        this.id = id;
        this.name = name;
        this.val = val;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVal(Boolean val) {
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getVal() {
        return val;
    }


}
