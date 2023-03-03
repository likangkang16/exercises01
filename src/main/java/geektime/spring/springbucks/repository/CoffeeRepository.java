package geektime.spring.springbucks.repository;

import com.github.pagehelper.Page;
import geektime.spring.springbucks.model.Coffee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CoffeeRepository {

    @Select("SELECT  * FROM t_coffee;")
    List<Coffee> findAll();

    @Insert("insert into t_coffee(id,create_time,update_time,name,price) values(#{id},#{createTime},#{updateTime}," +
            "#{name},#{price});")
    void saveAll(Coffee coffees);

    @Select("SELECT  * FROM t_coffee where id =#{id};")
    Page<Coffee> findAllById(@Param("id") String id);

    @Update("update t_coffee set price =#{price} where id =#{id};")
    int update(Coffee coffee);

    @Delete("delete from t_coffee where id =#{id};")
    int deleter(@Param("id") String id);
}
