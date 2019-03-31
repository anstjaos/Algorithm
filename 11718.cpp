#include <iostream>
#include <string>
using namespace std;

int main()
{
	string input;
	for (int i = 0; i < 1000; i++)
	{
		getline(cin, input);
		if (input == " ") break;
		cout << input << endl;
	}
	return 0;
}