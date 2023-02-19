package com.fandf.im.tcp.server;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fandongfeng
 * @date 2023/2/18 20:14
 */
@Slf4j
public class FimServer {

    private final int port;

    public FimServer(int port) {
        this.port = port;
        EventLoopGroup group = new NioEventLoopGroup();

    }
}
