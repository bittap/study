package com.atcoder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class CTraveling {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    Set<Direction> route = new HashSet<Direction>();
    route.add(new Direction(0, 0));
    int[][] destination = new int[N][3];

    for (int i = 0; i < N; i++) {

      for (int j = 0; j < destination[i].length; j++) {
        destination[i][j] = scan.nextInt();
      }
    }

    int previousStartingPoint = 0;
    boolean can = true;

    for (int i = 0; i < destination.length; i++) {
      int t = destination[i][0];
      int x = destination[i][1];
      int y = destination[i][2];

      route = moveRoute(route, t - previousStartingPoint);
      Set<Direction> temp = new HashSet<Direction>();

      for (Direction Direction : route) {
        if (Direction.x == x && Direction.y == y) {
          temp.add(Direction);
        }
      }

      route = temp;
      previousStartingPoint = t;

      if (temp.size() == 0) {
        can = false;
        break;
      }

    }

    if (can) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    scan.close();
  }

  private static Set<Direction> moveRoute(Set<Direction> routeParam, int loopCount) {
    Set<Direction> route = routeParam;
    for (int i = 0; i < loopCount; i++) {
      Set<Direction> temp = new HashSet<Direction>();

      for (Direction Direction : route) {
        int x = Direction.x;
        int y = Direction.y;

        temp.add(new Direction(x + 1, y));
        temp.add(new Direction(x - 1, y));
        temp.add(new Direction(x, y + 1));
        temp.add(new Direction(x, y - 1));
      }

      route = temp;
    }

    return route;
  }

}


class Direction {
  int x;
  int y;

  public Direction(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Direction other = (Direction) obj;
    return x == other.x && y == other.y;
  }



}
