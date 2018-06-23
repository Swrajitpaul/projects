import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class CircularLinkedList<AnyType> implements List<AnyType>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private Node<AnyType> next;

    public Node(AnyType d, Node<AnyType> n)
    {
      setData(d);
      setNext(n);
    }

    public AnyType getData() { return data; }

    public void setData(AnyType d) { data = d; }

    public Node<AnyType> getNext() { return next; }

    public void setNext(Node<AnyType> n) { next = n; }
  }

  private int theSize;
  private int modCount;
  private Node<AnyType> tail;

  public CircularLinkedList()
  {
	  tail = new Node<AnyType>(null, null);
	  modCount = 0;
	  clear();
  }

  public void clear()
  {
	  tail.setNext(tail);
	  theSize = 0;
  } // clear method

  public int size()
  {
	  return theSize;
  } // size method

  public boolean isEmpty()
  {
	  return(size() == 0);
  } // isEmpty method

  public AnyType get(int index)
  {
	  if (index >= size()) return null;
      
	  Node<AnyType> temporary;
	  
	  temporary = tail;
	  
	  for(int i=0; i<= index; i++){
		  temporary = temporary.next;
	  }
	  return temporary.data;
  } // get method

  public AnyType set(int index, AnyType newValue)
  {
	  
	  Node<AnyType> p = getNode(index);
	  
	  AnyType oldValue;
	  
	  oldValue = p.data;
	  
	  p.data = newValue;
	  
	  return oldValue;
	  
  } // set method

  public boolean add(AnyType newValue)
  {
	  Node<AnyType> p;
	  
	  p = tail;
		
	  	while (true) {
	  		
	  		if(p.next == tail)
				
	  			break;
	  		
	  		p = p.next;
			
		}
		
	  	Node<AnyType> newNode = new Node<AnyType>(null, null);
	  	
	  	p.setNext(newNode);
	  	
	  	newNode.setData(newValue);
	  	
	  	newNode.setNext(tail);
	  	
	  	theSize++;
	    
	    modCount++;	
	    
    return true;
  } // add method

  public void add(int index, AnyType newValue)
  {
	  
	  Node<AnyType> p;
	  	
	  p = tail;
		
	  	for (int i = 0; i < index; i++) {
			
	  		p = p.next;
		}
		
	  Node<AnyType> newNode = new Node<AnyType>(newValue, p.next);
	    
	  p.setNext(newNode);
	  
	  theSize++;
	    
	  modCount++;	 
  } // add method

  public AnyType remove(int index) {
	  
	  Node<AnyType> p;
	  
	  Node<AnyType> r;
	  	
	  r = getNode(index);
	  
	  p = tail;
	  
	  while (true) {
	  	
		if(p.next == r)
			break;
	  	
		p = p.next;
			
	  }
	  	
	  p.next = (r.getNext());
  	
	  theSize--;
  	
	  modCount++;
	
	  return r.getData();	

  }

  public void rotate()
  {
	  tail.setData(tail.getNext().getData());
	  
	  Node<AnyType> p;
	  	
	  p = tail.next;
	  
	  p.setData(tail.getNext().getNext().getData());

	  for (int i = 0; i < size(); i++) {
		  
		  p = p.next;
		  
		  p.data = p.next.data;
		  
	  }
  }

  public Iterator<AnyType> iterator()
  {
    return new LinkedListIterator();    
  }

  private Node<AnyType> getNode(int index)
  {
    return (getNode(index, 0, size()-1));
  }

  private Node<AnyType> getNode(int index, int lower, int upper)
  {
	  Node<AnyType> p;
	    
	    if( index < lower || index > upper )
	    	throw new IndexOutOfBoundsException();
	    
	   p = tail;
	    	
	   for( int i = 0; i <= index; i++)
		   p = p.next;
	  
	   return p;
  }

  private class LinkedListIterator implements Iterator<AnyType>
  {
    private Node<AnyType> previous;
    private Node<AnyType> current;
    private int expectedModCount;
    private boolean okToRemove;

    LinkedListIterator()
    {
    	 current = tail.getNext();
         expectedModCount = modCount;
         okToRemove = false;

    }

    public boolean hasNext()
    {
    	return (current != tail);
    }

    public AnyType next()
    {
    	if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
          if (!hasNext())
            throw new NoSuchElementException();

          AnyType nextValue = current.getData();
          previous = current;
          current = current.getNext();
          okToRemove = true;
          return nextValue;
    }

    public void remove()
    {
    	if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
          if (!okToRemove)
            throw new IllegalStateException();

          previous.next = current.next;
          expectedModCount++;
          okToRemove = false;
    }
  }
}