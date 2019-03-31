#include <iostream>
using namespace std;

char input;
char arr[201];
bool alpha[26];

int main()
{
	while (1)
	{
		for (int i = 0; i < 26; i++) alpha[i] = false;
		cin.getline(arr, 201);
		if (arr[0] == '*') break;
		alpha[arr[0] - 'a'] = true;
		int index = 1;
		while (1)
		{
			if (arr[index] == '\0') break;
			if (arr[index] == ' ')
			{
				index++;
				continue;
			}

			alpha[arr[index] - 'a'] = true;
			index++;
		}
		
		bool flag = true;
		for (int i = 0; i < 26; i++)
		{
			if (alpha[i] == false)
			{
				flag = false;
				break;
			}
		}

		if (flag == true) cout << "Y" << endl;
		else cout << "N" << endl;
	}
	return 0;
}