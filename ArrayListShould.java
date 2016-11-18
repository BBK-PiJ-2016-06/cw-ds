import org.junit.*;
import static org.junit.Assert.*;

public class ArrayListShould {

  private ArrayList myArrayList;
  private ArrayList myArrayList2;

  @Before
  public void ArraySetUp() {
    myArrayList = new ArrayList();
  }

  @Test
  public void beEmpty() {
    assertEquals(true, myArrayList.isEmpty());
  }

  @Test
  public void returnASizeofZero() {
    assertEquals(0, myArrayList.size());
  }

  @Test
  public void giveEmptyStructureWhenUsingGetMethod() {
    ReturnObject result = myArrayList.get(2);
    ReturnObject expected = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
    assertEquals(expected.getError(), result.getError());
  }

  @Before
  public void ArrayList2SetUp() {
    myArrayList2 = new ArrayList();
    myArrayList2.add(66);
    myArrayList2.add(67);
    myArrayList2.add(2387);
    myArrayList2.add(22);
  }

  @Test
  public void returnAValueOf66() {
    ReturnObject result = myArrayList2.get(0);
    ReturnObject expected = new ReturnObjectImpl(66);
    assertEquals(expected.getReturnValue(), result.getReturnValue());
    result = myArrayList2.get(3);
    expected = new ReturnObjectImpl(22);
    assertEquals(expected.getReturnValue(), result.getReturnValue());
  }

  @Test
  public void index1ShouldReturn2387AfterRemoving1() {
    myArrayList2.remove(1);
    ReturnObject result = myArrayList2.get(1);
    assertEquals(2387, result.getReturnValue());
  }

  @Test
  public void returnIndexOutofBoundsWhenAskingForAnIndexSizeThatIsTooLarge() {
    ReturnObject result = myArrayList2.remove(6);
    ReturnObject expected = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
    assertEquals(expected.getError() , result.getError());
  }

  @Test
  public void index0ShouldReturn67AfterRemoving0() {
    ReturnObject result = myArrayList2.get(0);
    assertEquals(66, result.getReturnValue());
    myArrayList2.remove(0);
    result = myArrayList2.get(0);
    assertEquals(67, result.getReturnValue());
  }
}
