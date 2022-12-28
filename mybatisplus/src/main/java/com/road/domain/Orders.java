package com.road.domain;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private Long id;
    private Integer price;
    private String remark;
    private Integer userId;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
    @Version
    private Integer version;
    //逻辑删除标识，0-未删除，1-已删除
    @TableLogic
    private Integer delFlag;


}
