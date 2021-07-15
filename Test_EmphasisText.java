import org.junit.Test;
import static org.junit.Assert.*;
public class MarkdownParserTests {
  @Test
  public void basicValidCases() {
    String expected0 = "<h1>header</h1>";
    String actual0 = Challenge.markdownParser("# header");
    assertEquals(expected0, actual0);
    String expected1 = "<h2>smaller header</h2>";
    String actual1 = Challenge.markdownParser("## smaller header");
    assertEquals(expected1, actual1);
    String expected2 = "<em>Emphasis</em>";
    String actual2 = Challenge.markdownParser("*Emphasis*");
    assertEquals(expected2, actual2);
    String expected3 = "<em>Emphasized Text</em>";
    String actual3 = Challenge.markdownParser("*Emphasized Text*");
    assertEquals(expected3, actual3);
  }
  @Test
  public void basicInvalidCases() {
    String expected0 = "#Invalid";
    String actual0 = Challenge.markdownParser("#Invalid");
    assertEquals(expected0, actual0);
    String expected1 = "* Invalid *";
    String actual1 = Challenge.markdownParser("* Invalid *");
    assertEquals(expected1, actual1);
  }
}
