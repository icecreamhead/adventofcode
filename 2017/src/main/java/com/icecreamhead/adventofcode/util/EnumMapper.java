package com.icecreamhead.adventofcode.util;

public class EnumMapper {

  public static <OUT extends Enum<OUT>> OUT map(Enum enumToMap, Class<OUT> outEnumType) {
    if (enumToMap == null) {
      return null;
    }
    return Enum.valueOf(outEnumType, enumToMap.name());
  }

}
