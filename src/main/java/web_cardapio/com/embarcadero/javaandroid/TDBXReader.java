//*******************************************************
//
//               Delphi DataSnap Framework
//
// Copyright(c) 1995-2011 Embarcadero Technologies, Inc.
//
//*******************************************************

package web_cardapio.com.embarcadero.javaandroid;

import java.util.Date;

import web_cardapio.br.com.bitbyte.sql.Cursor;

/**
 * TDBXReader provides a unidirectional reader for a collection of database
 * rows.
 */
public class TDBXReader implements JSONSerializable, TableType, Cursor
{
	protected int currentPosition = -1;
	private TParams columns;
	private TJSONObject internalDataStore;

	protected void setParameters(TParams params)
	{
		columns = params;
	}

	public TDBXReader(TParams params, TJSONObject value)
	{
		super();
		internalDataStore = value;
		setParameters(params);
	}

	public TParams getColumns()
	{
		return columns;
	}

	public DBXWritableValue getValue(int position)
	{
		return columns.getParameter(position).getValue();
	}
	
	@Override
	public boolean hasField(String name)
	{
		return columns.findParamByName(name) != null;
	}

	public DBXWritableValue getValue(String name) throws DBXException
	{
		return columns.getParamByName(name).getValue();
	}
	
	public DBXWritableValue findValue(String name)
	{
		DBXParameter parameter = columns.findParamByName(name);
		if (parameter != null)
			return parameter.getValue();
		else
			return null;
	}
	
	@Override
	public String findString(String name)
	{
		DBXWritableValue value = findValue(name);
		if (value != null)
		{
			try
			{
				return value.GetAsString();
			}
			catch (DBXException e)
			{
				e.printStackTrace();
				return "";
			}
		}
		else
			return "";
	}
	
	@Override
	public int findInt(String name)
	{
		DBXWritableValue value = findValue(name);
		if (value != null)
		{
			try
			{
				return value.GetAsInt32();
			}
			catch (DBXException e)
			{
				e.printStackTrace();
				return -1;
			}
		}
		else
			return -1;
	}
	
	@Override
	public long findLong(String field)
	{
		DBXWritableValue value = findValue(field);
		if (value != null)
		{
			try
			{
				return value.GetAsInt64();
			}
			catch (DBXException e)
			{
				e.printStackTrace();
				return -1;
			}
		}
		else
			return -1;
	}
	
	@Override
	public double findDouble(String name)
	{
		DBXWritableValue value = findValue(name);
		if (value != null)
		{
			try
			{
				return value.GetAsDouble();
			}
			catch (DBXException e)
			{
				e.printStackTrace();
				return -1;
			}
		}
		else
			return -1;
	}
	
	@Override
	public Date findDate(String field)
	{
		DBXWritableValue value = findValue(field);
		if (value != null)
		{
			try
			{
				return value.GetAsDate();
			}
			catch (DBXException e)
			{
				e.printStackTrace();
				return null;
			}
		}
		else
			return null;
	}

	@Override
	public boolean next()
	{
		currentPosition++;
		try
		{
			return TParams.LoadParametersValues(this.columns, this.internalDataStore,
					(int) currentPosition);
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	public static TDBXReader createFrom(TJSONObject value) throws DBXException
	{
		TParams params = TParams.CreateParametersFromMetadata(value.getJSONArray("table"));
		TDBXReader rdr = new TDBXReader(params, value);
		return rdr;
	}

	public TJSONObject asJSONObject() throws DBXException
	{
		TJSONObject result = null;
		int lastPosition = currentPosition;
		try
		{
			reset();
			result = DBXJSONTools.DBXReaderToJSONObject(this);
		}
		finally
		{
			currentPosition = lastPosition;
		}
		
		return result;
	}

	@Override
	public void reset()
	{
		currentPosition = -1;
	}
	
	@Override
	public int size()
	{
		return internalDataStore.elementsSize();
	}
	
	@Override
	public int getCurrentPosition()
	{
		return currentPosition;
	}
	
	public void setCurrentPosition(int position)
	{
		this.currentPosition = position;
	}

}
