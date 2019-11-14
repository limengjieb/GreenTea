package com.lmj.rabbitmq.controller;

import com.lmj.rabbitmq.dto.ItemInfoDTO;
import com.lmj.rabbitmq.entity.ItemInfo;
import com.lmj.rabbitmq.service.ItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/item/info")
public class ItemInfoController {

    @Autowired
    private ItemInfoService itemInfoService;

    @PostMapping("/select")
    public ItemInfo selectInfoByType(@RequestBody ItemInfoDTO dto) {
        ItemInfo itemInfo = itemInfoService.selectInfoByType(dto);
        return itemInfo;
    }

    @PostMapping("/insertItemInfo")
    public int insertItemInfo(@RequestBody ItemInfoDTO dto) {
        int i = itemInfoService.insertItemInfo(dto);
        return i;
    }

    @PostMapping("/deleteInfo")
    public int deleteInfo(@RequestBody ItemInfoDTO dto) {
        int i = itemInfoService.deleteInfo(dto);
        return i;
    }

    @PostMapping("/updateItemInfo")
    public int updateItemInfo(@RequestBody ItemInfoDTO dto) {
        int i = 0;
        try {
            i = itemInfoService.updateItemInfo(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}
