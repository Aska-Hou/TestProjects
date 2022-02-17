package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    public int id;
    public String name;
    public int money;

}
