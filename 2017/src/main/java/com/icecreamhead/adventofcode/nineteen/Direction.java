package com.icecreamhead.adventofcode.nineteen;

public enum Direction implements NextCoord {
  UP {
    @Override
    public int[] next(int[] current) {
      return new int[]{current[0] - 1, current[1]};
    }
  }, DOWN {
    @Override
    public int[] next(int[] current) {
      return new int[]{current[0] + 1, current[1]};
    }
  }, LEFT {
    @Override
    public int[] next(int[] current) {
      return new int[]{current[0], current[1] - 1};
    }
  }, RIGHT {
    @Override
    public int[] next(int[] current) {
      return new int[]{current[0], current[1] + 1};
    }
  };

  public Direction[] turns() {
    switch (this) {
      case UP:
      case DOWN:
        return new Direction[]{LEFT, RIGHT};
      case LEFT:
      case RIGHT:
        return new Direction[]{UP, DOWN};
    }
    throw new IllegalStateException();
  }
}

interface NextCoord {
  int[] next(int[] current);
}