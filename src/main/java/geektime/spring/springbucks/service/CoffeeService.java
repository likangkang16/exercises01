package geektime.spring.springbucks.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.repository.CoffeeRepository;
import geektime.spring.springbucks.until.RedisUntil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;


    @Transactional(rollbackOn = Exception.class)
    public void save(Coffee coffees) throws Exception {
        try {
            coffeeRepository.saveAll(coffees);
        } catch (Exception e) {
            log.error("执行新增失败");
            throw new Exception();
        }

    }

    @Transactional(rollbackOn = Exception.class)
    public int update(Coffee coffee) throws Exception {
        try {
            return coffeeRepository.update(coffee);
        } catch (Exception e) {
            log.error("执行修改失败");
            throw new Exception();
        }
    }


    @Transactional(rollbackOn = Exception.class)
    public int deleter(String id) throws Exception {
        try {
            return coffeeRepository.deleter(id);
        } catch (Exception e) {
            log.error("执行删除失败");
            throw new Exception();
        }
    }


    public List<Coffee> findAll() {
        // PageHelper.startPage(1, 2);
        List<Coffee> coffeeRepositoryAll = coffeeRepository.findAll();
        //将结果新增的redis
        JedisCluster jedisCluster = RedisUntil.getJedisCluster("localhost", 6379);
        coffeeRepositoryAll.forEach(x -> {
            jedisCluster.setex(String.valueOf(x.getId()), 60 * 60 * 24, x.toString());

        });

        String collect = coffeeRepositoryAll.stream().map(x -> String.valueOf(x.getId())).collect(Collectors.joining(
                ","));
        List<String> mget = jedisCluster.mget(collect);
        log.info("开始从redis读取");
        mget.forEach(System.out::println);
        log.info("结束从redis读取");
        return coffeeRepositoryAll;
    }


    public Page<Coffee> findAllByName(String name) {
         PageHelper.startPage(1, 2,false);
        List<Coffee> list = coffeeRepository.findAllByName(name);
        Page<Coffee> list1 = (Page<Coffee>) list;
        return list1;
    }

}
