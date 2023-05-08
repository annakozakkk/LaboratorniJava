package ua.lviv.iot.algo.part1.projectorLab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan({"ua.lviv.iot.algo.part1",
        "ua.lviv.iot.algo.part1.business",
        "ua.lviv.iot.algo.part1.projectorLab.controller"})
public class ProjectorLabApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProjectorLabApplication.class, args);
    }

}