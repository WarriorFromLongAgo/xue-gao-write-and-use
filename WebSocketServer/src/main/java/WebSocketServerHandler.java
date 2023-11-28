import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@ChannelHandler.Sharable
public class WebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    ChannelId channelId;

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String content = msg.text();
        System.out.println(" content " + content);
        Channel channel = channelGroup.find(channelId);

        if (WebSocketClient2.msgId.equals(content)) {
            System.out.println("================================");
            TimeUnit.SECONDS.sleep(5);
        }

        // 向客户端回写数据
        channel.writeAndFlush(new TextWebSocketFrame(content + "服务端收到消息了"));
    }

























    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("aaaaaaaaaaaaaaa");
//		super.channelActive(ctx);
        channelId = ctx.channel().id();
        channelGroup.add(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("{} 异常断开，异常信息 {}", ctx.channel(), cause.getMessage());
        ctx.channel().close();
        cause.printStackTrace();
    }
}