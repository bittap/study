package com.my.study;

import java.nio.file.Path;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PahTest {

  @Test
  void expectedAbsolutePath() {
    Path path = Path.of("/");

    Assertions.assertEquals("D://", path.toAbsolutePath());
  }

  @Test
  void expectedRelativePath() {
    Path path = Path.of("./");

    Assertions.assertEquals("E:\\git\\study", path.toAbsolutePath());
  }

  @Test
  void expectedRelativePath2() {
    Path path = Path.of("");

    Assertions.assertEquals("E:\\git\\study", path.toAbsolutePath());
  }
}
