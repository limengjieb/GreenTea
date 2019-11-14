package com.lmj.rabbitmq.mapper;

import com.lmj.rabbitmq.dto.ItemInfoDTO;
import com.lmj.rabbitmq.entity.ItemInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemInfoMapper {

    int insertItemInfo(ItemInfoDTO dto);

    int deleteInfo(ItemInfoDTO dto);

    ItemInfo selectInfoByType(ItemInfoDTO dto);

    int updateItemInfo(ItemInfoDTO dto);

}
