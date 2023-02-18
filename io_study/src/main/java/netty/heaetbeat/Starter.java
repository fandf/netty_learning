package netty.heaetbeat;

import netty.heaetbeat.server.DiscardServer;

/**
 * @author dongfengfan
 */
public class Starter {


    public static void main(String[] args) throws Exception {
        new DiscardServer(9001).run();
    }
}
