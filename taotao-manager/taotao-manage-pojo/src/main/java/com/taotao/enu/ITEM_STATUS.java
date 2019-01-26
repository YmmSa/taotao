package com.taotao.enu;

/**
 * @Auther: aaaa
 * @Date: 2019/1/25 21:00
 * @Description:
 */
public enum ITEM_STATUS {

    NORMAL((byte)1, "normal"),
    LOWER_SHELF((byte)2, "lower_shelf"),
    REMOVE((byte)3, "remove");

    private Byte value;
    private String msg;

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Byte getValue() {
        return value;
    }

    public void setValue(Byte value) {
        this.value = value;
    }

    private ITEM_STATUS(Byte value, String msg) {
        this.value = value;
        this.msg = msg;
    }

}
