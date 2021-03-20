#include <iostream>

using namespace std;

int main()
{
	char input[7];
	int result = 0;
	cin >> input;
	
	int length = strlen(input);
	for (int i = 0; i < length; i++)
	{
		if ('0' <= input[i] && input[i] <= '9')
		{
			result = result + (input[i]-'0');
			continue;
		}
		else
		{
			for (int j = 0; j < 7; j++)
			{
				if (input[i] == 'A' + j)
				{
					result = result + (input[i]-'A' + 10);
					break;
				}
			}
		}
	}
	cout << result << endl;
	
}