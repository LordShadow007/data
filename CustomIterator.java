
package project;

import java.util.Iterator;
import java.util.NoSuchElementException;

class TreesSet$ArraysList$CustomIterator implements Iterator<E> {
   private int cursor;
   private final int size;

   TreesSet$ArraysList$CustomIterator(TreesSet.ArraysList var1, int s) {
      this.this$1 = var1;
      this.cursor = 0;
      this.size = s;
   }

   public boolean hasNext() {
      return this.cursor < this.size;
   }

   public E next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return this.this$1.array[this.cursor++];
      }
   }
}
