package netty.upload.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.upload.FileDto;

import java.io.*;

/**
 * @author dongfengfan
 */
public class UploadFileHandler  extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof FileDto){
            FileDto dto = (FileDto) msg;
            if(dto.getCommand() == 1){
                //创建文件
                File file = new File("D://"+dto.getFileName());
                if(!file.exists()){
                    file.createNewFile();
                }
            }else if(dto.getCommand() == 2){
                //写入文件
                save2File("D://"+dto.getFileName(),dto.getBytes());
            }
        }

    }

    public static boolean save2File(String fileName, byte[] msg){
        OutputStream fos = null;
        try{
            File file = new File(fileName);
            File parent = file.getParentFile();
            boolean bool;
            if ((!parent.exists()) &
                    (!parent.mkdirs())) {
                return false;
            }
            fos = new FileOutputStream(file,true);
            fos.write(msg);
            fos.flush();
            return true;
        }catch (FileNotFoundException e){
            return false;
        }catch (IOException e){
            File parent;
            return false;
        }
        finally{
            if (fos != null) {
                try{
                    fos.close();
                }catch (IOException e) {}
            }
        }
    }


}
