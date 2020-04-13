package com.getheart.vol;

import lombok.Data;

/**
 * @author Json
 * @date 2020-01-16:03
 */
@Data
public class BlogQuery {

    private String title;

    private Long typeId;

    private boolean recommend;

}
