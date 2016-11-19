/**
*tester class for StackImpl
*/

import org.junit.*;
import static org.junit.Assert.*;

public class StackImplShould {

 private Stack arrayStack;
 private Stack linkedListStack;
 private Stack emptyArrayStack;
 private List arrayList = new ArrayList();
 private List linkedList = new LinkedList();
 private List emptyArrayList = new ArrayList();

 @Before
 public void stacksSetup() {
   arrayStack = new StackImpl(arrayList);
   linkedListStack = new StackImpl(linkedList);
   emptyArrayStack = new StackImpl(emptyArrayList);
   arrayStack.push(66);
   arrayStack.push(74);
   arrayStack.push(2);
   arrayStack.push(89);
   String food = "pizza";
   linkedListStack.push(food);
   food = "burger";
   linkedListStack.push(food);
   food = "taco";
   linkedListStack.push(food);
   food = "lasagna";
   linkedListStack.push(food);
 }

 @Test
 public void returnTrueWhenCallingIsEmptyOnEmptyArrayStack() {
   boolean result = emptyArrayStack.isEmpty();
   boolean expected = true;
   assertEquals(expected, result);
 }

 @Test
 public void bothStacksShouldReturnASizeOf4() {
   int result = linkedListStack.size();
   assertEquals(4, result);
   result = arrayStack.size();
   assertEquals(4, result);
 }

 @Test
 public void topShouldReturn89AndLasagnaForTheirRespectiveStacks() {
   ReturnObject expected = new ReturnObjectImpl("lasagna");
   ReturnObject result = new ReturnObjectImpl(linkedListStack.top().getReturnValue());
   assertEquals(expected.getReturnValue(), result.getReturnValue());
   expected = new ReturnObjectImpl(89);
   result = new ReturnObjectImpl(arrayStack.top().getReturnValue());
   assertEquals(expected.getReturnValue(), result.getReturnValue());
 }

 @Test
 public void returnTheSecondItemInEachListWhenCallingPopTwice() {
   linkedListStack.pop();
   ReturnObject result = new ReturnObjectImpl(linkedListStack.pop().getReturnValue());
   ReturnObject expected = new ReturnObjectImpl("taco");
   assertEquals(expected.getReturnValue(), result.getReturnValue());
   arrayStack.pop();
   result = new ReturnObjectImpl(arrayStack.pop().getReturnValue());
   expected = new ReturnObjectImpl(2);
   assertEquals(expected.getReturnValue(), result.getReturnValue());
 }
}
