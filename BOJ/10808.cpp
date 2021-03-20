#include <iostream>
#include <string>
using namespace std;

int alp[26];

int main()
{
	string input;
	cin >> input;
	int length = input.length();

	for (int i = 0; i < length; i++)
	{
		for (int j = 0; j < 26; j++)
		{
			if (input[i] == 'a' + j)
			{
				alp[j]++;
				break;
			}
		}
	}

	for (int i = 0; i < 26; i++)
	{
		cout << alp[i] << " ";
	}
	cout << endl;
}