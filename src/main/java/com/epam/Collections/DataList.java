package com.epam.Collections;

import java.util.AbstractList;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataList<E> extends AbstractList<E>
{
	public static final Logger LOGGER=LogManager.getLogger(DataList.class);
	int size;
	int CAPACITY=10;
	Object[] data;
	int pointer;
	public DataList() 
	{
		data=new Object[CAPACITY];
		pointer=0;
	}

	@Override
	public boolean add(E e) {
		data[pointer] = e;
		pointer++;
		if(size == pointer)
			increaseCapacity();
		return false;
	}

	private void increaseCapacity()
	{
		size = data.length * 2;
		data = Arrays.copyOf(data,size);
		
	}

	@SuppressWarnings("unchecked")
	public E remove(int index)
	{
		E element=(E)data[index];
		for(int loopVar=index;loopVar<pointer-1;loopVar++)
		{
			data[loopVar] = data[loopVar+1];
		}
		pointer--;
		size--;
		return element;
	}

	@Override
	public int size() {
		return pointer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		
		return (E)data[index];
	}
	
	public void display()
    {
        String s="";
        for (int i = 0; i < this.pointer; i++)
            s=s+data[i]+" ";
        LOGGER.info(s+"\n");
    }

	
}
