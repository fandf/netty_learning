package com.fandf.im.service.friendship.model.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author dongfengfan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ImportFriendShipResp {

    private List<String> successId;

    private List<String> errorId;
}
