import org.junit.*;
import static org.junit.Assert.*;

public class SampleableListImplShould {

  private SampleableListImpl emptySampleList;
  private SampleableListImpl mySampleList;

  @Before
  public void SampleableListsSetUp() {
    emptySampleList = new SampleableListImpl();
    mySampleList = new SampleableListImpl();
    mySampleList.add(6);
    mySampleList.add(8);
    mySampleList.add(11);
    mySampleList.add(17);
    mySampleList.add(38);
    mySampleList.add(123);
    mySampleList.add(4560);
  }

  @Test
  public void callingIsEmptyOnEmptyListShouldTrue() {
    SampleableList testSampleList = emptySampleList.sample();
    boolean result = testSampleList.isEmpty();
    boolean expected = true;
    assertEquals(expected, result);
  }

  @Test
  public void returnExpectedResultsWhenCallingGetAtIndex0OnASampledList() {
    SampleableList newList = mySampleList.sample();
    assertEquals(6, newList.get(0).getReturnValue());
    assertEquals(11, newList.get(1).getReturnValue());
    assertEquals(38, newList.get(2).getReturnValue());
    assertEquals(4560, newList.get(3).getReturnValue());
  }

 }
