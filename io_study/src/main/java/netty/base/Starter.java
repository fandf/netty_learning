package netty.base;

import netty.base.server.DiscardServer;

/**
 * @author fandongfeng
 * @date 2023/2/18 16:11
 */
public class Starter {
    public static void main(String[] args) throws Exception {
        new DiscardServer(9001).run();
    }
}
