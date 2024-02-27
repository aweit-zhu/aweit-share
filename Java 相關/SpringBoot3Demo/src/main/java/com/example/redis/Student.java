package com.example.redis;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@RedisHash("Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Serializable{
	
	public enum Gender { 
        MALE, FEMALE
    }

    private String id;
    private String name;
    private Gender gender;
    private int grade;
}
