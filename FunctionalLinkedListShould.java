import org.junit.*;
import static org.junit.Assert.*;

public class FunctionalLinkedListShould {

  private FunctionalLinkedList myFunctList;
  private FunctionalLinkedList emptyFunctList;

  @Before
  public void myFunctListSetUp() {
    myFunctList = new FunctionalLinkedList();
    myFunctList.add("red");
    myFunctList.add("orange");
    myFunctList.add("yellow");
    myFunctList.add("green");
    myFunctList.add("blue");
  }

  @Test
  public void returnRedWhenCallingHead() {
    ReturnObject result = myFunctList.head();
    ReturnObject expected = new ReturnObjectImpl("red");
    assertEquals(expected.getReturnValue(), result.getReturnValue());
  }

  @Test
  public void returnOrangeWhenCallingHeadAfterCallingRest() {
    FunctionalList result = myFunctList.rest();
    ReturnObject expected = new ReturnObjectImpl("orange");
    assertEquals(expected.getReturnValue(), result.head().getReturnValue());
    expected = new ReturnObjectImpl("green");
    assertEquals(expected.getReturnValue(), result.get(2).getReturnValue());
  }

  @Test
  public void returnBlueWhenCallingForWhatShouldBeTheLastItemInTheFunctListAfterCallingRest() {
    FunctionalList result = myFunctList.rest();
    ReturnObject expected = new ReturnObjectImpl("blue");
    assertEquals(expected.getReturnValue(), result.get(3).getReturnValue());
  }

  @Before
  public void emptyFunctListSetUp() {
    emptyFunctList = new FunctionalLinkedList();
  }

  @Test
  public void returnAnotherEmptyListWhenCallingRestOnEmptyFunctList() {
    FunctionalList resultFunctList = emptyFunctList.rest();
    ReturnObject expected = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
    ReturnObject resultReturnObject = resultFunctList.get(0);
    assertEquals(expected.getError(), resultReturnObject.getError());
  }

}
