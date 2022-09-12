package com.xuegao.crm.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * https://www.nhooo.com/note/qa3gne.html
 */
public class LoggerStartupListener extends ContextAwareBase implements LoggerContextListener, LifeCycle {
    private boolean started = false;

    private int getPid() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        // format: "pid@hostname"
        String name = runtime.getName();
        try {
            return Integer.parseInt(name.substring(0, name.indexOf('@')));
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public boolean isResetResistant() {
        return false;
    }

    @Override
    public void onStart(LoggerContext loggerContext) {
        System.out.println("LoggerStartupListener onStart");
    }

    @Override
    public void onReset(LoggerContext loggerContext) {
        System.out.println("LoggerStartupListener onReset");
    }

    @Override
    public void onStop(LoggerContext loggerContext) {
        System.out.println("LoggerStartupListener onStop");
    }

    @Override
    public void onLevelChange(Logger logger, Level level) {
        System.out.println("onLevelChange logger = " + logger);
        System.out.println("onLevelChange level = " + level);
    }

    @Override
    public void start() {
        System.out.println("LoggerStartupListener start");
        if (started) {
            return;
        }
        Context context = getContext();
        context.putProperty("pid", String.valueOf(getPid()));
        started = true;
    }

    @Override
    public void stop() {
        System.out.println("LoggerStartupListener stop");
    }

    @Override
    public boolean isStarted() {
        return false;
    }
}