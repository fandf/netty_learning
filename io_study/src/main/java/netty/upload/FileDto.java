package netty.upload;

import lombok.Data;

/**
 * @author dongfengfan
 */
@Data
public class FileDto {
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 1请求创建文件 2传输文件
     */
    private Integer command;

    /**
     * 文件字节；再实际应用中可以使用非对称加密，以保证传输信息安全
     */
    private byte[] bytes;

}
