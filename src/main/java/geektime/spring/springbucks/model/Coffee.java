package geektime.spring.springbucks.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
public class Coffee extends BaseEntity {

    public Coffee(){};
    public Coffee(String name,Integer price){
        this.name=name;
        this.price=price;
    }


    public Coffee(Long id , Date createTime,Date updateTime,String name, Integer price){
        this.setId(id);
        this.setCreateTime(createTime);
        this.setUpdateTime(updateTime);
        this.name=name;
        this.price=price;
    }

    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +super.toString()+
                '}';
    }
}
