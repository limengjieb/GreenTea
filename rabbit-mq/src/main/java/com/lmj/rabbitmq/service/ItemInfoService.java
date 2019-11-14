package com.lmj.rabbitmq.service;

import com.lmj.rabbitmq.dto.ItemInfoDTO;
import com.lmj.rabbitmq.entity.ItemInfo;


public interface ItemInfoService {

    ItemInfo selectInfoByType(ItemInfoDTO dto);

    int insertItemInfo(ItemInfoDTO dto);

    int deleteInfo(ItemInfoDTO dto);

    int updateItemInfo(ItemInfoDTO dto) throws Exception;

}
