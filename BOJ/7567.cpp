#include <iostream>
#include <string>
using namespace std;

int main()
{
	string input;
	cin >> input;
	int length = input.length();
	int cnt = 10;
	for (int i = 1; i < length; i++)
	{
		if (input[i] == input[i - 1]) cnt = cnt + 5;
		else cnt = cnt + 10;
	}
	cout << cnt << endl;
	return 0;
}