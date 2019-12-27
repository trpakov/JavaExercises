package trpakov;

import java.util.Iterator;



import trpakov.MyLinkedList.ListNode;


class MyLinkedList implements Iterable<ListNode>{
	
	ListNode start;
	ListNode end;
	
	class ListNode implements Comparable<ListNode>{
		String value;
		ListNode previousNode;
		ListNode nextNode;
		@Override
		public int compareTo(ListNode o) {
			return this.value.compareTo(o.value);
		}
	}
	
	void add(String stringValue){
		ListNode node = new ListNode();
		node.value = stringValue;
		
		if(start == null) start = end = node;
		
		node.previousNode = end;
		end.nextNode = node;
		end = node;
	}

	@Override
	public Iterator<ListNode> iterator() {
		return new MyLinkedListIterator(this);
	}
	
	void remove(String value){
		boolean found = false;
		
		for(ListNode node : this){
			
			if(node.value.equals(value)){
				found = true;
				node.previousNode.nextNode = node.nextNode;
				node.nextNode.previousNode = node.previousNode;
			}
			
		}
		
		if(!found) System.out.println("Value \"" + value + "\" not found!");
	}
	
	ListNode sort()  
	{  
	    int isSwapped;
	    int k;  
	    ListNode firstNode;  
	    ListNode lastNode = null;  
	  
	    if (start == null)  
	        return null;  
	  
	    do
	    {  
	        isSwapped = 0;  
	        firstNode = start;  
	  
	        while (firstNode.nextNode != lastNode)  
	        {  
	            if (firstNode.value.compareTo(firstNode.nextNode.value) > 0)  
	            {  
	                String temp = firstNode.value;
	                firstNode.value = firstNode.nextNode.value;
	                firstNode.nextNode.value = temp;
	                isSwapped = 1;  
	            }  
	            firstNode = firstNode.nextNode;
	        }  
	        lastNode = firstNode;  
	    }  
	    while (isSwapped != 0);  
	        return start; 
	}  
	
}

class MyLinkedListIterator implements Iterator<ListNode>{

	MyLinkedList.ListNode current;
	
	public  MyLinkedListIterator(MyLinkedList myLinkedList) {
		current = myLinkedList.start;
	}
	
	@Override
	public boolean hasNext() {
		return current.nextNode != null;
	}

	@Override
	public ListNode next() {
		ListNode nodeToReturn = current;
		current = current.nextNode;
		return nodeToReturn;
	}
	
}

public class LinkedListExercise {
	
	public static void main(String[] args) {
		
		/*
		LinkedList<String> linkedList = new LinkedList<String>();		
		for(int i = 99; i > -1; i--) linkedList.add( "string" + (i < 10 ? "0" + i: i));		
		Collections.sort(linkedList);
		System.out.println(linkedList);
		*/
		
		MyLinkedList list = new MyLinkedList();
		for(int i = 99; i > -1; i--) list.add( "string" + (i < 10 ? "0" + i : i));
		list.remove("string97");
		list.sort();
		for(ListNode node : list) System.out.print(node.value + " ");

	}

}
