package geektime.spring.springbucks.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.jar.JarEntry;

/**
 * @ClassName Test02
 * @Description //TODO
 * @Author lkk
 * Date 2023/03/26/11:21
 * @Version 1.0
 **/
@RestController()
@RequestMapping("/test")
public class Test02 {

    @PostMapping("/json")
    private String postJson() {
        return "{\"name\":\"llkk\"}";
    }


    @PostMapping("/xml")
    private String postXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<bookstore>\n" +
                "    <book>\n" +
                "        <id>1</id>\n" +
                "        <num>4</num>\n" +
                "        <result>\n" +
                "            <name>lkk01</name>\n" +
                "            <age>17</age>\n" +
                "        </result>\n" +
                "        <result>\n" +
                "            <name>lkk02</name>\n" +
                "            <age>18</age>\n" +
                "        </result>\n" +
                "\t\t<result>\n" +
                "            <name>lkk03</name>\n" +
                "            <age>18</age>\n" +
                "        </result>\n" +
                "\t\t<result>\n" +
                "            <name>lkk04</name>\n" +
                "            <age>18</age>\n" +
                "        </result>\n" +
                "    </book>\n" +
                "    <book>\n" +
                "        <id>2</id>\n" +
                "        <num>2</num>\n" +
                "        <result>\n" +
                "            <name>lkk05</name>\n" +
                "            <age>17</age>\n" +
                "        </result>\n" +
                "\t\t<result>\n" +
                "            <name>lkk06</name>\n" +
                "            <age>17</age>\n" +
                "        </result>\n" +
                "    </book>\n" +
                "</bookstore>";
    }
}
