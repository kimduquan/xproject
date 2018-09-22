package xproject.xwindow;

import java.awt.Rectangle;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;

public class XWindow {

	private HWND handle;
	
	protected XWindow(HWND hwnd)
	{
		handle = hwnd;
	}
	
	public static XWindow findWindow(String className, String windowName)
	{
		HWND handle = User32.INSTANCE.FindWindow(className, windowName);
		if(handle != null)
		{
			return new XWindow(handle);
		}
		return null;
	}
	
	public Rectangle getClientRect()
	{
		RECT rect = new RECT();
		rect.bottom = 0;
		rect.left = 0;
		rect.right = 0;
		rect.top = 0;
		User32.INSTANCE.GetClientRect(handle, rect);
		Rectangle res = new Rectangle();
		res.x = rect.left;
		res.y = rect.top;
		res.width = rect.right - rect.left;
		res.height = rect.bottom - rect.top;
		return res;
	}
	
	public Rectangle getRect()
	{
		RECT rect = new RECT();
		rect.bottom = 0;
		rect.left = 0;
		rect.right = 0;
		rect.top = 0;
		User32.INSTANCE.GetWindowRect(handle, rect);
		Rectangle res = new Rectangle();
		res.x = rect.left;
		res.y = rect.top;
		res.width = rect.right - rect.left;
		res.height = rect.bottom - rect.top;
		return res;
	}
	
	public String getText()
	{
		int length = User32.INSTANCE.GetWindowTextLength(handle);
		char[] text = new char[length];
		User32.INSTANCE.GetWindowText(handle, text, length);
		return String.copyValueOf(text, 0, length);
	}
	
	public boolean setForeground()
	{
		return User32.INSTANCE.SetForegroundWindow(handle);
	}
	
	public boolean close()
	{
		return User32.INSTANCE.CloseWindow(handle);
	}
	
	public boolean destroy()
	{
		return User32.INSTANCE.DestroyWindow(handle);
	}
	
	public static XWindow getActive()
	{
		HWND handle = User32.INSTANCE.GetActiveWindow();
		if(handle != null)
		{
			return new XWindow(handle);
		}
		return null;
	}
	
	public static XWindow getDesktop()
	{
		HWND handle = User32.INSTANCE.GetDesktopWindow();
		if(handle != null)
		{
			return new XWindow(handle);
		}
		return null;
	}
	
	public static XWindow getForeground()
	{
		HWND handle = User32.INSTANCE.GetForegroundWindow();
		if(handle != null)
		{
			return new XWindow(handle);
		}
		return null;
	}
	
	public boolean isEnabled()
	{
		return User32.INSTANCE.IsWindowEnabled(handle);
	}
	
	public boolean isVisible()
	{
		return User32.INSTANCE.IsWindowVisible(handle);
	}
	
	public void setFocus()
	{
		User32.INSTANCE.SetFocus(handle);
	}
}
