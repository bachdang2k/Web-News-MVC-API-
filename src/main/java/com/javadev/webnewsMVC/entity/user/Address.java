package com.javadev.webnewsMVC.entity.user;

import com.javadev.webnewsMVC.entity.base.BaseEntity;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "Address")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {

    @Column(name = "country", length = 25)
    private String country;

    @Column(name = "city", length = 25)
    private String city;

    @Column(name = "district", length = 25)
    private String district;

    @Column(name = "street", length = 25)
    private String street;

    @Column(name = "home_number", length = 25)
    private Long number;

}
