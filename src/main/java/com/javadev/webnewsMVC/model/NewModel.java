package com.javadev.webnewsMVC.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewModel extends AbstractModel<NewModel>{

    private String title;
    private String thumbnail;
    private String shortDescription;
    private String content;
    private Long categoryId;
    private String categoryCode;

}
