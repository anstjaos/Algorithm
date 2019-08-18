#include <iostream>
#include <string>
using namespace std;

int main()
{
	for(int i = 0; i < 100; i++)
	{
		string input;
		getline(cin, input);
		cout << input << endl;
	}
}