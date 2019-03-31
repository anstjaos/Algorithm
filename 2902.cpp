#include <iostream>
#include <string>
using namespace std;

int main()
{
	string input;
	string result = "";

	cin >> input;
	int length = input.length();
	for (int i = 0; i < length; i++)
	{
		if (i == 0) result = result + input[0];
		else if (input[i] == '-') result = result + input[i + 1];
	}
	cout << result << endl;
	return 0;
}