import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
 
/**
 * @author lixx
 * @version 1.0
 * @since 2023-05-12 15:32
 */
public class WebSocketServer {
 
 
	public static void main(String[] args) throws InterruptedException {
 
		ServerBootstrap serverBootstrap;
 
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
 
		serverBootstrap = new ServerBootstrap();
		serverBootstrap
				.group(boss, worker)
				.channel(NioServerSocketChannel.class)
				.childOption(ChannelOption.TCP_NODELAY, true)
				.childHandler(new ChannelInitializer<NioSocketChannel>() {
								  @Override
								  protected void initChannel(NioSocketChannel ch) throws Exception {
									  ChannelPipeline pipeline = ch.pipeline();
									  pipeline.addLast(new HttpServerCodec())
											  .addLast(new ChunkedWriteHandler())
											  .addLast(new HttpObjectAggregator(1024 * 1024 * 10))
											  .addLast(new WebSocketServerProtocolHandler("/socket.io", null, false, 1024 * 1024 * 50, false, true, 10000L))
											  .addLast(new WebSocketServerHandler())
									  ;
								  }
							  }
				);
		System.out.println("WebSocketServer main ");
		serverBootstrap.bind(8888).sync();
	}
}