import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lixx
 * @version 1.0
 * @since 2023-05-12 16:18
 */
@Slf4j
public class WebSocketClient2 {
    public static String msgId = "2222222222";
    static Map<String, CompletableFuture<String>> futureMap = new HashMap<>();
    static {
        CompletableFuture<String> resultFuture = new CompletableFuture<>();
        futureMap.put(msgId, resultFuture);
    }



    public static void main(String[] args) throws Exception {
        WebSocketClient2 client2 = new WebSocketClient2();
        Channel channel = client2.dest();
        ChannelFuture channelFuture = channel.writeAndFlush(new TextWebSocketFrame("222222+sleep"));

        String format1 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-hh mm:HH:ss"));
        System.out.println(format1);


        CompletableFuture<String> stringCompletableFuture = futureMap.get(msgId);
        String s = stringCompletableFuture.get(2, TimeUnit.SECONDS);


        System.out.println(s);
        String format2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-hh mm:HH:ss"));
        System.out.println(format2);
        System.out.println("=======================================");
    }

    public Channel dest() throws Exception {
        final URI webSocketURL = new URI("ws://127.0.0.1:8888/socket.io");

        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap boot = new Bootstrap();
        boot.option(ChannelOption.SO_KEEPALIVE, true).option(ChannelOption.TCP_NODELAY, true).group(group).handler(new LoggingHandler(LogLevel.INFO)).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel sc) throws Exception {
                ChannelPipeline pipeline = sc.pipeline();
                pipeline.addLast(new HttpClientCodec());
                pipeline.addLast(new ChunkedWriteHandler());
                pipeline.addLast(new HttpObjectAggregator(64 * 1024));
                pipeline.addLast(new WebSocketClientProtocolHandler(WebSocketClientHandshakerFactory.newHandshaker(webSocketURL, WebSocketVersion.V13, null, false, new DefaultHttpHeaders())));
                pipeline.addLast(new SimpleChannelInboundHandler<TextWebSocketFrame>() {


                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
                        System.err.println(" 客户端收到消息======== " + msg.text());
                        CompletableFuture<String> stringCompletableFuture = futureMap.get(msgId);
                        stringCompletableFuture.complete(msg.text());

                    }

                    @Override
                    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

                        if (WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_COMPLETE.equals(evt)) {
                            send(msgId, ctx.channel());
                        }

                        super.userEventTriggered(ctx, evt);
                    }
                });


            }
        });

        ChannelFuture cf = boot.connect(webSocketURL.getHost(), webSocketURL.getPort()).sync();

        return cf.channel();
    }


    public static void send(String msgId, Channel channel) {

        if (channel != null && channel.isActive()) {
            TextWebSocketFrame frame = new TextWebSocketFrame(msgId);
            channel.writeAndFlush(frame).addListener((ChannelFutureListener) channelFuture -> {
                if (channelFuture.isDone() && channelFuture.isSuccess()) {
                    log.info("     ================= 发送成功.");
                } else {
                    channelFuture.channel().close();
                    log.info("     ================= 发送失败. cause = " + channelFuture.cause());
                    channelFuture.cause().printStackTrace();
                }
            });
        } else {
            log.error("消息发送失败！ msgId = " + msgId);
        }
    }

}