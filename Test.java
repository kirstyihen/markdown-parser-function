import org.junit.Test;
import static org.junit.Assert.*;
public class MarkdownParserTests {
  @Test
  public void basicValidCases() {
    String expected = "<h1>Header</h1>";
    String actual = Challenge.markdownParser("# Header");
    assertEquals(expected, actual);
    String expected1 = "<h2>Smaller Header</h2>";
    String actual1 = Challenge.markdownParser("## Smaller Header");
    assertEquals(expected1, actual1);
  }
  @Test
  public void basicInvalidCases() {
    String expected = "#Invalid";
    String actual = Challenge.markdownParser("#Invalid");
    assertEquals(expected, actual);
  }
}
