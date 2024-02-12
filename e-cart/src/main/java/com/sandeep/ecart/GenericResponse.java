package com.sandeep.ecart;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GenericResponse <T>{
      private final Boolean success;
      private final T data;
      private final String message;
}
