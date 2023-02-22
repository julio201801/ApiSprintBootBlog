package com.ngsystem.apisprintbootblog.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("categoryMapper")
    public ModelMapper categoryMapper(){return new ModelMapper();}
    @Bean("commentMapper")
    public ModelMapper commentMapper(){return new ModelMapper();}
    @Bean("postMapper")
    public ModelMapper postMapper(){return new ModelMapper();}
    @Bean("userblogMapper")
    public ModelMapper userblogMapper(){
        return new ModelMapper();
    }

}
