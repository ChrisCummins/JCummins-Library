package jcummins.serial;

public class CommSettings
{
	private final String PORTNAME;
	private final int BAUDRATE;
	private final int DATABITS;
	private final int STOPBITS;
	private final int PARITY;
	private final int FLOWCONTROL;

	public CommSettings (String portname, int baudrate, int databits,
			int stopbits, int parity, int flowcontrol)
	{
		this.PORTNAME = portname;
		this.BAUDRATE = baudrate;
		this.DATABITS = databits;
		this.STOPBITS = stopbits;
		this.PARITY = parity;
		this.FLOWCONTROL = flowcontrol;
	}

	public String portname ()
	{
		return PORTNAME;
	}

	public int baudRate ()
	{
		return BAUDRATE;
	}

	public int dataBits ()
	{
		return DATABITS;
	}

	public int stopBits ()
	{
		return STOPBITS;
	}

	public int parity ()
	{
		return PARITY;
	}

	public int flowControl ()
	{
		return FLOWCONTROL;
	}
}
