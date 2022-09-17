package com.xuegao.conditional.springcontext.conditionaltest;

/**
 * @Auther: lifq
 * @Description:
 */
public class WindowsService implements ListService {
    public String showListCmd() {
        return "dir";
    }
}