import org.junit.*;
import static org.junit.Assert.*;

public class LinkedListShould {

  private LinkedList emptyLinkedList;
  private LinkedList myLinkedList;

  @Before
  public void emptyLinkedListSetup() {
    emptyLinkedList = new LinkedList();
  }

  @Test
  public void isEmptyReturnTrue() {
    assertEquals(true, emptyLinkedList.isEmpty());
  }

  @Test
  public void returnEmptyStructureWhenCallingMethods() {
    ReturnObject expected = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
    ReturnObject result = emptyLinkedList.get(2);
    assertEquals(expected.getError(), result.getError());
    result = emptyLinkedList.remove(5);
    assertEquals(expected.getError(), result.getError());
  }

  @Before
  public void myLinkedListSetup() {
    myLinkedList = new LinkedList();
    String color = "green";
    myLinkedList.add(color);
    color = "blue";
    myLinkedList.add(color);
    color = "red";
    myLinkedList.add(color);
    color = "orange";
    myLinkedList.add(color);
  }


  @Test
  public void returnASizeofFour() {
    int result = myLinkedList.size();
    int expected = 4;
    assertEquals(expected, result);
  }

  @Test
  public void getIndex0ShouldReturnGreen() {
    ReturnObject result = myLinkedList.get(0);
    String expected = "green";
    assertEquals(expected, result.getReturnValue());
  }

  @Test
  public void getIndex1ShouldReturnBlue() {
    ReturnObject result = myLinkedList.get(1);
    String expected = "blue";
    assertEquals(expected, result.getReturnValue());
  }

 @Test
  public void afterRemovingFirstElementWillReturnBlueIfGetIndexZero() {
    myLinkedList.remove(0);
    String expected = "blue";
    ReturnObject result = myLinkedList.get(0);
    assertEquals(expected, result.getReturnValue());
  }

  @Test
  public void afterRemovingLastIndexAndTryingAgainWillReturnIndexOutOfBounds() {
    myLinkedList.remove(3);
    ReturnObject expected = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
    ReturnObject result = myLinkedList.remove(3);
    assertEquals(expected.getError(), result.getError());
  }

  @Test
  public void shouldReturnTheSameValueWhenInsertingAtTheBottom() {
    String color = "magenta";
    myLinkedList.add(0, color);
    String expected = "magenta";
    ReturnObject result = myLinkedList.get(0);
    assertEquals(expected, result.getReturnValue());
  }


}
