package com.kongzue.baseokhttp.exceptions;

/**
 * @github: https://github.com/kongzue/
 * @homepage: http://kongzue.com/
 * @mail: myzcxhh@live.cn
 */
public class NewInstanceBeanException extends Exception {
    public NewInstanceBeanException(String reason){
        super("实例化错误：无法创建 Bean 目标类：" + reason);
    }
}
