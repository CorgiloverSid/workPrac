package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonPropertyOrder({"userName","userPassword"})
public class User {
  //  @JsonProperty("userName")
    private String userName;
    //@JsonProperty("userPassword")
    private String userPassword;


}
