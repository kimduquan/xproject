#pragma once

#define WIN32_LEAN_AND_MEAN             // Exclude rarely-used stuff from Windows headers
// Windows Header Files
#include <windows.h>

#ifdef  XCPP_EXPORTS 
#define XEXPORT __declspec(dllexport)  
#else
#define XEXPORT __declspec(dllimport)  
#endif

#include <string>
#include <vector>
#include <map>

using namespace std;