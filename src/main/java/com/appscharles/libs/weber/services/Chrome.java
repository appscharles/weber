package com.appscharles.libs.weber.services;

import com.appscharles.libs.weber.exceptions.WeberException;
import com.appscharles.libs.weber.tabs.Tab;
import io.webfolder.cdp.Launcher;
import io.webfolder.cdp.session.SessionFactory;

import java.io.File;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 10.08.2018
 * Time: 11:56
 * Project name: weber
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Chrome {

    private SessionFactory sessionFactory;

    private Launcher launcher;

    private File browserDir;

    public Chrome(SessionFactory sessionFactory, Launcher launcher, File browserDir) {
        this.sessionFactory = sessionFactory;
        this.launcher = launcher;
        this.browserDir = browserDir;
    }

    public void close() throws WeberException {
        this.sessionFactory.close();
        new WeberKillService().kill(this.browserDir);
    }

    public Tab createTab(){
        return new Tab(this.sessionFactory.create());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Launcher getLauncher() {
        return launcher;
    }

    /**
     * Getter for property 'browserDir'.
     *
     * @return Value for property 'browserDir'.
     */
    public File getBrowserDir() {
        return browserDir;
    }
}