package com.xuegao.netty1.channel;

import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;

// 与AbstractNioMessageChannel对应，是读取byte也就是字节并传递给channel的管道，实际的读取还是抽象的doReadBytes
// 源码使用自己封装的ByteBuf，这里简化了，看一下它的子类即NioSocketChannel
public abstract class AbstractNioByteChannel extends AbstractNioChannel {

    public AbstractNioByteChannel(Channel parent, SelectableChannel ch, int readInterestOp) {
        super(parent, ch, readInterestOp);
    }

    @Override
    public void read() {
        final ChannelPipeline pipeline = pipeline();
        // 这里做了简化处理，源码用的自封装ByteBuf
        ByteBuffer byteBuf = ByteBuffer.allocate(128);
        doReadBytes(byteBuf);
        pipeline.fireChannelRead(byteBuf);
    }

    protected abstract int doReadBytes(ByteBuffer buf);
}