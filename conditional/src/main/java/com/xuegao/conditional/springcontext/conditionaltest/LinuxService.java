package com.xuegao.conditional.springcontext.conditionaltest;

/**
 * @Auther: lifq
 * @Description:
 */
public class LinuxService implements ListService {
    public String showListCmd() {
        return "ls";
    }
}