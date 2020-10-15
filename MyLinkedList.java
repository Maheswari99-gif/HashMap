package com.capgemini.hashmap;

public class MyLinkedList<K> {
	public INode<K> head;
	public INode<K> tail;
	private int size;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public void insert(INode<K> myNode, INode<K> newNode) {
		INode<K> tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
		this.size++;
	}

	public void append(INode<K> newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (this.tail == null) {
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;

		}
		size++;

	}

	public void add(INode<K> newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (this.tail == null) {
			this.tail = newNode;
		} else {
			INode<K> temp = this.head;
			this.head = newNode;
			this.head.setNext(temp);
		}
		this.size++;
	}

	public INode<K> pop() {
		INode<K> tempNode = this.head;
		this.head = head.getNext();
		size--;
		return tempNode;
	}

	public INode<K> popLast() {
		INode<K> tempNode = this.head;
		while (!tempNode.getNext().equals(tail)) {
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tempNode = tempNode.getNext();
		this.tail.setNext(null);
		size--;
		return tempNode;

	}

	public INode<K> search(K value) {
		INode<K> node = this.head;
		while (node != null) {
			if (node.getKey().equals(value)) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}

	public void printMyNodes() {
		INode<K> node = this.head;
		if (node != null) {
			System.out.println("List: " + node.getKey());
			while ((node = node.getNext()) != null) {
				System.out.println("->" + node.getKey());
			}
		}

	}

	public void insertAfter(K value, INode<K> newNode) {
		INode<K> node = this.head;
		while (node != null) {
			if (node.getKey().equals(value)) {
				break;
			}
			node = node.getNext();
		}
		if (node != null) {
			INode<K> temp = node.getNext();
			node.setNext(newNode);
			node.getNext().setNext(temp);
			if (node == this.tail) {
				this.tail = newNode;
			}
			size++;
		}
	}

	public void deleteNode(K value) {
		INode<K> node = this.head;
		if (node == this.tail && node != null) {
			if (node.getKey().equals(value)) {
				this.head = null;
				this.tail = null;
				size--;
			}
		} else if (node != null) {
			while (node != this.tail && !(node.getNext().getKey().equals(value))) {
				node = node.getNext();
			}
			if (node != this.tail) {
				INode<K> deleteNode = node.getNext();
				node.setNext(deleteNode.getNext());
				deleteNode.setNext(null);
				if (deleteNode == this.tail) {
					this.tail = node;
				}
				size--;
			}
		}
	}

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		list.append(node1);
		list.append(node3);
		list.insert(node1, node2);
		list.printMyNodes();
		System.out.println("\nPopped element: " + list.popLast().getKey());
		System.out.println("\nList after popping:\n");
		list.printMyNodes();
	}
}

interface INode<K> {
	K getKey();

	void setKey(K key);

	INode<K> getNext();

	void setNext(INode<K> next);
}

class MyNode<K> implements INode<K> {
	private K key;
	private MyNode<K> next;

	public MyNode(K key) {
		super();
		this.key = key;
		this.next = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public MyNode<K> getNext() {
		return next;
	}

	public void setNext(INode<K> next) {
		this.next = (MyNode<K>) next;
	}

}
