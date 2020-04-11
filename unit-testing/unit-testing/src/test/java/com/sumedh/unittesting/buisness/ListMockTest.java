package com.sumedh.unittesting.buisness;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {

	List<String> mock = mock(List.class);

	@Test
	public void basic_List_Test() {
		when(mock.size()).thenReturn(0).thenReturn(1);// multiple param set
		assertEquals(0, mock.size());
		assertEquals(1, mock.size());

		when(mock.get(anyInt())).thenReturn("sumedh");// passing static value to get method
		assertEquals("sumedh", mock.get(0));
		assertEquals("sumedh", mock.get(1));

	}

	@Test
	public void verficationBasics() {
		String value1 = mock.get(0);
		String value2 = mock.get(1);

		verify(mock).get(1);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, never()).get(2);

	}

	@Test
	public void argumentPass() {
		mock.add("sumedh");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("sumedh", captor.getValue());

	}

	@Test
	public void MultipleArgumentPass() {
		mock.add("sumedh");
		mock.add("kulkarni");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());

		List<String> strings = captor.getAllValues();
		assertEquals("sumedh", strings.get(0));
		assertEquals("kulkarni", strings.get(1));
	}

	@Test
	public void spyMockitoTest() {
		ArrayList<Integer> arrayList = spy(ArrayList.class);// It will be affected only override method only.
		arrayList.add(2);
		System.out.println(arrayList.size());
		System.out.println(arrayList.get(0));
		when(arrayList.size()).thenReturn(5);
		System.out.println(arrayList.size());

		arrayList.add(0);
		System.out.println(arrayList.size());// once you override the method then value wont be changed.
		verify(arrayList).add(1);

	}
}
