/*
 *    Copyright 2009-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.xuegao.mybatis.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

/**
 * A class to simplify access to resources through the classloader.
 *
 * @author Clinton Begin
 */
public class Resources {

    private static final ClassLoaderWrapper classLoaderWrapper = new ClassLoaderWrapper();

    Resources() {
    }

    /**
     * Returns the default classloader (may be null).
     *
     * @return The default classloader
     */
    public static ClassLoader getDefaultClassLoader() {
        return classLoaderWrapper.defaultClassLoader;
    }

    /**
     * Returns a resource on the classpath as a Stream object
     *
     * @param resource The resource to find
     * @return The resource
     * @throws java.io.IOException If the resource cannot be found or read
     */
    public static InputStream getResourceAsStream(String resource) throws IOException {
        return getResourceAsStream(null, resource);
    }

    /**
     * Returns a resource on the classpath as a Stream object
     *
     * @param loader   The classloader used to fetch the resource
     * @param resource The resource to find
     * @return The resource
     * @throws IOException If the resource cannot be found or read
     */
    public static InputStream getResourceAsStream(ClassLoader loader, String resource) throws IOException {
        InputStream in = classLoaderWrapper.getResourceAsStream(resource, loader);
        if (in == null) {
            throw new IOException("Could not find resource " + resource);
        }
        return in;
    }

    /**
     * Returns a resource on the classpath as a Properties object
     *
     * @param resource The resource to find
     * @return The resource
     * @throws java.io.IOException If the resource cannot be found or read
     */
    public static Properties getResourceAsProperties(String resource) throws IOException {
        Properties props = new Properties();
        try (InputStream in = getResourceAsStream(resource)) {
            props.load(in);
        }
        return props;
    }

    /**
     * Gets a URL as a Properties object
     *
     * @param urlString - the URL to get
     * @return A Properties object with the data from the URL
     * @throws java.io.IOException If the resource cannot be found or read
     */
    public static Properties getUrlAsProperties(String urlString) throws IOException {
        Properties props = new Properties();
        try (InputStream in = getUrlAsStream(urlString)) {
            props.load(in);
        }
        return props;
    }

    /**
     * Gets a URL as an input stream
     *
     * @param urlString - the URL to get
     * @return An input stream with the data from the URL
     * @throws java.io.IOException If the resource cannot be found or read
     */
    public static InputStream getUrlAsStream(String urlString) throws IOException {
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        return conn.getInputStream();
    }

    public static Class<?> classForName(String className) throws ClassNotFoundException {
        return classLoaderWrapper.classForName(className);
    }
}
