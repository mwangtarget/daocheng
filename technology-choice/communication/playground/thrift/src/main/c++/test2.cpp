// File name: ~ftp/pub/class/cplusplus/HelloWorld/Variable.cpp
// Purpose:   Demonstrate the use of variables and constants
//
#include <iostream>
using namespace std;
// declaring a constant.  It's value cannot be changed.
const int CONST_VAL = 5;        
int main()
{
	int    iValue;  // An integer variable
	float  fValue;  // A floating point variable
	char   cValue;  // A character variable
	
	iValue = 1234;    // Assigns 1234 to iValue
	fValue = 1234.56; // Assigns 1234.56 to fValue
	cValue = 'A';     // Assigns A to cValue
	
	// Now print them out on the screen:
	cout << "Integer value is: " << iValue << endl;
	cout << "Float value is: " << fValue <<  endl;
	cout << "Character value is: " << cValue << endl;
	cout << "The constant is: " << CONST_VAL << endl;
	
	return 0;
}
