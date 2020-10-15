package com.capgemini.hashmap;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedHashMapTest {
	@Test
	public void givenASentenceWhenWordsAddedToListShouldReturnFrequency() {
		String sentence = "Paranoids are not paranoid because they are"
				+ " paranoid but because they keep putting themselves deliberately"
				+ " into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myHashMap = new MyLinkedHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myHashMap.add(word, value);
		}
		int frequency = myHashMap.get("paranoid");
		System.out.println(myHashMap);
		Assert.assertEquals(3, frequency);
	}

	@Test
	public void givenAWordInSentenceShouldRemoveTheGivenWord() {
		String sentence = "Paranoids are not paranoid because they are"
				+ " paranoid but because they keep putting themselves deliberately"
				+ " into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myHashMap = new MyLinkedHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myHashMap.add(word, value);
		}
		myHashMap.remove("avoidable");
		Integer frequency1 = myHashMap.get("avoidable");
		System.out.println(myHashMap);
		Assert.assertEquals(null, frequency1);
	}

}
