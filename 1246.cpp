#include <iostream>
#include <string>
using namespace std;

int main()
{
	while (1)
	{
		string input;
		int cnt = 0;
		cin.clear();
		getline(cin, input);
	
		int size = input.size();
		if (input == "#") break;
		for (int i = 0; i < size; i++)
		{
			if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i'
				|| input[i] == 'o' || input[i] == 'u' || input[i] == 'A'
				|| input[i] == 'E' || input[i] == 'I' || input[i] == 'O'
				|| input[i] == 'U') cnt++;
		}

		cout << cnt << endl;
	}
	return 0;
}