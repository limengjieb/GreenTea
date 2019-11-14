package com.lmj.rabbitmq.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lmj.rabbitmq.dto.ItemInfoDTO;
import com.lmj.rabbitmq.entity.ItemInfo;
import com.lmj.rabbitmq.mapper.ItemInfoMapper;
import com.lmj.rabbitmq.service.ItemInfoService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class ItemInfoServiceImpl implements ItemInfoService {

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Autowired
    private Channel channel;

    @Override
    @Transactional
    public ItemInfo selectInfoByType(ItemInfoDTO dto) {
        ItemInfo itemInfo = itemInfoMapper.selectInfoByType(dto);
        System.out.println("第一次查询到的SOURCE_TYPE:"+itemInfo.getSourceType());
        ItemInfo itemInfo1 = itemInfoMapper.selectInfoByType(dto);
        System.out.println("第二次查询到的SOURCE_TYPE:"+itemInfo1.getSourceType());
        return itemInfo;
    }

    @Override
    public int insertItemInfo(ItemInfoDTO dto) {
        int i = itemInfoMapper.insertItemInfo(dto);
        return i;
    }

    @Override
    public int deleteInfo(ItemInfoDTO dto) {
        int i = itemInfoMapper.deleteInfo(dto);
        return i;
    }

    @Override
    @Transactional
    public int updateItemInfo(ItemInfoDTO dto) throws Exception {
        int i = 0;
        try {
            ItemInfo itemInfo = itemInfoMapper.selectInfoByType(dto);
            channel.txSelect();
            channel.basicPublish("","hello",null,JSONObject.toJSONBytes(itemInfo));
            System.out.println("Sender1:"+JSONObject.toJSONString(itemInfo));
            i = itemInfoMapper.updateItemInfo(dto);
            channel.
            channel.txCommit();
        } catch (IOException e) {
            channel.txRollback();
            throw new RuntimeException("发消息异常");
        } finally {
            channel.close();
        }
        return i;
    }
}
