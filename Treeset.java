// Source code is decompiled from a .class file using FernFlower decompiler.
package project;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

public class TreesSet<E> {
   private TreesSet<E>.ArraysList<E> a;
   private Comparator<E> comparator;

   TreesSet() {
      this.a = new ArraysList(this);
   }

   TreesSet(Collection<? extends E> c) {
      this();
      this.addAll(c);
   }

   TreesSet(SortedSet<E> s) {
      this();
      this.addAll(s);
   }

   TreesSet(Comparator<E> comparator) {
      this();
      this.comparator = comparator;
   }

   public Comparator<? super E> comparator() {
      return this.comparator;
   }

   public E first() {
      return this.a.get(0);
   }

   public E last() {
      return this.a.get(this.a.size() - 1);
   }

   public int size() {
      return this.a.size();
   }

   public E get(int i) {
      if (i >= 0 && i < this.size()) {
         return this.a.get(i);
      } else {
         throw new IndexOutOfBound("the index was not included ");
      }
   }

   public void delete(int i) {
      if (i >= 0 && i < this.size()) {
         this.a.remove(i);
      } else {
         throw new IndexOutOfBound("the index was not included ");
      }
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public boolean contains(E o) {
      return this.binary_search(o) >= 0;
   }

   public Object[] toArray() {
      Object[] o = new Object[this.size()];

      for(int i = 0; i < this.size(); ++i) {
         o[i] = this.get(i);
      }

      return o;
   }

   public E[] toArray(E[] o) {
      for(int i = 0; i < this.size(); ++i) {
         o[i] = this.get(i);
      }

      return o;
   }

   public boolean add(E e) {
      if (e == null) {
         throw new NullValueException("Null value is not accepeted");
      } else {
         int i = this.binary_sort(e);
         if (i == -1) {
            return false;
         } else {
            this.a.add(i, e);
            return true;
         }
      }
   }

   public boolean remove(E e) {
      if (e == null) {
         throw new NullValueException("Null value is not accepeted");
      } else {
         int i = this.binary_sort(e);
         if (i == -1) {
            return false;
         } else {
            this.a.remove(i);
            return true;
         }
      }
   }

   public boolean containsAll(Collection<? extends E> c) {
      Iterator var3 = c.iterator();

      while(var3.hasNext()) {
         E i = (Object)var3.next();
         if (i == null) {
            throw new NullValueException("Null value is not accepeted");
         }

         if (!this.contains(i)) {
            return false;
         }
      }

      return true;
   }

   public boolean addAll(Collection<? extends E> c) {
      boolean output = false;
      Iterator var4 = c.iterator();

      while(var4.hasNext()) {
         E i = (Object)var4.next();
         if (!this.add(i)) {
            output = true;
         }
      }

      return output;
   }

   public boolean retainAll(Collection<?> c) {
      boolean output = false;

      for(int i = 0; i < this.a.size(); ++i) {
         if (!c.contains(this.get(i))) {
            this.remove(this.get(i));
            output = true;
         }
      }

      return output;
   }

   public boolean removeAll(Collection<?> c) {
      boolean output = false;

      for(int i = 0; i < this.a.size(); ++i) {
         if (c.contains(this.get(i))) {
            this.remove(this.get(i));
            output = true;
         }
      }

      return output;
   }

   public void clear() {
      this.a = new ArraysList(this);
   }

   public E lower(E traget) {
      int low = 0;
      int high = this.size() - 1;
      E value = null;

      while(low <= high) {
         int mid = (low + high) / 2;
         if (this.cpm(this.a.get(mid), traget) == 1) {
            value = this.get(mid);
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }

      return value;
   }

   public E floor(E traget) {
      int low = 0;
      int high = this.size() - 1;
      E value = null;

      while(low <= high) {
         int mid = (low + high) / 2;
         if (this.cpm(this.a.get(mid), traget) == 0) {
            return this.get(mid);
         }

         if (this.cpm(this.a.get(mid), traget) == 1) {
            value = this.get(mid);
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }

      return value;
   }

   public E ceiling(E traget) {
      int low = 0;
      int high = this.size() - 1;
      E value = null;

      while(low <= high) {
         int mid = (low + high) / 2;
         if (this.cpm(this.a.get(mid), traget) == 0) {
            return this.get(mid);
         }

         if (this.cpm(this.a.get(mid), traget) == 1) {
            value = this.get(mid);
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }

      return value;
   }

   public E higher(E traget) {
      int low = 0;
      int high = this.size() - 1;
      E value = null;

      while(low <= high) {
         int mid = (low + high) / 2;
         if (this.cpm(this.a.get(mid), traget) == 1) {
            low = mid + 1;
         } else {
            value = this.get(mid);
            high = mid - 1;
         }
      }

      return value;
   }

   public E pollFirst() {
      E o = this.get(0);
      this.delete(0);
      return o;
   }

   public E pollLast() {
      E o = this.get(this.size() - 1);
      this.delete(this.size() - 1);
      return o;
   }

   public Iterator<E> iterator() {
      return this.a.iterator();
   }

   public Iterator<E> descendingIterator() {
      return this.a.descendingiterator();
   }

   public TreesSet<E> headSet(E toElement, boolean inclusive) {
      toElement = this.floor(toElement);
      if (toElement == null) {
         throw new NoSuchElementException();
      } else if (!inclusive) {
         return this.headSet(toElement);
      } else {
         TreesSet<E> temp = new TreesSet();

         for(int i = 0; i <= this.binary_search(toElement); ++i) {
            temp.add(this.get(i));
         }

         return temp;
      }
   }

   public TreesSet<E> tailSet(E fromElement, boolean inclusive) {
      fromElement = this.ceiling(fromElement);
      if (fromElement == null) {
         throw new NoSuchElementException();
      } else if (!inclusive) {
         return this.headSet(fromElement);
      } else {
         TreesSet<E> temp = new TreesSet();

         for(int i = this.binary_search(fromElement); i < this.size(); ++i) {
            temp.add(this.get(i));
         }

         return temp;
      }
   }

   public TreesSet<E> subSet(E fromElement, E toElement) {
      fromElement = this.ceiling(fromElement);
      toElement = this.floor(toElement);
      if (fromElement != null && toElement != null) {
         if (this.cpm(fromElement, toElement) > 0) {
            throw new IndexOutOfBound("the element is not able create subset");
         } else {
            TreesSet<E> temp = new TreesSet();

            for(int i = this.binary_search(fromElement); i < this.binary_search(toElement); ++i) {
               temp.add(this.get(i));
            }

            return temp;
         }
      } else {
         throw new NoSuchElementException();
      }
   }

   public TreesSet<E> headSet(E toElement) {
      toElement = this.floor(toElement);
      if (toElement == null) {
         throw new NoSuchElementException();
      } else {
         TreesSet<E> temp = new TreesSet();

         for(int i = 0; i < this.binary_search(toElement); ++i) {
            temp.add(this.get(i));
         }

         return temp;
      }
   }

   public TreesSet<E> tailSet(E fromElement) {
      fromElement = this.ceiling(fromElement);
      if (fromElement == null) {
         throw new NoSuchElementException();
      } else {
         TreesSet<E> temp = new TreesSet();

         for(int i = this.binary_search(fromElement); i < this.size() - 1; ++i) {
            temp.add(this.get(i + 1));
         }

         return temp;
      }
   }

   private int binary_search(E traget) {
      int low = 0;
      int high = this.size() - 1;

      while(low <= high) {
         int mid = (low + high) / 2;
         if (this.cpm(this.get(mid), traget) == 0) {
            return mid;
         }

         if (this.cpm(this.get(mid), traget) > 0) {
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }

      return -1;
   }

   private int cpm(E l1, E l2) {
      if (this.comparator == null && Comparable.class.isAssignableFrom(l1.getClass())) {
         return ((Comparable)l1).compareTo(l2);
      } else if (this.comparator instanceof Comparator) {
         return this.comparator.compare(l1, l2);
      } else {
         throw new NoComparableException("No comparable and comparator are found");
      }
   }

   private int binary_sort(E traget) {
      int low = 0;
      int high = this.a.size();

      while(low < high) {
         int mid = low + (high - low) / 2;
         if (this.cpm(this.get(mid), traget) == 0) {
            return -1;
         }

         if (this.cpm(this.get(mid), traget) < 0) {
            low = mid + 1;
         } else {
            high = mid;
         }
      }

      return low;
   }

   public TreesSet<E> copy() {
      TreesSet<E> o = new TreesSet();

      for(int i = 0; i < this.size(); ++i) {
         o.add(this.get(i));
      }

      return o;
   }

   public String toString() {
      String o = "[" + String.valueOf(this.get(0));

      for(int i = 1; i < this.size(); ++i) {
         o = o + "," + String.valueOf(this.get(i));
      }

      o = o + "]";
      return o;
   }
}
