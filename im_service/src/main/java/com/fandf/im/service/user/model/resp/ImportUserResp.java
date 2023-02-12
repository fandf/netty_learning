package com.fandf.im.service.user.model.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author fandongfeng
 * @date 2023/2/11 21:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ImportUserResp {

    private List<String> successId;
    private List<String> errorId;

}
