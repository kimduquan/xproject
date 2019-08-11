#include "XPipeInput.h"

XPipeInput::XPipeInput(HANDLE handle) : XInput(), mArgs()
{
	mHandle = handle;
}

XPipeInput::~XPipeInput()
{
	mArgs.clear();
}

XPipeInput::XPipeInput(const XPipeInput& other) : XInput(other)
{
	mArgs = other.mArgs;
	mHandle = other.mHandle;
	wmemcpy(mBuffer, other.mBuffer, XINPUT_BUFFER_LENGTH);
}

void XPipeInput::xparse()
{
	wchar_t* pos = (wchar_t*)mBuffer;
	wstring szSize = pos;
	pos[szSize.size()] = '\0';
	pos += (szSize.size() + 1);
	long size = std::wcstol(szSize.c_str(), NULL, 0);
	for (int i = 0; i < size; i++)
	{
		wstring name = pos;
		pos[name.size()] = '\0';
		size_t index = name.find_first_of(L"=");
		wstring value = name.substr(index + 1);
		mArgs[name] = value;
		pos += (name.size() + 1);
	}
}

bool XPipeInput::xread()
{
	DWORD nBytes = 0;
	ZeroMemory(mBuffer, XINPUT_BUFFER_LENGTH);
	HRESULT hRes = ReadFile(mHandle, mBuffer, XINPUT_BUFFER_LENGTH, &nBytes, NULL);
	if (nBytes > 0)
	{
		xparse();
	}
	return nBytes > 0;
}

int XPipeInput::xreadString(const wchar_t* name, wstring& value)
{
	wstring key = name;
	value = mArgs[key];
	return 0;
}

int XPipeInput::xreadString(int index, wstring& value)
{
	value = mArgs[to_wstring(index)];
	return 0;
}

int XPipeInput::xreadStrings(map<wstring, wstring>& values)
{
	values = mArgs;
	return 0;
}

bool XPipeInput::xclose()
{
	BOOL bRes = CloseHandle(mHandle);
	return bRes == TRUE;
}