#include <iostream>
#include <string>
using namespace std;

string input;

int main()
{
	while (1)
	{
		getline(cin, input);
		if (input == "END") break;

		int len = input.length();
		for (int i = len - 1; i >= 0; i--)
		{
			cout << input[i];
		}
		cout << '\n';
	}
	return 0;
}