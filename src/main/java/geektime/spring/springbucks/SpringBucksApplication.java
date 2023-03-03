package geektime.spring.springbucks;

import com.github.pagehelper.Page;
import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@EnableTransactionManagement
@SpringBootApplication
public class SpringBucksApplication  implements ApplicationRunner {


	@Autowired
	private CoffeeService coffeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBucksApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		Coffee coffeeA = new Coffee(1L, new Date(), new Date(),"拿铁A",120);
		Coffee coffeeB = new Coffee(2L,new Date(), new Date(),"拿铁B",130);
		Coffee coffeeC = new Coffee(3L,new Date(), new Date(),"拿铁C",110);
		Coffee[] coffees =new Coffee[]{coffeeA,coffeeB,coffeeC};
		Arrays.asList(coffees).forEach(x->{
			try {
				//新增
				coffeeService.save(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Coffee coffeeD = new Coffee(3L,new Date(), new Date(),"拿铁C",140);
		coffeeService.update(coffeeD);
		coffeeService.deleter("3");
		List<Coffee> coffeeList = coffeeService.findAll();
		System.out.println(coffeeList.toString());
	}
}

