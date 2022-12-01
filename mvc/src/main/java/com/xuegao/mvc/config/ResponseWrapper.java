package com.xuegao.mvc.config;

/**
 * 作者:修罗大人
 * <p>
 * 时间:2018-11-15 17:13
 * <p>
 * 描述:ResponseWrapper
 */

import javax.servlet.ServletOutputStream;

import javax.servlet.WriteListener;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletResponseWrapper;

import java.io.*;

public class ResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream bytes = new ByteArrayOutputStream();

    private HttpServletResponse response;

    private PrintWriter pwrite;

    public ResponseWrapper(HttpServletResponse response) {

        super(response);

        this.response = response;

    }

    @Override

    public ServletOutputStream getOutputStream() throws IOException {

        return new MyServletOutputStream(bytes);// 将数据写到 byte 中

    }

    /**
     * 重写父类的 getWriter () 方法，将响应数据缓存在 PrintWriter 中
     */
    @Override
    public PrintWriter getWriter() throws IOException {
        try {
            pwrite = new PrintWriter(new OutputStreamWriter(bytes, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return pwrite;
    }

    /**
     * 获取缓存在 PrintWriter 中的响应数据
     */
    public byte[] getBytes() {
        if (null != pwrite) {
            pwrite.close();
            return bytes.toByteArray();
        }
        if (null != bytes) {
            try {
                bytes.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes.toByteArray();
    }

    class MyServletOutputStream extends ServletOutputStream {

        private ByteArrayOutputStream ostream;

        public MyServletOutputStream(ByteArrayOutputStream ostream) {
            this.ostream = ostream;
        }

        @Override
        public void write(int b) throws IOException {

            ostream.write(b);// 将数据写到 stream　中

        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {

        }

    }

}

// 作者：修罗大人
//         链接：https://www.jianshu.com/p/8e3950cffc14
//         来源：简书
//         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。