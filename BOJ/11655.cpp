#include <iostream>
#include <string>
using namespace std;

string input;

int main()
{
	getline(cin, input);
	int length = input.length();
	string result = "";
	for (int i = 0; i < length; i++)
	{
		if (isdigit(input[i]) || input[i] == ' ') continue;
		else if (isupper(input[i]))
		{
			input[i] = input[i] + 13;
			if ('A' > input[i] || input[i] > 'Z')
			{
				input[i] = input[i] - 26;
			}
		}
		else
		{
			input[i] = input[i] + 13;
			if ('a' > input[i] || input[i] > 'z')
			{
				input[i] = input[i] - 26;
			}
		}
	}
	cout << input << endl;
	return 0;
}