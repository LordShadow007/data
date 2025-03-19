// Source code is decompiled from a .class file using FernFlower decompiler.
package project;

import java.util.Iterator;

class TreesSet$ArraysList<E> {
   private E[] array;
   private int size;
   private int arraySize;

   TreesSet$ArraysList(TreesSet var1) {
      this.this$0 = var1;
      this.size = 0;
      this.arraySize = 20;
      this.array = new Object[this.arraySize];
   }

   public void add(int place, E value) {
      if ((double)this.size > (double)this.arraySize * 0.75) {
         this.copy();
      }

      for(int i = this.size; i > place; --i) {
         this.array[i] = this.array[i - 1];
      }

      this.array[place] = value;
      ++this.size;
   }

   private void copy() {
      this.arraySize *= 2;
      Object[] temp = new Object[this.arraySize];

      for(int i = 0; i < this.array.length; ++i) {
         temp[i] = this.array[i];
      }

      this.array = temp;
   }

   public void remove(int place) {
      for(int i = place; i < this.size; ++i) {
         this.array[i] = this.array[i + 1];
      }

      --this.size;
   }

   public int size() {
      return this.size;
   }

   public E get(int i) {
      return this.array[i];
   }

   public Iterator<E> iterator() {
      return new TreesSet.ArraysList.CustomIterator(this, this.size());
   }

   public Iterator<E> descendingiterator() {
      return new TreesSet.ArraysList.CustomdescendingIterator(this, this.size());
   }
}
