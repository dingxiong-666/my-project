package com.dx.project.utils;

public class Result<T> {
    private String code;
    private String msg;
    private T date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public static Result success(){
        Result res = new Result();
        res.setCode("0");
        res.setMsg("成功");
        return res;
    }

    public static <T>Result<T> success(T data){
        Result res = new Result();
        res.setCode("0");
        res.setMsg("成功");
        res.setDate(data);
        return res;
    }

   public static Result error(String code,String msg){
       Result res = new Result();
       res.setCode(code);
       res.setMsg(msg);
       return res;
   }

}
