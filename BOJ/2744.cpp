#include <iostream>
#include <string>
using namespace std;

int main()
{
	string input;

	cin >> input;
	int length = input.length();

	for (int i = 0; i < length; i++)
	{
		if (isupper(input[i])) input[i] = tolower(input[i]);
		else input[i] = toupper(input[i]);
	}
	cout << input << endl;
}