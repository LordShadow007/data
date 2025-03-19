
package project;

import java.util.Iterator;
import java.util.NoSuchElementException;

class TreesSet$ArraysList$CustomdescendingIterator implements Iterator<E> {
   private int cursor;

   TreesSet$ArraysList$CustomdescendingIterator(TreesSet.ArraysList var1, int s) {
      this.this$1 = var1;
      this.cursor = 0;
      this.cursor = s;
   }

   public boolean hasNext() {
      return this.cursor >= 0;
   }

   public E next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return this.this$1.array[this.cursor--];
      }
   }
}
