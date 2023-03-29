package com.qindel.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
  private String timestamp;
  private String message;
  private int code;
  private List<String> errors;
}
