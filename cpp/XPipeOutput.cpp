#include "XPipeOutput.h"

XPipeOutput::XPipeOutput(HANDLE handle) : XOutput(), mData()
{
	mHandle = handle;
}

XPipeOutput::~XPipeOutput()
{
	mData.clear();
}

XPipeOutput::XPipeOutput(const XPipeOutput& other) : XOutput(other)
{
	mHandle = other.mHandle;
	mData = other.mData;
}

bool XPipeOutput::xwrite()
{
	size_t size = mData.size();
	wstring szSize = to_wstring(size);
	size = szSize.size() + 1;
	map<wstring, wstring>::iterator it = mData.begin();
	while (it != mData.end())
	{
		size += (it->first.size() + 1);
		size++;
		size += (it->second.size() + 1);
		it++;
	}

	wchar_t* buffer = new wchar_t[size];
	ZeroMemory(buffer, size);
	wchar_t* pos = buffer;

	wmemcpy(pos, szSize.c_str(), szSize.size());
	pos[szSize.size() + 1] = '\0';
	pos += (szSize.size() + 1);

	it = mData.begin();
	while (it != mData.end())
	{
		wmemcpy(pos, it->first.c_str(), it->first.size());
		pos[it->first.size() + 1] = '\0';
		pos += (it->first.size() + 1);
		
		wmemcpy(pos, L"=", 1);
		pos++;

		wmemcpy(pos, it->second.c_str(), it->second.size());
		pos[it->second.size() + 1] = '\0';
		pos += (it->second.size() + 1);
		it++;
	}

	DWORD nBytes = size * sizeof(wchar_t);
	DWORD nWriteBytes = 0;
	HRESULT hRes = WriteFile(mHandle, buffer, nBytes, &nWriteBytes, NULL);

	delete[] buffer;
	return hRes == S_OK;
	return true;
}

int XPipeOutput::xwriteString(int index, const wchar_t* value)
{
	mData[to_wstring(index)] = wstring(value);
	return 0;
}

int XPipeOutput::xwriteString(const wchar_t* name, const wchar_t* value)
{
	mData[wstring(name)] = wstring(value);
	return 0;
}

int XPipeOutput::xwriteStrings(map<wstring, wstring>& values)
{
	mData = values;
	return 0;
}
