package netty.my;

import netty.my.server.DiscardServer;

/**
 * @author dongfengfan
 */
public class Starter {

    public static void main(String[] args) throws Exception {
        new DiscardServer(9001).run();
    }
}
