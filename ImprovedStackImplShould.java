/**
*tester class for StackImpl
*/

import org.junit.*;
import static org.junit.Assert.*;

public class ImprovedStackImplShould {

 private ImprovedStack arrayStack;
 private ImprovedStack linkedListStack;
 private ImprovedStack emptyArrayStack;
 private ImprovedStack stackWithDoubleObjects;
 private List arrayList = new ArrayList();
 private List linkedList = new LinkedList();
 private List emptyArrayList = new ArrayList();
 private List linkedList2 = new LinkedList();

 @Before
 public void stacksSetup() {
   arrayStack = new ImprovedStackImpl(arrayList);
   linkedListStack = new ImprovedStackImpl(linkedList);
   emptyArrayStack = new ImprovedStackImpl(emptyArrayList);
   stackWithDoubleObjects = new ImprovedStackImpl(linkedList2);
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
   stackWithDoubleObjects.push(2);
   stackWithDoubleObjects.push(2);
   stackWithDoubleObjects.push(45);
   stackWithDoubleObjects.push(99);
   stackWithDoubleObjects.push(99);
   stackWithDoubleObjects.push(1929);
   stackWithDoubleObjects.push(366);
   stackWithDoubleObjects.push(66);
   stackWithDoubleObjects.push(66);

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


 @Test
 public void return2WhenCallingTopAfterCallingReverse() {
    ImprovedStack reversedStack = stackWithDoubleObjects.reverse();
    assertEquals(2, reversedStack.top().getReturnValue());
 }

 @Test
 public void topShouldReturn366AfterCallingRemoveOnValueOf66() {
   stackWithDoubleObjects.remove(66);
   ReturnObject result = stackWithDoubleObjects.top();
   ReturnObject expected = new ReturnObjectImpl(366);
   assertEquals(expected.getReturnValue(), result.getReturnValue());
 }

 @Test
 public void return1929AfterRemoving99And2AndPoppingOnceAndThenCallingTop() {
   stackWithDoubleObjects.remove(99);
   stackWithDoubleObjects.remove(2);
   ImprovedStack reversedStack = stackWithDoubleObjects.reverse();
   reversedStack.pop();
   ReturnObject result = reversedStack.top();
   ReturnObject expected = new ReturnObjectImpl(1929);
   assertEquals(expected.getReturnValue(), result.getReturnValue());
 }

 @Test
 public void returnASizeof9AndThenASizeOf7AfterPoppingTwice() {
   int size = stackWithDoubleObjects.size();
   assertEquals(9, size);
   stackWithDoubleObjects.pop();
   stackWithDoubleObjects.pop();
   size = stackWithDoubleObjects.size();
   assertEquals(7, size);
 }

}
